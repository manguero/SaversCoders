package saverscoders.DAO;

import saverscoders.resources.Database;
import saverscoders.Modelo.Articulo;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOimpl extends Database implements ArticuloDAO {
	
	 private final Connection con = Database.conexion();
	 private final static String SQL_CREATE_ARTICULO = "INSERT INTO `saverscoders.store`.articulos(codigo, descripcion, precio, gastos_envio, tiempo_envio) VALUES (?, ?, ?, ?, ?)";
	 private final static String SQL_GET_ARTICULO_ID = "SELECT * FROM `saverscoders.store`.articulos WHERE codigo = ?";
	 private final static String SQL_GET_ALL_ARTICULOS = "SELECT * FROM `saverscoders.store`.articulos";

	@Override
	public boolean addArticulo(Articulo articulo) {
		try {
			//preparar el mysql statment
			PreparedStatement pstm = con.prepareStatement(SQL_CREATE_ARTICULO);
			//dar los valores a los campos ?
			pstm.setString(1, articulo.getCodigo());
			pstm.setString(2, articulo.getDescripcion());
			pstm.setDouble(3, articulo.getPrecio());
            pstm.setDouble(4, articulo.getGastosEnvio());
            pstm.setInt(5, articulo.getTiempoEnvio());
            //ejecutar stattment
            pstm.executeUpdate();
            return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Articulo> getArticulos() {
		List<Articulo> list = new ArrayList<>();
		try (PreparedStatement psmt = con.prepareStatement(SQL_GET_ALL_ARTICULOS)){
			try(ResultSet rs = psmt.executeQuery()){
				while(rs.next()) {
					Articulo articulo = new Articulo();
					articulo.setCodigo(rs.getString(1));
					articulo.setDescripcion(rs.getString(2));
					articulo.setPrecio(rs.getDouble(3));
					articulo.setGastosEnvio(rs.getDouble(4));
					articulo.setTiempoEnvio(rs.getInt(5));
					list.add(articulo);	
				}
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public Articulo getArticuloById(String codigo) {
		Articulo articulo = new Articulo();
		try (PreparedStatement pstm = con.prepareStatement(SQL_GET_ARTICULO_ID)){
			pstm.setString(1, codigo);
			try (ResultSet rs = pstm.executeQuery()){
				if (rs.next()) {
					articulo.setCodigo(rs.getString(1));
					articulo.setDescripcion(rs.getString(2));
					articulo.setPrecio(rs.getDouble(3));
					articulo.setGastosEnvio(rs.getDouble(4));
					articulo.setTiempoEnvio(rs.getInt(5));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return articulo;
	}
	
	 @Override
	    public boolean articuloExiste(String codigo) {
	        boolean existe = false;
	        try (PreparedStatement pstm= con.prepareStatement((SQL_GET_ARTICULO_ID))) {
	            //Declaramos que el codigo esta en la primera posicion
	            pstm.setString(1, codigo);
	            try (ResultSet rs = pstm.executeQuery()) {
	                // comprobar si la query devuelve algun resultado
	                if (rs.next()) {
	                    existe = true;
	                }
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex);
	        }
	        return existe;
	    }

}
