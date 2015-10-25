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

import co.edu.ufps.proyeccionSocial.utils.conexion.Conexion;
import co.edu.ufps.proyeccionSocial.dto.LiderDto;

public class LiderDao implements Serializable{
    
    private Conexion conexion;

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public LiderDto consultarLider (int codigoUFPS){
        
        LiderDto lider = null;
        Connection con=null;
        PreparedStatement ps=null;

        try{
                if(conexion==null) conexion= new Conexion();
                if(conexion.getConnection()==null) con = conexion.conectar("LiderDao.consultarLider");
                else con= conexion.getConnection();
                String sql="SELECT * FROM lider WHERE codigoUFPS= '"+codigoUFPS+"'";

                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);

                if(rs.next()){
                    
                    lider = new LiderDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
                            rs.getString(4), rs.getString(5));
                        
                }

        }catch(Exception e){
                e.printStackTrace();
                conexion.escribirLogs("LiderDao", "consultarLider", e.toString());

        }finally{

                ps=null;
                con=null;
        }

        return lider;
    }
    
}
