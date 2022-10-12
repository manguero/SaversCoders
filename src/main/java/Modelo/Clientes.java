
package Modelo;

/**
 *
 * @author Usuario
 */
public class Clientes {

	public String nombre;
	public String domicilio;
	public String nif;
	public String email;
	
        //Constructores//
        
        public Clientes (String nombre, String domicilio, String nif, String email){
        
            this.nombre = nombre;
            this.domicilio = domicilio;
            this.nif = nif;
            this.email = email;
        }
        
        //toString//
        
        @Override
        public String toString() {
            return "Clientes{" + "nombre=" + nombre + ", domicilio=" + domicilio + ", nif=" + nif + ", email=" + email + '}';
    }
        
        //Getters y Setters//
        
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
