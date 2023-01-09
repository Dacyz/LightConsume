package Controlador.FMXLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Vista.MainLightConsume.setStage;

public class CodeSendUserFXMLController implements Initializable {

    @FXML
    private JFXTextField c1;

    @FXML
    private JFXTextField c2;

    @FXML
    private JFXTextField c3;

    @FXML
    private JFXTextField c4;

    @FXML
    private JFXTextField c5;

    @FXML
    void OnClickBackToLogin(ActionEvent event) throws IOException {
        setStage(getClass().getResource("/Vista/FXMLs/FXMLLoginUser.fxml"));
    }
    
    @FXML
    void OnClickSendCode(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
