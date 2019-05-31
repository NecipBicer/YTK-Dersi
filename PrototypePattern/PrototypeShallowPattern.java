package prototype;

class RandevuBolumu
{
    String rnd;
 
    
 
    public RandevuBolumu(String rnd )
    {
        this.rnd = rnd;
 
        
       
    }
}
 
class Hasta implements Cloneable
{
    int no;
 
    String name;
 
    RandevuBolumu randevubolumu;
 
    public Hasta(int no, String name, RandevuBolumu randevubolumu)
    {
        this.no = no;
 
        this.name = name;
 
        this.randevubolumu = randevubolumu;
    }
 
   
 
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
 
public class Prototype
{
    public static void main(String[] args)
    {
        RandevuBolumu rndbolum = new RandevuBolumu("Kadın Dooğum bölümü");
 
        Hasta hasta1 = new Hasta(444, "necip", rndbolum);
 
        Hasta hasta2 = null;
 
        try
        {
            
 
            hasta1 = (Hasta) hasta2.clone();
        }
        catch (Exception e)
        {
            
        }
 
       
 
       
        
    }
}
