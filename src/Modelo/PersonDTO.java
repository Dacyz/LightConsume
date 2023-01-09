package Modelo;

import Controlador.BusinessObject.User;

public class PersonDTO {

    private int idPerson;
    private int idUser;
    private char sex;
    private String name;
    private String lastName;
    private String identificationDocument;
    private String direction;
    private String birthDate;

    public PersonDTO(int idPerson, int idUser, char sex, String name, String lastName, String identificationDocument, String direction, String birthDate) {
        this.idPerson = idPerson;
        this.idUser = idUser;
        this.sex = sex;
        this.name = name;
        this.lastName = lastName;
        this.identificationDocument = identificationDocument;
        this.direction = direction;
        this.birthDate = birthDate;
    }

    public PersonDTO(int idUser, char sex, String name, String lastName, String identificationDocument, String direction, String birthDate) {
        this.idUser = idUser;
        this.sex = sex;
        this.name = name;
        this.lastName = lastName;
        this.identificationDocument = identificationDocument;
        this.direction = direction;
        this.birthDate = birthDate;
    }

    public PersonDTO(char sex, String name, String lastName, String identificationDocument, String direction, String birthDate) {
        this.sex = sex;
        this.name = name;
        this.lastName = lastName;
        this.identificationDocument = identificationDocument;
        this.direction = direction;
        this.birthDate = birthDate;
    }

    public PersonDTO(int idPerson) {
        this.idPerson = idPerson;
    }
    
    public PersonDTO() {

    }
    
    public UserDTO getUser(){
        return new User().buscar(idUser);
    }

    public String getFullName() {

        return name + " " + lastName;
    }

    @Override
    public String toString() {
        return '[' + getName()
                + ", " + getLastName()
                + ", " + getIdentificationDocument()
                + ", " + getDirection()
                + ", " + getSexS()
                + ", " + getBirthDate();
    }

    public String getSexS() {
        return 'M' == getSex() ? "Male" : "Female";
    }

// <editor-fold defaultstate="collapsed" desc="Getter and Setter code">
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public void setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    // </editor-fold> 

}
