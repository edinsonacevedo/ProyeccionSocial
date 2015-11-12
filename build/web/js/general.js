// JavaScript Document

/* Crea el objeto AJAX */
function nuevoAjax()
{ 
	var xmlhttp=false;
	try	{
		// Creacion del objeto AJAX para navegadores no IE Ejemplo:Mozilla, Safari 
		xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
		try	{
			// Creacion del objet AJAX para IE
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(E){
			if (!xmlhttp && typeof XMLHttpRequest!='undefined') xmlhttp=new XMLHttpRequest();
		}
	}
	return xmlhttp; 
}

function mostrarInfoActP(){
	
	mostrarInfoActPAjax();
}

function mostrarInfoActPAjax(){
	
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
	parametros = "aleatorio="+aleatorio;
        
        var idActPresupuestal = document.editarActP.idActPresupuestal.value;
	
		
	url = "jsp/mostrarInfoActP.jsp?idActPresupuestal="+idActPresupuestal;  
	 
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       
	        	document.getElementById("divInfoActP").innerHTML = ajax.responseText;
	        
	    }
	    else
	    {    
	    	
	        	document.getElementById("divInfoActP").innerHTML = ajax.responseText;
	        	         
	    }
	  } 
	  else
	  {
	    document.getElementById("divInfoActP").innerHTML = "Generando...";
	  }
	};
}

function mostrarMontoEjecutado(){
	
	mostrarMontoEjecutadoAjax();
}

function mostrarMontoEjecutadoAjax(){
	
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
	parametros = "aleatorio="+aleatorio;
        
        var idActPresupuestal = document.ejecutarMonto.idActPresupuestal.value;
	
		
	url = "jsp/montoEjecutado.jsp?idActPresupuestal="+idActPresupuestal;  
	 
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       
	        	document.getElementById("divMontoAjustado").innerHTML = ajax.responseText;
	        
	    }
	    else
	    {    
	    	
	        	document.getElementById("divMontoAjustado").innerHTML = ajax.responseText;
	        	         
	    }
	  } 
	  else
	  {
	    document.getElementById("divMontoAjustado").innerHTML = "Generando...";
	  }
	};
}



