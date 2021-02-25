package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dto.ComboDTO;

public interface ComboDAO {
	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
}
