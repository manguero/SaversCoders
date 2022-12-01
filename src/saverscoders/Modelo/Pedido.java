package saverscoders.Modelo;

import java.sql.Time;
import static java.lang.Math.floor;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Pedido {

	public int numPedido;
	public Articulo articulo;
	public Cliente cliente;
	public int cantidad;
	public java.sql.Timestamp fecha;
	public boolean procesado;
	
	public Pedido() {}
	public Pedido(int numPedido, Articulo articulo, Cliente clientes, int cantidad, java.sql.Timestamp fecha, boolean procesado) {
		super();
		this.numPedido = numPedido;
		this.articulo = articulo;
		this.cliente = clientes;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.procesado = procesado;
	}
	
	
	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public java.sql.Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}

	public boolean getProcesado() {return this.procesado;}

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }
    
    public boolean isProcesado() {
        return procesado;
    }


    // Comprobar si el pedido ha sido enviado
    public String pedidoEnviado() {
        if(this.procesado){
            return "si";
        } else {
            return "no";
        }
    }

	
	  public double pecioTotal() {
	        double total;
	        total = this.articulo.getPrecio() * this.cantidad + gastosEnvio();
	        if (this.getCliente() instanceof ClientePremium) {
	            total -= total * 0.2;
	        }

	        floor(total);
	        return total;

	    }

	    public double gastosEnvio() {
	        return this.articulo.getGastosEnvio() * this.cantidad;
	    }




	@Override
	public String toString() {
        return "Nº PEDIDO: " + this.numPedido + "\n" +
                "CLIENTE " + this.cliente.getNombre() + "      NIF: " + this.cliente.getNif() + "\n" +
                "_______________________________________________________________________________________________"  + "\n" +
                "CODIGO: " + this.articulo.getCodigo() +
                "   |   DESCRIPCION: " + this.articulo.getDescripcion()  +"   |   CANTIDAD: " + this.cantidad +
                "   |   COSTE: " + articulo.getPrecio() +"€" + "\n" +
                "_______________________________________________________________________________________________"  + "\n" +
                "COSTE ENVIO: " + articulo.getGastosEnvio() +"€" + "\n" +
                "PRECIO TOTAL: " + pecioTotal() +"\n"+
                "PROCESADO:" + pedidoEnviado() + "\n"
                ;
	}
	
	
	
	
}
