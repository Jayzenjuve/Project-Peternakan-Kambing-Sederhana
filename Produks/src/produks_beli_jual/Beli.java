package produks_beli_jual;

public class Beli extends Jual{
    
    String nama, TanggalBeli;
    
    public Beli(){}
    
    public void inputNama(String nama){
        this.nama=nama;
    }
    
    public String ambilNama(){
        return this.nama;
    }    
    
    public void inputTanggalBeli(String TanggalBeli){
        this.TanggalBeli = TanggalBeli;
    }
    
    public String ambilTanggalBeli(){
        return this.TanggalBeli;
    }
    
    public int totalBayar(){
        return ambilHarga() * ambilJumlah();
    }
    
}
