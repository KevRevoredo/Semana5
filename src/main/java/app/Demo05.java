package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo05 {
	//Listado de todos los usuarios
	
	public static void main(String[] args) {
		
		//1.Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		//2.crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//select*from tb_usuarios
		String jpql = "select u from Usuario u";
		List<Usuario> lstUsuario =  em.createQuery(jpql, Usuario.class).getResultList();
		
		//mostrar el contenido del listado
		for (Usuario u : lstUsuario) {
			System.out.println("Codigo....:" + u.getCod_usua());
			System.out.println("Nombre....:" + u.getNom_usua( )+""+ u.getApe_usua());
			System.out.println("Codigo....:" + u.getIdtipo());
			System.out.println("----------------------------");
		}
		
		
		
		em.close();
		
	}
}
