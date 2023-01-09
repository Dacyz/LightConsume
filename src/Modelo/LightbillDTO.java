package Modelo;

import Controlador.BusinessObject.Month;
import Controlador.BusinessObject.Person;

public class LightbillDTO {

    private int idLightBill;
    private String codeLightBill;
    private String issueDate;
    private int idMonth;
    private int idPerson;

    public LightbillDTO(int idLightBill, String codeLightBill, String issueDate, int idMonth, int idPerson) {
        this.idLightBill = idLightBill;
        this.codeLightBill = codeLightBill;
        this.issueDate = issueDate;
        this.idMonth = idMonth;
        this.idPerson = idPerson;
    }

    public LightbillDTO(String codeLightBill, String issueDate, int idMonth, int idPerson) {
        this.codeLightBill = codeLightBill;
        this.issueDate = issueDate;
        this.idMonth = idMonth;
        this.idPerson = idPerson;
    }
    
    public PersonDTO getPerson(){
        return new Person().buscar(idPerson);
    }
    
    public MonthDTO getMonth(){
        return new Month().buscar(idMonth);
    }

    public LightbillDTO() {
        
    }

    public LightbillDTO(int Id) {
        this.idLightBill = Id;
    }
    
    @Override
    public String toString() {
        return '[' + getCodeLightBill()
                + ", " + getIssueDate()
                + ", " + getIdMonth()
                + ", " + getIdPerson()
                + ']';
    }
    
    public float calculoIgv(float total) {
        return (float) (total * 0.18);
    }

    float calculoTotal() {
        return 0;
    }

    float calculoWatts() {
        return 0;
    }

    float convertMoney() {
        return 0;
    }

    void MostrarRecibo() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter code">  
    public int getIdLightBill() {
        return idLightBill;
    }

    public void setIdLightBill(int idLightBill) {
        this.idLightBill = idLightBill;
    }

    public String getCodeLightBill() {
        return codeLightBill;
    }

    public void setCodeLightBill(String codeLightBill) {
        this.codeLightBill = codeLightBill;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getIdMonth() {
        return idMonth;
    }

    public void setIdMonth(int idMonth) {
        this.idMonth = idMonth;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

}// </editor-fold>  

