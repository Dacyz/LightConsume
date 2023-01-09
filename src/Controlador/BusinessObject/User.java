package Controlador.BusinessObject;

import Controlador.Connections.UserDAO;
import Modelo.UserDTO;
import java.util.List;

public class User {

    UserDAO userDAO = new UserDAO();
    UserDTO userDTO;

    public List<UserDTO> listar() {
        if (userDAO.listar() != null) {
            List<UserDTO> lista = userDAO.listar();
            return lista;
        }
        return null;
    }

    public UserDTO buscar(String Email) {
        userDTO = userDAO.buscar(new UserDTO(Email));
        if (userDTO != null) {
            return userDTO;
        }
        return null;
    }
    
    public UserDTO buscar(int id) {
        userDTO = userDAO.buscar(id);
        if (userDTO != null) {
            return userDTO;
        }
        return null;
    }
}
