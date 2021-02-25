package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dto.ComboDTO;
import com.kike.colegio.utils.DBUtils;

public class ComboDAOImplement implements ComboDAO{

	@Override
	public List<ComboDTO> comboMunicipios() {
		
		String sql = "SELECT * FROM municipios ORDER BY nombre";
		List<ComboDTO> listaMunicipios = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {

				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(5));
				listaMunicipios.add(a);

			}

			return listaMunicipios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return null;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		String sql = "SELECT * FROM alumnos ORDER BY nombre";
		List<ComboDTO> listaAlumnos = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {

				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(2));
				listaAlumnos.add(a);

			}

			return listaAlumnos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return null;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		String sql = "SELECT * FROM asignaturas ORDER BY nombre";
		List<ComboDTO> listaAsignaturas = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {

				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(2));
				listaAsignaturas.add(a);

			}

			return listaAsignaturas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return null;
	}

}
