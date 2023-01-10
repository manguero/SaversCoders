package modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="cliente_standard")
@DiscriminatorValue("0")
public class ClienteStandard extends Cliente{
    
    public ClienteStandard(){
        
    }

    public ClienteStandard(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }
  
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ", domicilio=" + domicilio + ", email=" + email + ", nif=" + nif + ", tipo de cliente= standard";
    }
    
    @Override
    public String getTipoCliente(){
        return "Standard";
    }
    
}
