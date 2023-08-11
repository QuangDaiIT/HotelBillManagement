/*
*  created date: Jul 24, 2023
*  author: cgm
*/

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

import javax.swing.SwingUtilities;

import pesistence.BillJdbcGateway;
import presentation.BillManagementApp;

public class BootStrap {

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				BillJdbcGateway billJdbcGateway = new BillJdbcGateway();
                new BillManagementApp(billJdbcGateway).setVisible(true);
		
		
		// try {
			// truy vấn ngay tháng : stm.setSDate(3, new java.sql.Date(stu.getBirthday().getTime());
			// setBirthDay : 
			// tìm kiếm theo id
			// java.sql.Date birthday = rs.getDay(3);
			// find all tương tự. 
			// if() { birthday != null
				// stu.setBirthday(new Date(birthday.getTiem()));
			//}




		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HotelManager;user=sa;password=123456789;trustServerCertificate=true;");
		// }
		// catch(ClassNotFoundException e) {
		// 	e.printStackTrace();
		// }
		// catch(SQLException e) {
		// 	e.printStackTrace();
		// }
		/// create
		
		// try {
		// 	PreparedStatement pstm1 = conn.prepareStatement("insert into category(name,status) values(?,?)");
		// 	pstm1.setString(1,"mu");
		// 	pstm1.setBoolean(2,true);
		// 	pstm1.executeUpdate();
		// }catch(SQLException e) {
		// 	e.printStackTrace();
		// }
		// // update
		
		// try {
		// 	PreparedStatement pstm2 = conn.prepareStatement("Update category SET name = ?, status = ? WHERE id = ?");
		// 	pstm2.setString(1,"giay");
		// 	pstm2.setBoolean(2,false);
		// 	pstm2.setInt(3,1);
		// 	pstm2.executeUpdate();
		// }catch(SQLException e) {
		// 	e.printStackTrace();
		// }
		// // delete
		// try {
		// 	PreparedStatement pstm3 = conn.prepareStatement("DELETE category WHERE id = ?");
		// 	pstm3.setInt(1,2);
		// 	pstm3.executeUpdate();
		// }catch(SQLException e) {
		// 	e.printStackTrace();
		// }
		
		
		/// read
		// try {
		// 	PreparedStatement pstm = conn.prepareStatement("SELECT * FROM bill");
		// 	ResultSet rs = pstm.executeQuery();
		// 	while(rs.next()) {
		// 		System.out.println("ma phong : "+ rs.getInt("MaPhong"));
		// 		System.out.println("ten khach hang : " + rs.getString("TenKH"));
		// 		System.out.println("ngay hoa don : " + rs.getDate("NgayHD"));
        //         System.out.println("ma hoa don : " + rs.getInt("MaHD"));
        //         System.out.println("Do gia : " + rs.getDouble("DonGia"));
        //         System.out.println("Thanh tien theo (gio) : " + rs.getDouble("ThanhTienH"));
        //         System.out.println("Thanh tien thao (ngay) : " + rs.getDouble("ThanhTienD"));
        //         // MaPhong int,
        //         // TenKH nvarchar(50),
        //         // NgayHD date,
        //         // MaHD int,
        //         // DonGia smallmoney,
        //         // ThanhTienH smallmoney,
        //         // ThanhTienD smallmoney,
		// 	}
		// }catch(SQLException e) {
		// 	e.printStackTrace();
		// }
            }
        });
    }

    

    
}
