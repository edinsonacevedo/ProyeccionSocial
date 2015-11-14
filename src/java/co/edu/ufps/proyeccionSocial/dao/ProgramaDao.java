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
import co.edu.ufps.proyeccionSocial.dto.ProgramaDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import co.edu.ufps.proyeccionSocial.utils.conexion.Conexion;

public class ProgramaDao implements Serializable{
    
    private Conexion conexion;
    
    public Conexion getConexion() {
		return conexion;
	}

    public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
    
    /**
     * Busca un  programa por su id
     * @param idPrograma
     * @return 
     */
    public ProgramaDto consultarProgramaDao(int idPrograma){
                ProgramaDto programa = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ProgramaDao.consultarProgramaDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM programa WHERE idPrograma= '"+idPrograma+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				programa = new ProgramaDto(rs.getInt(1), rs.getString(2));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ProgramaDao", "consultarProgramaDao", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return programa;
        }
    
    /**
     * carga todos los programas registrados en base de datos
     * @return 
     */
    public ArrayList<ProgramaDto> cargarProgramasDao(){
		ArrayList<ProgramaDto> r = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ProgramaDao.cargarProgramasDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM programa";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ProgramaDto(rs.getInt(1), rs.getString(2)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ProgramaDao", "cargarProgramasDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
	}
}
