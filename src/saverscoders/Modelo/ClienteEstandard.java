package saverscoders.Modelo;

public class ClienteEstandard extends Cliente{

	public ClienteEstandard() {}
	public ClienteEstandard(String nombre, String domicilio, String nif, String email) {
		super(nombre, domicilio, nif, email);	
		super.setCuota(0);
        super.setDescuento(0);
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
	
	 public boolean tipoDeCliente(String email) {
	        boolean encontrado = false;
	        // retornar objeto return OnlineStore.getClientes().stream().filter(cliente -> email.equals(cliente.getEmail())).findFirst().orElse(null);
//	        for (Cliente cliente : ListaClientes.getClientes()) {
//	            if (cliente instanceof ClienteEstandard) {
//	                if (cliente.getEmail().equals(email)) {
//	                    encontrado = true;
//	                }
//	            }
	//
//	        }
	        return encontrado;
	    }
	 
	 public double cuotaAnual() {
	        return 0;
	    }


	 public double descuentoGastosDeEnvio(double totalPedido) {
	        return 0;
	    }

	@Override
	public String toString(){
        return  "Tipo de cliente: Estandar" + "\n" +
                "NIF: " + this.getNif() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Domicilio: " + this.getDomicilio() + "\n";
	}	
}
