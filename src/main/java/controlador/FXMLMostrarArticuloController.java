package controlador;



import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Articulo;
import modelo.ArticuloDAO;
import modelo.DAOFactory;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLMostrarArticuloController implements Initializable {

    @FXML
    private Button btnAtras;
    
    @FXML
    private TableView<Articulo> tableArticulo;


    @FXML
    private TableColumn<Articulo, Integer> tvCodigoArticulo;

    @FXML
    private TableColumn<Articulo, String> tvDescripcionArticulo;

    @FXML
    private TableColumn<Articulo, Double> tvGastosEnvioArticulo;

    @FXML
    private TableColumn<Articulo, Double> tvPrecioVentaArticulo;

    @FXML
    private TableColumn<Articulo, LocalDate> tvTiempoEnvioArticulo;
    
    
    @FXML
    private Button btnEliminarArticulo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ArticuloDAO dao=DAOFactory.createArticuloDAO();
       ArrayList<Articulo> lista = dao.listar();
      
        tvCodigoArticulo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tvDescripcionArticulo.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tvGastosEnvioArticulo.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
        tvPrecioVentaArticulo.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        tvTiempoEnvioArticulo.setCellValueFactory(new PropertyValueFactory<>("tiempoEnvio"));
        
        //tvTipoCliente.setCellValueFactory(new PropertyValueFactory<>("tipo_cliente"));
        tableArticulo.setItems(FXCollections.observableArrayList(lista));
    }    
    
    @FXML
    void btnAtrasMostrarArticuloClicado(ActionEvent event) {
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }
    
    
    @FXML
    void btnEliminarArticuloClicado(ActionEvent event) {
        
        Articulo a = this.tableArticulo.getSelectionModel().getSelectedItem();
        if(a!=null){
            
            tableArticulo.getItems().remove(a);
            tableArticulo.refresh();
            ArticuloDAO dao=DAOFactory.createArticuloDAO(a.getClass());
            dao.delete(a.getCodigo());
        }

    }
}
