package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;


// CRUD = Create Reaad Update Delete
public class ClienteDAO extends DAO {
    
    public static final String TIPO_STANDARD="standard";
    public static final String TIPO_PREMIUM="premium";
    
    
    public Cliente read(String nif){
        
        em.getTransaction().begin();
        Cliente a=em.find(ClientePremium.class, nif);
        if(a==null){
            a=em.find(ClienteStandard.class, nif);
        }
        em.getTransaction().commit();
        
        
        return a;
    }

    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> l=new ArrayList<>();
        
        em.getTransaction().begin();
        
        Query q1=em.createQuery("select c from ClientePremium  c");
        List<Cliente> l1=q1.getResultList();
        
        Query q2=em.createQuery("select c from ClienteStandard  c");
        List<Cliente> l2=q2.getResultList();
        
        l.addAll(l1);
        l.addAll(l2);
        
        em.getTransaction().commit();
        
        return l;
    }
    
    /**
     * Inserta el cliente en la base de datos
     * @param a Cliente a insertar
     * @return true si se ha conseguido insertar y false si no
     */
    public boolean create(Cliente a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return true;
    }
    
    
    public boolean delete(String nif){
        Cliente c=read(nif);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        return true;
    }
    
    public boolean update(Cliente a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return true;
    }


}