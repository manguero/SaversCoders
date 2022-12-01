package saverscoders.DAO;

import java.util.List;
import saverscoders.Modelo.Pedido;

public interface PedidoDAO {
	
	public Pedido getPedido(int numeroPedido);
	//Create
	public boolean addPedido (Pedido pedido);
	
	//Get all
	public List<Pedido> getPedidos();
	
	 public void actualizarPedidos();

	 public boolean eliminarPedido(int numPedido);

	 public List getPedidosPendientes();

	 public List getPedidosEnviados();

}
