package Controlador.Connections;

import Modelo.MonthDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonthDAO extends Connections implements CRUD<MonthDTO>{
    
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<MonthDTO> listar() {
        List<MonthDTO> lista = new ArrayList<>();
        String sql = "select * from Month";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonthDTO obj = new MonthDTO();
                obj.setIdMonth(rs.getInt(1));
                obj.setStartDate(rs.getString(2));
                obj.setEndingDate(rs.getString(3));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode() + ex.getMessage());
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(MonthDTO obj) {
        int r;
        String sql = "insert into Month(startDate,endingDate)values(?,?,?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(obj.getStartDate()));
            ps.setDate(2, java.sql.Date.valueOf(obj.getEndingDate()));
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(MonthDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(MonthDTO obj) {
        int r;
        String sql = "update Month set startDate=?,endingDate=? where idMonth=?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(obj.getStartDate()));
            ps.setDate(2, java.sql.Date.valueOf(obj.getEndingDate()));
            ps.setInt(3, obj.getIdMonth());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(MonthDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean eliminar(MonthDTO obj) {
                int r;
        String sql = "delete from Month where idMonth=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdMonth());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(MonthDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public MonthDTO buscar(MonthDTO obj) {
        String sql = "select * from Month where idMonth=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdMonth());
            obj = new MonthDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setStartDate(rs.getString(1));
                obj.setEndingDate(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonthDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }
    
}
