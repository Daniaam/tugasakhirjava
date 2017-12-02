package tugas.akhircuu;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LensaController {

    @FXML
    private RadioButton satu;

    @FXML
    private RadioButton dua;

    @FXML
    private RadioButton tiga;

    @FXML
    private RadioButton empat;

    @FXML
    private TextField min;

    @FXML
    private TextArea TA;

    @FXML
    private Button reset;
     @FXML
    private Button btnResult;
      @FXML
    private Button next;
      @FXML
    private Button logout;
         @FXML
    private JFXTextField jenis;

    @FXML
    private JFXTextField piro;

    @FXML
    private JFXTextField bayaren;

    @FXML
    private JFXTextField harga;

    
    String ukuran;
    @FXML
    private ToggleGroup satuu;
    @FXML
    private AnchorPane Result;
       @FXML
    void logout(ActionEvent event) {
 try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("OptikCrime");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
    
    
    @FXML
    void dua(ActionEvent event) {

    }

    @FXML
    void empat(ActionEvent event) {

    }

    @FXML
    void satu(ActionEvent event) {

    }


    @FXML
    void btnResult(ActionEvent event) throws IOException {
        int bayar = 0;
        
        if(satu.isSelected()){
            ukuran = "Standart Lens";
            bayar = 200000 ;
        }else if(dua.isSelected()){
            ukuran = "Omega Lens";
            bayar = 250000 ;
        }
        else if(tiga.isSelected()){
            ukuran = "Essilor Lens";
            bayar = 300000;
        }
        else if(empat.isSelected()){
            ukuran = "UV Lens";
            bayar = 300000;
        }
      
        int kaca = 200000;
        String minus = String.valueOf(min.getText());
     
        String lensa = String.valueOf(ukuran);
       jenis.setText("Jenis Lensa Anda "+ukuran);
       piro.setText("Ukuran Lensa Anda "+minus);
       harga.setText("Harga Lensa Anda "+bayar);
       bayaren.setText("Total Yang harus dibayar "+(kaca+bayar));
       
    }
    
    @FXML
    void reset(ActionEvent event) throws IOException {
        
        satu.setSelected(false);
        dua.setSelected(false);
        tiga.setSelected(false);
        empat.setSelected(false);
        min.setText("");
        jenis.setText("");
        piro.setText("");
        harga.setText("");
        bayaren.setText("");
       
    }
        

    @FXML
    void tiga(ActionEvent event) {

    }

   

}
