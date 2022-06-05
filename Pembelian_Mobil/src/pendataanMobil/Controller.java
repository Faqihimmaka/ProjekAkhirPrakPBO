package pendataanMobil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Lenovo
 */
public class Controller {
    Model modelPembelian;
    View viewPembelian;
    public String data;
    public Controller(Model modelPembelian, View viewPembelian){
        this.modelPembelian = modelPembelian;
        this.viewPembelian = viewPembelian;
        
        if (modelPembelian.getBanyakData()!=0) {
            String dataPembelian[][] = modelPembelian.readData();
            viewPembelian.tabel.setModel((new JTable(dataPembelian, viewPembelian.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        
         viewPembelian.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String NoHP = viewPembelian.getNoHP();
                String Nama = viewPembelian.getNama();
                
                String tipe_mobil = viewPembelian.getMobil();
                String Tanggal = viewPembelian.getTanggal();
                if(NoHP.isEmpty() || Nama.isEmpty() || viewPembelian.getPembelian().isEmpty() || Tanggal.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }else{
                    int pembelianKe = Integer.parseInt(viewPembelian.getPembelian());
                    modelPembelian.insertData(NoHP, Nama, pembelianKe, tipe_mobil, Tanggal);
                }
                
         
                String dataPembelian[][] = modelPembelian.readData();
                viewPembelian.tabel.setModel((new JTable(dataPembelian, viewPembelian.namaKolom)).getModel());
            }
        });
         
          viewPembelian.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String NoHP = viewPembelian.getNoHP();
                String Nama = viewPembelian.getNama();
                int pembelianKe = Integer.parseInt(viewPembelian.getPembelian());
                String tipe_mobil = viewPembelian.getMobil();
                String Tanggal = viewPembelian.getTanggal();
                modelPembelian.updateData(NoHP, Nama, pembelianKe, tipe_mobil, Tanggal);

                String dataPembelian[][] = modelPembelian.readData();
                viewPembelian.tabel.setModel((new JTable(dataPembelian, viewPembelian.namaKolom)).getModel());
            }
        });
         
          viewPembelian.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                viewPembelian.tfNoHP.setText("");
                viewPembelian.tfNama.setText("");
                viewPembelian.tfPembelian.setText("");
                viewPembelian.tftanggal.setText("");
            }
        });
        
    
          viewPembelian.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = viewPembelian.tabel.getSelectedRow();
                data = viewPembelian.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = viewPembelian.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = viewPembelian.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          viewPembelian.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus NoHP " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelPembelian.deleteData(data);
                String dataPembelian[][] = modelPembelian.readData();
                viewPembelian.tabel.setModel((new JTable(dataPembelian, viewPembelian.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
    
}
