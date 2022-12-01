package saverscoders.Controlador;


import saverscoders.Modelo.Cliente;
import saverscoders.Modelo.Datos;
import saverscoders.Vista.ClienteView;
import saverscoders.Modelo.ClienteEstandard;
import saverscoders.Modelo.ClientePremium;
import saverscoders.DAO.ClienteDAOimpl;


import java.util.List;

public class ClienteController {
	
	Datos bbdd = new Datos();
	ClienteView menuCliente = new ClienteView();
	
	OnlineStore volver = new OnlineStore();
	

	public void subMenu() throws Exception {
		
		int opcion = menuCliente.mostrarMenu();
		
		switch (opcion) {
		case 1:
			agregarCliente();
			subMenu();
			break;
		case 2:
			mostrarClientes();
			subMenu();
			break;
		case 3:
			mostrarClientesEstandard();
			subMenu();
			break;
		case 4:
			mostrarClientesPremium();
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
	

	// metodo para agregar un cliente
    public void agregarCliente() {
        boolean creado = false;
        boolean existe = false;
        List<Object> parametros;
        parametros = menuCliente.printAgregarCliente();

        // comprobar que nos lleguen parametros de entrada
        if (!parametros.isEmpty()) {
            // comprobar si el cliente introducido ya existe
            existe = bbdd.clienteExiste(parametros.get(1).toString());
            if(!existe) {
                creado = bbdd.crearCliente(parametros);
                menuCliente.clienteCreado(creado);
            }
        }

    }

    // metodo para mostrar los clientes
    public void mostrarClientes() {
        List lista = bbdd.recibirDatosClientes();
        menuCliente.mostrarClientes(lista);
    }

    // metodo para mostrar clientes estandard
    public void mostrarClientesEstandard() {
        List lista = bbdd.recibirDatosClientesEstandard();
        menuCliente.printMostrarClientesEstandard(lista);
    }

    public void mostrarClientesPremium() {
        List lista = bbdd.recibirDatosClientesPremium();
        menuCliente.printMostrarClientesPremium(lista);
    }


}
