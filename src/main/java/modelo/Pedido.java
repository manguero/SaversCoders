package modelo;

import javax.persistence.*;

import modelo.Articulo;
import modelo.ArticuloDAO;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.DAOFactory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Pedido implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    private int numero;
    private int cantidad; 
    private String nif;
    private int codigo;
    private LocalDate fechaPedido;
    private LocalTime hora;
    private Boolean enviado;

    public Pedido(){
        
    }
    
    public Pedido(int numero, int cantidad, String nif, int codigo, LocalDate fechaPedido, LocalTime hora, Boolean enviado) {
        this.numero = numero;
        this.cantidad = cantidad;
        this.nif = nif;
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.hora = hora;
        this.enviado = enviado;
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        ClienteDAO dao=DAOFactory.createClienteDAO();
        Cliente c=dao.read(nif);
        return c;
    }


    public Articulo getArticulo() {
        ArticuloDAO dao=DAOFactory.createArticuloDAO();
        Articulo a=dao.read(codigo);
        return a;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public Boolean getEnviado() {
        return enviado;
    }
    

    
    public boolean pedidoEnviado() {
        return enviado;
    }
    
    @Override
    public String toString() {
        Cliente cliente=getCliente();
        Articulo articulo=getArticulo();
        String text ="Pedido{"; 
        text += "  Numero=" + numero;
        text += ", Cantidad=" + cantidad;
        text += ", Cliente nif=" + cliente.nif;
        text += ", Cliente nombre=" + cliente.nombre;
        text += ", Articulo codigo=" + articulo.getCodigo();
        text += ", Articulo descripcion=" + articulo.getDescripcion();
        text += ", PVPArticulo=" + articulo.getPrecioVenta();
        text += ", FechaPedido=" + fechaPedido;
        text += ", Hora=" + hora;
        text += "}";
        return text;

        //return "Pedido{" + "numero=" + numero + ", cantidad=" + cantidad + ", cliente nif=" + Cliente.nif + ", cliente nombre=" + Cliente.nombre + ", Articulo codigo =" + Articulo.codigo + ", Articulo descripcion =" + Articulo.descripcion + ",fechaPedido =" +fechaPedido + ", hora =" +hora + ",pvpArticulo'}';
    }

    
}
