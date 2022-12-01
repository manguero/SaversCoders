package saverscoders.DAO;

import saverscoders.Modelo.Pedido;
import saverscoders.resources.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class PedidoDAOimpl extends Database implements PedidoDAO {
	
	private final Connection con = Database.conexion();
	private final ClienteDAOimpl cliente = new ClienteDAOimpl();  // Asi lo tenia yo. numero_pedido, email_cliente, codigo_articulo, fecha_hora_pedido, procesado, cantidad
	private final ArticuloDAOimpl articulo = new ArticuloDAOimpl();    //email_cliente, codigo_articulo, cantidad, fecha, procesado
	
	private final static String SQL_CREATE_PEDIDO = "INSERT INTO `saverscoders.store`.pedidos(email_cliente, codigo_articulo, cantidad, fecha, procesado) VALUES(?,?,?,?,?)";
	private final static String SQL_DELETE_PEDIDO = "DELETE FROM pedidos WHERE numero_pedido = ?";
	private final static String SQL_SELECT_PEDIDOS = "SELECT * FROM pedidos";
	private final static String SQL_SELECT_PEDIDOS_PENDIENTES = "SELECT * FROM pedidos WHERE procesado = 0";
	private final static String SQL_SELECT_PEDIDOS_ENVIADOS = "SELECT * FROM pedidos WHERE procesado = 1";
	private final static String SQL_ACTUALIZAR_PROCESADO = "UPDATE pedidos SET procesado = 1 WHERE numero_pedido = ?";

    
    @Override
    public Pedido getPedido(int numPedido) {
        return null;
    }
    
	@Override
	public boolean addPedido(Pedido pedido) {
		try {
            PreparedStatement pstm = con.prepareStatement(SQL_CREATE_PEDIDO);
            pstm.setObject(1, pedido.getCliente().getEmail());
            pstm.setString(2, pedido.getArticulo().getCodigo());
            pstm.setInt(3, pedido.getCantidad());
            pstm.setTimestamp(4, pedido.getFecha());
            pstm.setBoolean(5, pedido.getProcesado());
            pstm.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
	}

	@Override
    public List<Pedido> getPedidos() {
        List lista = new ArrayList();
        try (PreparedStatement pstm = con.prepareStatement(SQL_SELECT_PEDIDOS)) {
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setNumPedido(rs.getInt(1));
                    pedido.setCliente(cliente.getClienteByEmail(rs.getString(2)));
                    pedido.setArticulo(articulo.getArticuloById(rs.getString(3)));
                    pedido.setCantidad(rs.getInt(4));
                    pedido.setFecha(rs.getTimestamp(5));
                    pedido.setProcesado(rs.getBoolean(6));

                    lista.add(pedido);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lista;
    }

	// comprueba la diferencia horaria entre el pedido y ahora y comprueba el tiempo de preparacion
    @Override
    public void actualizarPedidos() {
        List<Pedido> lista = getPedidos();

        // recibir todos los pedidos
        for (Pedido pedido : getPedidos()) {

            if (pedido.getProcesado() == false) {
                // comprobar si el tiempo de preparacion se ha cumplido
                Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
                Timestamp fechaPedido = pedido.getFecha();
                long diferencia = fechaActual.getTime() - fechaPedido.getTime();
                int seconds = (int) diferencia / 1000;
                int minutes = (seconds % 3600) / 60;
                if (minutes >= pedido.getArticulo().getTiempoEnvio()) {
                    try {
                        PreparedStatement pstm = con.prepareStatement(SQL_ACTUALIZAR_PROCESADO);
                        int numeroPedido = pedido.getNumPedido();
                        pstm.setInt(1,numeroPedido);
                        pstm.executeUpdate();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }

                }
            }
        }
    }

    @Override
    public boolean eliminarPedido(int numPedido) {
        boolean eliminado;
        try (PreparedStatement pstm = con.prepareStatement(SQL_DELETE_PEDIDO)) {
            pstm.setInt(1, numPedido);
            pstm.executeUpdate();
            eliminado = true;
        } catch (SQLException ex) {
            System.err.println(ex);
            eliminado = false;
        }

        return eliminado;
    }
    
    @Override
    public List getPedidosPendientes() {
        List<Pedido> lista = new ArrayList<>();
        // empezamos actualizando los pedidos
        try (PreparedStatement pstm = con.prepareStatement(SQL_SELECT_PEDIDOS_PENDIENTES)) {
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setNumPedido(rs.getInt(1));
                    pedido.setCliente(cliente.getClienteByEmail(rs.getString(2)));
                    pedido.setArticulo(articulo.getArticuloById(rs.getString(3)));
                    pedido.setCantidad(rs.getInt(4));
                    pedido.setFecha(rs.getTimestamp(5));
                    pedido.setProcesado(rs.getBoolean(6));

                    lista.add(pedido);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return lista;
    }
    
    @Override
    public List getPedidosEnviados() {
        List<Pedido> lista = new ArrayList<>();
        // empezamos actualizando los pedidos
        try (PreparedStatement pstm = con.prepareStatement(SQL_SELECT_PEDIDOS_ENVIADOS)) {
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setNumPedido(rs.getInt(1));
                    pedido.setCliente(cliente.getClienteByEmail(rs.getString(2)));
                    pedido.setArticulo(articulo.getArticuloById(rs.getString(3)));
                    pedido.setCantidad(rs.getInt(4));
                    pedido.setFecha(rs.getTimestamp(5));
                    pedido.setProcesado(rs.getBoolean(6));

                    lista.add(pedido);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return lista;
    }
}
