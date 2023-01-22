package Controladores;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.sql.*;

import javax.swing.*;

import Entidade.Estudante;
import baseDados.Conexao;

//import com.mysql.jdbc.ResultSet;

public class ControllerEstudante {
	
	static Scanner brain=new Scanner(System.in);
	
	public static void adicionarEstudante(int codigo,String nome, String sobrenome,String telefone, String sexo) throws SQLException{
		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement insercao=null;
		insercao = cone.prepareStatement("insert into estudante1 values(?,?,?,?,?)");
		
		insercao.setInt(1, codigo);
		insercao.setString(2, nome);
		insercao.setString(3, sobrenome);
		insercao.setString(4, telefone);
		insercao.setString(5, sexo);
		insercao.executeUpdate();
		cone.close();
		
	}
	
	public static ArrayList<Estudante> listaDeEstudantes() throws SQLException{
		
		
		
		ArrayList<Estudante> estudantes=new ArrayList<Estudante>();
		
		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement selecao=null;
		
		selecao=cone.prepareStatement("select * from estudante1");
		ResultSet registros= (ResultSet) selecao.executeQuery();
		while(registros.next()){
			int codigo=registros.getInt(1);
			String nome=registros.getString(2);
			String sobrenome=registros.getString(3);
			String telefone=registros.getString(4);
			String sexo = registros.getString(5);
			
			
			estudantes.add(new Estudante(codigo,nome,sobrenome,telefone, sexo));
		}
			return estudantes;
		
	}
	

	
	public static void actualizar(int codigo,String nome, String sobrenome, String telefone, String sexo) throws SQLException{
		

		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement actualizar=null;
		actualizar=cone.prepareStatement("update estudante1 set nome=?,sobrenome=?,telefone=?,sexo=?  where codigo=?");
		
		actualizar.setString(1, nome);
		actualizar.setString(2, sobrenome);
		actualizar.setString(3, telefone);
		actualizar.setString(4, sexo);
		actualizar.setInt(5, codigo);
		actualizar.executeUpdate();
	}
	public static void apagar(int codigo) throws SQLException{
		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement remover=null;
		remover=cone.prepareStatement("delete from estudante1 where codigo=?");
		
		remover.setInt(1, codigo);
		remover.executeUpdate();
	}
	
}
package Controladores;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.sql.*;

import javax.swing.*;

import Entidade.Estudante;
import baseDados.Conexao;

//import com.mysql.jdbc.ResultSet;

public class ControllerEstudante {
	
	static Scanner brain=new Scanner(System.in);
	
	public static void adicionarEstudante(int codigo,String nome, String sobrenome,String telefone, String sexo) throws SQLException{
		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement insercao=null;
		insercao = cone.prepareStatement("insert into estudante1 values(?,?,?,?,?)");
		
		insercao.setInt(1, codigo);
		insercao.setString(2, nome);
		insercao.setString(3, sobrenome);
		insercao.setString(4, telefone);
		insercao.setString(5, sexo);
		insercao.executeUpdate();
		cone.close();
		
	}
	
	public static ArrayList<Estudante> listaDeEstudantes() throws SQLException{
		
		
		
		ArrayList<Estudante> estudantes=new ArrayList<Estudante>();
		
		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement selecao=null;
		
		selecao=cone.prepareStatement("select * from estudante1");
		ResultSet registros= (ResultSet) selecao.executeQuery();
		while(registros.next()){
			int codigo=registros.getInt(1);
			String nome=registros.getString(2);
			String sobrenome=registros.getString(3);
			String telefone=registros.getString(4);
			String sexo = registros.getString(5);
			
			
			estudantes.add(new Estudante(codigo,nome,sobrenome,telefone, sexo));
		}
			return estudantes;
		
	}
	

	
	public static void actualizar(int codigo,String nome, String sobrenome, String telefone, String sexo) throws SQLException{
		

		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement actualizar=null;
		actualizar=cone.prepareStatement("update estudante1 set nome=?,sobrenome=?,telefone=?,sexo=?  where codigo=?");
		
		actualizar.setString(1, nome);
		actualizar.setString(2, sobrenome);
		actualizar.setString(3, telefone);
		actualizar.setString(4, sexo);
		actualizar.setInt(5, codigo);
		actualizar.executeUpdate();
	}
	public static void apagar(int codigo) throws SQLException{
		Conexao conexao=new Conexao();
		Connection cone= conexao.conectar();
		
		PreparedStatement remover=null;
		remover=cone.prepareStatement("delete from estudante1 where codigo=?");
		
		remover.setInt(1, codigo);
		remover.executeUpdate();
	}
	
}
