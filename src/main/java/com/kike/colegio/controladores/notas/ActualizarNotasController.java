package com.kike.colegio.controladores.notas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dao.impl.NotaDAOImplement;

/**
 * Servlet implementation class ActualizarNotasController
 */
@WebServlet("/actualizarnota")
public class ActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NotaDAO n = new NotaDAOImplement();
		
		String idNota = request.getParameter("idNota");
		String idAlumno  = request.getParameter("alumnos");
		String idAsignatura = request.getParameter("asignaturas");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
		
		Integer resultado = n.actualizarNota(idNota, idAlumno, idAsignatura, nota, fecha);
		
		request.setAttribute("resultado", resultado);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/notas/actualizarNotas.jsp");		
		d.forward(request, response);
	}

}
