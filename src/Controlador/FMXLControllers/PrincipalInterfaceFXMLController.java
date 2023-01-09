/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.FMXLControllers;

import Controlador.BusinessObject.Appliances;
import Controlador.BusinessObject.Category;
import Controlador.BusinessObject.DetailAL;
import Modelo.AppliancesDTO;
import Modelo.DetailDTO;
import Modelo.PersonDTO;
import static Vista.MainLightConsume.stage;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrincipalInterfaceFXMLController implements Initializable {

    PrincipalInterfaceFXMLController PrincipalInterface;

    Category CategoryList = new Category();
    Appliances AppliancedList = new Appliances();
    public static PersonDTO StaticPerson;
    DetailAL Business = new DetailAL();

    ObservableList<DetailDTO> DetailsModel;

    @FXML
    private JFXSlider SldNHours, SldNDevices;

    @FXML
    private JFXTextField txtWatts;
    
    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtLastName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtPasswordConfirm;

    @FXML
    private JFXTextField txtDirection;

    @FXML
    private JFXTextField txtNumber;
    
    @FXML
    private JFXTextField txtIdentificationDocument;
    
    @FXML
    private JFXToggleButton OnTopSwitch;
    
    @FXML
    void OnClickInterface(ActionEvent event) {
        if(OnTopSwitch.isSelected()){
            stage.setAlwaysOnTop(true);
        } else {
            stage.setAlwaysOnTop(false);
        }
    }
    
    void ChargeUser(){
        txtName.setText(StaticPerson.getName());
        txtLastName.setText(StaticPerson.getLastName());
        txtEmail.setText(StaticPerson.getUser().getEmail());
        txtDirection.setText(StaticPerson.getDirection());
        txtNumber.setText(StaticPerson.getUser().getPhoneNumber());
        txtIdentificationDocument.setText(StaticPerson.getIdentificationDocument());
    }
    
    @FXML
    void OnClickDefault(ActionEvent event) {
        ChargeUser();
        setUserValues();
    }
    
    @FXML
    void OnClickUserUpdate(ActionEvent event) {
        ChargeUser();
        setUserValues();
    }

    @FXML
    private Label txtConsume, lblDescription, lblUserName, lblEmail, lblPhoneNumber, lblRecount;

    @FXML
    private AnchorPane TopBar, PaneHome, PaneCalculator, PaneReport, PaneSettings;

    @FXML
    private JFXComboBox<String> cbxCategory, cbxApplianced;

    @FXML
    private TableView<DetailDTO> tableElectrodomestic;

    @FXML
    private TableColumn CategoryCL, DeviceCL, HourCl, AmountCL, WattsCL;

    @FXML
    void OnClickDevices(MouseEvent event) {
        Calculate();
    }

    @FXML
    void OnClickHours(MouseEvent event) {
        Calculate();
    }

    @FXML
    void OnPerformedWatts(KeyEvent event) {
        Calculate();
    }

    @FXML
    void OnClickPerformancedCalculateCbx(ActionEvent event) { //Al elegir un electrodomestico
        txtWatts.setText(String.valueOf(getAppliance().getWattsPower()));
        Calculate();
    }

    private void Calculate() { //Calcula los Watts
        try {
            int Hours = (int) SldNHours.getValue();
            int Devices = (int) SldNDevices.getValue();
            float Watts = Float.parseFloat(txtWatts.getText());
            DetailDTO Apli = new DetailDTO(Watts, Devices, Hours);
            txtConsume.setText("Consume: " + Apli.DailyCalculation());

        } catch (NumberFormatException e) {
            txtConsume.setText("Consume: Choose elements");
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" Bar Functions">
    @FXML
    void OnClickExit(ActionEvent event) { // Botón para salir :D
        System.exit(0);
    }

    @FXML
    void OnClickBarCalculatorButton(ActionEvent event) {
        DisableVisibility(PaneCalculator);
    }

    @FXML
    void OnClickBarConsumptionButton(ActionEvent event) {
        DisableVisibility(PaneReport);
    }

    @FXML
    void OnClickBarHomeButton(ActionEvent event) {
        DisableVisibility(PaneHome);
    }

    @FXML
    void OnClickBarSettingsButton(ActionEvent event) {
        DisableVisibility(PaneSettings);
    }

    private void DisableVisibility(AnchorPane Pane) { //Funcionalidad de los botones de barra
        if (Pane.isVisible()) {
            Pane.setVisible(false);
        } else {
            PaneCalculator.setVisible(false);
            PaneReport.setVisible(false);
            PaneSettings.setVisible(false);
            PaneHome.setVisible(false);
            Pane.setVisible(true);
        }
    }// </editor-fold> 

    @FXML
    void AddApplianced(ActionEvent event) {
        lblDescription.setText(Business.agregar(getDetail().getWattsPower(),
                        getDetail().getAmmount(),
                        getDetail().getHours(),
                        getDetail().getIdAppliances(),
                        getDetail().getIdUser())
        );
        if(!"¡Error to add!".equals(lblDescription.getText())){
            lblDescription.setTextFill(Paint.valueOf("#097E13"));
        } else{
            lblDescription.setTextFill(Paint.valueOf("#E81123"));
        }
        DetailsModel.add(getDetail());
        ListToTable();
        Clean();
    }

    @FXML
    void DeleteApplianced(ActionEvent event) {
        lblDescription.setText(Business.eliminar(getRowSelected()));
        if(!"¡Error to delete!".equals(lblDescription.getText())){
            lblDescription.setTextFill(Paint.valueOf("#097E13"));
        } else{
            lblDescription.setTextFill(Paint.valueOf("#E81123"));
        }
        ListToTable();
    }

    @FXML
    void ListApplianced(ActionEvent event) {
        ListToTable();
        lblDescription.setText("Updated list!");
        lblDescription.setTextFill(Paint.valueOf("#000000"));
    }
    
    @FXML
    private Button Edit;
    
    @FXML
    void EditApplianced(ActionEvent event) {
        lblDescription.setText("Not yet supported! :(");
        lblDescription.setTextFill(Paint.valueOf("#E81123"));
    }

    @FXML
    void OnClickClean(ActionEvent event) {
        Clean();
    }

    @FXML
    void GenerateReport(ActionEvent event) throws IOException, ParseException {
        if (DetailsModel.isEmpty()) {
            lblDescription.setText("Debes agregar productos primero");
            lblDescription.setTextFill(Paint.valueOf("#E81123"));
        } else {
            lblDescription.setTextFill(Paint.valueOf("#097E13"));
            lblDescription.setText("Reporte Generado");

            Stage LightBillStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane) loader.load(getClass().getResource("/Vista/FXMLs/FXMLLightBill.fxml").openStream());
            LightBillFXMLController LightBillController = (LightBillFXMLController) loader.getController();
            Scene stag = new Scene(root);
            LightBillStage.setScene(stag);
            LightBillStage.setAlwaysOnTop(true);
            LightBillStage.initStyle(StageStyle.TRANSPARENT);
            LightBillStage.show();
            LightBillController.recibe(PrincipalInterface, StaticPerson.getIdPerson(), 0);
        }
    }

    @FXML
    void OnClickChargeApplianced(MouseEvent event) { //Carga los electrodomesticos.
        try {
            String Categoria = cbxCategory.getValue();
            if (!cbxCategory.validate()) {
            } else {
                cbxApplianced.getItems().clear();
                AppliancedList.listar(CategoryList.buscar(Categoria).getIdCategory()).forEach((Applianced) -> {
                    cbxApplianced.getItems().add(Applianced.toString());
                });
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());
        }
    }

    @FXML
    void OnClickChargeCategory(MouseEvent event) { //Carga las categorias
        cbxCategory.getItems().clear();
        cbxApplianced.getItems().clear();
        CategoryList.listar().forEach((Category) -> {
            cbxCategory.getItems().add(Category.toString());
        });
    }

    void ListToTable() {
        DetailsModel.clear();
        Business.listFrom(StaticPerson.getIdUser()).stream().forEach((a) -> {
            DetailsModel.add(a);
        });
        lblRecount.setText("Ammount: " + Business.getTotalAmmount()
                + " - Hours: " + Business.getTotalHours()
                + " - Watts: " + Business.getTotalWattsPower()
                + " - Monthly: " + Business.getCalculoTotal());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { //Iniciador
        PrincipalInterface = this;
        RequiredFieldValidator requiredValidator = new RequiredFieldValidator("Choose a Category");
        cbxCategory.getValidators().add(requiredValidator);
        stage.setAlwaysOnTop(true);
        initializeTableElectrodomestic();
        ListToTable();
        setUserValues();
        ChargeUser();
    }

    public DetailDTO getRowSelected() {
        if (tableElectrodomestic != null) {
            List<DetailDTO> tabla = tableElectrodomestic.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final DetailDTO competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void initializeTableElectrodomestic() {
        CategoryCL.setCellValueFactory(new PropertyValueFactory<>("CategoryName"));
        DeviceCL.setCellValueFactory(new PropertyValueFactory<>("DeviceName"));
        HourCl.setCellValueFactory(new PropertyValueFactory<>("Hours"));
        AmountCL.setCellValueFactory(new PropertyValueFactory<>("ammount"));
        WattsCL.setCellValueFactory(new PropertyValueFactory<>("wattsPower"));
        DetailsModel = FXCollections.observableArrayList();
        tableElectrodomestic.setItems(DetailsModel);
        final ObservableList<DetailDTO> tablaPersonaSel = tableElectrodomestic.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersona);
        
    }

    @FXML
    private Button Delete;

    private final ListChangeListener<DetailDTO> selectorTablaPersona = (ListChangeListener.Change<? extends DetailDTO> c) -> {
        final DetailDTO Device = getRowSelected();
        if (Device != null) {
            lblDescription.setText(Device.getDeviceName() != null
                    ? "Selected appliance: " + Device.getDeviceName() : "UnSelected appliance.");
            lblDescription.setTextFill(Paint.valueOf("#000000"));
            Delete.setVisible(true);
            Edit.setVisible(true);
        } else {
            Delete.setVisible(false);
            Edit.setVisible(false);
        }
    };

    private AppliancesDTO getAppliance() {
        return AppliancedList.buscar(cbxApplianced.getValue());
    }

    private DetailDTO getDetail() {
        int Hours = (int) SldNHours.getValue();
        int Devices = (int) SldNDevices.getValue();
        float Watts = Float.parseFloat(txtWatts.getText());
        return new DetailDTO(Watts, Devices, Hours, getAppliance().getIdApliances(), StaticPerson.getIdUser());
    }

    private void setUserValues() {
        lblUserName.setText("Name: " + StaticPerson.getName());
        lblEmail.setText("Email: " + StaticPerson.getUser().getEmail());
        lblPhoneNumber.setText("PhoneNumber: " + StaticPerson.getUser().getPhoneNumber());
    }

    private void Clean() {
        cbxCategory.getItems().clear();
        cbxApplianced.getItems().clear();
        SldNHours.setValue(1);
        SldNDevices.setValue(1);
        txtWatts.setText("");
        cbxCategory.requestFocus();
    }

    @FXML
    void MouseLeftTop(MouseEvent event) {
        if (PaneSettings.isVisible() || PaneHome.isVisible() || PaneCalculator.isVisible() || PaneReport.isVisible()) {
            TopBar.setOpacity(1);
        } else {
            TopBar.setOpacity(0.5);
        }
    }

    @FXML
    void MouseEnterTop(MouseEvent event) {
        TopBar.setOpacity(1);
    }

}
