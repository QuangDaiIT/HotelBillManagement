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
            }
        });
    }

    

    
}
