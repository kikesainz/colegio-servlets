package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dto.MatriculacionDTO;

public interface MatriculacionDAO {
	List<MatriculacionDTO> obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(String idAsig, String nombreAsig, String idAlum, String nombreAlum, String fecha, String activo);
	Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha);
	Integer borrarMatriculacion(String idMatricula);
}
