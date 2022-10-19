/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Tamara Blanco
 */
public class ClientesEtandard extends Clientes{

        public ClientesEtandard (String nombre, String domicilio, String nif, String email){
    
	super (nombre, domicilio, nif, email);
        }
        
        //toString//
        
        @Override
        public String toString() {
            return super.toString() + "ClientesEtandard{" + '}';
        }
                
     //Getters y Setters//
        
        @Override
	public String getNombre() {
		return nombre;
	}
        @Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        @Override
	public String getDomicilio() {
		return domicilio;
	}
        @Override
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
        @Override
	public String getNif() {
		return nif;
	}
        @Override
	public void setNif(String nif) {
		this.nif = nif;
	}
        @Override
	public String getEmail() {
		return email;
	}
        @Override
	public void setEmail(String email) {
		this.email = email;
	}
}

