package saverscoders.Vista;
import java.util.Scanner;

/* Vista del menu principal de nuestra aplicacion
*  menuPrincipal() es una funcion que imprime las opciones en pantalla, escanea un numero y lo retorna
* Iniciando producto 3
* */

public class AppView {

	public int menuPrincipal() {
		int opcion = 0;
		System.out.println("BIENVENIDO A SAVERSCODE.STORE");
		System.out.println(" ");
			System.out.println("*** MENU PRINCIPAL ***");
			System.out.println("--------------------------------");
			System.out.println("1. Gestionar Clientes");
			System.out.println("2. Gestionar Articulos");
			System.out.println("3. Gestionar Pedidos");
			System.out.println("4. Salir");
			System.out.println("--------------------------------");
			System.out.println("Elije una de las siguientes opciones: 1, 2, 3 o 4");
			
			opcion = new Scanner(System.in).nextInt();
			
			
		return opcion;
	}

}
