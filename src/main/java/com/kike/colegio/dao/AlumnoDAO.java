package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dto.AlumnoDTO;

public interface AlumnoDAO {
	List<AlumnoDTO> obtenerTodosAlumnos();
	List<AlumnoDTO> obtenerAlumnosporIdyNombre(String nombre, String id);
	Integer insertarAlumno(String id, String nombre, String idMunicipio);
	Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa);
	Integer actualizaralumno(String idOld, String idNew, String nombre, String idMunicipio);
	Integer actualizaralumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa);
	Integer eliminarAlumno(String id);
	boolean esFamiliaNumerosa(String idAlumno);
}
