package Modelo;

/**
 *
 * @author Usuario
 */
public class ClientesPremium extends Clientes{
    
        public int cuotaAnual;


    public ClientesPremium(int cuotaAnual, String nombre, String domicilio, String nif, String email) {
        super(nombre, domicilio, nif, email);
        this.cuotaAnual = cuotaAnual;
    }
        
        //toString
    
	@Override
        public String toString() {
            return super.toString() + "ClientesPremium{" + "cuotaAnual=" + cuotaAnual + '}';
        }
        
     //Getters y Setters//
        
	public int getCuotaAnual() {
		return cuotaAnual;
	}
	public void setCuotaAnual(int cuotaAnual) {
		this.cuotaAnual = cuotaAnual;
	}
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
