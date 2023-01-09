package Controlador.Connections;

import Modelo.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends Connections implements CRUD<UserDTO> {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<UserDTO> listar() {
        List<UserDTO> lista = new ArrayList<>();
        String sql = "select * from Users";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDTO obj = new UserDTO();
                obj.setIdUser(rs.getInt(1));
                obj.setEmail(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setPhoneNumber(rs.getString(4));
                obj.setRegistrationDate(rs.getString(5));
                obj.setIdProfile(rs.getInt(6));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(UserDTO obj) {
        int r;
        String sql = "insert into Users(email,password,phoneNumber,registrationDate,idProfile)values(?,?,?,?,?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getPhoneNumber());
            ps.setString(4, obj.getRegistrationDate());
            ps.setInt(5, obj.getIdProfile());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(UserDTO obj) {
        int r;
        String sql = "update Users set email=?,password=?,phoneNumber=?,registrationDate=?,idProfile=? where idUser=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getPhoneNumber());
            ps.setString(4, obj.getRegistrationDate());
            ps.setInt(5, obj.getIdProfile());
            ps.setInt(6, obj.getIdUser());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean eliminar(UserDTO obj) {
        int r;
        String sql = "delete from Users where idUser=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdUser());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public UserDTO buscar(UserDTO obj) {
        String sql = "select * from Users where email=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getEmail());
            obj = new UserDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdUser(rs.getInt(1));
                obj.setEmail(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setPhoneNumber(rs.getString(4));
                obj.setRegistrationDate(rs.getString(5));
                obj.setIdProfile(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }

    public UserDTO buscar(int id) {
        String sql = "select * from Users where idUser=?";
        UserDTO obj = new UserDTO();
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdUser(rs.getInt(1));
                obj.setEmail(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setPhoneNumber(rs.getString(4));
                obj.setRegistrationDate(rs.getString(5));
                obj.setIdProfile(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }

}
