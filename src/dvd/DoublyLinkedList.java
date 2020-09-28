package dvd;

import java.util.ArrayList;
import javax.swing.JOptionPane;

// Çift bağlı liste sınıfımız
public class DoublyLinkedList {
    
    // "Inner class" olarak çift bağlı düğüm sınıfı
    private class TWN {
        // Düğümlerdeki veriler dvd olacak
        private DVD veri;
        // TwoWayNode sınıfından önceki ve sonraki düğümlerin nesneleri yaratılıyor
        private TWN next, previous;
        
        // Constructor
        public TWN(DVD newDVD) {
            this.veri = newDVD;
        }
        
        // Klasik get metodları ve toString metodu
        public DVD getVeri() {
            return veri;
        }
        
        public TWN getNext() {
            return next;
        }
        
        public TWN getPrevious() {
            return previous;
        }
        
        @Override
        public String toString() {
            return veri.toString();
        }
        // Inner Class'ımızın sonu
    }
    
    // Yeniden çift bağlı liste sınıfına dönüyoruz ve ilgili nesnelerimizi oluşturuyoruz
    private TWN head, tail;
    
    // Constructor'ımız ilk veriyi null'a eşitliyor
    public DoublyLinkedList() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public TWN getHead() {
        return head;
    }
    
    public TWN getTail() {
        return tail;
    }
    
    // DVD'leri ArrayList olarak döndüren bir get metodumuz var
    public ArrayList<DVD> getDVDs() {
        ArrayList<DVD> liste = new ArrayList<>();
        TWN konum = head;
        while(konum != null) {
            liste.add(konum.getVeri());
            konum = konum.next;
        }
        return liste;
    }
    
    // Başa, sona ve sonrasına ekleme metodlarımız listeye eleman eklemede bize yardımcı oluyor
    public void basaEkle(DVD newDVD) {
        // Yeni düğüm oluşturuluyor
        TWN newNode = new TWN(newDVD);
        // Liste boşsa listenin sonu bu düğüme eşitleniyor
        if(isEmpty()) tail = newNode;
        else {
            // Değilse head'i bir sağa kaydırıyoruz
            head.previous = newNode;
            newNode.next = head;
        }
        // Ve yeni düğümü başa ekliyoruz
        head = newNode;
    }
    
    public void sonaEkle(DVD newDVD) {
        // Yeni düğüm oluşturuluyor
        TWN newNode = new TWN(newDVD);
        // Liste boşsa listenin başı bu düğüme eşitleniyor
        if(isEmpty()) head = newNode;
        else {
            // Değilse tail'i bir sola kaydırıyoruz
            tail.next = newNode;
            newNode.previous = tail;
        }
        // Ve yeni düğümü sona ekliyoruz
        tail = newNode;
    }
    
    // Bu metodda referans'ın sonrasına newDVD ekleniyor
    public void sonrasinaEkle(DVD referans, DVD newDVD) {
        // Referans bulunana kadar while döndürülecek
        // Bu yüzden düğümleri dolaşan bir geçici düğüm oluşturduk
        TWN konum = head;
        while(konum.getVeri() != referans) {
            konum = konum.next;
            // Referans bulunamazsa eklenemediğine dair uyarı veriliyor
            if(konum == null) System.out.println("Eklenemedi.");
        }
        
        // Referans bulunursa;
        // Yeni düğüm oluşturuluyor
        TWN newNode = new TWN(newDVD);
        // Referans sondaysa yeni düğüm en sona ekleniyor
        if(konum == tail) {
            newNode.next = null;
            tail = newNode;
        } else {
            // Değilse konumun sonrasına eklenecek şekilde işlemler yapılıyor
            newNode.next = konum.next;
            konum.next.previous = newNode;
        }
        newNode.previous = konum;
        konum.next = newNode;
    }
    
    /* Kayıt ekle metodumuz yukarıdaki 3 metodu kullanarak yeni eklenen kaydı
    alfabetik biçimde veya yıla göre sıralı olarak listede doğru yere eklememizi sağlıyor
    */
    public void kayitEkle(DVD newDVD) {
        // Liste boşsa eleman başa ekleniyor
        if(isEmpty()) basaEkle(newDVD);
        else {
            // Değilse isim karşılaştırmaları yapılıyor ve gerekli metodlar çalıştırılıyor
            TWN konum = head;
            if(konum != null) {
                int compareName = newDVD.compareName(konum.getVeri());
                if(compareName < 0 && konum.previous == null) {
                    basaEkle(newDVD);
                }
                else if(compareName < 0) {
                    sonrasinaEkle(konum.previous.getVeri(), newDVD);
                }
                else if(compareName > 0 && konum.next == null) {
                    sonaEkle(newDVD);
                }
                else if(compareName > 0) {
                    konum = konum.next;
                    boolean added = false;
                    while(konum != null && !added) {
                        compareName = newDVD.compareName(konum.getVeri());
                        if(compareName < 0) {
                            sonrasinaEkle(konum.previous.getVeri(), newDVD);
                            added = true;
                        }
                        else if(compareName == 0) {
                            if(newDVD.getCikisTarihi() < konum.getVeri().getCikisTarihi()) {
                                sonrasinaEkle(konum.previous.getVeri(), newDVD);
                                added = true;
                            }
                            else {
                                sonrasinaEkle(konum.getVeri(), newDVD);
                                added = true;
                            }
                        }
                        konum = konum.next;
                    }
                    if(!added) sonaEkle(newDVD);
                }
                else {
                    // İsme göre karşılaştırmada eşitlik söz konusu olunca yıla göre ekleniyor
                    if(newDVD.getCikisTarihi() < konum.getVeri().getCikisTarihi()) {
                        sonrasinaEkle(konum.previous.getVeri(), newDVD);
                    }
                    else sonrasinaEkle(konum.getVeri(), newDVD);
                }
            }
        }
    }
    
    // Kayıt silerken kolaylık sağlaması açısından yazılan "private" bir metot
    private TWN kayitAra(DVD referans) {
        // Geçici düğüm oluşturuluyor
        TWN konum = head;
        // While döngüsüyle aranan düğüm bulunursa döndürülüyor
        while(konum != null) {
            if(konum.getVeri().compareName(referans) == 0 && konum.getVeri().compareAlbum(referans) == 0) {
                return konum;
            }
            konum = konum.next;
        }
        // Bulunamazsa null döndürülüyor
        return null;
    }
    
    // Kullanıcının girdiği ad-soyad ve albüm başlığına göre dvd silmeye yarayan metod
    public void kayitSil(DVD hedefDVD) {
        // Liste boşsa uyarı mesajı gönderiliyor
        if(isEmpty()) {
            System.out.println("Liste boş");
            JOptionPane.showMessageDialog(null, "Liste Boş");
        }
        TWN kayit = kayitAra(hedefDVD);
        if(kayit != null) {
            // Aranan kayıt bulunursa silinmesi için gereken işlemler yapılıyor
            TWN sonraki = kayit.getNext();
            TWN onceki = kayit.getPrevious();
            kayit.next = kayit.previous = null;
            if(kayit == head) head = sonraki;
            if(kayit == tail) tail = onceki;
            if(sonraki != null) sonraki.previous = onceki;
            if(onceki != null) onceki.next = sonraki;
        } else {
            System.out.println("Kayıt Bulunamadı");
            JOptionPane.showMessageDialog(null, "Kayıt Bulunamadı");
        }
    }
    
    // Listedeki elemanları alfabetik sıralı bir şekilde konsola yazdıran metot
    public void yazdir() {
        TWN konum = head;
        if(konum == null) {
            System.out.println("Liste boş");
        }
        while(konum != null) {
            System.out.println(konum.getVeri().toString());
            konum = konum.next;
            System.out.println();
        }
    }
    
    // Listedeki elemanları alfabetik sıralı bir şekilde string olarak döndüren metod
    public String sirala() {
        StringBuilder sb = new StringBuilder();
        TWN konum = head;
        if(konum == null) return "Liste boş";
        while(konum != null) {
            sb.append(konum.getVeri().toString());
            sb.append("\n");
            konum = konum.next;
        }
        return sb.toString();
    }
    
    // Listedeki elemanları tersten alfabetik sıralı bir şekilde konsola yazdıran metot
    public void tersYazdir() {
        TWN konum = tail;
        if(head == null) {
            System.out.println("Liste boş");
        }
        while(konum != null) {
            System.out.println(konum.getVeri().toString());
            konum = konum.previous;
            System.out.println();
        }
    }
    
    // Listedeki elemanları tersten alfabetik sıralı bir şekilde string olarak döndüren metod
    public String tersSirala() {
        StringBuilder sb = new StringBuilder();
        TWN konum = tail;
        if(head == null) return "Liste boş";
        while(konum != null) {
            sb.append(konum.getVeri().toString());
            sb.append("\n");
            konum = konum.previous;
        }
        return sb.toString();
    }
    
    // 2000'den önce piyasaya çıkan albümleri konsola yazdıran metot
    public void milenyumYazdir() {
        TWN konum = head;
        if(konum == null) {
            System.out.println("Liste boş");
        }
        while(konum != null) {
            int yil = konum.getVeri().getCikisTarihi();
            if(yil < 2000) System.out.println(konum.getVeri().toString());
            konum = konum.next;
            System.out.println();
        }
    }
    
    // 2000'den önce piyasaya çıkan albümleri string olarak döndüren metot
    public String milenyumSirala() {
        StringBuilder sb = new StringBuilder();
        TWN konum = head;
        if(konum == null) return "Liste boş";
        while(konum != null) {
            int yil = konum.getVeri().getCikisTarihi();
            if(yil < 2000) {
                sb.append(konum.getVeri().toString());
                sb.append("\n");
            }
            konum = konum.next;
        }
        return sb.toString();
    }
    
    // Adı verilen sanatçının albüm listesini string olarak döndüren metot
    public String sanatciBilgisiYazdir(DVD dvd) {
        TWN konum = head;
        String adSoyad = dvd.getAdSoyad();
        String str = "";
        while(konum != null) {
            String konumAd = konum.getVeri().getAdSoyad();
            if(konum.getVeri().karsilastir(konumAd, adSoyad) == 0) {
                str = str + konum.getVeri().toString() + "\n";
            }
            konum = konum.next;
        }
        return str;
    }
    
    // Dosyanın üstüne yazılması için gereken şablonu string olarak döndüren metot
    public String dosyayaYaz(DVD dvd) {
        String str = "";
        str = str + dvd.getAdSoyad() + ", " + dvd.getAlbumBasligi() + ", " + dvd.getCikisTarihi() + ", " + dvd.getFiyat() + ", ";
        ArrayList<String> sarkilar = dvd.getSarkiListesi();
        int sonindex = sarkilar.size() - 1;
        for(String sarki : sarkilar) {
            if(sarki.equals(sarkilar.get(sonindex))) str += sarki;
            else str += sarki + ", ";
        }
        return str;
    }
}
