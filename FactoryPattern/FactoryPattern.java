/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonclass;

import java.util.Scanner;

interface unvanBelirleme {
    hastaneOtomasyon kisiBelirleme();
}

class hastaneOtomasyon {
    private String unvan;
// Hastane otomasyonunda doktor ve hasta olarak iki kişilik tanımlanmıştır.Bilgisayardan girilen kişi ünvanına göre kod nesne üretmektedir.
    public hastaneOtomasyon(String unvan) {
        this.unvan = unvan;
    }

    @Override
    public String toString() {
        return unvan + " olarak sisteme kaydedildi.";
    }
}

class Doktor implements unvanBelirleme {
    private hastaneOtomasyon unvan;

    public Doktor(String unvan) {
        this.unvan = new hastaneOtomasyon(unvan);
    }

    @Override
    public hastaneOtomasyon kisiBelirleme() {
        return unvan;
    }
}

class Hasta implements unvanBelirleme {
    private hastaneOtomasyon unvan;

    public Hasta(String unvan) {
       this.unvan = new hastaneOtomasyon(unvan);
    }

    @Override
    public hastaneOtomasyon kisiBelirleme() {
        return unvan;
    }
}

public class factoryDesign {
    public static void main(String[] args) {
        hastaneOtomasyon unvan;
        unvanBelirleme kisi = null;
        Scanner keyboard=new Scanner(System.in);
        String meslek = keyboard.next();
        if (meslek.equals("doktor")) {
            kisi = new Doktor(meslek);
        }
        if (meslek.equals("hasta")) {
            kisi = new Hasta(meslek);
        }
       
        unvan = kisi.kisiBelirleme();
        System.out.println(unvan);
    }
}
