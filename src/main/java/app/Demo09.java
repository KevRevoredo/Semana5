package app;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

//GUI

public class Demo09 {
	//Listado de los usuarios, segun un criterio (filtro)
	
	public static void main(String[] args) {
		
		String usuario = JOptionPane.showInputDialog("Ingrese usuario");
		String clave = JOptionPane.showInputDialog("Ingrese clave");
		
				//1.Obtener la conexion -> llamar a la unidad de persistencia
				EntityManagerFactory fabrica = 
						Persistence.createEntityManagerFactory("jpa_sesion01");
				//2.crear un manejador de entidades
				EntityManager em = fabrica.createEntityManager();
				
				//select*from tb_usuarios where campo condicion  --> Lista
				
				String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
				//List<Usuario> lstUsuario =  em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getResultList();
				
				try {
					Usuario u =  em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
					
					//mostrar el contenido del usuario
					
					JOptionPane.showMessageDialog(null, "Bienvenido" +  u.getNom_usua());
					
					//abrir ventana principal
					FrmManteProd v =  new FrmManteProd();
					v.setVisible(true);
					//dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: usuario o clave incorrecto");
				}
				
				em.close();
		
	}
}
