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

import co.edu.ufps.proyeccionSocial.dto.EntidadDto;
import co.edu.ufps.proyeccionSocial.utils.conexion.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EntidadDao {
    
    private Conexion conexion;
    
    public Conexion getConexion() {
		return conexion;
	}

    public void setConexion(Conexion conexion) {
            this.conexion = conexion;
    }
    
    /**
     * registra una nueva entidad en la base de datos
     * @param entidad
     * @return 
     */
    public boolean registrarEntidadDao(EntidadDto entidad){
			boolean res=false;
			Connection con=null;
			PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("EntidadDao.registrarentidadDao");
			else con= conexion.getConnection();
                        
                        String sql="INSERT INTO entidad (nombre, direccion)"
                                +"VALUES (?,?)";
                        
                        ps = con.prepareStatement(sql);
			ps.setString(1, entidad.getNombre());
                        ps.setString(2, entidad.getDireccion());
                        
                        ps.executeUpdate();
                        res=true;
                        /**
                         * sql="SELECT MAX(idActividadBS) AS id FROM actividadBS";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				int idActividad=rs.getInt(1);
				actividad.setIdActividadBS(idActividad);
				res=true; //Envia el objeto con el id asignado por autoincremento
			}**/
                        
                }
                
                catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("EntidadDao", "RegistrarEntidadDao", e.toString());
			res=false;
		}
                finally{                    				
			ps=null;
			con=null;
		}
            return res;
        }
    
    /**
     * Consulta una entidad registrada en la base de datos dado su id.
     * @param idEntidad
     * @return 
     */
    public EntidadDto consultarEntidadDao(int idEntidad){
            EntidadDto entidad = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("EntidadDao.consultarEntidadDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM entidad WHERE idEntidad= '"+idEntidad+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				entidad = new EntidadDto(rs.getInt(1), rs.getString(2),rs.getString(3) );
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("EntidadDao", "consultarEntidadDao", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return entidad;
        }
    
    /**
     * consulta todas las entidades registradas en la base de datos.
     * @return 
     */
    public ArrayList<EntidadDto> cargarEntidadesDao(){
		ArrayList<EntidadDto> r = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("EntidadDao.cargarEntidadesDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM entidad";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new EntidadDto(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("EntidadDao", "cargarEntidadesDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
	}
    
}
