
package Controlador.Connections;

import Modelo.PersonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDAO extends Connections implements CRUD<PersonDTO>{
    
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<PersonDTO> listar() {
        List<PersonDTO> lista = new ArrayList<>();
        String sql = "select * from Person";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PersonDTO obj = new PersonDTO();
                obj.setIdPerson(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setLastName(rs.getString(3));
                obj.setSex(rs.getString(4).charAt(0));
                obj.setIdentificationDocument(rs.getString(5));
                obj.setDirection(rs.getString(6));
                obj.setBirthDate(rs.getDate(7).toString());
                obj.setIdUser(rs.getInt(8));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return lista;
    }

    @Override
    public boolean agregar(PersonDTO obj) {
        int r;
        String sql = "insert into Person(name,lastName,sex,identificationDocument,direction,birthDate,idUser)values(?,?,?,?,?,?,?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, String.valueOf(obj.getSex()));
            ps.setString(4, obj.getIdentificationDocument());
            ps.setString(5, obj.getDirection());
            ps.setDate(6, java.sql.Date.valueOf(obj.getBirthDate()));
            ps.setInt(7, obj.getIdUser());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PersonDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean actualizar(PersonDTO obj) {
        int r;
        String sql = "update Person set name=?,lastName=?,sex=?,identificationDocument=?,direction=?,birthDate=?,idUser=? where idPerson=?)";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, String.valueOf(obj.getSex()));
            ps.setString(4, obj.getIdentificationDocument());
            ps.setString(5, obj.getDirection());
            ps.setDate(6, java.sql.Date.valueOf(obj.getBirthDate()));
            ps.setInt(7, obj.getIdUser());
            ps.setInt(8, obj.getIdPerson());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PersonDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public boolean eliminar(PersonDTO obj) {
        int r;
        String sql = "delete from Person where idPerson=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdPerson());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PersonDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cerrar();
        }
    }

    @Override
    public PersonDTO buscar(PersonDTO obj) {
        String sql = "select * from Person where idPerson=?";
        cn = conectar();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, obj.getIdPerson());
            obj = new PersonDTO();
            rs = ps.executeQuery();
            while (rs.next()) {
                obj.setIdPerson(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setLastName(rs.getString(3));
                obj.setSex(rs.getString(4).charAt(0));
                obj.setIdentificationDocument(rs.getString(5));
                obj.setDirection(rs.getString(6));
                obj.setBirthDate(rs.getDate(7).toString());
                obj.setIdUser(rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar();
        }
        return obj;
    }
}
