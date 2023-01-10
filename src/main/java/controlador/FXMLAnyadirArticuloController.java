package controlador;


import modelo.Articulo;
import modelo.ArticuloDAO;
import modelo.DAOFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLAnyadirArticuloController implements Initializable {

    
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnArticuloCancelar;

    @FXML
    private TextField tfCodigoArticulo;

    @FXML
    private TextField tfDescripcionArticulo;

    @FXML
    private TextField tfGastosEnvioArticulo;

    @FXML
    private TextField tfPrecioVentaArticulo;

    @FXML
    private TextField tfTiempoEnvioArticulo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    void btnAceptarArticuloClicado(ActionEvent event) {
        
        String sCodigo=tfCodigoArticulo.getText().trim(); //.trim elimina espacios vacios
        int codigo=Integer.parseInt(sCodigo);
        String descripcion=tfDescripcionArticulo.getText().trim();
        String sGastosEnvio=tfGastosEnvioArticulo.getText().trim();
        double gastosEnvio=Double.parseDouble(sGastosEnvio);
        String sPrecioVenta=tfPrecioVentaArticulo.getText().trim();
        double precioVenta=Double.parseDouble(sPrecioVenta);
        String sTiempoEnvio=tfTiempoEnvioArticulo.getText().trim();
        LocalDate tiempoEnvio=LocalDate.parse(sTiempoEnvio);
        
        Articulo c=null;
        c=new Articulo(codigo, descripcion, precioVenta, gastosEnvio,tiempoEnvio);     

       
        ArticuloDAO dao=DAOFactory.createArticuloDAO(c.getClass());
        dao.create(c);
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Articulo creado");
        a.show();
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }

    @FXML
    void btnCancelarClicado(ActionEvent event) {
        NewFXMain.mostrarEscena(NewFXMain.ESCENA_PRINCIPAL);
    }
    
}
