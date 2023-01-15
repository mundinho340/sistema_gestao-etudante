package DAO;
import java.sql.Connection;


package default;

public class ConnectionDB {
    public Connection connectDB(){
		Connection conn =null;
        try {
			String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"ConexaoDAO" + e.getMessage());
		}
		return conn;
	}
		
}
