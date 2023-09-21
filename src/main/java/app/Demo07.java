package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

//GUI

public class Demo07 {
	//Listado de todos los usuarios
	
	public static void main(String[] args) {
		
		//1.Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		//2.crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//select*from tb_Producto
		String jpql = "select p from Producto p";
		List<Producto> lstProducto =  em.createQuery(jpql, Producto.class).getResultList();
		
		//mostrar el contenido del listado
		for (Producto p : lstProducto) {
			System.out.println("Codigo....:" + p.getId_prod());
			System.out.println("Nombre....:" + p.getDes_prod());
			System.out.println("Categoria....:" + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor....:" + p.getObjProveedor().getNombre_rs());
			System.out.println("----------------------------");
		}
		em.close();	
	}
}
