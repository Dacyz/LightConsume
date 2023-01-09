package Controlador.FMXLControllers;

import Controlador.BusinessObject.User;
import Modelo.UserDTO;
import Vista.MainLightConsume;
import static Vista.MainLightConsume.setStage;
import static Vista.MainLightConsume.stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLInterfaceController implements Initializable {

    User User = new User();

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPass;

    @FXML
    void OnClickGoToRegister(ActionEvent event) throws IOException {
        setStage(getClass().getResource("/Vista/FXMLs/FXMLRegisterUser.fxml"));
    }

    @FXML
    void OnClickGoToLostPassword(ActionEvent event) throws IOException {
        setStage(getClass().getResource("/Vista/FXMLs/FXMLLostPasswordUser.fxml"));
    }

    @FXML
    void OnClickExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void OnClickLogin(ActionEvent event) throws IOException {
        if(!Corroborante(txtEmail.getText().trim(), txtPass.getText())){
            JOptionPane.showConfirmDialog(null, "incorret password"); 
        }
    }
    
    private boolean Corroborante(String Email, String Password) throws IOException{
        for (UserDTO usuario : User.listar()) {
            if (usuario.getEmail().equalsIgnoreCase(Email)
                    && usuario.getPassword().equals(Password)) {
                PrincipalInterfaceFXMLController.StaticPerson = usuario.getPerson();
                Parent ParentRoot = FXMLLoader.load(getClass().getResource("/Vista/FXMLs/PrincipalInterfaceFXML.fxml"));
                Scene scene =new Scene(ParentRoot);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.setScene(scene);
                MainLightConsume.MovementVoid(ParentRoot, stage);
                return true;
            }
        }return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
