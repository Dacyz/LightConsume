/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.BusinessObject;

import Controlador.Connections.AppliancesDAO;
import Modelo.AppliancesDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Appliances {

    AppliancesDAO appliancesDAO = new AppliancesDAO();
    AppliancesDTO appliancesDTO;

    public Collection listar(int Colection) {
        if (appliancesDAO.listar() != null) {
            List<AppliancesDTO> lista = appliancesDAO.listar();
            List<String> list = new ArrayList<>();
            lista.stream().filter((a) -> (a.getIdCategory() == Colection)).forEachOrdered((a) -> {
                list.add(a.getName());
            });
            return list;
        }
        return null;
    }

    public AppliancesDTO buscar(String Email) {
        appliancesDTO = appliancesDAO.buscar(new AppliancesDTO(Email));
        if (appliancesDTO != null) {
            return appliancesDTO;
        }
        return null;
    }
    
    public AppliancesDTO buscar(int Email) {
        appliancesDTO = appliancesDAO.buscarId(Email);
        if (appliancesDTO != null) {
            return appliancesDTO;
        }
        return null;
    }

}
