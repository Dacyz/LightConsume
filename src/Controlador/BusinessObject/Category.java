package Controlador.BusinessObject;

import Controlador.Connections.CategoryDAO;
import Modelo.CategoryDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Category {

    CategoryDAO categoryDAO = new CategoryDAO();
    CategoryDTO categoryDTO;

    public Collection listar() {
        if (categoryDAO.listar() != null) {
            List<String> list = new ArrayList<>();
            categoryDAO.listar().stream().forEach((p) -> {
                list.add(p.getName());
            });
            return list;
        }
        return null;
    }

    public CategoryDTO buscar(String Email) {
        categoryDTO = categoryDAO.buscar(new CategoryDTO(Email));
        if (categoryDTO != null) {
            return categoryDTO;
        }
        return null;
    }
    
    public CategoryDTO buscar(int Email) {
        categoryDTO = categoryDAO.buscarId(Email);
        if (categoryDTO != null) {
            return categoryDTO;
        }
        return null;
    }
}
