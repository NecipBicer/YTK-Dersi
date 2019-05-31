package singletonclass;
// Hastane otomasyonunda uyesayisi ve tarih kısmı değiştirilebilir.Fakat değişen tüm değerler diğer kopya objelere de yansır.
//Böylece her admin bir obje üzerinde işlem yapmış olur.
class hastaneOtomasyonu{
    private static  hastaneOtomasyonu SINGLE_INSTANCE = null;
   private int uyeSayisi=100;
   private String tarihDegistir;
    
    
    private hastaneOtomasyonu() {}
    public static hastaneOtomasyonu getInstance() {
        if (SINGLE_INSTANCE == null) {  
          synchronized(hastaneOtomasyonu.class) {
          SINGLE_INSTANCE = new hastaneOtomasyonu();
             
              
              
          }
        }
       
        return SINGLE_INSTANCE;
        
    }
    public void tarihDegistir(String tarih){
       
       this.tarihDegistir=tarih;
    }
    
    public void uyesayisiGuncelle(int sayi){
        this.uyeSayisi=sayi;
    }
    public int uyesayisiOku(){
        return this.uyeSayisi;
    }
     
  
}
    
           
public class SingletonClass {

       

    
    
    public static void main(String[] args) {

      hastaneOtomasyonu admin1=hastaneOtomasyonu.getInstance(); 
      hastaneOtomasyonu admin2=hastaneOtomasyonu.getInstance();  
     
      
        
        
        
    }
    
}
