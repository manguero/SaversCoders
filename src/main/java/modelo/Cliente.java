package modelo;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/*
Un JavaBean tiene
Un constructor vacio
sigue el protocolo de java de getters y setters

*/

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="cliente")
@DiscriminatorColumn(
        name="tipo_cliente",
        discriminatorType=DiscriminatorType.INTEGER)
public abstract class Cliente implements Serializable{
    
    protected String nombre;
    protected String domicilio;
    protected String email;
    
    @Id
    protected String nif; 
    

   //public abstract String tipoCliente(){}; 
   
   /*
    Constructor
    */
   
    public Cliente(){
        
    }
    
    
    public Cliente(String nombre, String domicilio, String email, String nif) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.nif = nif;
    }

    /*
    Getter y Setter
    */
   
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    
    public abstract String getTipoCliente();

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", domicilio=" + domicilio + ", email=" + email + ", nif=" + nif + '}';
    }

    void setCliente(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}

