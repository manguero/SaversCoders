package saverscoders.resources;

import javax.swing.JOptionPane;

import saverscoders.resources.Database;

public class PruebaConexion {

	public static void main(String[] args) {
        Database bd = new Database();
        JOptionPane.showMessageDialog(null, "Conectado");
        bd.conexion();
    }
}
