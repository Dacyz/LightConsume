package Modelo;
import java.util.Date;

public class MonthDTO {

    private int idMonth;
    private String endingDate;
    private String startDate;

    public MonthDTO(int idMonth, String endingDate, String startDate) {
        this.idMonth = idMonth;
        this.endingDate = endingDate;
        this.startDate = startDate;
    }
    
    public MonthDTO( String endingDate, String startDate) {
        this.endingDate = endingDate;
        this.startDate = startDate;
    }

    public MonthDTO(int idMonth) {
        this.idMonth = idMonth;
    }

    public MonthDTO() {
        
    }

    private String convertMonth(int Month){
        switch (Month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "None Month";
        }
    }



// <editor-fold defaultstate="collapsed" desc="Getter and Setter code">

    public int getIdMonth() {
        return idMonth;
    }

    public void setIdMonth(int idMonth) {
        this.idMonth = idMonth;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    // </editor-fold> 

}
