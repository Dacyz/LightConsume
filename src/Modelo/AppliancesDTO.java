package Modelo;

import Controlador.BusinessObject.Category;

public class AppliancesDTO {

    private int IdApliances;
    String name; // Nombre del electrodomestico
    float wattsPower; // Potencia de Watts
    boolean status; // Activo o Inactivo
    private int IdCategory; // category 

    public AppliancesDTO(int IdApliances, int IdCategory, String nameElectro, float wattsPower, boolean Status) {
        this.IdApliances = IdApliances;
        this.IdCategory = IdCategory;
        this.name = nameElectro;
        this.wattsPower = wattsPower;
        this.status = Status;
    }

    public AppliancesDTO(int IdCategory, String nameElectro, float wattsPower, boolean Status) {
        this.IdCategory = IdCategory;
        this.name = nameElectro;
        this.wattsPower = wattsPower;
        this.status = Status;
    }

    public AppliancesDTO(String nameElectro, float wattsPower, boolean Status) {
        this.name = nameElectro;
        this.wattsPower = wattsPower;
        this.status = Status;
    }

    public AppliancesDTO() {
    }

    public AppliancesDTO(String Email) {
        this.name = Email;
    }
    
    String getCategory(){
        return new Category().buscar(IdCategory).getName();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getter and Setter code">      
    public int getIdApliances() {
        return IdApliances;
    }

    public void setIdApliances(int IdApliances) {
        this.IdApliances = IdApliances;
    }

    public int getIdCategory() {
        return IdCategory;    
    }
    
    public void setIdCategory(int IdCategory) {
        this.IdCategory = IdCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWattsPower() {
        return wattsPower;
    }

    public void setWattsPower(float wattsPower) {
        this.wattsPower = wattsPower;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean Status) {
        this.status = Status;
    }


    
    // </editor-fold> 
    
    
}
