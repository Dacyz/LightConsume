/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.BusinessObject;

import Controlador.Connections.LightBillDAO;
import Modelo.LightbillDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DacyG
 */
public class LightBill {

    LightBillDAO LightBillDAO = new LightBillDAO();
    LightbillDTO LightBillDTO;

    public List<LightbillDTO> listar() {
        if (LightBillDAO.listar() != null) {
            List<LightbillDTO> lista = LightBillDAO.listar();
            return lista;
        }
        return null;
    }

    public List<LightbillDTO> listAnteriores(int idPerson) {
        List<LightbillDTO> lista = new ArrayList<>();
        listar().stream().filter(t -> t.getIdPerson() == idPerson).forEach((a) -> {
            lista.add(a);
        });
        return lista;
    }

    public LightbillDTO buscar(int Id) {
        LightBillDTO = LightBillDAO.buscar(new LightbillDTO(Id));
        if (LightBillDTO != null) {
            return LightBillDTO;
        }
        return null;
    }

    public String agregar(String codeLightBill, String issueDate, int idMonth, int idPerson) {
        LightBillDTO = new LightbillDTO(codeLightBill, issueDate, idMonth, idPerson);
        return LightBillDAO.agregar(LightBillDTO) ? "Guardado Correctamente: " + LightBillDTO.toString() : "¡Error al Agregar!";
    }

    public String actualizar(String codeLightBill, String issueDate, int idMonth, int idPerson, int idLightBill) {
        LightBillDTO = new LightbillDTO(idLightBill, codeLightBill, issueDate, idMonth, idPerson);
        return LightBillDAO.actualizar(LightBillDTO) ? "Se actualizo correctamente" : "error agg";
    }

    public String eliminar(int idDetail) {
        LightBillDTO = new LightbillDTO(idDetail);
        return LightBillDAO.eliminar(LightBillDTO) ? "¡Se elimino correctamente!" : "¡Error al Eliminar!";
    }
}
