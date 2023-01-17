package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class ConexaoBaseDados {
	

		/*
	     * dados e credenciais para a conexao a base dados
	     * servidor: loocalhost;
	     * nome base de dados: subds_contactos;
	     * porta do servidor de base de dados: 3306 (mysql)
	     * nome do usuario: root;
	     * palavra-passe: 
	     */
	    private final String serverName = "localhost";
	    private final String dbName = "subds_contactos";
	    private final String portNumber = "3306";
	    private final String userID = "root";
	    private final String password = "";
	    
	    public Connection obterConexao(){
	        
	    	String url = "jdbc:mysql://"+serverName+":"+portNumber+"/"+dbName;        
			Connection conexao = null;
			
			try {

				conexao = DriverManager.getConnection(url, userID, password);
				
			} catch (SQLException e) {	
				JOptionPane.showMessageDialog(null, "Erro de conexão à base de dados: "+e.getMessage(), "Base de Dados", 
						JOptionPane.ERROR_MESSAGE);	
			}
			
			return conexao;
	    }
	

}
