package saverscoders.Modelo;

public class ClientePremium extends Cliente{

	public ClientePremium() {}
	public ClientePremium(String nombre, String domicilio, String nif, String email) {
		
		super(nombre, domicilio, nif, email);
		super.cuota = 30;
		super.descuento = 20;
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
	
	
	@Override
    public boolean tipoDeCliente(String email) {
        // TODO
        return false;
    }

    @Override
    public double cuotaAnual() {
        return getCuota();
    }
    
    @Override
    public double descuentoGastosDeEnvio(double totalPedido) {
        return totalPedido - (totalPedido * 0.2);
    }


	@Override
	public String toString(){
        return  "Tipo de cliente: Premium" + "\n" +
                "NIF: " + this.getNif() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Domicilio: " + this.getDomicilio() + "\n"+
                "Cuota: " + this.getCuota() + "\n" +
                "Descuento en el envio: " + this.getDescuento();
	}
	
	

}
