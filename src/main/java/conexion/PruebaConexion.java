package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Articulo;
import modelo.Cliente;
import java.time.LocalDate;


public class PruebaConexion {
    
    public static void main(String[] args) {
        EntityManagerFactory sf=Persistence.createEntityManagerFactory("saverscoders");
        EntityManager em=sf.createEntityManager();
        
        em.getTransaction().begin();
        Cliente c=em.find(Cliente.class,"12345678A" );
        System.out.println(c);
        Articulo b=new Articulo(12,"Articulo de test",10.0,5.0,LocalDate.now());
        em.persist(b);
        em.getTransaction().commit();
        em.close();
    }
}