package Controlador.BusinessObject;

import Controlador.Connections.MonthDAO;
import Modelo.MonthDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Month {

    MonthDAO MonthDAO = new MonthDAO();
    MonthDTO MonthDTO;

    public List<MonthDTO> listar() {
        if (MonthDAO.listar() != null) {
            List<MonthDTO> lista = MonthDAO.listar();
            return lista;
        }
        return null;
    }

    public MonthDTO buscar(int id) {
        MonthDTO = MonthDAO.buscar(new MonthDTO(id));
        if (MonthDTO != null) {
            return MonthDTO;
        }
        return null;
    }
/*
    public String agregar(String startdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fecha = simpleDateFormat.parse(startdate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); 
        calendar.add(Calendar.DAY_OF_YEAR, 30); 
        String endingdate = simpleDateFormat.format(calendar.getTime());
        MonthDTO = new MonthDTO(startdate, endingdate);
        return MonthDAO.agregar(MonthDTO) ? "Guardado Correctamente: " + MonthDTO.toString() : "¡Error al Agregar!";
    }

    public String actualizar(float wattsPower, int ammount, int Hours, int idAppliances, int idDetail) {
        userDTO = new DetailDTO(wattsPower, ammount, Hours, idAppliances, idDetail);
        return userDAO.actualizar(userDTO) ? "Se actualizo correctamente" : "error agg";
    }

    public String eliminar(int idDetail) {
        userDTO = new DetailDTO(idDetail);
        return userDAO.eliminar(userDTO) ? "¡Se elimino correctamente!" : "¡Error al Eliminar!";
    }
*/
}
