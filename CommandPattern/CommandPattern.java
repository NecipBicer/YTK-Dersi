package singletonclass;

import java.util.ArrayList;
import java.util.List;

 interface Komut {
    public void calistir();
}
class RandevuOnayButonu implements Komut {
  public Randevu randevu;
     
    public RandevuOnayButonu(Randevu randevu) {
        this.randevu = randevu;
    }
     
    public void calistir() {
        randevu.onay();
    }
}
class RandevuGuncelleButonu implements Komut {
    Randevu light;
     
    public RandevuGuncelleButonu(Randevu light) {
        this.light = light;
    }
     
    public void calistir() {
        light.guncelle();
    }
}
class RandevuIptalButonu implements Komut {
   public Randevu randevu;
     
    public RandevuIptalButonu(Randevu randevu) {
        this.randevu = randevu;
    }
     
    public void calistir() {
        randevu.iptal();
    }
}
class Randevu {
 public void onay() {
        System.out.println("Randevunuz onaylandı");
    }
     
    public void iptal() {
        System.out.println("Randevunuz iptal edildi");
    }
    public void guncelle(){
        System.out.println("Randevunuz Güncellendi");
    }
}
 class Sistem {
   public Komut gorev;
     
   
    public void setGorev(Komut komut) {
        this.gorev = komut;
    }
     
    public void SistemCalistirildi() {
        gorev.calistir();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
    
       Sistem sistem = new Sistem();
        Randevu randevu = new Randevu();
        RandevuOnayButonu RandevuOnay = new RandevuOnayButonu(randevu);
        RandevuGuncelleButonu RandevuGuncelle= new RandevuGuncelleButonu(randevu);
        sistem.setGorev(RandevuOnay);
        sistem.SistemCalistirildi();
        sistem.setGorev(RandevuGuncelle);
        sistem.SistemCalistirildi();
        
  }
   }

    

