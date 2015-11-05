/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.proyeccionSocial.dao;

import co.edu.ufps.proyeccionSocial.dto.ActividadPSDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.edu.ufps.proyeccionSocial.utils.conexion.Conexion;

/**
 *
 * @author Edinson
 */
public class ActividadPSDao {
    
    private Conexion conexion;
    
    public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
        
    
        public ArrayList<ActividadPSDto> asignadasLiderDao(int codLider){
            ArrayList<ActividadPSDto> r = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPSDao.asignadasLiderDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadPS WHERE lider_codigoUFPS ="+codLider;
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ActividadPSDto(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4),
                                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadBsDao", "asignadasLiderDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
        }
        
}
