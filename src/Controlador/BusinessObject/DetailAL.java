/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.BusinessObject;

import Controlador.Connections.DetailALDAO;
import Modelo.DetailDTO;
import java.util.ArrayList;
import java.util.List;

public class DetailAL {

    DetailALDAO userDAO = new DetailALDAO();
    DetailDTO userDTO;

    public List<DetailDTO> listFrom(int idUser) {
        if (userDAO.listar() != null) {
            List<DetailDTO> lista = new ArrayList<>();
            TotalHour = 0;
            TotalAmmount = 0;
            TotalWatts = 0;
            CalculoTotal = 0;
            listar().stream().filter(t -> t.getIdUser() == idUser).forEach((DetailDTO a) -> {
                lista.add(a);
                TotalHour = TotalHour + a.getHours();
                TotalAmmount = TotalAmmount + a.getAmmount();
                TotalWatts = TotalWatts + a.getWattsPower();
                CalculoTotal = CalculoTotal +a.MonthlyCalculation();
            });
            return lista;
        }
        return null;
    }

    int TotalHour = 0;
    int TotalAmmount = 0;
    float TotalWatts = 0;
    float CalculoTotal = 0;

    public float getCalculoTotal(){
        return CalculoTotal;
    }
    
    public int getTotalHours() {
        return TotalHour;
    }

    public int getTotalAmmount() {
        return TotalAmmount;
    }

    public float getTotalWattsPower() {
        return TotalWatts;
    }

    public List<DetailDTO> listar() {
        if (userDAO.listar() != null) {
            List<DetailDTO> lista = userDAO.listar();
            return lista;
        }
        return null;
    }

    public DetailDTO buscar(int idAppliance, int idUser) {
        userDTO = userDAO.buscar(new DetailDTO(idAppliance, idUser));
        if (userDTO != null) {
            return userDTO;
        }
        return null;
    }

    public String agregar(float wattsPower, int ammount, int Hours, int idAppliances, int idUser) {
        userDTO = new DetailDTO(wattsPower, ammount, Hours, idAppliances, idUser);
        return userDAO.agregar(userDTO) ? "New Appliance: " + userDTO.getDeviceName(): "¡Error to add!";
    }

    public String actualizar(float wattsPower, int ammount, int Hours, int idAppliances, int idUser) {
        userDTO = new DetailDTO(wattsPower, ammount, Hours, idAppliances, idUser);
        return userDAO.actualizar(userDTO) ? "Se actualizo correctamente" : "error agg";
    }

    public String eliminar(float wattsPower, int ammount, int Hours, int idAppliances, int idUser) {
        userDTO = new DetailDTO(wattsPower, ammount, Hours, idAppliances, idUser);
        return userDAO.eliminar(userDTO) ? "¡Se elimino correctamente!" : "¡Error al Eliminar!";
    }
    
    public String eliminar(DetailDTO Detail) {
        userDTO = Detail;
        return userDAO.eliminar(userDTO) ? "¡Deleted Correctly!" : "¡Error to delete!";
    }
}
