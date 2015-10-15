package co.edu.ufps.proyeccionSocial.utils.conexion;

import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * Clase que permite realizar una conexi�n con la base de datos.
 * @author Fredy Vera
 *
 */
public class Conexion
{
	/* Variables */
	
	long tiempo_inicio = -1;
  	long tiempo_total = 0;
  	
  	/**postgresql
         * private final static String url ="jdbc:postgresql://sandbox2.ufps.edu.co/21web";//local
	private String usuario="ufps_15";	
	private String password="ufps_11";
	private final static String driver = "org.postgresql.Driver";			
	private String error;**/
		
        private final static String url ="jdbc:mysql://sandbox2.ufps.edu.co/ufps_15";
	private String usuario="ufps_15";	
	private String password="ufps_11";
	private final static String driver = "com.mysql.jdbc.Driver";			
	private String error;
	
	public String ruta_logs="C:/Users/Lenovo/Desktop/ProyeccionSocial/web/logs/logs.html";
	
	private Connection con;
	private CallableStatement cs;
	private PreparedStatement ps;	
	private ResultSet rst;
	
	/**
	 * Constructor de la clase.
	 */
	public Conexion()
	{		
		super();
	}
	
	public void setusuario(String usuario)
	{
		this.usuario=usuario;		
	}

	public void setclave(String clave)
	{
		this.password=clave;		
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	/**
	 * M�todo que permite realizar una conexi�n con la base de datos.
	 * @param conectaDesde: Clase y m�todo de donde se realiza la conexi�n. 
	 * @return Connection: Objeto con la conexi�n establecida con la base de datos.
	 * @throws java.sql.SQLException
	 */
	public Connection conectar(String conectaDesde) throws java.sql.SQLException
	{						
		try
		{
			Class.forName(driver);
			this.con = DriverManager.getConnection(url,usuario,password);
			this.escribirLogsCon(conectaDesde);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.escribirLogs("Conexion","conectar()",e.toString());
		}
		return this.con;
	}
	
	/**
	 * M�todo que asigna una conexion.
	 * @param conex: Conecction a asignar
	 */
	public void setConnection (Connection conex)
	{
		this.con= conex;	
	}
	
	/**
	 * M�todo que permite cerrar una conexi�n.
	 */
	public void cerrarConexion()
	{
		
		try
		{		
			if (this.rst!=null) this.rst.close();
			if (this.ps!=null) this.ps.close();
			if (this.cs!=null) this.cs.close();
						
			this.rst= null;
			this.ps= null;
			this.cs=null;
			
			this.con.close();
			this.con=null;
		}
		catch(Exception e)
		{
			this.escribirLogs("Conexion", "cerrarConexion()",e.toString());
		}
		
	}  		
	
	/**
	 * M�todo que se encarga de escribir lo logs de conexi�n del usuario.
	 * @param conexionDesde: pagina o clase donde se realiza la conexi�n.
	 */
	public void escribirLogsCon(String conexionDesde)
	{
		try
		{
			java.util.Date tiempo=new java.util.Date();
			SimpleDateFormat formato_fecha=new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat formato_hora=new SimpleDateFormat("h:mm a");
			FileWriter fw = new FileWriter(this.ruta_logs,true);
			fw.write(formato_fecha.format(tiempo)+" "+formato_hora.format(tiempo)+" >> Conexion del usuario: "+ this.usuario+" pagina: "+conexionDesde+"<br><br>");
			fw.close();
		}
		catch(Exception e)
		{
			this.escribirLogs("Conexion", "escribirLogsCon()",e.toString());
		}
	}
		
	/* M�todo que registra los errores presentados en el sistema */
	public void escribirLogs(String nombre_clase, String nombre_pagina,String mensaje_error)
	{
		try
		{
			java.util.Date tiempo=new java.util.Date();
			SimpleDateFormat formato_fecha=new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat formato_hora=new SimpleDateFormat("h:mm a");
			FileWriter fw = new FileWriter(this.ruta_logs,true);
			fw.write(formato_fecha.format(tiempo)+" "+formato_hora.format(tiempo)+" >> Error en la clase: "+nombre_clase+" de: "+nombre_pagina+ ": " +mensaje_error+"<br><br>");
			fw.close();
			
			this.error = mensaje_error;
		}
		catch(Exception e)
		{
			System.err.println("Error en el m�todo escribirLogs: "+e.toString());
		}
	}
	
	/* M�todo que permite iniciar el cronometro */
	public void iniciarCronometro()
	{
		tiempo_inicio = System.currentTimeMillis();
		tiempo_total=0;
	}

	/* M�todo que permite detener el cronometro */
	public void detenerCronometro()
	{
		tiempo_total = System.currentTimeMillis() - tiempo_inicio;
	}

	/* M�todo que permite calcular el tiempo total de ejecuci�n para un proceso */
	public long getTiempoTotal()
	{
		return tiempo_total;
	}
	
	public Connection getConnection()
	{
		return this.con;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Conexion))
			return false;
		final Conexion other = (Conexion) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}