package Controlador.FMXLControllers;

import Controlador.Connections.PersonDAO;
import Controlador.Connections.UserDAO;
import Modelo.PersonDTO;
import Modelo.UserDTO;
import static Vista.MainLightConsume.setStage;
import static Vista.MainLightConsume.setStageT;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class RegisterUserFXMLController implements Initializable {

    PersonDTO Person = new PersonDTO();
    PersonDAO PersonDAO = new PersonDAO();
    UserDTO user = new UserDTO();
    UserDAO UserDAO = new UserDAO();

    @FXML
    private Button btnExit;

    @FXML
    private AnchorPane RegisterUser;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtPasswordConfirmation;

    @FXML
    private JFXTextField txtphoneNumber;

    @FXML
    private AnchorPane RegisterPerson;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtUserLastName;

    @FXML
    private JFXTextField txtDirection;

    @FXML
    private JFXTextField txtIdentificatorDocument;

    @FXML
    private JFXComboBox<String> cbxSex;

    @FXML
    private JFXDatePicker txtBirthDate;

    @FXML
    private Button NextToRegister;

    @FXML
    void OnClickBack(ActionEvent event) throws IOException {
        setStage(getClass().getResource("/Vista/FXMLs/FXMLLoginUser.fxml"));
    }

    @FXML
    void OnClickNextToRegister(ActionEvent event) throws IOException {
        if ("Next".equals(NextToRegister.getText())) { //Boton conexión :v
            Person = new PersonDTO();
            user = new UserDTO();
            if (txtEmail.validate()
                    && txtPassword.validate()
                    && txtPasswordConfirmation.validate()
                    && Passwords()) {
                user = new UserDTO(
                        txtEmail.getText(),
                        txtPassword.getText(),
                        "".equals(txtphoneNumber.getText())
                        ? "Unspecified" : txtphoneNumber.getText().trim(),
                        new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),
                        1);
                RegisterUser.setVisible(false);
                RegisterPerson.setVisible(true);
                NextToRegister.setText("Register");
            } else {
                JOptionPane.showMessageDialog(null, "Completa correctamente todos los campos");
            }
        } else {
            if (txtUserName.validate()
                    && txtUserLastName.validate()
                    && txtBirthDate.validate()
                    && cbxSex.validate()
                    && txtIdentificatorDocument.validate()) {

                Person = new PersonDTO(
                        "Male".equals(cbxSex.getValue()) ? 'M' : 'F',
                        txtUserName.getText().trim(),
                        txtUserLastName.getText().trim(),
                        txtIdentificatorDocument.getText().trim(),
                        "".equals(txtDirection.getText().trim())
                        ? "Unspecified" : txtDirection.getText().trim(),
                        txtBirthDate.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE));
                UserDAO.agregar(user);
                Person.setIdUser(UserDAO.buscar(user).getIdUser());
                PersonDAO.agregar(Person);
                PrincipalInterfaceFXMLController.StaticPerson = Person.getUser().getPerson();
                setStageT(getClass().getResource("/Vista/FXMLs/PrincipalInterfaceFXML.fxml"));
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxSex.getItems().addAll(
                "Male",
                "Female");
        RequiredFieldValidator requiredValidator = new RequiredFieldValidator("This field is required");
        RegexValidator numberValidator = new RegexValidator("This field required format: 99999999");
        numberValidator.setRegexPattern("^[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]");
        RegexValidator regexValidator = new RegexValidator("This field required format: Example@exam.com");
        regexValidator.setRegexPattern("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        RegexValidator regexValidator2 = new RegexValidator("YYYY-MM-DD");
        regexValidator2.setRegexPattern("^\\d{4}-\\d{2}-\\d{2}$");
        setValidations(txtUserName, requiredValidator);
        setValidations(txtUserLastName, requiredValidator);
        setValidations(txtBirthDate, requiredValidator);
        setValidations(txtPassword, requiredValidator);
        setValidations(txtIdentificatorDocument, requiredValidator);
        setValidations(txtEmail, requiredValidator);
        setValidations(cbxSex, requiredValidator);
        setValidations(txtPasswordConfirmation, requiredValidator);
        txtBirthDate.getValidators().add(regexValidator2);
        txtIdentificatorDocument.getValidators().add(numberValidator);
        txtEmail.getValidators().add(regexValidator);
    }

    private boolean Passwords() {
        if (txtPassword.getText() == null ? txtPasswordConfirmation.getText() == null
                : !txtPassword.getText().equals(txtPasswordConfirmation.getText())) {
            JOptionPane.showMessageDialog(null, "Passwords are'nt the same");
            return false;
        }
        return true;
    }

    public void setValidations(JFXTextField a, RequiredFieldValidator requiredValidator) {
        a.getValidators().add(requiredValidator);
        a.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                a.validate();
            }
        }));
    }

    public void setValidations(JFXPasswordField a, RequiredFieldValidator requiredValidator) {
        a.getValidators().add(requiredValidator);
        a.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                a.validate();
            }
        }));
    }

    private void setValidations(JFXDatePicker a, RequiredFieldValidator requiredValidator) {
        a.getValidators().add(requiredValidator);
        a.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                a.validate();
            }
        }));
    }

    private void setValidations(JFXComboBox<String> a, RequiredFieldValidator requiredValidator) {
        a.getValidators().add(requiredValidator);
        a.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) {
                a.validate();
            }
        }));
    }
}
