package Controlador.FMXLControllers;

import Controlador.BusinessObject.DetailAL;
import Controlador.BusinessObject.LightBill;
import Controlador.BusinessObject.Person;
import Modelo.DetailDTO;
import Modelo.LightbillDTO;
import Modelo.PersonDTO;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LightBillFXMLController implements Initializable {

    private double xOffset = 0, yOffset = 0;

    private LightBill SqlLightBill;

    DecimalFormat FormatD = new DecimalFormat("0.00");

    private LightbillDTO LD;
    private PersonDTO PD;
    private final DetailAL Details = new DetailAL();

    private void Information() {
        codeLightBill.setText(LD.getCodeLightBill());
        fullname.setText(PD.getFullName());
        issueDate.setText(LD.getIssueDate());
        email.setText(PD.getUser().getEmail());
        direction.setText(PD.getDirection());
        identificationDocument.setText(PD.getIdentificationDocument());
//        startDate.setText(LD.getMonth().getStartDate());
        startDate.setText(new SimpleDateFormat("dd/mm/yyyyy").format(Calendar.getInstance().getTime()));
        phoneNumber.setText(PD.getUser().getPhoneNumber());
        endingDate.setText(LD.getMonth().getEndingDate());
    }

    public void setPerson(PersonDTO person) {
        this.PD = person;
    }

    public void setLightBill(int idLightBill) {
        this.LD = new LightBill().buscar(idLightBill);
    }

    private void Coiunts() {
        List<DetailDTO> lista = Details.listFrom(PD.getIdUser());
        if (lista.size() >= 1) {
            name1.setText(lista.get(0).getDeviceName());
            ammount1.setText(String.valueOf(lista.get(0).getAmmount()));
            watts1.setText(lista.get(0).getWattsPower() + " w");
            hours1.setText(lista.get(0).getHours() + " h");
            Calcu1.setText(FormatD.format(lista.get(0).MonthlyCalculation()) + " Kw/h");
        } else {
            name1.setText("");
            ammount1.setText("");
            watts1.setText("");
            hours1.setText("");
            Calcu1.setText("");
        }
        if (lista.size() >= 2) {
            name2.setText(lista.get(1).getDeviceName());
            ammount2.setText(String.valueOf(lista.get(1).getAmmount()));
            watts2.setText(lista.get(1).getWattsPower() + " w");
            hours2.setText(lista.get(1).getHours() + " h");
            Calcu2.setText(FormatD.format(lista.get(1).MonthlyCalculation()) + " Kw/h");
        } else {
            name2.setText("");
            ammount2.setText("");
            watts2.setText("");
            hours2.setText("");
            Calcu2.setText("");
        }
        if (lista.size() >= 3) {
            name3.setText(lista.get(2).getDeviceName());
            ammount3.setText(String.valueOf(lista.get(2).getAmmount()));
            watts3.setText(lista.get(2).getWattsPower() + " w");
            hours3.setText(lista.get(2).getHours() + " h");
            Calcu3.setText(FormatD.format(lista.get(2).MonthlyCalculation()) + " Kw/h");
        } else {
            name3.setText("");
            ammount3.setText("");
            watts3.setText("");
            hours3.setText("");
            Calcu3.setText("");
        }
        if (lista.size() >= 4) {
            name4.setText(lista.get(3).getDeviceName());
            ammount4.setText(String.valueOf(lista.get(3).getAmmount()));
            watts4.setText(lista.get(3).getWattsPower() + " w");
            hours4.setText(lista.get(3).getHours() + " h");
            Calcu4.setText(FormatD.format(lista.get(3).MonthlyCalculation()) + " Kw/h");
        } else {
            name4.setText("");
            ammount4.setText("");
            watts4.setText("");
            hours4.setText("");
            Calcu4.setText("");
        }
        if (lista.size() >= 5) {
            name5.setText(lista.get(4).getDeviceName());
            ammount5.setText(String.valueOf(lista.get(4).getAmmount()));
            watts5.setText(lista.get(4).getWattsPower() + " w");
            hours5.setText(lista.get(4).getHours() + " h");
            Calcu5.setText(FormatD.format(lista.get(4).MonthlyCalculation()) + " Kw/h");
        } else {
            name5.setText("");
            ammount5.setText("");
            watts5.setText("");
            hours5.setText("");
            Calcu5.setText("");
        }
        if (lista.size() >= 6) {
            name6.setText(lista.get(5).getDeviceName());
            ammount6.setText(String.valueOf(lista.get(5).getAmmount()));
            watts6.setText(lista.get(5).getWattsPower() + " w");
            hours6.setText(lista.get(5).getHours() + " h");
            Calcu6.setText(FormatD.format(lista.get(5).MonthlyCalculation()) + " Kw/h");
        } else {
            name6.setText("");
            ammount6.setText("");
            watts6.setText("");
            hours6.setText("");
            Calcu6.setText("");
        }
        if (lista.size() >= 7) {
            name7.setText(lista.get(6).getDeviceName());
            ammount7.setText(String.valueOf(lista.get(6).getAmmount()));
            watts7.setText(lista.get(6).getWattsPower() + " w");
            hours7.setText(lista.get(6).getHours() + " h");
            Calcu7.setText(FormatD.format(lista.get(6).MonthlyCalculation()) + " Kw/h");
        } else {
            name7.setText("");
            ammount7.setText("");
            watts7.setText("");
            hours7.setText("");
            Calcu7.setText("");
        }
        if (lista.size() >= 8) {
            name8.setText(lista.get(7).getDeviceName());
            ammount8.setText(String.valueOf(lista.get(7).getAmmount()));
            watts8.setText(lista.get(7).getWattsPower() + " w");
            hours8.setText(lista.get(7).getHours() + " h");
            Calcu8.setText(FormatD.format(lista.get(7).MonthlyCalculation()) + " Kw/h");
        } else {
            name8.setText("");
            ammount8.setText("");
            watts8.setText("");
            hours8.setText("");
            Calcu8.setText("");
        }
    }

    private void Totals() {
        hoursTotal.setText(String.valueOf(Details.getTotalHours()));
        ammountTotal.setText(String.valueOf(Details.getTotalAmmount()));
        wattsHours.setText(String.valueOf(Details.getTotalWattsPower()));
        CalcuTotal.setText(FormatD.format(Details.getCalculoTotal())+ " Kw/h");
        igv.setText("S/. " + FormatD.format(Details.getCalculoTotal()*0.55 * 0.18));
        TotalTotal.setText("S/. " + FormatD.format(Details.getCalculoTotal()*0.55 * 1.18));
        money.setText("S/. " + FormatD.format(Details.getCalculoTotal()*0.55));
    }

    @FXML
    private Label codeLightBill, fullname, issueDate, email, direction, identificationDocument, startDate, phoneNumber, endingDate,
            name1, ammount1, name2, ammount2, name3, ammount3, name4, ammount4, name5, ammount5, name6, ammount6, name7, ammount7,
            name8, ammount8, wattsHours, hours1, hours2, hours3, hours4, hours5, hours6, hours7, hours8, watts1, watts2, watts3,
            watts4, watts5, watts6, watts7, watts8, hoursTotal, ammountTotal, igv, TotalTotal, money, Calcu1, Calcu2, Calcu3, Calcu4,
            Calcu5, Calcu6, Calcu7, Calcu8, CalcuTotal;

    @FXML
    void OnClickExit(ActionEvent event) {
        codeLightBill.getScene().getWindow().hide();
    }

    @FXML
    void PDFprint(ActionEvent event) {
        //Aqui se imprimira
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void MovementVoid(Parent root, Stage stage) {
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    void recibe(PrincipalInterfaceFXMLController PrincipalInterface, int idPerson, int idLightBill) throws ParseException {
//        LightbillDTO a = SqlLightBill.buscar(idLightBill);
//        if(a!=null){

//        }else{
//            String startDate1 = new Month().buscar(a.getIdMonth()).getStartDate();
//            new Month().agregar(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance()));
//            SqlLightBill.agregar("LTO132", new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance()) , 0, idPerson);
        PD = new Person().buscar(idPerson);
        LD = new LightbillDTO(0, "LTO132", new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()), 0, idPerson);
        Information();
        Coiunts();
        Totals();
        endingDate.setText("15/08/2021");
//        }
    }
}
