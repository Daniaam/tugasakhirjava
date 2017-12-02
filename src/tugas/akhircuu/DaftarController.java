package tugas.akhircuu;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class DaftarController {

    @FXML
    private JFXButton btnDaftar;

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField telp;
   

    @FXML
    private TextField nama;
   
    
    @FXML
    void btnDaftar(ActionEvent event) {
   Connection connection = null ;
    PreparedStatement ps;
          try{ 
            connection =DriverManager.getConnection("jdbc:mysql://localhost/pbo?zeroDate TimeBehavior=convertToNull", "root", "");
            String sql = "INSERT INTO daftar(nama,telp,username,password) VALUES (?,?,?,?)";
            ps= connection.prepareStatement(sql);
            ps.setString(1,nama.getText());
            ps.setString(2,telp.getText());
            ps.setString(3,user.getText());
            ps.setString(4,pass.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
          
    }
     
     public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
  @FXML
    void btnLogin(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("login.fxml"));
        Scene scene =new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
