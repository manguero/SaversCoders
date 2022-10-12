/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Time;

/**
 *
 * @author Usuario
 */
public class Articulos {


	public String codigo;
	public String descripcion;
	public Double precio;
	public Double gastosEnvio;
	public Time tiempoEnvio; //Tiempo de preparacion, representado en minutos
	
        //Constructores//

        public Articulos(String codigo, String descripcion, Double precio, Double gastosEnvio, Time tiempoEnvio) {
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.precio = precio;
            this.gastosEnvio = gastosEnvio;
            this.tiempoEnvio = tiempoEnvio;
    }
        
       
         //toString//
        
        @Override
        public String toString() {
        return "Articulos{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", gastosEnvio=" + gastosEnvio + ", tiempoEnvio=" + tiempoEnvio + '}';
        }

         //Getters y Setters//
        
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getGastosEnvio() {
		return gastosEnvio;
	}
	public void setGastosEnvio(Double gastosEnvio) {
		this.gastosEnvio = gastosEnvio;
	}
	public Time getTiempoEnvio() {
		return tiempoEnvio;
	}
	public void setTiempoEnvio(Time tiempoEnvio) {
		this.tiempoEnvio = tiempoEnvio;
	}

}
