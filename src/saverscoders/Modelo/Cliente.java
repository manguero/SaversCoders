package saverscoders.Modelo;

public abstract class Cliente {

	public String email;
	public String nombre;
	public String domicilio;
	public String nif;
	public double cuota;
	public double descuento;
  
        //Constructores//
        
	public Cliente() {}
	
    public Cliente (String email, String nombre, String domicilio, String nif){
        
    		
            this.nombre = nombre;
            this.domicilio = domicilio;
            this.nif = nif;
            this.email = email;
            
        }
    
    //Getters y Setters//
    

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

		public String getNif() {
			return nif;
		}

		public void setNif(String nif) {
			this.nif = nif;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		public int getCuota() {
	        return (int) cuota;
	    }

	    public void setCuota(int cuota) {
	        this.cuota = cuota;
	    }

	    public int getDescuento() {
	        return (int) descuento;
	    }

	    public void setDescuento(int descuento) {
	        this.descuento = descuento;
	    }
	    
	    public abstract boolean tipoDeCliente (String email); //  implemented in override in childs

	    public abstract double cuotaAnual(); //  implemented in override in childs

	    public abstract double descuentoGastosDeEnvio(double totalPedido); // implemented in override in childs

		@Override
		public String toString() {
			return "ClientePremium [nombre=" + nombre + ", domicilio=" + domicilio + ", nif=" + nif + ", email=" + email
					+ "]";
		}
}
