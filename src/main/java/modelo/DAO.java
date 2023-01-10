package modelo;

import conexion.Conexion;
import javax.persistence.EntityManager;


public class DAO {
    protected final EntityManager em;
    
    public DAO(){
        em=Conexion.getEntityManager();
    }
}
