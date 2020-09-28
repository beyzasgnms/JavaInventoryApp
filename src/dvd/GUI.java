package dvd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class GUI extends javax.swing.JFrame {
    
    ImageIcon icon = new ImageIcon("icon.png");
    static Scanner read = null;
    static DVD dvd = null;
    static DoublyLinkedList list = null;
    SortGUI sort;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sarkiciAdiLabel = new javax.swing.JLabel();
        sarkiciAdiTextBox = new javax.swing.JTextField();
        albumAdiLabel = new javax.swing.JLabel();
        albumAdiTextBox = new javax.swing.JTextField();
        albumYiliLabel = new javax.swing.JLabel();
        albumYiliTextBox = new javax.swing.JTextField();
        albumFiyatiLabel = new javax.swing.JLabel();
        albumFiyatiTextBox = new javax.swing.JTextField();
        sarkiListesiLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sarkiListesiTextBox = new javax.swing.JTextArea();
        actionSelect = new javax.swing.JComboBox<>();
        actionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DVD Envanteri");
        setIconImage(icon.getImage());
        setResizable(false);

        sarkiciAdiLabel.setText("Şarkıcı Adı:");

        sarkiciAdiTextBox.setToolTipText("");

        albumAdiLabel.setText("Albüm Adı:");

        albumYiliLabel.setText("Albüm Yılı:");

        albumFiyatiLabel.setText("Albüm Fiyatı:");

        sarkiListesiLabel.setText("Şarkı Listesi (Şarkıları virgül ile ayırınız):");
        sarkiListesiLabel.setAutoscrolls(true);

        jScrollPane1.setBorder(null);

        sarkiListesiTextBox.setColumns(20);
        sarkiListesiTextBox.setLineWrap(true);
        sarkiListesiTextBox.setRows(5);
        sarkiListesiTextBox.setWrapStyleWord(true);
        jScrollPane1.setViewportView(sarkiListesiTextBox);

        actionSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DVD Ekle", "DVD Sil", "DVD Görüntüle", "A-Z Sırala", "Z-A Sırala", "2000 Öncesi Albümleri Listele" }));
        actionSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionSelectActionPerformed(evt);
            }
        });

        actionButton.setText("Ekle");
        actionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(actionSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(actionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(sarkiciAdiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sarkiciAdiTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(sarkiListesiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(albumAdiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(albumAdiTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(albumYiliLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(albumYiliTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(albumFiyatiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(albumFiyatiTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(actionSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(actionButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sarkiciAdiLabel)
                        .addComponent(sarkiciAdiTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(albumAdiLabel)
                        .addComponent(albumAdiTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(albumYiliLabel)
                        .addComponent(albumYiliTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(albumFiyatiLabel)
                        .addComponent(albumFiyatiTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(sarkiListesiLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sarkiciAdiLabel.getAccessibleContext().setAccessibleName("");
        sarkiciAdiTextBox.getAccessibleContext().setAccessibleName("");
        albumAdiLabel.getAccessibleContext().setAccessibleName("");
        albumYiliLabel.getAccessibleContext().setAccessibleName("");
        albumFiyatiLabel.getAccessibleContext().setAccessibleName("");
        sarkiListesiLabel.getAccessibleContext().setAccessibleName("");
        actionButton.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionSelectActionPerformed
        // TODO add your handling code here:
        // Seçilen seçeneğe göre arayüzde bulunan elemanların görünürlüğü ayarlanıyor
        String selectedAction = actionSelect.getSelectedItem().toString();
        if(selectedAction.equals("DVD Ekle")) {
            sarkiciAdiLabel.setVisible(true);
            sarkiciAdiTextBox.setVisible(true);
            albumAdiLabel.setVisible(true);
            albumAdiTextBox.setVisible(true);
            albumYiliLabel.setVisible(true);
            albumYiliTextBox.setVisible(true);
            albumFiyatiLabel.setVisible(true);
            albumFiyatiTextBox.setVisible(true);
            sarkiListesiLabel.setVisible(true);
            sarkiListesiTextBox.setVisible(true);
            actionButton.setVisible(true);
            actionButton.setText("Ekle");
        }
        else if(selectedAction.equals("DVD Sil")) {
            sarkiciAdiLabel.setVisible(true);
            sarkiciAdiTextBox.setVisible(true);
            albumAdiLabel.setVisible(true);
            albumAdiTextBox.setVisible(true);
            albumYiliLabel.setVisible(false);
            albumYiliTextBox.setVisible(false);
            albumFiyatiLabel.setVisible(false);
            albumFiyatiTextBox.setVisible(false);
            sarkiListesiLabel.setVisible(false);
            sarkiListesiTextBox.setVisible(false);
            actionButton.setVisible(true);
            actionButton.setText("Sil");
        }
        else if(selectedAction.equals("DVD Görüntüle")) {
            sarkiciAdiLabel.setVisible(true);
            sarkiciAdiTextBox.setVisible(true);
            albumAdiLabel.setVisible(false);
            albumAdiTextBox.setVisible(false);
            albumYiliLabel.setVisible(false);
            albumYiliTextBox.setVisible(false);
            albumFiyatiLabel.setVisible(false);
            albumFiyatiTextBox.setVisible(false);
            sarkiListesiLabel.setVisible(false);
            sarkiListesiTextBox.setVisible(false);
            actionButton.setVisible(true);
            actionButton.setText("Görüntüle");
        }
        else {
            sarkiciAdiLabel.setVisible(false);
            sarkiciAdiTextBox.setVisible(false);
            albumAdiLabel.setVisible(false);
            albumAdiTextBox.setVisible(false);
            albumYiliLabel.setVisible(false);
            albumYiliTextBox.setVisible(false);
            albumFiyatiLabel.setVisible(false);
            albumFiyatiTextBox.setVisible(false);
            sarkiListesiLabel.setVisible(false);
            sarkiListesiTextBox.setVisible(false);
            actionButton.setVisible(false);
            // Sıralama seçeneklerinden biri seçilirse açılır pencerede uygun şekilde listeleniyor
            if(selectedAction.contains("A-Z")) {
                System.out.println(selectedAction);
                list.yazdir();
                String siraliListe = list.sirala();
                sort = new SortGUI(siraliListe);
                sort.setTitle(selectedAction);
                sort.setVisible(true);
            }
            else if(selectedAction.contains("Z-A")) {
                System.out.println(selectedAction);
                list.tersYazdir();
                String tersListe = list.tersSirala();
                sort = new SortGUI(tersListe);
                sort.setTitle(selectedAction);
                sort.setVisible(true);
            }
            else {
                System.out.println(selectedAction);
                list.milenyumYazdir();
                String milenyum = list.milenyumSirala();
                sort = new SortGUI(milenyum);
                sort.setTitle(selectedAction);
                sort.setVisible(true);
            }
        }
    }//GEN-LAST:event_actionSelectActionPerformed

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButtonActionPerformed
        // TODO add your handling code here:
        // Butona basıldığında yeni dvd nesnesi oluşturuluyor
        DVD yeniDVD = null;
        String buttonLabel = actionButton.getText();
        String sarkiciAdi = sarkiciAdiTextBox.getText();
        String albumBasligi = albumAdiTextBox.getText();
        int albumYili = 0, albumFiyati = 0;
        ArrayList<String> sarkiListesi = null;
        String[] sarkiListesiArray = null;
        try {
            albumYili = Integer.parseInt(albumYiliTextBox.getText());
            albumFiyati = Integer.parseInt(albumFiyatiTextBox.getText());
            sarkiListesi = new ArrayList<>();
            sarkiListesiArray = sarkiListesiTextBox.getText().split(",");
            sarkiListesi.addAll(Arrays.asList(sarkiListesiArray));
        }
        catch(NumberFormatException e) {
        }

        yeniDVD = new DVD(sarkiciAdi, albumBasligi, albumYili, albumFiyati, sarkiListesi);
        File file = new File("bilgiler.txt");
        if(!file.exists()) {
            try {
            file.createNewFile();
            } catch (IOException e) {
                System.out.println("Dosya okunamadı/oluşturulamadı.");
            }
        }
        BufferedWriter bw = null;
        
        switch (buttonLabel) {
            case "Ekle":
                list.kayitEkle(yeniDVD);
                list.yazdir();
                String dosyayaEkle = list.dosyayaYaz(yeniDVD);
                try {
                    // Dosyaya yazma işlemi yapılıyor
                    bw = new BufferedWriter(new FileWriter(file, true));
                    bw.newLine();
                    bw.append(dosyayaEkle);
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Dosya düzenlenemedi");
                }
                break;
            case "Sil":
                list.kayitSil(yeniDVD);
                list.yazdir();
                String dosyayiYaz = "";
                ArrayList<DVD> dvdler = list.getDVDs();
                try {
                    for(int i = 0; i < dvdler.size(); i++) {
                        // Silinen dvd dosyadan da siliniyor
                        bw = new BufferedWriter(new FileWriter(file, false));
                        dosyayiYaz += list.dosyayaYaz(dvdler.get(i));
                        dosyayiYaz += System.lineSeparator();
                        bw.append(dosyayiYaz);
                        bw.newLine();
                    }
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Dosya düzenlenemedi");
                }
                break;
            case "Görüntüle":
                System.out.println(list.sanatciBilgisiYazdir(yeniDVD));
                String bilgiler = list.sanatciBilgisiYazdir(yeniDVD);
                if(bilgiler.equals("")) {
                    bilgiler = "Sanatçıya ait albüm bilgisi envanterde bulunamadı";
                }
                sort = new SortGUI(bilgiler);
                sort.setTitle(buttonLabel);
                sort.setVisible(true);
        }
    }//GEN-LAST:event_actionButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Uygulama çalışır çalışmaz dosyanın varlığı sorgulanıyor
        read = null;
        try {
            read = new Scanner(new FileInputStream("bilgiler.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadı.");
            System.exit(0);
        }
        
        // Ve liste oluşturuluyor
        list = new DoublyLinkedList();
        
        // Dosyadaki satırlar elemanlarına ayrılıp dvd nesnesi oluşturuluyor
        // Ve oluşturulan nesne listeye ekleniyor
        while(read.hasNext()) {
            String satir = read.nextLine();
            String[] satirElemanlari = satir.split(",");
            int elemanSay = satirElemanlari.length;
            String sarkiciAdi = satirElemanlari[0].trim();
            String albumBasligi = satirElemanlari[1].trim();
            int albumYili = Integer.parseInt(satirElemanlari[2].trim());
            int albumFiyati = Integer.parseInt(satirElemanlari[3].trim());
            ArrayList<String> sarkiListesi = new ArrayList<>();
            for(int i = 4; i < elemanSay; i++) {
                sarkiListesi.add(satirElemanlari[i].trim());
            }
            dvd = new DVD(sarkiciAdi, albumBasligi, albumYili, albumFiyati, sarkiListesi);
            list.kayitEkle(dvd);
        }
        list.yazdir();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionButton;
    private javax.swing.JComboBox<String> actionSelect;
    private javax.swing.JLabel albumAdiLabel;
    private javax.swing.JTextField albumAdiTextBox;
    private javax.swing.JLabel albumFiyatiLabel;
    private javax.swing.JTextField albumFiyatiTextBox;
    private javax.swing.JLabel albumYiliLabel;
    private javax.swing.JTextField albumYiliTextBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sarkiListesiLabel;
    private javax.swing.JTextArea sarkiListesiTextBox;
    private javax.swing.JLabel sarkiciAdiLabel;
    private javax.swing.JTextField sarkiciAdiTextBox;
    // End of variables declaration//GEN-END:variables
}
