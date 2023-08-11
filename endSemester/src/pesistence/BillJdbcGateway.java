/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.model.Bill;



public class BillJdbcGateway implements BillGateway {
    private Connection connection;

    public BillJdbcGateway() {
        // try {
        //     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //     conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HotelManager;user=sa;password=123456789;trustServerCertificate=true;");
        //     }
        //     catch(ClassNotFoundException e) {
        //         e.printStackTrace();
        //     }
        //     catch(SQLException e) {
        //         e.printStackTrace();
        //     }
        // Initialize the database connection here (replace dbUrl, username, and password with your SQL Server credentials)
        // String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=HotelManager";
        // String username = "sa";
        // String password = "123456789";
        try {
            // connection = DriverManager.getConnection(dbUrl, username, password);
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HotelManager;user=sa;password=123456789;trustServerCertificate=true;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBill(Bill bill) {
        String sql = "INSERT INTO bill2 (MaPhong, TenKH, NgayHD, MaHD, DonGia, LoaiHD, SoLuong) VALUES (?, ?, ?, ?, ?, ?, ?)";
        // int maHD, String tenKH, int maPhong, Date ngayHD,Double donGia, Double thanhTienH, Double thanhTienD
        // // MaPhong int,
                // TenKH nvarchar(50),
                // NgayHD date,
                // MaHD int,
                // DonGia smallmoney,
                // ThanhTienH smallmoney,
                // ThanhTienD smallmoney,

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bill.getMaPhong());
            statement.setString(2, bill.getTenKH());
            statement.setString(3, bill.getNgayHD());
            statement.setInt(4, bill.getMaHD());
            statement.setDouble(5, bill.getDonGia());
            statement.setString(6, bill.getLoaiHD());
            statement.setInt(7, bill.getSoLuong());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBill(Bill bill) {
        String sql = "UPDATE bill2 SET MaPhong = ?, TenKH = ?, NgayHD = ?, DonGia = ?, LoaiHD = ?, SoLuong = ? WHERE maHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bill.getMaPhong());
            statement.setString(2, bill.getTenKH());
            statement.setString(3, bill.getNgayHD());
            statement.setDouble(4, bill.getDonGia());
            statement.setString(5, bill.getLoaiHD());
            statement.setInt(6, bill.getSoLuong());
            statement.setInt(7, bill.getMaHD());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBill(int billId) {
        String sql = "DELETE FROM bill2 WHERE maHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, billId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bill getBillById(int billId) {
        String sql = "SELECT * FROM bill2 WHERE maHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, billId);
            ResultSet resultSet = statement.executeQuery();
            // MaPhong, TenKH, NgayHD, MaHD, DonGia, ThanhTienH, ThanhTienD
            if (resultSet.next()) {
                int maHD = resultSet.getInt("MaHD");
                String tenKH = resultSet.getString("TenKH");
                int maPhong = resultSet.getInt("MaPhong");
                String ngayHD = resultSet.getString("NgayHD");
                Double donGia = resultSet.getDouble("DonGia");
                String loaiHD = resultSet.getString("LoaiHD");
                int soLuong = resultSet.getInt("SoLuong");
                // Calculate the average mark using the formula provided
                // double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;
                //// int maHD, String tenKH, int maPhong, Date ngayHD,Double donGia, Double thanhTienH, Double thanhTienD
                return new Bill(maHD, tenKH, maPhong, ngayHD, donGia, loaiHD,soLuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bill2";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int maHD = resultSet.getInt("MaHD");
                String tenKH = resultSet.getString("TenKH");
                System.out.println(tenKH);
                int maPhong = resultSet.getInt("MaPhong");
                String ngayHD = resultSet.getString("NgayHD");
                Double donGia = resultSet.getDouble("DonGia");
                String loaiHD = resultSet.getString("LoaiHD");
                int soLuong = resultSet.getInt("SoLuong");
                // Calculate the average mark using the formula provided
                // double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

                bills.add(new Bill(maHD, tenKH, maPhong, ngayHD, donGia, loaiHD, soLuong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }
}



