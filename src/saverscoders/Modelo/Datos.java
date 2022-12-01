package saverscoders.Modelo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/*import modelo.Cliente;
import modelo.ClienteEstandard;
import modelo.ClientePremium;
import modelo.Pedido;*/
import saverscoders.Modelo.Articulo;
import saverscoders.DAO.ArticuloDAOimpl;
import saverscoders.DAO.ClienteDAO;
import saverscoders.DAO.ClienteDAOimpl;
import saverscoders.DAO.PedidoDAOimpl;

public class Datos {
	
	private final ArticuloDAOimpl articuloDAO = new ArticuloDAOimpl();
    private final ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
    private final PedidoDAOimpl pedidoDAO = new PedidoDAOimpl();
    
    public Datos() {}
    
    //GESTION ARTICULOS
    public boolean agregarArticulo (List<Object> parametros) {
    	
    	 // crear un nuevo objeto de tipo Articulo
        Articulo articuloACrear = new Articulo(parametros.get(0).toString(),parametros.get(1).toString(),
                (Double)parametros.get(2), (Double)parametros.get(3), (Integer)parametros.get(4));

        // Comprobar si el articulo existe antes de agregarlo
        if (!articuloDAO.articuloExiste(parametros.get(0).toString())){
            // agregarlo a la arraylist en main
            articuloDAO.addArticulo(articuloACrear);
        }

        // enviar al controlador si el articulo se ha creado o no
        return articuloExiste(parametros.get(0).toString());
    }
    
 // Comprobar si el articulo existe en la base de datos
    public boolean articuloExiste(String codArticulo) {
        boolean existe = articuloDAO.articuloExiste(codArticulo);
        return existe;
    }
    
    public List<Articulo> getArticulos() {
        List lista = articuloDAO.getArticulos();
        return lista;
    }
    
    //FIN GESTION ARTICULOS

    //GESTION CLIENTES
    public boolean clienteExiste(String email) {
        return clienteDAO.clienteExiste(email);
    }
    
    public boolean crearCliente(List<Object> parametros) {
    	boolean clienteCreado = false;
        // en la primera posicion de los parametros tenemos el tipo de cliente
        if (parametros.get(0).equals(1)) {
            // crear cliente estandard
            Cliente clienteEstandard = new ClienteEstandard(parametros.get(1).toString(),parametros.get(2).toString(),
                    parametros.get(3).toString(),parametros.get(4).toString());
            clienteDAO.addCliente(clienteEstandard);
            clienteCreado = clienteDAO.clienteExiste(parametros.get(1).toString());
        } else if (parametros.get(0).equals(2)) {
            // crear cliente premium
            Cliente cp = new ClientePremium(parametros.get(1).toString(),parametros.get(2).toString(),
                    parametros.get(3).toString(),parametros.get(4).toString());
            clienteDAO.addCliente(cp);
            clienteCreado = clienteDAO.clienteExiste(parametros.get(1).toString());
        }
        // enviar si el cliente exista en la base de datos al controlador
        return clienteCreado;
    }

    public List recibirDatosClientes() {
        List lista = clienteDAO.getClientes();
        return lista;
    }

    public List recibirDatosClientesEstandard() {
        List lista = clienteDAO.listarClientesEstandard();
        return lista;
    }

    public List recibirDatosClientesPremium() {
        List lista = clienteDAO.listarClientesPremium();
        return lista;
    }
    
    //FIN FESTION CLIENTES

    
    //GESTION PEDIDOS
    public boolean crearDatosPedido(List parametros) {
        boolean existe;
        Pedido nuevoPedido = new Pedido();
        Articulo articuloPedido = articuloDAO.getArticuloById((String)parametros.get(0));
        Cliente clientePedido = clienteDAO.getClienteByEmail((String)parametros.get(1));

        // Declarar la fecha
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
        // Set valores del pedido
        // el numero de pedido es autoincrement, no hace falta agregarlo
        nuevoPedido.setArticulo(articuloPedido);
        nuevoPedido.setCliente(clientePedido);
        nuevoPedido.setCantidad((Integer)parametros.get(2));
        nuevoPedido.setFecha(dateSQL);
        nuevoPedido.setProcesado(false);

        // agregar datos al pedido
        existe = pedidoDAO.addPedido(nuevoPedido);

        return existe;
    }

    public Pedido getPedido(int numeroPedido) {
        Pedido pedidoADevolver = pedidoDAO.getPedido(numeroPedido);
        return pedidoADevolver;
    }



    // metodo para eliminar un pedido existente
    public boolean eliminarPedido(int numPedido) {
        boolean eliminado = false;
        eliminado = pedidoDAO.eliminarPedido(numPedido);
        return eliminado;
    }

    public List recibirDatosPedidosPendientes() {
        // actualizar los pedidos si se han enviado
        pedidoDAO.actualizarPedidos();
        // recibir todos los pedidos WHERE enviado == FALSE
        List lista = pedidoDAO.getPedidosPendientes();
        // enviar arraylist a controlador
        return lista;
    }

    public List recibirDatosPedidosEnviados() {
        // actualizar los pedidos
        pedidoDAO.actualizarPedidos();
        // recibir todos los pedidos enviados
        List lista = pedidoDAO.getPedidosEnviados();
        return lista;
    }
    // FIN GESTION PEDIDOS
}
