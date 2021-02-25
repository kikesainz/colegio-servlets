package com.kike.colegio.controladores.matriculaciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dao.impl.MatriculacionDAOImplement;
import com.kike.colegio.dto.MatriculacionDTO;

/**
 * Servlet implementation class FormularioBorrarMatriculacionesController
 */
@WebServlet("/formularioborrarmatriculaciones")
public class FormularioBorrarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarMatriculacionesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/matriculaciones/borrarMatriculaciones.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  idAsig = request.getParameter("idAsig");
		String  nombreAsig = request.getParameter("nombreAsig");
		String  idAlum = request.getParameter("idAlum");
		String  nombreAlum = request.getParameter("nombreAlum");
		String  fecha = request.getParameter("fecha");
		String  activo = request.getParameter("activo");
		
		MatriculacionDAO m = new MatriculacionDAOImplement();
		List<MatriculacionDTO> listaMatriculaciones = m.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo);
		
		request.setAttribute("lista", listaMatriculaciones);
		
		RequestDispatcher d = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/matriculaciones/borrarMatriculaciones.jsp");
		d.forward(request, response);
	}

}
