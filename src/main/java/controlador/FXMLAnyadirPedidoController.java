package controlador;


import modelo.DAOFactory;
import modelo.Pedido;
import modelo.PedidoDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class FXMLAnyadirPedidoController implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField tfCantidadPedido;

    @FXML
    private TextField tfCodigoArticuloPedido;

    @FXML
    private TextField tfEnviado;

    @FXML
    private TextField tfFechaPedido;

    @FXML
    private TextField tfHoraPedido;

    @FXML
    private TextField tfNifClientePedido;

    @FXML
    private TextField tfNumeroPedido;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void btnACeptarClicado(ActionEvent event) {
        
        String sNumero=tfNumeroPedido.getText().trim();
        int numero=Integer.parseInt(sNumero);
        String sCantidad=tfCantidadPedido.getText().trim();
        int cantidad=Integer.parseInt(sCantidad);
        String nif=tfNifClientePedido.getText().trim();
        String sCodigo=tfCodigoArticuloPedido.getText().trim();
        int codigo=Integer.parseInt(sCodigo);
        String sFechaPedido=tfFechaPedido.getText().trim();
        LocalDate fechaPedido=LocalDate.parse(sFechaPedido);
        String sHoraPedido=tfHoraPedido.getText().trim();
        LocalTime hora=LocalTime.parse(sHoraPedido);
        String sEnviado=tfEnviado.getText().trim();
        Boolean enviado=Boolean.valueOf(sEnviado);
        
        Pedido c=null;
        c=new Pedido(numero, cantidad, nif, codigo, fechaPedido,hora, enviado);
        
        PedidoDAO dao=DAOFactory.createPedidoDAO(c.getClass());
        dao.create(c);
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Pedido creado");
        a.show();
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }

    @FXML
    void btnCancelarclicado(ActionEvent event) {
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }

}
