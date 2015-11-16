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
import co.edu.ufps.proyeccionSocial.dto.ActividadPresupuestalDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import co.edu.ufps.proyeccionSocial.util.conexion.Conexion;

public class ActividadPresupuestalDao implements Serializable{
    
    private Conexion conexion;
    
    public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
        
        /**
         * registra una nueva actividad presupuestal
         * @param actividadP
         * @return 
         */
        public boolean registrarActividadPresupuestal(ActividadPresupuestalDto actividadP){
			boolean res=false;
			Connection con=null;
			PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPresupuestalDao.registrarActividadPresupuestal");
			else con= conexion.getConnection();
                        
                        String sql="INSERT INTO actividadPresupuestal  (nomActividadPresupuestal, montoPresupuestal, descripcionMonto, idPresupuesto)"
                                +"VALUES (?,?,?,?)";
                        
                        ps = con.prepareStatement(sql);
			ps.setString(1, actividadP.getNomActividadPresupuestal());
                        ps.setInt(2, actividadP.getMontoPresupuestal());
                        ps.setString(3, actividadP.getDescripcionMonto());
                        ps.setInt(4, actividadP.getIdPresupuesto());
                        
                        ps.executeUpdate();
                        
                        sql="SELECT MAX(idActPresupuestal) AS id FROM actividadPresupuestal";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				int idActPresupuestal=rs.getInt(1);
				actividadP.setIdActPresupuestal(idActPresupuestal);
				res=true; 
			}
                        
                }
                
                catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPresupuestalDao", "RegistrarActividadPresupuestalo", e.toString());
			res=false;
		}
                finally{                    				
			ps=null;
			con=null;
		}
                return res;
        }
        
       
        /**
         * consulta una actividad presupuestal dado su id
         * @param idActPresupuestal
         * @return 
         */
        public ActividadPresupuestalDto consultarActividadPresupuestal(int idActPresupuestal){
                ActividadPresupuestalDto actividadP = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPresupuestalDao.consultarActividadPresupuestal");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadPresupuestal WHERE idActPresupuestal= '"+idActPresupuestal+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				actividadP = new ActividadPresupuestalDto(rs.getInt(1), rs.getString(2), 
                                        rs.getInt(3), rs.getString(4), rs.getInt(5),rs.getInt(6));
                                
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPresupuestalDao", "consultarActividadPresupuestal", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return actividadP;
        }
        
        /**
         * actualiza una actividad presupuestal ya existente
         * @param actividadP
         * @return 
         */
        public boolean actualizarActividadPresupuestal(ActividadPresupuestalDto actividadP){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPresupuestalDao.actualizarActividadPresupuestal");
			else con= conexion.getConnection();
			String sql = "UPDATE actividadPresupuestal SET nomActividadPresupuestal=?, montoPresupuestal=?, "
                                + "descripcionMonto=? WHERE idActPresupuestal= ?";
                        ps=con.prepareStatement(sql);
                        ps.setString(1, actividadP.getNomActividadPresupuestal());
                        ps.setInt(2, actividadP.getMontoPresupuestal());
                        ps.setString(3, actividadP.getDescripcionMonto());
                        ps.setInt(4, actividadP.getIdActPresupuestal());
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPresupuestalDao", "ctualizarActividadPresupuestal", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
        
        
        /**
         * carga las actividades presupuestales asignadas a un presupuesto
         * @param idPresupuesto
         * @return 
         */
        public ArrayList<ActividadPresupuestalDto> cargarActividadesPresupuestales(int idPresupuesto){
		ArrayList<ActividadPresupuestalDto> r = new ArrayList<ActividadPresupuestalDto>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPresupuestalDao.cargarActividadesPresupuestales");
			else con= conexion.getConnection();
			String sql="SELECT * FROM actividadPresupuestal WHERE "
                                + "idPresupuesto="+idPresupuesto;
			ps = con.prepareStatement(sql);
                       // ps.setInt(1, idPresupuesto);
			
			ResultSet rs = ps.executeQuery(sql); 
			while(rs.next()){
				
                            
				r.add(new ActividadPresupuestalDto(rs.getInt(1), rs.getString(2), 
                                        rs.getInt(3), rs.getString(4),rs.getInt(5),rs.getInt(6)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPresupuestalDao", "cargarActividadesPresupuestales", e.toString());
			r=null;
		}finally{
					
			ps=null;
			con=null;
		}
		return r;
	}
        
        
        public boolean ejecutarActividadPresupuestal(ActividadPresupuestalDto actividadP){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPresupuestalDao.ejecutarActividadPresupuestal");
			else con= conexion.getConnection();
			String sql = "UPDATE actividadPresupuestal SET montoEjecutado=? WHERE idActPresupuestal=?";
                        ps=con.prepareStatement(sql);
                        ps.setInt(1, actividadP.getMontoEjecutado());
                        ps.setInt(2, actividadP.getIdActPresupuestal());
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPresupuestalDao", "ejecutarActividadPresupuestal", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
        
        
        /**
         * elimina una actividad de la base de datos dado su id.
         * @param idActPresupuestal
         * @return 
         */
        public boolean borrarActividadPresupuestal(int idActPresupuestal){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("ActividadPresupuestalDao.borrarActividadPresupuestal");
			else con= conexion.getConnection();
			String sql = "DELETE FROM actividadPresupuestal WHERE idActPresupuestal=?";
                        ps=con.prepareStatement(sql);
                        ps.setInt(1, idActPresupuestal);
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("ActividadPresupuestalDao", "borrarActividadPresupuestal", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
    
}
