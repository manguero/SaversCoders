/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Pedidos {
    
    public String numPedido;
    public Date fechaPedido;
    public Time horaPedido;
    public ArrayList<Clientes> Clientes; 
    public ArrayList<Articulos> Articulos;
    public int unidades;
    
    //toString//
    
    @Override
    public String toString() {
        return "Pedidos{" + "numPedido=" + numPedido + ", fechaPedido=" + fechaPedido + ", horaPedido=" + horaPedido + ", Clientes=" + Clientes + ", Articulos=" + Articulos + ", unidades=" + unidades + '}';
    }
    
    //Constructores//
    
    public Pedidos (String numPedido, Date fechaPedido, Time horaPedido, int unidades){
    
        this.unidades = unidades;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.Clientes = new ArrayList();
        this.Articulos = new ArrayList();
    
    }
}
