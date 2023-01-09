
package Controlador.Connections;

import Modelo.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO extends Connections implements CRUD<CategoryDTO>{

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<CategoryDTO> listar() {
        List<CategoryDTO> lista = new ArrayList<>();
        String sql = "select * from Category";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryDTO obj = new CategoryDTO();
                obj.setIdCategory(rs.getInt(1));
                obj.setName(rs.getString(2));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(CategoryDTO obj) {
        int r;
        String sql = "insert into Category(idCategory)values(?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(CategoryDTO obj) {
        int r;
        String sql = "update Category set name=? where idCategory=?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getIdCategory());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean eliminar(CategoryDTO obj) {
        int r;
        String sql = "delete from Category where idCategory=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdCategory());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public CategoryDTO buscar(CategoryDTO obj) {
        String sql = "select * from Category where name=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            obj = new CategoryDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdCategory(rs.getInt(1));
                obj.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }
    
    public CategoryDTO buscarId(int Id) {
        CategoryDTO obj = new CategoryDTO();
        String sql = "select * from Category where idCategory=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, Id);
            obj = new CategoryDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdCategory(rs.getInt(1));
                obj.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }
    
}
