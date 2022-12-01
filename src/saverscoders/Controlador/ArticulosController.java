package saverscoders.Controlador;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import saverscoders.Modelo.Articulo;
import saverscoders.Modelo.Datos;
import saverscoders.Vista.ArticulosView;


public class ArticulosController {
	
	Datos bbdd = new Datos();
	ArticulosView menuArticulo = new ArticulosView();
	OnlineStore volver = new OnlineStore();

	public void subMenu() throws Exception {
		
		int opcion = menuArticulo.mostrarMenu();
		
		switch (opcion) {
		case 1:
			nuevoArticulo();
			subMenu();
			break;
		case 2:
			verArticulos();
			subMenu();
			break;
		case 3:
			OnlineStore volver = new OnlineStore();
			volver.inicio();
		default:
			System.out.println("*** Opcion no disponible ***");
			subMenu();
		}	
	}
	
	
	public void nuevoArticulo() {
		 boolean creado = false;
	        List<Object> parametros = new ArrayList<>();
	        parametros = menuArticulo.printAgregarArticulo();
	        // enviar informacion a Datos si la informacion no esta vacia
	        if (!parametros.isEmpty()) {
	            // Comprobar si el articulo existe antes de crearlo
	            if (!bbdd.articuloExiste(parametros.get(0).toString())){
	                creado = bbdd.agregarArticulo(parametros);
	            } else {
	                //todo
	                // trhow articuloExisteException
	                // print articulo ya existe
	            }
	        }
	        menuArticulo.articuloCreado(creado);
	    }
				
	
	public void verArticulos() {
		List lista = new ArrayList<>();
		lista  = bbdd.getArticulos();
		menuArticulo.printMostrarArticulos(lista);
	}
	
}
