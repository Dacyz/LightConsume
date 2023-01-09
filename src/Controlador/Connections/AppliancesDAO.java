
package Controlador.Connections;

import Modelo.AppliancesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppliancesDAO extends Connections implements CRUD<AppliancesDTO> {
    
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<AppliancesDTO> listar() {
        List<AppliancesDTO> lista = new ArrayList<>();
        String sql = "select * from Appliances";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AppliancesDTO obj = new AppliancesDTO();
                obj.setIdApliances(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setStatus(rs.getBoolean(3));
                obj.setWattsPower(rs.getFloat(4));
                obj.setIdCategory(rs.getInt(5));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppliancesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(AppliancesDTO obj) {

        int r;
        String sql = "insert into Appliances(name, status, wattsPower, idCategory)values(?,?,?,?)";
        cn = conectar();

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setBoolean(2, obj.isStatus());
            ps.setFloat(3, obj.getWattsPower());
            ps.setInt(4, obj.getIdCategory());
            r = ps.executeUpdate();
            return r == 1;

        } catch (SQLException ex) {
            Logger.getLogger(AppliancesDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(AppliancesDTO obj) {

        int r;
        String sql = "update Appliances set name=?,status=?,idCategory=?,wattsPower=? where idAppliances=? )";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setBoolean(2, obj.isStatus());
            ps.setInt(3, obj.getIdCategory());
            ps.setFloat(4, obj.getWattsPower());
            ps.setInt(5, obj.getIdApliances());
            r = ps.executeUpdate();
            return r == 1;

        } catch (SQLException ex) {
            Logger.getLogger(AppliancesDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean eliminar(AppliancesDTO obj) {
        int r;
        String sql = "delete from Appliances where idAppliances=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdApliances());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(AppliancesDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public AppliancesDTO buscar(AppliancesDTO obj) {
        String sql = "select * from Appliances where name=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            obj = new AppliancesDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdApliances(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setStatus(rs.getBoolean(3));
                obj.setWattsPower(rs.getFloat(4));
                obj.setIdCategory(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppliancesDTO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            cerrar();
        }
        return obj;
    }
    
    public AppliancesDTO buscarId(int obj) {
        String sql = "select * from Appliances where idAppliances=?";
        AppliancesDTO objs = new AppliancesDTO();
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                objs.setIdApliances(rs.getInt(1));
                objs.setName(rs.getString(2));
                objs.setStatus(rs.getBoolean(3));
                objs.setWattsPower(rs.getFloat(4));
                objs.setIdCategory(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppliancesDTO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            cerrar();
        }
        return objs;
    }
}
