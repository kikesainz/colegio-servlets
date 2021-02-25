package com.kike.colegio.utils;

import javax.servlet.http.HttpServletRequest;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dao.impl.ComboDAOImplement;

public class ComboUtils {
	
	public static void recuperarComboMunicipios(HttpServletRequest request) {
		//Recuperar todos los municipios y meterlos en una lista		
		ComboDAO c = new ComboDAOImplement();		
		
		//Pasar la lista a la vista
		request.setAttribute("listaMunicipios", c.comboMunicipios());
	}
	
	public static void recuperarComboAlumnos(HttpServletRequest request) {
		//Recuperar todos los municipios y meterlos en una lista		
		ComboDAO c = new ComboDAOImplement();		
		
		//Pasar la lista a la vista
		request.setAttribute("listaAlumnos", c.comboAlumnos());
	}
	
	public static void recuperarComboAsignaturas(HttpServletRequest request) {
		//Recuperar todos los municipios y meterlos en una lista		
		ComboDAO c = new ComboDAOImplement();		
		
		//Pasar la lista a la vista
		request.setAttribute("listaAsignaturas", c.comboAsignaturas());
	}
}
