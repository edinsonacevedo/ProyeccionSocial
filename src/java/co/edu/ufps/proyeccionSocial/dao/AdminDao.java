/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.proyeccionSocial.dao;

/**
 *
 * @author Edinson
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import co.edu.ufps.proyeccionSocial.util.conexion.Conexion;
import co.edu.ufps.proyeccionSocial.dto.AdministradorDto;

public class AdminDao implements Serializable{
    
    private Conexion conexion;

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public AdministradorDto consultarAdministrador(int codUFPS){
        AdministradorDto admin = null;
        Connection con=null;
        PreparedStatement ps=null;

        try{
                if(conexion==null) conexion= new Conexion();
                if(conexion.getConnection()==null) con = conexion.conectar("AdminDao.consultarAdministrador");
                else con= conexion.getConnection();
                String sql="SELECT * FROM administrador WHERE codUFPS= '"+codUFPS+"'";

                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);

                if(rs.next()){
                    
                    admin = new AdministradorDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        
                }

        }catch(Exception e){
                e.printStackTrace();
                conexion.escribirLogs("AdminDao", "consultarAdministrador", e.toString());

        }finally{

                ps=null;
                con=null;
        }

        return admin;
    }
    
}
