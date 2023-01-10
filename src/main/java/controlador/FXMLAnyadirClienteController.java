package controlador;



import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.ClientePremium;
import modelo.ClienteStandard;
import modelo.DAOFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLAnyadirClienteController implements Initializable {
    
    private static final int CLIENTE_STANDARD=0;
    private static final int CLIENTE_PREMIUM=1;
    
    @FXML
    private Button btnAceptar;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private TextField tfNombreCliente;
    
    @FXML
    private TextField tfDomicilio;
    
    @FXML
    private TextField tfNif;
        
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfCuota;
    
    @FXML
    private TextField tfDescuentoEnvio;
    
    @FXML
    private ComboBox cmbTipo;
    
    @FXML
    private Label lbCuota;
    
    @FXML
    private Label lbDescuentoEnvio;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbTipo.getItems().addAll(
                "Cliente Standard",
                "Cliente Premium"
        );
        lbCuota.setVisible(false);
        tfCuota.setVisible(false);
        lbDescuentoEnvio.setVisible(false);
        tfDescuentoEnvio.setVisible(false);
    }    
    
    @FXML
    public void btnAceptarClicado(ActionEvent evt){
        String nombre=tfNombreCliente.getText().trim(); //.trim elimina espacios vacios
        String domicilio=tfDomicilio.getText().trim();
        String nif=tfNif.getText().trim();
        String email=tfEmail.getText().trim();
        int tipo=cmbTipo.getSelectionModel().getSelectedIndex();
        
        Cliente c=null;
        if(tipo==CLIENTE_STANDARD){
            c=new ClienteStandard(nombre,domicilio,email,nif);
        }
        else{
            String sCuota=tfCuota.getText().trim();
            int cuota=Integer.parseInt(sCuota);
            String sDescuento=tfDescuentoEnvio.getText().trim();
            double descuento=Double.parseDouble(sDescuento);
            
            c=new ClientePremium(cuota,descuento,nombre,domicilio,email,nif);
        }
        ClienteDAO dao=DAOFactory.createClienteDAO(c.getClass());
        dao.create(c);
        Alert a=new Alert(AlertType.INFORMATION);
        a.setContentText("Cliente creado");
        a.show();
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }
    
    @FXML
    public void btnCancelarClienteClicado(ActionEvent evt){
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }
    
    
    @FXML
    void tipoSeleccionado(ActionEvent event) {
        int s=cmbTipo.getSelectionModel().getSelectedIndex();
        if(s==0){
            lbCuota.setVisible(false);
            tfCuota.setVisible(false);
            lbDescuentoEnvio.setVisible(false);
            tfDescuentoEnvio.setVisible(false);
        }
        else{
            lbCuota.setVisible(true);
            tfCuota.setVisible(true);
            lbDescuentoEnvio.setVisible(true);
            tfDescuentoEnvio.setVisible(true);
        }
    }
}

