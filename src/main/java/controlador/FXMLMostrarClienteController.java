package controlador;



import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.DAOFactory;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLMostrarClienteController implements Initializable {

    @FXML
    private TableView<Cliente> table;

    @FXML
    private TableColumn<Cliente, String> tvDomicilio;

    @FXML
    private TableColumn<Cliente, String> tvEmail;

    @FXML
    private TableColumn<Cliente, String> tvNif;

    @FXML
    private TableColumn<Cliente, String> tvNombre;

    @FXML
    private TableColumn<Cliente, String> tvTipoCliente;
    
    @FXML
    private Button btnAtras;
    
    @FXML
    private Button btnEliminar;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ClienteDAO dao=DAOFactory.createClienteDAO();
       ArrayList<Cliente> lista = dao.listar();
      
        tvDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        tvEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tvNif.setCellValueFactory(new PropertyValueFactory<>("nif"));
        tvNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tvTipoCliente.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));
        table.setItems(FXCollections.observableArrayList(lista));

    }
    
    
    @FXML
    void btnAtrasClicado(ActionEvent event){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }
    
    
    
    @FXML
    void btnEliminarClicado(ActionEvent event) {
        Cliente c = this.table.getSelectionModel().getSelectedItem();
        if(c!=null){
            
            table.getItems().remove(c);
            table.refresh();
            ClienteDAO dao=DAOFactory.createClienteDAO(c.getClass());
            dao.delete(c.getNif());
        }
    }
}
