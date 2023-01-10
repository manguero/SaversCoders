package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;



// CRUD = Create Reaad Update Delete
public class PedidoDAO extends DAO{

    public boolean create(Pedido a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return true;
    }

    public Pedido read(int numero) {
        em.getTransaction().begin();
        Pedido a=em.find(Pedido.class, numero);
        em.getTransaction().commit();
        return a;
    }
    
    public ArrayList<Pedido> listar(){
        em.getTransaction().begin();
        Query q=em.createQuery("select a from Pedido a");
        ArrayList<Pedido> l= new ArrayList<>();
        l.addAll(q.getResultList());
        em.getTransaction().commit();
        return l;
    }

    public boolean update(Pedido a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return true;
    }

    public boolean delete(int numero) {
        em.getTransaction().begin();
        Articulo a=em.find(Articulo.class, numero);
        em.remove(a);
        em.getTransaction().commit();
        return true;
    }

}