
package Controlador.Connections;

import Modelo.LightbillDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LightBillDAO extends Connections implements CRUD<LightbillDTO>{

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<LightbillDTO> listar() {
        List<LightbillDTO> lista = new ArrayList<>();
        String sql = "select * from LightBill";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                LightbillDTO obj = new LightbillDTO();
                obj.setIdLightBill(rs.getInt(1));
                obj.setCodeLightBill(rs.getString(2));
                obj.setIssueDate(rs.getString(3));
                obj.setIdMonth(rs.getInt(4));
                obj.setIdPerson(rs.getInt(5));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LightbillDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(LightbillDTO obj) {
        int r;
        String sql = "insert into LightBill(codeLightBill,issueDate,idMonth,idPerson)values(?,?,?,?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getCodeLightBill());
            ps.setString(2, obj.getIssueDate());
            ps.setInt(3, obj.getIdMonth());
            ps.setInt(4, obj.getIdPerson());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(LightbillDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(LightbillDTO obj) {
        int r;
        String sql = "update LightBill set codeLightBill=?,issueDate=?,idMonth=?,idPerson=? where idLightBill=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getCodeLightBill());
            ps.setString(2, obj.getIssueDate());
            ps.setInt(3, obj.getIdMonth());
            ps.setInt(4, obj.getIdPerson());
            ps.setInt(5, obj.getIdLightBill());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(LightbillDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean eliminar(LightbillDTO obj) {
        int r;
        String sql = "delete from LightBill where idLightBill=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdLightBill());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(LightbillDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public LightbillDTO buscar(LightbillDTO obj) {
        String sql = "select * from LightBill where idLightBill=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdLightBill());
            obj = new LightbillDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdLightBill(rs.getInt(1));
                obj.setCodeLightBill(rs.getString(2));
                obj.setIssueDate(rs.getString(3));
                obj.setIdMonth(rs.getInt(4));
                obj.setIdPerson(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LightbillDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }
    
}
