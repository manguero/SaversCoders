package saverscoders.DAO;

import saverscoders.Modelo.Cliente;
import saverscoders.Modelo.ClienteEstandard;
import saverscoders.Modelo.ClientePremium;
import saverscoders.resources.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends Database implements ClienteDAO {

	private final Connection con = Database.conexion();
    private final static String SQL_CREATE_CLIENTE = "INSERT INTO `saverscoders.store`.clientes(email, nombre, domicilio, nif, cuota, descuento) VALUES (?, ?, ?, ?, ?, ?)";
    private final static String SQL_GET_CLIENTE = "SELECT * FROM `saverscoders.store`.clientes WHERE email = ?";
    private final static String SQL_GET_CLIENTES = "SELECT * FROM `saverscoders.store`.clientes";

    @Override
    public boolean addCliente(Cliente cliente) {
        try {
            PreparedStatement pstm = con.prepareStatement(SQL_CREATE_CLIENTE);
            pstm.setString(1, cliente.getEmail());
            pstm.setString(2, cliente.getNombre());
            pstm.setString(3, cliente.getDomicilio());
            pstm.setString(4, cliente.getNif());
            pstm.setDouble(5, cliente.getDescuento());
            pstm.setDouble(6, cliente.getCuota());
   
            // Ejecutamos statement
            pstm.executeUpdate();
            return true;

        } catch (SQLException ex) { //  si ocurre una excepcion
        	System.err.println(ex);
            return false;
        }
    }
    
    @Override
    public boolean clienteExiste(String email) {
        boolean existe = false;

        try (PreparedStatement pstm = con.prepareStatement(SQL_GET_CLIENTE)){
            // declaramos que el email esta en la posicion 1
            pstm.setString(1, email);
            // intentamos lanzar la query
            try (ResultSet rs = pstm.executeQuery()){
                // si el resultado tiene una fila existe
                if (rs.next()) {
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return existe;
    }

    @Override
    public List<Cliente> getClientes() {
        Cliente cliente = null;
        List<Cliente> list = new ArrayList<>();
        try(PreparedStatement pstm = con.prepareStatement(SQL_GET_CLIENTES);
            ResultSet rs = pstm.executeQuery()){
            while(rs.next()) {
                int setCuota = rs.getInt(5);
                if(setCuota > 0) {
                    Cliente clientePremium = new ClientePremium();
                    
                    clientePremium.setEmail(rs.getString(1));
                    clientePremium.setNombre(rs.getString(2));
                    clientePremium.setDomicilio(rs.getString(3));
                    clientePremium.setNif(rs.getString(4));
                    clientePremium.setCuota(rs.getInt(5));
                    clientePremium.setDescuento(rs.getInt(6));
                    
                    cliente = clientePremium;
                    list.add(cliente);

                } else {
                    Cliente clienteEstandard = new ClienteEstandard();

                    clienteEstandard.setEmail(rs.getString(1));
                    clienteEstandard.setNombre(rs.getString(2));
                    clienteEstandard.setDomicilio(rs.getString(3));
                    clienteEstandard.setNif(rs.getString(4));
                    clienteEstandard.setCuota(rs.getInt(5));
                    clienteEstandard.setDescuento(rs.getInt(6));
                    
                    cliente = clienteEstandard;
                    list.add(cliente);
                }
            }
        } catch (SQLException ex) {
        	System.err.println(ex);
        }
        return list;
    }

    @Override
    public Cliente getClienteByEmail(String email) {
        Cliente cliente = null;
        try (PreparedStatement pstm = con.prepareStatement(SQL_GET_CLIENTE)){
            pstm.setString(1, email);
            try (ResultSet rs = pstm.executeQuery()){
                if (rs.next()) {
                    if(rs.getInt(5) > 0) {
                        Cliente clientePremium = new ClientePremium();
                        
                        clientePremium.setEmail(rs.getString(1));
                        clientePremium.setNombre(rs.getString(2));
                        clientePremium.setDomicilio(rs.getString(3));
                        clientePremium.setNif(rs.getString(4));
                        clientePremium.setCuota(rs.getInt(5));
                        clientePremium.setDescuento(rs.getInt(6));

                        cliente = clientePremium;
                    } else {
                        Cliente clienteEstandard = new ClienteEstandard();
                        
                        clienteEstandard.setEmail(rs.getString(1));
                        clienteEstandard.setNombre(rs.getString(2));
                        clienteEstandard.setDomicilio(rs.getString(3));
                        clienteEstandard.setNif(rs.getString(4));
                        clienteEstandard.setCuota(rs.getInt(5));
                        clienteEstandard.setDescuento(rs.getInt(6));

                        cliente = clienteEstandard;
                    }

                }
            }
        } catch (SQLException ex) {
        	System.err.println(ex);
        }
        return cliente;
    }
    
    @Override
    public List<Cliente> listarClientesEstandard() {
    // declaramos una nueva lista
        Cliente cliente = null;
        List<Cliente> list = new ArrayList<>();
        // preparamos el sql statement
        try(PreparedStatement pstm = con.prepareStatement(SQL_GET_CLIENTES);
            ResultSet rs = pstm.executeQuery()){
            // siempre que hayan mas columnas
            while(rs.next()) {
            // comprobar si es cliente Estandard
            int getCuota = rs.getInt(5);
                if(getCuota == 0) {
                    Cliente clienteEstandard = new ClienteEstandard();

                    clienteEstandard.setEmail(rs.getString(1));
                    clienteEstandard.setNombre(rs.getString(2));
                    clienteEstandard.setDomicilio(rs.getString(3));
                    clienteEstandard.setNif(rs.getString(4));
                    clienteEstandard.setCuota(rs.getInt(5));
                    clienteEstandard.setDescuento(rs.getInt(6));

                    cliente = clienteEstandard;
                    list.add(cliente);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return list;
    }


    @Override
    public List<Cliente> listarClientesPremium() {
        // declaramos una nueva lista
        Cliente cliente = null;
        List<Cliente> list = new ArrayList<>();
        // preparamos el sql statement
        try(PreparedStatement pstm = con.prepareStatement(SQL_GET_CLIENTES);
            ResultSet rs = pstm.executeQuery()){
            // siempre que hayan mas columnas
            while(rs.next()) {
                // comprobar si es cliente premium
                int setCuota = rs.getInt(5);
                if(setCuota > 0) {
                    Cliente clientePremium = new ClientePremium();

                    clientePremium.setEmail(rs.getString(1));
                    clientePremium.setNombre(rs.getString(2));
                    clientePremium.setDomicilio(rs.getString(3));
                    clientePremium.setNif(rs.getString(4));
                    clientePremium.setCuota(rs.getInt(5));
                    clientePremium.setDescuento(rs.getInt(6));

                    cliente = clientePremium;
                    list.add(cliente);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return list;
    }
    

}
