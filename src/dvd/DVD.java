package dvd;

import java.util.ArrayList;

public class DVD {
    private String adSoyad, albumBasligi;
    private int cikisTarihi, fiyat;
    private ArrayList<String> sarkiListesi;

    // Constructor
    public DVD(String adSoyad, String albumBasligi, int cikisTarihi, int fiyat, ArrayList<String> sarkiListesi) {
        this.adSoyad = adSoyad;
        this.albumBasligi = albumBasligi;
        this.cikisTarihi = cikisTarihi;
        this.fiyat = fiyat;
        this.sarkiListesi = sarkiListesi;
    }
    
    // Getter-Setter
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAlbumBasligi() {
        return albumBasligi;
    }

    public void setAlbumBasligi(String albumBasligi) {
        this.albumBasligi = albumBasligi;
    }

    public int getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(int cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public ArrayList<String> getSarkiListesi() {
        return sarkiListesi;
    }

    public void setSarkiListesi(ArrayList<String> sarkiListesi) {
        this.sarkiListesi = sarkiListesi;
    }
    
    // İsimleri karşılaştıran metot
    public int compareName(DVD otherDVD) {
        return karsilastir(getAdSoyad(), otherDVD.getAdSoyad());
    }
    
    // Albümleri karşılaştıran metot
    public int compareAlbum(DVD otherDVD) {
        return karsilastir(getAlbumBasligi(), otherDVD.getAlbumBasligi());
    }
    
    // İki stringi alfabetik olarak karşılaştıran metot
    public int karsilastir(String referans, String hedef) {
        referans = normalizeUp(referans);
        hedef = normalizeUp(hedef);
        int uzunluk = referans.length();
        if(hedef.length() < uzunluk) uzunluk = hedef.length();
        for(int i = 0; i < uzunluk; i++) {
            char refharf = referans.charAt(i);
            char hedefharf = hedef.charAt(i);
            if(refharf > hedefharf) return 1;
            else if(refharf < hedefharf) return -1;
        }
        if(referans.length() > hedef.length()) return 1;
        if(referans.length() < hedef.length()) return -1;
        return 0;
    }
    
    /* Dosya okumada bazı karakter sıkıntıları ortaya çıktı
    Scanner ASCII kodu -1 olan karakterler buldu
    Biz de bunun önüne geçmek için ASCII koduna göre stringi düzenleyen bir metot yazdık
    */
    private String normalizeUp(String str) {
        String tmp = "";
        for(int i = 0; i < str.length(); i++) {
            String harf = str.substring(i, i + 1);
            if(harf.equals("ç") || harf.equals("Ç")) tmp = tmp + "C";
            else if(harf.equals("ğ") || harf.equals("Ğ")) tmp = tmp + "G";
            else if(harf.equals("ı") || harf.equals("İ")) tmp = tmp + "I";
            else if(harf.equals("ö") || harf.equals("Ö")) tmp = tmp + "O";
            else if(harf.equals("ş") || harf.equals("Ş")) tmp = tmp + "S";
            else if(harf.equals("ü") || harf.equals("Ü")) tmp = tmp + "U";
            else {
                byte bharf = (byte)(harf.charAt(0));
                if(bharf >= 32) tmp = tmp + harf.toUpperCase();
            }
        }
        return tmp;
    }
    
    @Override
    public String toString() {
        return "Albüm Sahibi: " + this.getAdSoyad()+
                "\nAlbüm Başlığı: " + this.getAlbumBasligi() +
                "\nAlbüm Çıkış Tarihi: " + this.getCikisTarihi() +
                "\nAlbüm Fiyatı: " + this.getFiyat() + " TL" +
                "\nAlbümdeki Şarkılar: " + this.getSarkiListesi();
    }
}
