import java.sql.*;

public class TampilkanView {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/toko";
        String user = "root"; // sesuaikan
        String password = ""; // sesuaikan

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM view_barang");

            System.out.println("Data Barang:");
            System.out.println("-------------------------------------------");
            while (rs.next()) {
                System.out.println("Kode: " + rs.getString("kode"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Harga: " + rs.getInt("harga"));
                System.out.println("Stok: " + rs.getInt("stok"));
                System.out.println("Total Nilai: " + rs.getInt("total_nilai"));
                System.out.println("-------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }
    }
}