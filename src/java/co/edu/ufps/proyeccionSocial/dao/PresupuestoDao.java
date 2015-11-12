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

import co.edu.ufps.proyeccionSocial.dto.PresupuestoDto;
import co.edu.ufps.proyeccionSocial.utils.conexion.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PresupuestoDao {
    
    private Conexion conexion;
    
    public Conexion getConexion() {
            return conexion;
	}

    public void setConexion(Conexion conexion) {
            this.conexion = conexion;
    }
    
    /**
     * Metodo que permite registrar un nuevo presupuesto
     * @param presupuesto objeto de tipo PrepuestoDto
     * @return id del presuesto registrado
     */
    public int registrarPresupuestoDao(PresupuestoDto presupuesto){
        int id = 0;
        Connection con=null;
        PreparedStatement ps=null;
		
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("PresupuestoDao.registrarPresupuestoDao");
			else con= conexion.getConnection();
                        
                        String sql="INSERT INTO presupuesto (monto, estado)"
                                +"VALUES (?,?)";
                        
                        ps = con.prepareStatement(sql);
			ps.setDouble(1, presupuesto.getMonto());
			ps.setString(2, presupuesto.getEstado());
                        
                        ps.executeUpdate();
                        
                        sql="SELECT MAX(idPresupuesto) AS id FROM presupuesto";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				int idPresupuesto=rs.getInt(1);
				presupuesto.setIdPresupuesto(idPresupuesto);
				id=idPresupuesto; 
			}
                        
                }
                
                catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("PresupuestoDao", "registrarPresupuestoDao", e.toString());
			id = 0;
		}
                finally{                    				
			ps=null;
			con=null;
		}
                return id;
        }
    
    /**
     * Elimina un Presypuesto
     * @param idPresupuesto
     * @return 
     */
    public  boolean eliminarPresupuestoDao(int idPresupuesto){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
		try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("PresupuestoDao.eliminarPresupuestoDao");
			else con= conexion.getConnection();
			String sql="DELETE FROM presupuesto WHERE idPresupuesto = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idPresupuesto);
			ps.executeUpdate();
			r=true;
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("PresupuestoDao", "eliminarPresupuestoDao", e.toString());
			r=false;
		}finally{			
			ps=null;
			con=null;
		}
		return r;
	}
    
    /**
     * Consulta un oresupuesto dado su id
     * @param idPresupuesto
     * @return 
     */
    public PresupuestoDto consultarPresupuestoDao(int idPresupuesto){
                PresupuestoDto presupuesto = null;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("PresupuestoDao.consultarPresupuestoDao");
			else con= conexion.getConnection();
			String sql="SELECT * FROM presupuesto WHERE idPresupuesto= '"+idPresupuesto+"'";
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()){
				presupuesto = new PresupuestoDto(rs.getInt(1), rs.getDouble(3), rs.getDate(2), rs.getString(4), rs.getString(5));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("PresupuestoDao", "consultarPresupuestoDao", e.toString());
			
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return presupuesto;
        }
    
    public boolean actualizarPresupuesto(PresupuestoDto presupuesto){
		boolean r=false;
		Connection con=null;
		PreparedStatement ps=null;
                
                try{
			if(conexion==null) conexion= new Conexion();
			if(conexion.getConnection()==null) con = conexion.conectar("PresupuestoDao.actualizarPresupuesto");
			else con= conexion.getConnection();
			String sql = "UPDATE presupuesto SET monto=?, fecha=?, estado=?, nota=?"
                                + "  WHERE idPresupuesto= ?";
                        ps=con.prepareStatement(sql);
                        ps.setDouble(1, presupuesto.getMonto());
                        ps.setDate(2, presupuesto.getFecha());
                        ps.setString(3, presupuesto.getEstado());
                        ps.setString(4, presupuesto.getNota());
                        ps.setInt(5, presupuesto.getIdPresupuesto());
                        
                        
                        ps.executeUpdate(); 
			r=true;
                        
                }
                
                
                    catch(Exception e){
			e.printStackTrace();
			conexion.escribirLogs("PresupuestoDao", "ActualizarPresupuesto", e.toString());
			r=false;
		}
                
                finally{						
			ps=null;
			con=null;
		}
		return r;
                
        }
    
}
