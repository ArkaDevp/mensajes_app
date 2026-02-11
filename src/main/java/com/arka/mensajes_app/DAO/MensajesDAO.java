package com.arka.mensajes_app.DAO;

import com.arka.dbconnection.ConnectionDB;
import com.arka.mensajes_app.model.Mensajes;

import java.sql.*;

public class MensajesDAO {
    public static void createMensajeDB(Mensajes mensaje){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = ConnectionDB.get_connection().prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Message created succesfully");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
    }

    public static void readMensajesDB(){
        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM mensajes";

            ps = ConnectionDB.get_connection().prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("-----------------");
                System.out.println("ID: "+ rs.getInt("id_mensaje"));
                System.out.println("Message:" + rs.getString("mensaje"));
                System.out.println("Author: " + rs.getString("autor_mensaje"));
                System.out.println("Date: " + rs.getString("fecha_mensaje"));
                System.out.println("-----------------");
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMensajesDB(int id_mensaje){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = ConnectionDB.get_connection().prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Message deleted succesfully");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
    }

    public static void actualizarMensajeDB(Mensajes mensaje, int id_mensaje){
        PreparedStatement ps = null;
        try{
            String query = "UPDATE mensajes SET mensaje = ?, autor_mensaje = ? WHERE id_mensaje = ?";
            ps = ConnectionDB.get_connection().prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor_mensaje());
            ps.setInt(3,id_mensaje);
            ps.executeUpdate();
            System.out.println("Message edited succesfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
