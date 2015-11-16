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

import co.edu.ufps.proyeccionSocial.dto.ConvenioDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import co.edu.ufps.proyeccionSocial.util.conexion.Conexion;

public class ConvenioDao {
    
    private Conexion conexion;
    
    public Conexion getConexion() {
		return conexion;
	}

    public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
    
    /**
     * Registra un  convenio en la base de datos
     * @param convenio
     * @return 
     */
    public boolean registrarConvenioDao(ConvenioDto convenio){
			boolean res=false;
			Connection con=null;
			PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ConvenioDao.registrarConvenioDao");
			else con= conexion.getConnection();
                        
                        String sql="INSERT INTO convenio(nombre, fecha, programa_id, entidad_id)"
                                +"VALUES (?,?,?,?)";
                        
                        ps = con.prepareStatement(sql);
                        ps.setString(1, convenio.getNombre());
                        ps.setDate(2, convenio.getFecha());
                        ps.setInt(3, convenio.getPrograma_id());
                        ps.setInt(4, convenio.getEntidad_id());
			
                        
                        ps.executeUpdate();
                        res=true;
                        /**
                        sql="SELECT MAX(idActividadBS) AS id FROM actividadBS";
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
			conexion.escribirLogs("ConvenioDao", "RegistrarConvenioDao", e.toString());
			res=false;
		}
                finally{                    				
			ps=null;
			con=null;
		}
                return res;
        }
    
    /**
     * consulta un convenio dado su id
     * @param idConvenio
     * @return 
     */
    public ConvenioDto consultarConvenioDao(int idConvenio){
            ConvenioDto convenio = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ConvenioDao.consultarConvenioDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM convenio WHERE idconvenio= '"+idConvenio+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				convenio = new ConvenioDto(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ConvenioDao", "consultarConvenioDao", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return convenio;
        }
        
        /**
         * Actualiza la informacion de un convenio
         * @param convenio
         * @return 
         */
        public boolean actualizarConvenioDao(ConvenioDto convenio){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadBSDao.actualizarActividad");
			else con= conexion.getConnection();
			String sql = "UPDATE convenio SET nombre=?, fecha=?, programa_id=?, entidad_id=?"
                                + " WHERE idconvenio= ?";
                        ps=con.prepareStatement(sql);
                        ps.setString(1, convenio.getNombre());
                        ps.setDate(2, convenio.getFecha());
                        ps.setInt(3, convenio.getPrograma_id());
                        ps.setInt(4, convenio.getEntidad_id());
                        ps.setInt(5, convenio.getIdConvenio());
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ConvenioDao", "actualizarConvenioDao", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
        
        /**
         * carga todos los convenios registrados en la base de datos
         * @return 
         */
        public ArrayList<ConvenioDto> cargarConveniosDao(){
		ArrayList<ConvenioDto> r = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ConvenioDao.cargarConveniosDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM convenio";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ConvenioDto(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ConvenioDao", "cargarConveniosDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
	}
    
    
    
}
