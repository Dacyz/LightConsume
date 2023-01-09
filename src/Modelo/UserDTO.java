package Modelo;

import Controlador.BusinessObject.Person;

public class UserDTO {

    private int idUser;
    private String email;
    private String password;
    private String phoneNumber;
    private String registrationDate;
    private int idProfile;

    public UserDTO() {

    }

    public UserDTO(int idUser, String email, String password, String phoneNumber, String registrationDate, int idProfile) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.idProfile = idProfile;
    }

    public UserDTO(String email, String password, String phoneNumber, String registrationDate, int idProfile) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.idProfile = idProfile;
    }

    public UserDTO(int idUser) {
        this.idUser = idUser;
    }

    public UserDTO(String email) {
        this.email = email;
    }
    
    public PersonDTO getPerson(){
        return new Person().buscarFrom(idUser);
    }

    @Override
    public String toString() {
        return '[' + getEmail()
                + ", " + getPassword()
                + ", " + getPhoneNumber()
                + ", " + getRegistrationDate()
                + ']';
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter code">
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    // </editor-fold> 

    public int getIdProfile() {
        return idProfile;
    }
    public void setIdProfile(int idProfile){
        this.idProfile = idProfile;
    }

}
