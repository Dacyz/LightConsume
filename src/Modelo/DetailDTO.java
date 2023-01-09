package Modelo;

import Controlador.BusinessObject.Appliances;
import Controlador.BusinessObject.User;

public class DetailDTO {
    
    private float wattsPower;
    private int ammount;
    private int Hours;
    private int idAppliances;
    private int idUser;
    
    private String CategoryName;
    private String DeviceName;
    
    private AppliancesDTO Appliance;
    private UserDTO User;

    public DetailDTO() {
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getDeviceName() {
        return DeviceName;
    }
    
//    public DetailDTO(float wattsPower, int ammount, int Hours, int idAppliances,int idUser) {
//        this.wattsPower = wattsPower;
//        this.ammount = ammount;
//        this.Hours = Hours;
//        this.idUser = idUser;
//        this.idAppliances = idAppliances;
//    }

    public DetailDTO(float wattsPower, int ammount, int Hours, int idAppliances, int idUser) {
        this.wattsPower = wattsPower;
        this.ammount = ammount;
        this.Hours = Hours;
        this.idAppliances = idAppliances;
        this.idUser = idUser;
        ChargeValues();
    }
    
    public void ChargeValues(){
        Appliance = new Appliances().buscar(idAppliances);
        User = new User().buscar(idUser);
        CategoryName = Appliance.getCategory() != null ?
                Appliance.getCategory() : "UnCategorized";
        DeviceName = Appliance.getName()!= null ?
                Appliance.getName(): "UnApplianced"; 
    }

    public DetailDTO(float wattsPower, int ammount, int Hours) {
        this.wattsPower = wattsPower;
        this.ammount = ammount;
        this.Hours = Hours;
    }

    public DetailDTO(int idAppliances, int idUser) {
        this.idAppliances = idAppliances;
        this.idUser = idUser;
    }
    
    @Override
    public String toString() {
        return "[" + CategoryName
                + ", " + DeviceName
                + ", " + getHours()
                + ", " + getAmmount()
                + ", " + getWattsPower()
                + ']';
    }

// <editor-fold defaultstate="collapsed" desc="Getter and Setter code"> 
    public int getIdUser(){
        return idUser;
    }
    
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
    
    public int getIdAppliances() {
        return idAppliances;
    }

    public void setIdAppliances(int idAppliances) {
        this.idAppliances = idAppliances;
    }

    public float getWattsPower() {
        return wattsPower;
    }

    public void setWattsPower(float wattsPower) {
        this.wattsPower = wattsPower;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }
// </editor-fold> 
    
    public float DailyCalculation() {
        return (getWattsPower() * getAmmount() * getHours()) / 1000;
    }

    public float MonthlyCalculation() {
        return DailyCalculation()*30;
    }

}
