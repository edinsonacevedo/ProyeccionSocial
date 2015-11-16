
package co.edu.ufps.proyeccionSocial.dao;

import co.edu.ufps.proyeccionSocial.dto.ActividadBSDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import co.edu.ufps.proyeccionSocial.util.conexion.Conexion;
/**
 *
 * @author Nando
 */
public class ActividadBSDao implements Serializable{
    
    private Conexion conexion;
    
    public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
        
        /**
         * Metodo que permite registrar una Actividad de Bienestar social en la base da datos
         * @param actividad (ActividadBSDto) Objeto actividad con la información correspondiente
         * a la Actividad de Bienestar Social
         * @return (boolean) TRUE si todo ha sido exitoso el registro en la BD y sino FALSE
         */
        public boolean registrarActividadBS(ActividadBSDto actividad){
			boolean res=false;
			Connection con=null;
			PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadBSDao.registrarActividadBSDao");
			else con= conexion.getConnection();
                        
                        String sql="INSERT INTO actividadBS (descripcion, lugar, fecha, programa_id, presupuesto_id, lider_codigoUFPS, nombre, estado)"
                                +"VALUES (?,?,?,?,?,?,?,?)";
                        
                        ps = con.prepareStatement(sql);
			ps.setString(1, actividad.getDescripcion());
			ps.setString(2, actividad.getLugar());
			ps.setDate(3, actividad.getFecha());
			ps.setInt(4, actividad.getPrograma_id());
			ps.setInt(5, actividad.getPresupuesto_id());
                        ps.setInt(6, actividad.getLider_codigoUFPS());
                        ps.setString(7, actividad.getNombre());
                        ps.setString(8, actividad.getEstado());
                        
                        ps.executeUpdate();
                        
                        sql="SELECT MAX(idActividadBS) AS id FROM actividadBS";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				int idActividad=rs.getInt(1);
				actividad.setIdActividadBS(idActividad);
				res=true; //Envia el objeto con el id asignado por autoincremento
			}
                        
                }
                
                catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadBSDao", "RegistrarActividadBSDao", e.toString());
			res=false;
		}
                finally{                    				
			ps=null;
			con=null;
		}
                return res;
        }
        
       
        /**
         * Método para consultar una actividad de Bienestar social por ID de 
         * actividad
         * @param idActividadBS ID de la mascota a consultar
         * @return actividad (ActividadDTO)
         */
        public ActividadBSDto consultarActividadBS(int idActividadBS){
            ActividadBSDto actividad = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadDao.consultarActividadBS");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadBS WHERE idActividadBS= '"+idActividadBS+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				actividad = new ActividadBSDto(rs.getInt(1), rs.getString(2), rs.getString(3),
                                        rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), 
                                        rs.getString(9));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadBSDao", "consultarActividadBS", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return actividad;
        }
        
        /**
         * Actualiza la informacion relacionada a una actividad de bienestar
         * @param actividad
         * @return 
         */
        public boolean actualizarActividad(ActividadBSDto actividad){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadBSDao.actualizarActividad");
			else con= conexion.getConnection();
			String sql = "UPDATE actividadBS SET descripcion=?, lugar=?, fecha=?, programa_id=?,"
                                + " lider_codigoUFPS=?, nombre=?, estado=? WHERE idActividadBS= ?";
                        ps=con.prepareStatement(sql);
                        ps.setString(1, actividad.getDescripcion());
                        ps.setString(2, actividad.getLugar());
                        ps.setDate(3, actividad.getFecha());
                        ps.setInt(4, actividad.getPrograma_id());
                        ps.setInt(5, actividad.getLider_codigoUFPS());
                        ps.setString(6, actividad.getNombre());
                        ps.setString(7, actividad.getEstado());
                        ps.setInt(8, actividad.getIdActividadBS());
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadBSDao", "ActualizarActividad", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
        
        /**
         * Metodo que carga todas las actividades de bienestar social que se
         * encuentren registradas en la base de datos
         * @return r arraylist con las actividades
         */
        public ArrayList<ActividadBSDto> cargarActividadesBSDao(){
		ArrayList<ActividadBSDto> r = new ArrayList<ActividadBSDto>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadBSDao.cargarActividadesBSDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadBS";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ActividadBSDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
                                        rs.getDate(4), rs.getInt(5), 
                                        rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadBsDao", "cargarActividadesBSDao", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
	}
        
        /**
         * carga las actividades asignadas a un lider
         * @param codLider
         * @return 
         */
        public ArrayList<ActividadBSDto> asignadasLiderDao(int codLider){
            ArrayList<ActividadBSDto> r = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadBSDao.asignadasLiderDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadBS WHERE lider_codigoUFPS ="+codLider;
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ActividadBSDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
                                        rs.getDate(4), rs.getInt(5), 
                                        rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
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

