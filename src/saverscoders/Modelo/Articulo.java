package saverscoders.Modelo;

import java.sql.Time;

public class Articulo {
	
	public String codigo;
	public String descripcion;
	public double precio;
	public double gastosEnvio;
	public int tiempoEnvio;

	
	public Articulo() {}
	public Articulo(String codigo, String descripcion, double precio, double gastosEnvio, int tiempoEnvio) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.gastosEnvio = gastosEnvio;
		this.tiempoEnvio = tiempoEnvio;
	}


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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getGastosEnvio() {
		return gastosEnvio;
	}


	public void setGastosEnvio(double gastosEnvio) {
		this.gastosEnvio = gastosEnvio;
	}


	public int getTiempoEnvio() {
		return tiempoEnvio;
	}


	public void setTiempoEnvio(int tiempoEnvio) {
		this.tiempoEnvio = tiempoEnvio;
	}


	@Override
	public String toString(){
        return  "Codigo del articulo: " + this.getCodigo() + "\n" +
                "Nombre del articulo: " + this.getDescripcion() + "\n" +
                "Precio de venta: " + this.getPrecio() + "€" + "\n" +
                "Gastos de envio:  " + this.getGastosEnvio() + "€" + "\n" +
                "Tiempo de preparación:  " + this.getTiempoEnvio() + "\n";
	}

}
