import java.sql.*;
import java.util.Scanner;

public class InsertBarang {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/toko";
        String user = "root"; // sesuaikan
        String password = ""; // sesuaikan

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            CallableStatement stmt = conn.prepareCall("{CALL insert_barang(?, ?, ?, ?)}");
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            stmt.execute();
            System.out.println("Data berhasil diinsert ke tabel barang.");
        } catch (SQLException e) {
            System.out.println("Gagal insert data: " + e.getMessage());
        }
    }
}