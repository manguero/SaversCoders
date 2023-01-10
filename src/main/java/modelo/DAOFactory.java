package modelo;


import modelo.ArticuloDAO;
import modelo.ClienteDAO;
import modelo.PedidoDAO;

public class DAOFactory {
    
    public static ClienteDAO createClienteDAO(Class c){
        return new ClienteDAO();
    }
    
    public static ClienteDAO createClienteDAO(){
        return new ClienteDAO();
    }
    
    public static ArticuloDAO createArticuloDAO(){
        return new ArticuloDAO();
    }
      public static ArticuloDAO createArticuloDAO(Class c){
        return new ArticuloDAO();
    }
    
    public static PedidoDAO createPedidoDAO(){
        return new PedidoDAO();
    }
    
       public static PedidoDAO createPedidoDAO(Class c){
        return new PedidoDAO();
    }
    
    
}