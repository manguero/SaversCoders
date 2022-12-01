package saverscoders.Vista;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import saverscoders.Controlador.OnlineStore;
import saverscoders.Modelo.Articulo;
import saverscoders.Modelo.Cliente;
import saverscoders.Modelo.Datos;
import saverscoders.Modelo.Pedido;

public class PedidosView {
	
	static Scanner sc = new Scanner(System.in);
	
	public int mostrarMenu() {
		System.out.println("MENU PEDIDOS");
		System.out.println("--------------------------------");
		System.out.println("1. Crear nuevo pedido");
		System.out.println("2. Mostrar pedidos pendientes");
		System.out.println("3. Mostrar pedidos enviados");
		System.out.println("4. Eliminar pedido");
		System.out.println("5. Volver al menu principal");
		System.out.println("--------------------------------");
		System.out.println("Elije una de las siguientes opciones: 1, 2, 3, 4 o 5");
		
		int opcion = new Scanner(System.in).nextInt();
		
		return opcion;
	}
	

    // Sub menu para agregar un pedido
    public String printAgregarPedido() {
        String codArticulo = "";
        System.out.println("\nIntroduzca la informacion del pedido: ");
        System.out.println("--------------------------------------");
        // pedir por el input mientras el codigo este vacio
        do {
            System.out.println("Introduzca el articulo");
            codArticulo = getString();
        } while (codArticulo.isEmpty());

        return codArticulo;
    }
	
	// recibir el cliente para el pedido
    public String printGetClientePedido() {
        String email = "";
        do {
            System.out.println("Introduzca el email del cliente");
            email = getString();
        } while (email.isEmpty());

        return email;
    }

    // recibir la cantidad para el pedido
    public int printGetCantidadPedido() {
        int cantidad = 0;
        do {
            System.out.println("Introduzca la cantidad de articulos");
            cantidad = getInt();
        } while (cantidad == 0);
        return cantidad;
    }

    public void pedidoCreado(Boolean creado) {
        if (creado) {
            System.out.println("Se ha creado el pedido");
        } else {
            System.err.println("Ha habido un error al crear el pedido");
        }
    }


    // Sub menu para eliminar un pedido
    public int printEliminarPedido() throws Exception {
        int numPedido = 0;
        // Pedir el numero del pedido
        System.out.println("Introduzca el numero de pedido a borrar");
        numPedido = getInt();

        return numPedido;
    }

    public void pedidoEliminado(boolean eliminado) {
        if (eliminado) {
            System.out.println("se ha eliminado el pedido exitosamente");
        } else {
            System.err.println("Ha ocurrido un error al eliminar el pedido");
        }
    }

    // Sub menu para mostrar pedidos por enviar
    public void printMostrarPedidosPendientes(List lista) {
        System.out.println("Mostrando pedidos pendientes de envio");
        System.out.println("-------------------------------------");
        for (Object o : lista) {
            System.out.println(o);
            System.out.println("---------------------");
        }
    }

    // Sub menu para mostrar los pedidos enviados
    public void printMostrarPedidosEnviados(List lista) {
        System.out.println("Mostrando pedidos enviados");
        System.out.println("-------------------------------------");
        for (Object o : lista) {
            System.out.println(o);
            System.out.println("---------------------");
        }
    }
    
 // Metodo para recibir el input del usuario para el menu
    public static int getInput(int max){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > max){
            try {
                System.out.print("\nIntroduzca la opcion: \n");
                // recibir input en forma de String y parse a int
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException e){
                System.err.println("Introduzca un numero valido\n");
            }
        }
        return choice;
    }

    // metodo para recibir un input en forma de string
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        // try catch error
        String string = scanner.nextLine();
        return string;
    }

    // metodo para recibir un input en forma de int
    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        try {
            numero = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.err.println(e);
        }
        return numero;
    }

    // metodo para recibir un double
    public static double getDouble() {
        Scanner scanner = new Scanner(System.in);
        double numero = 0;
        try {
        numero = Double.parseDouble(scanner.nextLine());
        } catch (Exception e){
            System.err.println(e);
    }
        return numero;
    }
}
