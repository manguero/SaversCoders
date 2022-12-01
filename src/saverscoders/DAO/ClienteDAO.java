package saverscoders.DAO;

import java.util.List;

import saverscoders.Modelo.Cliente;

public interface ClienteDAO {

		
		//Create
		public boolean addCliente (Cliente cliente);
		
		//Get all
		public List<Cliente> getClientes();
		
		//Get one by email
		public Cliente getClienteByEmail(String email);
		
		public boolean clienteExiste(String email);

		public List<Cliente> listarClientesEstandard();
	    public List<Cliente> listarClientesPremium();
}
