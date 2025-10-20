/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() throws SQLException {
        if (koneksi == null || koneksi.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                koneksi = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/kasir_db", // nama DB sama seperti di pgAdmin
                    "postgres", // username PostgreSQL
                    "jalu123" // ganti dengan password PostgreSQL kamu
                );
            } catch (ClassNotFoundException e) {
                System.out.println("Driver PostgreSQL tidak ditemukan: " + e.getMessage());
            }
        }
        return koneksi;
    }
}

