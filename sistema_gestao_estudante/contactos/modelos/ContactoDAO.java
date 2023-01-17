
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import database.ConexaoBaseDados;
import Entidades.Contactos;
//import entity.Autor;

public class ContactosDAO {

    // returna a lista de todos os contactos
    public List<Contactos> selecionarTodos() throws Exception {
        String consulta = " select * from contactos ";
        Connection con = new ConexaoBaseDados().obterConexao();
        PreparedStatement ps = con.prepareStatement(consulta);

        ResultSet rs = ps.executeQuery();
        List<Contactos> contactos = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("contact_name");
            String email = rs.getString("contact_email");
            String telemovel = rs.getString("contact_phone");
            String comentarios = rs.getString("contact_comments");
            contactos.add(new Contactos(id, nome, email, telemovel, comentarios));
        }
        rs.close();
        con.close();
        return contactos;
    }

    /*
     * retorna apenas um contacto através do seu ID
     */
    public Contactos selecionarContactoPorID(int contactoID) throws Exception {
        List<Contactos> contactos = selecionarTodos();

        Optional<Contactos> encontrado = contactos.stream()
        	.filter(contacto -> (contacto.getId() == contactoID))
            .findFirst();
        return encontrado.isPresent() ? encontrado.get() : null;
    }

    // adicionar novo contacto
    public void adicionarContacto(Contactos contacto) throws SQLException, Exception {
        String query = " insert into contactos(contact_name, contact_email, contact_phone, contact_comments) values(?,?,?,?)";
        Connection con = new ConexaoBaseDados().obterConexao();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, contacto.getNomeCompleto());
        ps.setString(2, contacto.getEmail());
        ps.setString(3, contacto.getTelemovel());
        ps.setString(4, contacto.getComentarios());
        ps.executeUpdate();
        con.close();
    }

    // actualizar contacto
    public void actualizarContacto(Contactos contacto) throws SQLException, Exception {
         String query = " update contactos set contact_name = ?, contact_email = ?, contact_phone = ?, contact_comments = ? where"
             + " id = "+contacto.getId();
        Connection con = new ConexaoBaseDados().obterConexao();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, contacto.getNomeCompleto());
        ps.setString(2, contacto.getEmail());
        ps.setString(3, contacto.getTelemovel());
        ps.setString(4, contacto.getComentarios());
        ps.executeUpdate();
        con.close();
    }

    // eliminar contacto sendo dado o seu ID
    public void eliminarContacto(int contactoID) throws Exception {
        String delete = " delete from contactos where id = ? ";
        Connection con = new ConexaoBaseDados().obterConexao();
        PreparedStatement ps = con.prepareStatement(delete);
        
        // especificar o valor do parámetro
        ps.setInt(1, contactoID);
        
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    // verificar se o contacto a ser adicionado é um contacto válido.
    public boolean isContactoValido(Contactos contacto) throws Exception {
        List<Contactos> contactos = selecionarTodos();
         Optional<Contactos> contactoEncontrado = contactos.stream()
             .filter(c -> (c.getId() == contacto.getId()))
             .findFirst();
         return contactoEncontrado.isPresent();
     }
	
}
