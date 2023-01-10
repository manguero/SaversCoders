package controlador;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class FXMLController implements Initializable {

    @FXML
    private Button btnAnyadirCliente;
    
    @FXML
    private Button btnMostrarClientes;
    
    @FXML
    private Button btnMostrarArticulo;
      
    @FXML
    private Button btnAnyadirArticulo;
    
    @FXML
    private Button btnAnyadirPedido;
         
    @FXML
    private Button btnMostrarPedido;
    
    @FXML
    private Button btnSalir;
    
    
          
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void btnAnyadirClienteClicado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_NUEVO_CLIENTE);
    }
   

    @FXML
    public void btnMostrarClientesClicado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_MOSTAR_CLIENTE);
    }
    
    @FXML
    public void btnAnyadirArticuloClicado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_NUEVO_ARTICULO);
    }
    
    @FXML
    public void btnMostrarArticuloClicado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_MOSTAR_ARTICULO);
    }  
   
   
    @FXML
    public void btnAnyadirPedidoClicado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_NUEVO_PEDIDO);
    }
   
    @FXML
    public void btnMostrarPedidoCliclado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_MOSTAR_PEDIDO);
    }
    
     @FXML
    public void btnSalirCliclado(ActionEvent evt){
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
        
    } 
}