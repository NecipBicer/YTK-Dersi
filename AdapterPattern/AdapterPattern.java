
package adapterpattern;

 interface Doktor {
    public void hastaBak();
    public void ameliyataGir();
}
 interface Hasta {
    public void randevuAl();
    public void randevuIptal();
}
class Doktor1 implements Doktor{
    public void hastaBak(){
        System.out.println("Ben doktorum işim hastalara bakmaktır.");
    }
    public void ameliyataGir(){
        System.out.println("Ben doktorum gerekirse ameliyata girerim");
    }
    
}
class HastaOlanDoktor implements Hasta{
    Doktor doktor1;
    HastaOlanDoktor(Doktor doktor1){
        this.doktor1=doktor1;
    }
    public void randevuAl(){
        System.out.println("Hasta olarak randevu alabilirim.");
    }
    public void randevuIptal(){
        System.out.println("Hasta olarak randevu iptal edebilirim.");
    }
    
}

public class AdapterPattern {
    public static void Donusum(Hasta hasta){
        hasta.randevuAl();
        hasta.randevuIptal();
        
    }

   
    public static void main(String[] args) {
        
        Doktor1 Doktor1=new Doktor1();
        Hasta hastaDoktor1= new HastaOlanDoktor(Doktor1);
        Doktor1.ameliyataGir();
        Doktor1.hastaBak();
        Donusum(hastaDoktor1);
        
        
        
        
    }
    
}
