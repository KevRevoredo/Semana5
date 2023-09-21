package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo08 {
	//Listado de los usuarios, segun un criterio (filtro)
	
	public static void main(String[] args) {
		
		//1.Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		//2.crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//select*from tb_usuarios where campo condicion  --> Lista
		int xtipo = 1;
		String jpql = "select u from Usuario u where u.idtipo = :xtipo";
		List<Usuario> lstUsuario =  em.createQuery(jpql, Usuario.class).
				setParameter("xtipo", xtipo).getResultList();
		
		//mostrar el contenido del listado
		for (Usuario u : lstUsuario) {
			System.out.println("Codigo....:" + u.getCod_usua());
			System.out.println("Nombre....:" + u.getNom_usua( )+""+ u.getApe_usua());
			System.out.println("Codigo....:" + u.getIdtipo() + "-" + "xxxx");
			System.out.println("----------------------------");
		}
		
		
		
		em.close();
		
	}
}
