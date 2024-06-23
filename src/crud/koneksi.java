package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class koneksi {
    
    private String databaseName = "dbpeternakan_2210010125";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/"+databaseName;
    
    public static Connection koneksiDB;
    
    
    public koneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi,username,password);
            System.out.println("Database Terkoneksi");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    public void simpanProduks(int paramid, String paramjenis, String paramnama, int paramharga){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "INSERT INTO produks (id,jenis,nama,harga,created_at,updated_at)"
                    + "VALUE(?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setString(2, paramjenis);
            perintah.setString(3, paramnama);
            perintah.setInt(4, paramharga);
            perintah.setString(5, currentDateTime);
            perintah.setString(6, currentDateTime);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ubahProduks(int paramid, String paramjenis, String paramnama, int paramharga){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "UPDATE produks SET jenis = ?, nama = ?, harga = ?, updated_at = ? WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramjenis);
            perintah.setString(2, paramnama);
            perintah.setInt(3, paramharga);
            perintah.setString(4, currentDateTime);
            perintah.setInt(5, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Ubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void hapusProduks(int paramid){
        try {
            String SQL = "DELETE FROM produks WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Hapus");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void cariProduks(int paramid){
        try {
            String SQL = "SELECT * FROM produks WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID : "+data.getInt("id"));
                System.out.println("Jenis : "+data.getString("jenis"));
                System.out.println("Nama : "+data.getString("nama")); 
                System.out.println("Created_At : "+data.getString("created_at")); 
                System.out.println("Updated_At : "+data.getString("updated_at")); 
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void dataProduks(){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM produks ORDER BY id ASC");
            while(baris.next()){
                System.out.println(baris.getInt("id")+" | "+
                        baris.getString("jenis")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("created_at")+" | "+
                        baris.getString("updated_at"));
            }
                    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void simpanProduksBeli(int paramid, String paramjenis, int paramjumlah, String paramtanggalbeli, int paramharga, int paramidproduk){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "INSERT INTO produk_belis (id,jenis,jumlah,tanggal_beli,harga,created_at,updated_at,produks_id)"
                    + "VALUE(?,?,?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setString(2, paramjenis);
            perintah.setInt(3, paramjumlah);
            perintah.setString(4, paramtanggalbeli);
            perintah.setInt(5, paramharga);
            perintah.setString(6, currentDateTime);
            perintah.setString(7, currentDateTime);
            perintah.setInt(8, paramidproduk);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ubahProduksBeli(int paramid, String paramjenis, int paramjumlah, String paramtanggalbeli, int paramharga, int paramidproduk){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "UPDATE produk_belis SET jenis = ?, jumlah = ?, tanggal_beli = ?, harga = ?, updated_at = ?, produks_id = ? WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramjenis);
            perintah.setInt(2, paramjumlah);
            perintah.setString(3, paramtanggalbeli);
            perintah.setInt(4, paramharga);
            perintah.setString(5, currentDateTime);
            perintah.setInt(6, paramidproduk);
            perintah.setInt(7, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Ubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public void hapusProduksBeli(int paramid){
        try {
            String SQL = "DELETE FROM produk_belis WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Hapus");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void simpanProduksJual(int paramid, String paramjenis, int paramjumlah, String paramtanggalbeli, int paramharga, int paramidproduk){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "INSERT INTO produk_juals (id,jenis,jumlah,tanggal_jual,harga,created_at,updated_at,produks_id)"
                    + "VALUE(?,?,?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setString(2, paramjenis);
            perintah.setInt(3, paramjumlah);
            perintah.setString(4, paramtanggalbeli);
            perintah.setInt(5, paramharga);
            perintah.setString(6, currentDateTime);
            perintah.setString(7, currentDateTime);
            perintah.setInt(8, paramidproduk);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ubahProduksJual(int paramid, String paramjenis, int paramjumlah, String paramtanggalbeli, int paramharga, int paramidproduk){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "UPDATE produk_juals SET jenis = ?, jumlah = ?, tanggal_jual = ?, harga = ?, updated_at = ?, produks_id = ? WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramjenis);
            perintah.setInt(2, paramjumlah);
            perintah.setString(3, paramtanggalbeli);
            perintah.setInt(4, paramharga);
            perintah.setString(5, currentDateTime);
            perintah.setInt(6, paramidproduk);
            perintah.setInt(7, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Ubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public void hapusProduksJual(int paramid){
        try {
            String SQL = "DELETE FROM produk_juals WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Hapus");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void simpanSaldo(int paramid, int paramsaldo){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try{
            String SQL = "INSERT INTO saldos (id,saldo,created_at,updated_at)"
                    + "VALUE(?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setInt(2, paramsaldo);
            perintah.setString(3, currentDateTime);
            perintah.setString(4, currentDateTime);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void ubahSaldo(int paramid, int paramsaldo){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try{
            String SQL = "UPDATE saldos SET saldo = ?, updated_at = ? WHERE ID = ?";

            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramsaldo);
            perintah.setString(2, currentDateTime);
            perintah.setInt(3, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Ubah");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void hapusSaldo(int paramid){
        try{
            String SQL = "DELETE FROM saldo WHERE ID = ?";
            
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Hapus");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void simpanPemasukkan(int paramid, String paramnama, String paramtgl, int paramharga){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try{
            String SQL = "INSERT INTO pemasukkans (id,nama,tanggal,harga,created_at,updated_at)"
                    + "VALUE(?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setString(2, paramnama);
            perintah.setString(3, paramtgl);
            perintah.setInt(4, paramharga);
            perintah.setString(5, currentDateTime);
            perintah.setString(6, currentDateTime);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void ubahPemasukkan(int paramid, String paramnama, String paramtgl, int paramharga){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try{
            String SQL = "UPDATE pemasukkans SET nama = ?, tanggal = ?, harga = ?, updated_at = ? WHERE ID = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramnama);
            perintah.setString(2, paramtgl);
            perintah.setInt(3, paramharga);
            perintah.setString(4, currentDateTime);
            perintah.setInt(5, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Ubah");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void hapusPemasukkan(int paramid){
        try{
            String SQL = "DELETE FROM pemasukkans WHERE ID = ?";
            
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Hapus");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void simpanPengeluaran(int paramid, String paramnama, String paramtgl, int paramharga){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try{
            String SQL = "INSERT INTO pengeluarans (id,nama,tanggal,harga,created_at,updated_at)"
                    + "VALUE(?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setString(2, paramnama);
            perintah.setString(3, paramtgl);
            perintah.setInt(4, paramharga);
            perintah.setString(5, currentDateTime);
            perintah.setString(6, currentDateTime);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void ubahPengeluaran (int paramid, String paramnama, String paramtgl, int paramharga){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try{
            String SQL = "UPDATE pengeluarans SET nama = ?, tanggal = ?, harga = ?, updated_at = ? WHERE ID = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramnama);
            perintah.setString(2, paramtgl);
            perintah.setInt(3, paramharga);
            perintah.setString(4, currentDateTime);
            perintah.setInt(5, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Ubah");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void hapusPengeluaran (int paramid){
        try{
            String SQL = "DELETE FROM pengeluarans WHERE ID = ?";
            
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Hapus");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
