package com.kike.colegio.controladores.alumno;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImplement;
import com.kike.colegio.dao.impl.ComboDAOImplement;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/insertaralumno")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComboUtils.recuperarComboMunicipios(request);
		
		//Redirigir a la vista
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/alumnos/insertarAlumnos.jsp");
		d.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupero datos del formulario
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String idMunicipio = request.getParameter("municipios");
		String famNumerosa = request.getParameter("familiaNumerosa");
		
		AlumnoDAO a = new AlumnoDAOImplement();
		
		Integer resultado = a.insertarAlumno(id, nombre, idMunicipio, famNumerosa);
		
		request.setAttribute("resultado", resultado);
		ComboUtils.recuperarComboMunicipios(request);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/alumnos/insertarAlumnos.jsp");
		d.forward(request, response);
	}
	
	

}
