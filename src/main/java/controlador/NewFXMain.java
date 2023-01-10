package controlador;



import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class NewFXMain extends Application {
    
    public static final int ESCENA_PRINCIPAL=0;
    public static final int ESCENA_NUEVO_CLIENTE=1;
    public static final int ESCENA_MOSTAR_CLIENTE=2;
    public static final int ESCENA_NUEVO_ARTICULO=3;
    public static final int ESCENA_MOSTAR_ARTICULO=4;
    public static final int ESCENA_NUEVO_PEDIDO=5;
    public static final int ESCENA_MOSTAR_PEDIDO=6;
    public static final int ESCENA_SALIR=7;
    
    private static Stage primaryStage;
    private static NewFXMain main;
    
    @Override
    public void start(Stage primaryStage) {
        NewFXMain.primaryStage=primaryStage;
        main=this;
        mostrarEscena(ESCENA_PRINCIPAL);
    }
    
    public static void mostrarEscena(int escena){
        switch(escena){
            case ESCENA_PRINCIPAL -> setEscena("/vista/FXML.fxml");
            case ESCENA_NUEVO_CLIENTE -> setEscena("/vista/FXMLAnyadirCliente.fxml");
            case ESCENA_MOSTAR_CLIENTE -> setEscena("/vista/FXMLMostrarCliente.fxml");
            case ESCENA_NUEVO_ARTICULO -> setEscena("/vista/FXMLAnyadirArticulo.fxml");
            case ESCENA_MOSTAR_ARTICULO -> setEscena("/vista/FXMLMostrarArticulo.fxml");
            case ESCENA_NUEVO_PEDIDO -> setEscena("/vista/FXMLAnyadirPedido.fxml");
            case ESCENA_MOSTAR_PEDIDO -> setEscena("/vista/FXMLMostrarPedido.fxml");
            case ESCENA_SALIR -> setEscena("/vista/FXML.fxml");
        }
    }
    
    private static void setEscena(String escena){
        try{
            Parent root = FXMLLoader.load(main.getClass().getResource(escena));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Online Store");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
