package com.turkkrallik;

public class KrallikBinaManager {

    // O 150 yatak sınırını çöpe atan sınırsız nüfus motoru!
    private static int toplamKislaSayisi = 0;
    private static int toplamEvSayisi = 0;

    // Oyuncu yeni bir Kışla kurduğunda kapasiteye sınırsız ordu eklenir
    public static void kislaEkle() {
        toplamKislaSayisi++;
    }

    // Oyuncu ev kurdukça nüfus sınırı olmadan köylü/işçi kapasitesi artar
    public static void evEkle() {
        toplamEvSayisi++;
    }

    // Kışla başına 20 asker kapasitesi (İstediğin kadar Kışla kurabilirsin!)
    public static int getMaxAskerKapasitesi() {
        return toplamKislaSayisi * 20; 
    }

    // Ev başına sınırsız köylü desteği
    public static int getMaxKoyluKapasitesi() {
        return toplamEvSayisi * 10;
    }
}