package produks_beli_jual;

import com.mysql.cj.util.Util;
import java.security.Timestamp;
import java.text.SimpleDateFormat;


public class Jual {
    
    String jenis, namaProduk ;
    int jumlah, harga;
    
    public Jual(){}
    
    public Jual(String jenis, int jumlah, int harga){
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
    public void inputJenis(String jenis){
        this.jenis = jenis;
    }

    public String ambilJenis(){
        return this.jenis;
    }
    
    public String namaProduk(){
        if(this.jenis.equals("I")){
            this.namaProduk = "Paket Gamal";
        }else if(this.jenis.equals("II")){
            this.namaProduk = "Paket Daun Singkong";       
        }else if(this.jenis.equals("III")){
            this.namaProduk = "Paket Turi";
        }else if(this.jenis.equals("IV")){
            this.namaProduk = "Paket Kaliandra";
        }else{
            this.namaProduk = "Paket Rumput Gajah Taiwan";
        }
        return this.namaProduk;    
    }
    public int ambilHarga(){
        this.harga = 0;
        if(this.jenis.equals("I")){
            this.harga = 500000;
        }else if(this.jenis.equals("II")){
           this.harga = 600000;         
        }else if(this.jenis.equals("III")){
            this.harga = 700000;
        }else if(this.jenis.equals("IV")){
            this.harga = 800000;
        }else{
            this.harga = 1000000;
        }
        return this.harga;
    }
    public void inputJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    
    public int ambilJumlah(){
        return this.jumlah;
    }   
    
}
