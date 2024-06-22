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
    
    public void simpanProduks(int paramid, String paramjenis, String paramnama){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "INSERT INTO produks (id,jenis,nama,created_at,updated_at)"
                    + "VALUE(?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramid);
            perintah.setString(1, paramjenis);
            perintah.setString(2, paramnama);
            perintah.setString(3, currentDateTime);
            perintah.setString(4, currentDateTime);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Di Simpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ubahProduks(int paramid, String paramjenis, String paramnama){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        
        try {
            String SQL = "UPDATE produks SET jenis = ?, nama = ?, updated_at = ? WHERE id = ?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramjenis);
            perintah.setString(2, paramnama);
            perintah.setString(3, currentDateTime);
            perintah.setInt(4, paramid);
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
    
    
    
}
