package Controlador.FMXLControllers;

import static Vista.MainLightConsume.setStage;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LostPasswordFXMLController implements Initializable {

    @FXML
    private AnchorPane VariablePane;

    @FXML
    private FontAwesomeIconView lblICON;

    @FXML
    private Button button;

    @FXML
    private Text lblWriteToYou;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private Hyperlink HPChangeMethod;

    @FXML
    void OnClickChangeMethod(ActionEvent event) {
        if ("Use Phone Number".equals(HPChangeMethod.getText())) {
            changeVoid("Phone Number", "PHONE", "Write your phone number", "Use E-mail");
        } else {
            changeVoid("E-mail", "ENVELOPE", "Write your E-mail", "Use Phone Number");
        }
    }

    private void changeVoid(String a, String b, String c, String d) {
        txtEmail.setPromptText(a);
        lblICON.setGlyphName(b);
        lblWriteToYou.setText(c);
        HPChangeMethod.setText(d);
    }

    @FXML
    void OnClickBackToLogin(ActionEvent event) throws IOException {
        setStage(getClass().getResource("/Vista/FXMLs/FXMLLoginUser.fxml"));
    }

    @FXML
    void OnClickSendCode(ActionEvent event) throws IOException {
        txtEmail.getValidators().clear();
        if ("Use Phone Number".equals(HPChangeMethod.getText())) {
            RegexValidator regexValidator = new RegexValidator("Write in this format: Example@mail.dot");
            regexValidator.setRegexPattern("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            txtEmail.setValidators(regexValidator);
        } else if("Use E-mail".equals(HPChangeMethod.getText())) {
            RegexValidator numberValidator = new RegexValidator("Write in this format: #########");
            numberValidator.setRegexPattern("^[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]");
            txtEmail.setValidators(numberValidator);
        }
        if(txtEmail.validate()) ChargeSendCode();
    }

    private void ChargeSendCode() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/FXMLs/FXMLCodeSendUser.fxml"));
            Scene scene = button.getScene();
            root.translateXProperty().set(scene.getWidth());

            BorderPane parentContainer = (BorderPane) scene.getRoot();

            parentContainer.setCenter(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.2), kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(t -> {
                parentContainer.getChildren().remove(VariablePane);
            });
            timeline.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
