
package singletonclass;

import java.util.ArrayList;
import java.util.List;

class Randevu {

  public String  hasta;

  public String hastaAl() {
    return hasta;
  }

  public void hastaAta(  String hasta ) {
    this.hasta = hasta;
  }

  public RandevuGecmisi hatırlayıcıYarat() {
    return new RandevuGecmisi( this );
  }

  public void gecmiseBak(  RandevuGecmisi gecmis ) {
    this.hasta = gecmis.içerikAl();
  }
}
class RandevuGecmisi {

  public String  randevu;
 
  public RandevuGecmisi(){
      
  }

  public RandevuGecmisi(  Randevu kayit ) {
    this.randevu = kayit.hastaAl();
  }

  public String içerikAl() {
    return randevu;
  }
}
class RandevuEklemeSistemi {

  public  Randevu randevu;
  public  List< RandevuGecmisi >  gecmisHastaListesi  = new ArrayList< RandevuGecmisi >();

  public RandevuEklemeSistemi(  Randevu randevu ) {
    this.randevu = randevu;
  }

  public void KisiEkle(  String yeniKisi ) {
    RandevuGecmisi gecmis = randevu.hatırlayıcıYarat();
    gecmisHastaListesi.add( gecmis );

    randevu.hastaAta( yeniKisi );
  }

  public void geriAl() {
     RandevuGecmisi hatırlayıcı = gecmisHastaListesi.remove( gecmisHastaListesi.size() - 1 );
    randevu.gecmiseBak( hatırlayıcı );
  }
}







public class MementoPattern {
    public static void main(String[] args){
  Randevu randevu = new Randevu();
    

    RandevuEklemeSistemi sistem = new RandevuEklemeSistemi( randevu );
    sistem.KisiEkle("Necip Biçer");
    sistem.KisiEkle( "Alişan Bağrışen" );
    sistem.KisiEkle( "Hasan Hakanoğlu" );
    

    
    System.out.println("En son kisi : " + randevu.hastaAl() );

    
    sistem.geriAl();
    sistem.geriAl();
   

   
    System.out.println("iki işlem geri alındıktan sonra hasta : " + randevu.hastaAl() );
    
}
}
