
package Controlador.Connections;

import Modelo.DetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetailALDAO extends Connections implements CRUD<DetailDTO>{
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<DetailDTO> listar() {
        List<DetailDTO> lista = new ArrayList<>();
        String sql = "select * from DetailAppliances_Users";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetailDTO obj = new DetailDTO();
                obj.setIdAppliances(rs.getInt(1));
                obj.setIdUser(rs.getInt(2));
                obj.setWattsPower(rs.getFloat(3));
                obj.setAmmount(rs.getInt(4));
                obj.setHours(rs.getInt(5));
                obj.ChargeValues();
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(DetailDTO obj) {
        int r;
        String sql = "insert into DetailAppliances_Users (wattsPower,amount,Hours,idAppliances,idUser) values (?,?,?,?,?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, obj.getWattsPower());
            ps.setInt(2, obj.getAmmount());
            ps.setInt(3, obj.getHours());
            ps.setInt(4, obj.getIdAppliances());
            ps.setInt(5, obj.getIdUser());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DetailDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(DetailDTO obj) {
        int r;
        String sql = "update DetailAppliances_Users set wattsPower=?,amount=?,Hours=? where idAppliances=? and idUser=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, obj.getWattsPower());
            ps.setInt(2, obj.getAmmount());
            ps.setInt(3, obj.getHours());
            ps.setInt(4, obj.getIdAppliances());
            ps.setInt(5, obj.getIdUser());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DetailDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean eliminar(DetailDTO obj) {
        int r;
        String sql = "delete from DetailAppliances_Users where wattsPower=? and amount=? and Hours=? and idAppliances=? and idUser=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, obj.getWattsPower());
            ps.setInt(2, obj.getAmmount());
            ps.setInt(3, obj.getHours());
            ps.setInt(4, obj.getIdAppliances());
            ps.setInt(5, obj.getIdUser());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public DetailDTO buscar(DetailDTO obj) {
        String sql = "select * from DetailAppliances_Users where idAppliances=? and idUser=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdAppliances());
            ps.setInt(1, obj.getIdUser());
            obj = new DetailDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdAppliances(rs.getInt(1));
                obj.setIdUser(rs.getInt(2));
                obj.setWattsPower(rs.getFloat(3));
                obj.setAmmount(rs.getInt(4));
                obj.setHours(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }
}
