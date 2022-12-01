package saverscoders.DAO;

import java.util.List;

import saverscoders.Modelo.Articulo;

public interface ArticuloDAO {

	 /* Create */
    public boolean addArticulo(Articulo articulo);

    /* Get All*/
    public List getArticulos();

    /* Get one by id*/
    public Articulo getArticuloById(String codigo);
    
 // metodo para comprobar si un articulo existe
    public boolean articuloExiste(String codArticulo);
}
