package UI;

import java.util.List;

import controladores.ContactoControladores;
import Entidades.Contactos;

public class Executavel {
	ContactoControladores ops = new ContactoControladores();
	public static void main(String args[]) throws Exception{
		
		
		adicionarContactos(ops);
		selecionarContactos(ops);
	}
	
	public static void adicionarContactos(ContactoControladores ops) throws Exception {
		
		// Adicionar o contacto a base de dados
		Contactos contacto = new Contactos("John Doe", "johndoe@mail.com", "+258841110321", "comentarios...");
		boolean isAdded = ops.adicionar(contacto);
		if(isAdded){
			System.out.println("Adicionado!");
		}else{
			System.out.println("Não adicionado!");
		}
	}
	
	public static void selecionarContactos(ContactoControladores ops) throws Exception {
		
		// Selecionar todos os contactos
    	List<Contactos> contactos = ops.visualizarTodos();
    	for(int i = 0; i < contactos.size(); i++){
    		System.out.println((i+1)+"o -> "+contactos.get(i).toString());
    	}	
	}	
	
}