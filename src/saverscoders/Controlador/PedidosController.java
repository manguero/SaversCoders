package saverscoders.Controlador;

import saverscoders.Modelo.*;
import saverscoders.Vista.AppView;
import saverscoders.Vista.PedidosView;

import java.nio.channels.NonReadableChannelException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import saverscoders.Controlador.OnlineStore;

import saverscoders.Controlador.ArticuloNoExisteException;
import saverscoders.Controlador.ClienteNoExisteException;

public class PedidosController {
	
	Datos bbdd = new Datos();
	PedidosView menuPedido = new PedidosView();
	OnlineStore volver = new OnlineStore();
	AppView menuPrinc = new AppView();
	private int opcion = 0;
	

	public void subMenu() throws Exception {
		PedidosView menuPedidos = new PedidosView();
		int opcion = menuPedidos.mostrarMenu();
		
		switch (opcion) {
			case 1:
				agregarPedido();
				subMenu();
				break;
			case 2:
				mostrarPedidosPendientes();
				subMenu();
				break;
			case 3:
				mostrarPedidosEnviados();
				subMenu();
				break;
			case 4:
				eliminarPedido();
				subMenu();
				break;
			case 5:
				OnlineStore volver = new OnlineStore();
				volver.inicio();
			default:
				System.out.println("*** Opcion no disponible ***");
				subMenu();	
		}	
	}
	
	
	public void agregarPedido() throws Exception {
        List parametros = new ArrayList<>();
        boolean pedidoCreado = false;
        String codigoArticulo = "";
        String emailCliente = "";
        int cantidad = 0;

        // recibir el codigo del articulo
        try {
            codigoArticulo = menuPedido.printAgregarPedido();
            // comprobar si el articulo existe
            if (!bbdd.articuloExiste(codigoArticulo)) {
                // lanzar error si el articulo no existe
                throw new ArticuloNoExisteException("Este articulo no existe");
            } else {
                parametros.add(codigoArticulo);
            }
        } catch (ArticuloNoExisteException ex) { // manejar la excepcion
            System.err.println(ex);
            menuPrinc.menuPrincipal();
        }

        // recibir el email del cliente
        try {
            emailCliente = menuPedido.printGetClientePedido();
            // comprobar si el cliente existe
            if (!bbdd.clienteExiste(emailCliente)) {
                // lanzar error si el cliente no existe
                throw new ClienteNoExisteException("Este cliente no existe");
            } else {
                parametros.add(emailCliente);
            }
        } catch (ClienteNoExisteException ex) {
            System.err.println(ex);
            menuPrinc.menuPrincipal();
        }

        // recibir la cantidad
        cantidad = menuPedido.printGetCantidadPedido();
        parametros.add(cantidad);


        // Llamar al modelo para crear el pedido
        pedidoCreado = bbdd.crearDatosPedido(parametros);

        // informar a la vista si se ha creado el pedido
        menuPedido.pedidoCreado(pedidoCreado);
    }

	 // metodo para eliminar un pedido
    public void eliminarPedido() throws Exception {
        int numPedido = 0;
        boolean pedidoEliminado = false;

        // recibir el número del pedido a ser borrado
        numPedido = menuPedido.printEliminarPedido();

        // llamar al modelo para eliminar el pedido
        pedidoEliminado = bbdd.eliminarPedido(numPedido);

        // informar si el pedido se ha eliminado
        menuPedido.pedidoEliminado(pedidoEliminado);

    }
    
 // metodo para mostrar los pedidos pendientes de envio
    public void mostrarPedidosPendientes() {
        List lista = new ArrayList<>();
        // llenar la lista con los pedidos pendientes
        lista = bbdd.recibirDatosPedidosPendientes();
        // enviar la lista a vista
        menuPedido.printMostrarPedidosPendientes(lista);
    }

    // metodo para mostrar los pedidos enviados
    public void mostrarPedidosEnviados() {
        List lista = new ArrayList<>();
        // llenar la lista con los pedidos enviados
        lista = bbdd.recibirDatosPedidosEnviados();
        // enviar la lista a vista para ser impresa
        menuPedido.printMostrarPedidosEnviados(lista);
    }

}
