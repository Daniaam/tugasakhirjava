package tugas.akhircuu;

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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class KacamataController {

    @FXML
    private RadioButton petama;

    @FXML
    private RadioButton kedua;

    @FXML
    private RadioButton ketiga;

    @FXML
    private RadioButton keempat;

    @FXML
    private RadioButton kelima;

    @FXML
    private RadioButton keenam;

    @FXML
    private Button simpan;
    public String pilihan1;

    @FXML
    void kedua(ActionEvent event) {

    }

    @FXML
    void keempat(ActionEvent event) {

    }

    @FXML
    void keenam(ActionEvent event) {

    }

    @FXML
    void kelima(ActionEvent event) {

    }

    @FXML
    void ketiga(ActionEvent event) {

    }

    @FXML
    void pertama(ActionEvent event) {

    }

    @FXML
    void simpan(ActionEvent event) throws IOException {
        
        int harga;
        Connection connection = null ;
        PreparedStatement ps;
        if(petama.isSelected()){
            pilihan1 = "petama";
            
        }else if(kedua.isSelected()){
            pilihan1 = "kedua";
        }
        else if(ketiga.isSelected()){
            pilihan1 = "ketiga";
        }
        else if(keempat.isSelected()){
            pilihan1 = "keempat";
        }
        else if(kelima.isSelected()){
            pilihan1 = "kelima";
        }
        else if(keenam.isSelected()){
            pilihan1 = "keenam";
        }
        
        
        try{ 
            connection =DriverManager.getConnection
        ("jdbc:mysql://localhost/pbo?zeroDate TimeBehavior=convertToNull", "root", "");
            String sql = "INSERT INTO kacamata(pilihan , total_harga, lensa) VALUES (?,?,?) ";
            ps= connection.prepareStatement(sql);
            ps.setString(1, pilihan1);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            int i = ps.executeUpdate();
            if (i == 1){
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("lensa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("OptikCrime");
            stage.show();
            }else{
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Gagal");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }


