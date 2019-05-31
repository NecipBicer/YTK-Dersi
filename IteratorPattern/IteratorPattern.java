package prototype;

import java.util.ArrayList;

 interface Iterator {
   public boolean hasNext();
   public Object next();
}

interface Container {

     public Iterator getIterator();
}
class Calisanlar{
    String adi;
    String soyadi;
    String memleket;
    int maas;

    public Calisanlar(String adi, String soyadi, String memleket, int maas) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.memleket = memleket;
        this.maas = maas;
    }
    
    
}   

class CalisanDeposu implements Container {
   ArrayList <Calisanlar> calisanlar= new ArrayList<Calisanlar>();

   @Override
   public Iterator getIterator() {
      return new isimIterator();
   }

   private class isimIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
      
         if(index < calisanlar.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return calisanlar.get(index++);
         }
         return null;
      }		
   }
}


public class IteratorPattern {
     public static void main(String[] args) {
      Calisanlar a=new Calisanlar("Necip","Bicer","Kirsehir",14000);
      Calisanlar b=new Calisanlar("Alisan","Bagrisen","Ordu",12000);
      Calisanlar c=new Calisanlar("Rahmi","Ilteris","Manisa",10000);
      CalisanDeposu calisanDeposu = new CalisanDeposu();
      calisanDeposu.calisanlar.add(a);
      calisanDeposu.calisanlar.add(b);
      calisanDeposu.calisanlar.add(c);
      Iterator iter = calisanDeposu.getIterator();

      while( iter.hasNext()){
         Calisanlar kisi = (Calisanlar)iter.next();
         System.out.println("İsim : " + kisi.adi+" Soyadi : "+kisi.soyadi+" Memleketi : "+kisi.memleket+" Maas : "+kisi.maas);
      } 	
   }
    

}
