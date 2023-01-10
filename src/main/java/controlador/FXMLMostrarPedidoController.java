package controlador;



import modelo.DAOFactory;
import modelo.Pedido;
import modelo.PedidoDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
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


public class FXMLMostrarPedidoController implements Initializable {

    @FXML
    private TableView<Pedido> tablePedido;

    @FXML
    private TableColumn<Pedido, Integer> tvCantidadPedido;

    @FXML
    private TableColumn<Pedido, Integer> tvCodigoPedido;

    @FXML
    private TableColumn<Pedido, Boolean> tvEnviadoPedido;

    @FXML
    private TableColumn<Pedido, LocalDate> tvFechaPedido;

    @FXML
    private TableColumn<Pedido, LocalTime> tvHoraPedido;

    @FXML
    private TableColumn<Pedido, String> tvNifPedido;

    @FXML
    private TableColumn<Pedido, Integer> tvNumeroPedido;
    
    @FXML
    private Button btnEliminar;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       PedidoDAO dao=DAOFactory.createPedidoDAO();
       ArrayList<Pedido> lista = dao.listar();
      
        tvCantidadPedido.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tvCodigoPedido.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tvEnviadoPedido.setCellValueFactory(new PropertyValueFactory<>("enviado"));
        tvFechaPedido.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        tvHoraPedido.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tvNifPedido.setCellValueFactory(new PropertyValueFactory<>("nif"));
        tvNumeroPedido.setCellValueFactory(new PropertyValueFactory<>("numero"));
       
        tablePedido.setItems(FXCollections.observableArrayList(lista));
    }    
    
    @FXML
    void btnAtrasClicado(ActionEvent event) {
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);

    }
       @FXML
    void btnEliminarClicado(ActionEvent event) {
        Pedido p = this.tablePedido.getSelectionModel().getSelectedItem();
        if(p!=null){
            
            tablePedido.getItems().remove(p);
            tablePedido.refresh();
            PedidoDAO dao=DAOFactory.createPedidoDAO(p.getClass());
            dao.delete(p.getCodigo());
        }

    }

}
