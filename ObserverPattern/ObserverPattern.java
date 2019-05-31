
package prototype;

import java.util.ArrayList;
import java.util.List;


interface Subject {

	
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	
	public void notifyObservers();
	
	
	public Object getUpdate(Observer obj);
	
}

interface Observer {
	
	
	public void update();
	
	
	public void setSubject(Subject sub);
}
 class Cagri implements Subject {

	 List<Observer> doktorlar;
	 String message;
	 boolean flag;
	public  Object MUTEX= new Object();
	
	public Cagri(){
		this.doktorlar=new ArrayList<>();
	}
	@Override
	public void register(Observer obj) {
                    
		synchronized (MUTEX) {
		if(!doktorlar.contains(obj)) doktorlar.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		doktorlar.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
	
		synchronized (MUTEX) {
			if (!flag)
				return;
			observersLocal = new ArrayList<>(this.doktorlar);
			this.flag=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	
	public void duyuru(String msg){
		System.out.println("Duyuru cagriya eklendi:"+msg);
		this.message=msg;
		this.flag=true;
		notifyObservers();
	}

}
class CagriDoktorlari implements Observer {
	
	 String isim;
	 Subject cagri;
	
	public CagriDoktorlari(String nm){
		this.isim=nm;
	}
	@Override
	public void update() {
		String msg = (String) cagri.getUpdate(this);
		if(msg == null){
			System.out.println(isim+":: Suanlik ameliyat yok");
		}else
		System.out.println(isim+":: Onemli ::"+msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.cagri=sub;
	}

}
public class ObserverPattern {
    public static void main(String args[]){
        Cagri cagri = new Cagri();
		
		
		Observer dr2 = new CagriDoktorlari("Doktor2");
                Observer dr1 = new CagriDoktorlari("Doktor1");
		 
		Observer dr3 = new CagriDoktorlari("Doktor3");
		
		
		cagri.register(dr1);
		cagri.register(dr2);
               
		cagri.register(dr3);
		
		
		dr1.setSubject(cagri);
		dr2.setSubject(cagri);
		dr3.setSubject(cagri);
               
		
		
		dr1.update();
		
		 cagri.duyuru("Herkes ameliyata lütfen");
		
              // cagri.duyuru("Herkes ameliyata lütfen");
                
                 
               
        
    }
}
