package com.kike.colegio.controladores.asignaturas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImplement;
import com.kike.colegio.dao.impl.AsignaturaDAOImplement;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class FormularioActualizarAsignaturasController
 */
@WebServlet("/formularioactualizarasignatura")
public class FormularioActualizarAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarAsignaturasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/asignaturas/actualizarAsignaturas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String curso = request.getParameter("curso");
		String tasa = request.getParameter("tasa");
		
		AsignaturaDAO a = new AsignaturaDAOImplement();
		
		request.setAttribute("lista", a.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/asignaturas/actualizarAsignaturas.jsp");
		d.forward(request, response);
	}

}
