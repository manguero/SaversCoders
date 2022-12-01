package saverscoders.Vista;

import saverscoders.Modelo.Cliente;
import saverscoders.Modelo.ClienteEstandard;
import saverscoders.Modelo.ClientePremium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteView {
	
	public int mostrarMenu() {
		int opcion;
		System.out.println("MENU CLIENTES");
		System.out.println("--------------------------------");
		System.out.println("1. Agregar cliente");
		System.out.println("2. Mostrar clientes");
		System.out.println("3. Mostrar clientes estandard");
		System.out.println("4. Mostrar clientes premium");
		System.out.println("5. Volver al menu principal");
		System.out.println("--------------------------------");
		System.out.println("Elije una de las siguientes opciones: 1, 2, 3, 4 o 5");
		
		opcion = getInput(5);
		
		return opcion;
	}
	public List printAgregarCliente() {
        int tipoDeCliente;
        String nombre, domicilio, nif, email;
        List parametros = new ArrayList<>();


        System.out.println("Selecciona el tipo de cliente que quiere crear");
        System.out.println("1. Cliente estandard");
        System.out.println("2. Cliente premium");
        
        tipoDeCliente = getInput(2);
        parametros.add(tipoDeCliente);

        System.out.println("Introduzca el email");
        email = getString();
        parametros.add(email);
        System.out.println("Introduzca el nombre");
        nombre = getString();
        parametros.add(nombre);
        System.out.println("Introduzca el domicilio");
        domicilio = getString();
        parametros.add(domicilio);
        System.out.println("Introduzca el nif");
        nif = getString();
		parametros.add(nif);
        

        // devolver la lista de parametros para crear el cliente
        return parametros;
    }
	
	public void clienteCreado(Boolean creado) {
        if (creado) {
            System.out.println("Cliente creado correctamente");
        } else {
            System.err.println("Este cliente ya existe");
        }
    }
	
	//Mostrar todos los clientes
	public void mostrarClientes(List lista) {
        System.out.println("CLIENTES");
        System.out.println("---------------------");
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
            System.out.println("---------------------");
        }
    }
	
	 // Sub menu para mostrar los clientes estandard
    public void printMostrarClientesEstandard(List clienteEstLista) {
        System.out.println("Lista de clientes Estandard");
        System.out.println("---------------------");

        for (int i = 0; i < clienteEstLista.size(); i++) {
            System.out.println(clienteEstLista.get(i));
            System.out.println("---------------------");
        }
    }

    // Sub menu para mostrar los clientes premium
    public void printMostrarClientesPremium(List clientePremLista) {
        System.out.println("Lista de clientes Premium");
        System.out.println("---------------------");

        for (int i = 0; i < clientePremLista.size(); i++) {
            System.out.println(clientePremLista.get(i));
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
