/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager; //menghubungkan ke mysql
import java.sql.PreparedStatement; //untuk CRUD
import java.sql.SQLException;


/**
 *
 * @author User
 */
public class Koneksi {
    private String database_name = "2210010415_pbo";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 
    
    public Koneksi(){
    
        try {  
            String lokasi = "jdbc:mysql://localhost/" + database_name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());          
        }
        
    }
    
    // tabel pelanggan //
    public void Simpan_pelanggan(String nama, String alamat, String no_telpon, String daftar_paket, String tgl_pemesanan, String tgl_pelaksanaan, String harga){
        try {
            String sql = "INSERT INTO pelanggan (nama, alamat, no_telpon, daftar_paket, tgl_pemesanan, tgl_pelaksanaan, harga) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama);
            perintah.setString(2, alamat);
            perintah.setString(3, no_telpon);
            perintah.setString(4, daftar_paket);
            perintah.setString(5, tgl_pemesanan);
            perintah.setString(6, tgl_pelaksanaan);
            perintah.setString(7, harga);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Update_pelanggan(String id, String nama, String alamat, String no_telpon, String daftar_paket, String tgl_pemesanan, String tgl_pelaksanaan, String harga){
        try {
            String sql = "UPDATE pelanggan SET nama = ?, alamat = ?, no_telpon = ?, daftar_paket = ?, tgl_pemesanan = ?, tgl_pelaksanaan = ?, harga = ? WHERE id_pelanggan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama);
            perintah.setString(2, alamat);
            perintah.setString(3, no_telpon);
            perintah.setString(4, daftar_paket);
            perintah.setString(5, tgl_pemesanan);
            perintah.setString(6, tgl_pelaksanaan);
            perintah.setString(7, harga);
            perintah.setString(8, id);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Diubah");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Hapus_pelanggan(String id){
        try {
            String sql = "DELETE FROM pelanggan WHERE id_pelanggan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    // tabel catering //
    
    public void Simpan_catering(String nama, String alamat, String no_telpon, String paket, String porsi, String harga, String tgl_pemesanan){
        try {
            String sql = "INSERT INTO catering (nama, alamat, no_telpon, paket, porsi, harga, tgl_pemesanan) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama);
            perintah.setString(2, alamat);
            perintah.setString(3, no_telpon);
            perintah.setString(4, paket);
            perintah.setString(5, porsi);
            perintah.setString(6, harga);
            perintah.setString(7, tgl_pemesanan);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }   
        
    public void Update_catering(int id, String nama, String alamat, String no_telpon, String paket, String porsi, String harga, String tgl_pemesanan) {
        try{
            String sql = "UPDATE catering SET nama = ?, alamat = ?, no_telpon = ?, paket = ?, porsi = ?, harga = ?, tgl_pemesanan = ? WHERE id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
        
            perintah.setString(1, nama);
            perintah.setString(2, alamat);
            perintah.setString(3, no_telpon);
            perintah.setString(4, paket);
            perintah.setString(5, porsi);
            perintah.setString(6, harga);
            perintah.setString(7, tgl_pemesanan);
            perintah.setInt(8, id);
        
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void Hapus_catering(String id){
        try {
            String sql = "DELETE FROM catering WHERE id_pelanggan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    
    // Tabel Rancangan //
    
    public void Simpan_rancangan(String nama, String daftar_paket, String warna_tenda, String dekorasi, String baju_pengantin, String keterangan){
        try {
            String sql = "INSERT INTO rancangan (nama, daftar_paket, warna_tenda, dekorasi, baju_pengantin, keterangan) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama);
            perintah.setString(2, daftar_paket);
            perintah.setString(3, warna_tenda);
            perintah.setString(4, dekorasi);
            perintah.setString(5, baju_pengantin);
            perintah.setString(6, keterangan);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Update_rancangan(int id, String nama, String daftar_paket, String warna_tenda, String dekorasi, String baju_pengantin, String keterangan) {
        try{
            String sql = "UPDATE rancangan SET nama = ?, daftar_paket = ?, warna_tenda = ?, dekorasi = ?, baju_pengantin = ?, keterangan = ? WHERE id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
        
            perintah.setString(1, nama);
            perintah.setString(2, daftar_paket);
            perintah.setString(3, warna_tenda);
            perintah.setString(4, dekorasi);
            perintah.setString(5, baju_pengantin);
            perintah.setString(6, keterangan);
            perintah.setInt(8, id);
        
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void Hapus_rancangan(String id){
        try {
            String sql = "DELETE FROM rancangan WHERE id_pelanggan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    
    // Tabel jumlah //
    
    public void Simpan_jumlah(String no_cetak, String tanggal, String kelas, String total_saldo){
        try {
            String sql = "INSERT INTO jumlah (no_cetak, tanggal, kelas, total_saldo) VALUES (?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, no_cetak);
            perintah.setString(2, tanggal);
            perintah.setString(3, kelas);
            perintah.setString(4, total_saldo);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Update_jumlah(int no_cetak, String tanggal, String kelas, String total_saldo){
        try {
            String sql = "UPDATE jumlah SET tanggal = ?, kelas = ?, total_saldo = ? WHERE no_cetak = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, tanggal);
            perintah.setString(2, kelas);
            perintah.setString(3, total_saldo);
            perintah.setInt(4, no_cetak);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Hapus_jumlah(String no_cetak){
        try {
            String sql = "DELETE FROM jumlah WHERE no_cetak = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setString(1, no_cetak);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
}
