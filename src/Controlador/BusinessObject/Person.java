package Controlador.BusinessObject;

import Controlador.Connections.PersonDAO;
import Modelo.PersonDTO;
import java.util.List;

public class Person {
    
    PersonDAO PersonDAO = new PersonDAO();
    PersonDTO PersonDTO;
    
    public List <PersonDTO> listar(){
        if(PersonDAO.listar() !=null){
            List<PersonDTO> lista = PersonDAO.listar();
            return lista;
        }
        return null;
    }
    
    public PersonDTO buscar(int id){
        PersonDTO = PersonDAO.buscar(new PersonDTO(id));
        if (PersonDTO != null) {
            return PersonDTO;
        }
        return null;
    }
    
    public PersonDTO buscarFrom(int idUser){
        listar().stream().forEach((a)->{
            if(a.getIdUser() == idUser){
                PersonDTO = a;
            }
        });
        return PersonDTO;
    }
}
