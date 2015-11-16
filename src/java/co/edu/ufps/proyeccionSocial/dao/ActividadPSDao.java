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

import co.edu.ufps.proyeccionSocial.util.conexion.Conexion;

/**
 *
 * @author Edinson
 */
public class ActividadPSDao implements Serializable{
    
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
			conexion.escribirLogs("ActividadPSDao", "asignadasLiderDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
        }
        
        /**
         * Registra una nueva actividad de proyeccion social
         * @param actividad
         * @return 
         */
        public boolean registrarActividadPSDao(ActividadPSDto actividad){
			boolean res=false;
			Connection con=null;
			PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPSDao.registrarActividadPSDao");
			else con= conexion.getConnection();
                        
                        String sql="INSERT INTO actividadPS (fecha, lugar, convenio_id, presupuesto_id, lider_codigoUFPS,"
                                + " nombre, estado, descripcion)"
                                +"VALUES (?,?,?,?,?,?,?,?)";
                        
                        ps = con.prepareStatement(sql);
                        ps.setDate(1, actividad.getFecha());
                        ps.setString(2, actividad.getLugar());
                        ps.setInt(3, actividad.getConvenio_id());
                        ps.setInt(4, actividad.getPresupesto_id());
                        ps.setInt(5, actividad.getLider_codigoUFPS());
                        ps.setString(6, actividad.getNombre());
                        ps.setString(7, actividad.getEstado());
                        ps.setString(8, actividad.getDescripcion());
			
                        
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
			}
                        * */
                        
                }
                
                catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPSDao", "RegistrarActividadPSDao", e.toString());
			res=false;
		}
                finally{                    				
			ps=null;
			con=null;
		}
                return res;
        }
        
        
        public ActividadPSDto consultarActividadPSDao(int idActividadPS){
                ActividadPSDto actividad = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPSDao.consultarActividadPSDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadPS WHERE idActividadPS= '"+idActividadPS+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				actividad = new ActividadPSDto(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPSDao", "consultarActividadPSDao", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return actividad;
        }
        
        /**
         * Actualiza la informacion de una actividad de proyeccion social
         * @param actividad
         * @return 
         */
        public boolean actualizarActividadPSDao(ActividadPSDto actividad){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPSDao.actualizarActividadPSDao");
			else con= conexion.getConnection();
			String sql = "UPDATE actividadPS SET fecha=?, lugar=?, convenio_id=?, presupuesto_id=?,"
                                + " lider_codigoUFPS=?, nombre=?, estado=?, descripcion=? WHERE idActividadPS= ?";
                        ps=con.prepareStatement(sql);
                        ps.setDate(1, actividad.getFecha());
                        ps.setString(2, actividad.getLugar());
                        ps.setInt(3, actividad.getConvenio_id());
                        ps.setInt(4, actividad.getPresupesto_id());
                        ps.setInt(5, actividad.getLider_codigoUFPS());
                        ps.setString(6, actividad.getNombre());
                        ps.setString(7, actividad.getEstado());
                        ps.setString(8, actividad.getDescripcion());
                        ps.setInt(9, actividad.getIdActividadPS());
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPSDao", "ActualizarActividadPSDao", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
        
        /**
         * Carga todas las actividades de Proyeccion social 
         * registradas en la base de datos
         * @return 
         */
        public ArrayList<ActividadPSDto> cargarActividadesPSDao(){
		ArrayList<ActividadPSDto> r = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPSDao.cargarActividadesPSDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadPS";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ActividadPSDto(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), 
                                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPSDao", "cargarActividadesPSDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
	}
        
}
