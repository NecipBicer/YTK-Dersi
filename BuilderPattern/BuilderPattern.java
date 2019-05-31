/*
 Hasta adı ve soyadı girilmek zorundadır diğer bilgiler girilmese de olur.
 */
package builderpattern;

class Hasta {

  private final String adi;
  private final String soyadi;
  private  int yasi;
  private  String telefon;
  private  String adres;

    public Hasta(UserBuilder userBuilder) {
        this.adi = userBuilder.adi;
        this.soyadi = userBuilder.soyadi;
        this.yasi = userBuilder.yasi;
        this.telefon = userBuilder.telefon;
        this.adres = userBuilder.adres;
    }

    public String getAdi() {
        return adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public int getYasi() {
        return yasi;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getAdres() {
        return adres;
    }

    @Override
    public String toString() {
        return "Hasta: " + this.adi + ", " + this.soyadi + ", " + this.yasi + ", " + this.telefon + ", " + this.adres;
    }

    public static class UserBuilder {

        private final String adi;
        private final String soyadi;
        private int yasi;
        private String telefon;
        private String adres;

        public UserBuilder(String adi, String soyadi) {
            this.adi = adi;
            this.soyadi = soyadi;
        }

        public UserBuilder yasi(int yasi) {
            this.yasi = yasi;
            return this;
        }

        public UserBuilder telefon(String telefon) {
            this.telefon = telefon;
            return this;
        }

        public UserBuilder adres(String adres) {
            this.adres = adres;
            return this;
        }

        public Hasta build() {
            Hasta hasta = new Hasta(this);
            return hasta;
        }
    }
}
 




public class BuilderPattern {

    
    public static void main(String[] args) {
         Hasta necip = new Hasta.UserBuilder("Necip", "Biçer")
                .yasi(22)
                .telefon("+90 541 614 34 40")
                .telefon("Küçükköy")
                .build();

        Hasta recep = new Hasta.UserBuilder("Recep", "Kara")
                .yasi(22)
                .telefon("+90 530 693 31 20")
                .build();

       

        System.out.println(necip);
        System.out.println(recep);
        
        
        
        
        
        
        
    }
    
}
