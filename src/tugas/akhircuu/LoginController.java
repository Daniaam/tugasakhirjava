package tugas.akhircuu;

import com.jfoenix.controls.JFXButton;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    void btnLogin(ActionEvent event) {
        Connection connection;
        PreparedStatement st;
        try {
             connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/pbo?zeroDate TimeBehavior=convertToNull", "root", "");
       st = connection.prepareStatement("SELECT * FROM `daftar` WHERE `username` = ? AND `password` = ?");
            st.setString(1, user.getText());
            st.setString(2, pass.getText());
            ResultSet result = st.executeQuery();
            if(user.getText().equals("") && pass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Isikan Username atau Password anda");
            }
            else if (result.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("kacamata.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("OptikCrime");
            stage.show(); } 
            else {
                JOptionPane.showMessageDialog(null, "Username atau Password Salah!");
                user.setText("");
                user.requestFocus();
                pass.setText("");
            }
        } catch (SQLException | HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal!");
        }
    }
}
