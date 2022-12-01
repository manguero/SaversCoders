package saverscoders.Vista;

import saverscoders.Modelo.Articulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticulosView {
	
	public int mostrarMenu() {
        System.out.println("MENU ARTICULOS");
        System.out.println("--------------------------------");
        System.out.println("1. Agregar nuevo articulo");
        System.out.println("2. Ver todos los articulos");
        System.out.println("3. Volver al menu principal");
        System.out.println("--------------------------------");
		System.out.println("Elije una de las siguientes opciones: 1, 2 o 3");

        int opcion = new Scanner(System.in).nextInt();

        return opcion;
    }
	public List printAgregarArticulo() {
	String codigo, descripcion;
    double pvp, envio;
    int tiempo;
    List<Object> parametros = new ArrayList<>();
    // pedir informacion del artiulo y guardarlo en variables locales
    System.out.println("Introduzca el codigo del producto");
    codigo = getString();
    parametros.add(codigo);
    System.out.println("Introduzca la descripcion del articulo:");
    descripcion = getString();
    parametros.add(descripcion);
    System.out.println("Introduzca el precio de venta:");
    pvp = getDouble();
    parametros.add(pvp);
    System.out.println("Introduzca los gastos de envio:");
    envio = getDouble();
    parametros.add(envio);
    System.out.println("Introduzca el tiempo de preparacion en minutos:");
    tiempo = getInt();
    parametros.add(tiempo);

    // Devolver al controlador los parametros para crear el articulo
    return parametros;
	}
    
    public void articuloCreado(Boolean creado) {
        if (creado) {
            System.out.println("Se ha creado el articulo correctamente");
        } else {
           System.err.println("Ha habido un error al crear el articulo");
        }
    }
    
    public void printMostrarArticulos(List lista) {
        System.out.println("Lista de articulos");
        System.out.println("---------------------");

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
