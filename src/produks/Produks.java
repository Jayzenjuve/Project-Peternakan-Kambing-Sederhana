package produks;

import produks_beli_jual.*;
import java.util.Scanner;
import java.util.ArrayList;
import crud.koneksi;

public class Produks {


    public static void main(String[] args) {
        koneksi db = new koneksi();
        db.dataProduks();
//       Beli jalan = new Beli();
//       Scanner input = new Scanner(System.in);
//       
//        System.out.println("========================Pemesanan========================");
//        System.out.print("Nama : ");
//        jalan.inputNama(input.nextLine());
//        System.out.print("Masukkan Tanggal Pembelian (dd/mm/yyyyy) : ");
//        jalan.inputTanggalBeli(input.nextLine());
//
//        System.out.println("=========================Produk==========================");
//        System.out.println("=========================Jenis===========================");
//        System.out.println("| I   Paket Gamal                   |   Rp.500.000      |");
//        System.out.println("| II  Paket Daun Singkong           |   Rp.600.000      |");
//        System.out.println("| III Paket Turi                    |   Rp.700.000      |");
//        System.out.println("| IV  Paket Kaliandra               |   Rp.800.000      |");
//        System.out.println("| V   Pakat Rumput Gajah Taiwan     |   Rp.1.000.000    |");
//        System.out.println("=========================================================");
//        
//        System.out.print("Masukkan Jenis Produk : ");
//        jalan.inputJenis(input.nextLine());
//        System.out.print("Masukkan Jumlah Beli : ");
//        jalan.inputJumlah(input.nextInt());
//        
//        System.out.println("=======================Detail Beli=======================");
//        
//        System.out.println("Nama : "+jalan.ambilNama());
//        System.out.println("Nama Produk : "+jalan.namaProduk());
//        System.out.println("Tanggal : "+jalan.ambilTanggalBeli());
//        System.out.println("Jumlah : "+jalan.ambilJumlah());
//        System.out.println("Total : "+jalan.totalBayar());
    }
    
}
