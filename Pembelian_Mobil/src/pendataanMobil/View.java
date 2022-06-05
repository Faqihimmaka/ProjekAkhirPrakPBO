package pendataanMobil;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lenovo
 */
public class View extends JFrame{
    JLabel lNoHP = new JLabel("No.HP");
    JLabel lnama = new JLabel("Nama");
    JLabel lPembelian = new JLabel("Pembelian Ke - ");
    JLabel lTipe = new JLabel("Tipe Mobil");
    JLabel lTanggal = new JLabel("Tanggal");
    
    public JTextField tfNoHP = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfPembelian = new JTextField();
    String [] tipe = {"Avanza", "Rush", "Yaris", "Fortuner", "Innova", "Agya", "Calya", "Vioz" };
    public JComboBox tipeMobil = new JComboBox(tipe);
    public JTextField tftanggal = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"NO.HP", "Nama", "Pembelian Ke", "Tipe Mobil", "Tanggal"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Pendataan Pembelian Mobil Di Showroom Toyota");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(850,550);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 630, 450);
        
        add(lNoHP);
        lNoHP.setBounds(670, 20, 90, 20);
        add(tfNoHP);
        tfNoHP.setBounds(670, 40, 120, 20);
        
        add(lnama);
        lnama.setBounds(670, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(670, 80, 120, 20);
        
        add(lPembelian);
        lPembelian.setBounds(670, 100, 90, 20);
        add(tfPembelian);
        tfPembelian.setBounds(670, 120, 120, 20);
        
        add(lTipe);
        lTipe.setBounds(670, 140, 90, 20);
        add(tipeMobil);
        tipeMobil.setBounds(670, 160, 120, 20);
        
        add(lTanggal);
        lTanggal.setBounds(670, 180, 90, 20);
        add(tftanggal);
        tftanggal.setBounds(670, 200, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(670, 230, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(670, 260, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(670, 290, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(670, 320, 90, 20);
    }
    
    public String getNoHP(){
        return tfNoHP.getText();
    }
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public String getPembelian(){
        return tfPembelian.getText();
    }
    
    public String getMobil(){
        return (String) tipeMobil.getSelectedItem();
    }
    
    public String getTanggal(){
        return tftanggal.getText();
    }
}
