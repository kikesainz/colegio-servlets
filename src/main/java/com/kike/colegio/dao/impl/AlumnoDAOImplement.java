package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dto.AlumnoDTO;
import com.kike.colegio.utils.DBUtils;

public class AlumnoDAOImplement implements AlumnoDAO {

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() {

		try {
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement();
			ResultSet rs;
			rs = st.executeQuery("SELECT * FROM alumnos");

			List<AlumnoDTO> listaAlumnos = new ArrayList<>();

			while (rs.next()) {

				AlumnoDTO a = new AlumnoDTO(rs.getInt(1), rs.getString(2), "");
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
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(String nombre, String id) {
		//String sql = "SELECT * FROM alumnos WHERE nombre LIKE ? AND id LIKE ?";
		
		String sql = "SELECT a.id, a.nombre, m.nombre, m.id_municipio, a.familia_numerosa FROM alumnos a JOIN  municipios m ON a.id_municipio = m.id_municipio WHERE a.nombre LIKE ? AND a.id LIKE ? ";

		Connection connection = DBUtils.DBConnection();
		ResultSet alumnoRs = null;
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + nombre + "%");
			ps.setString(2, "%" + id + "%");

			alumnoRs = ps.executeQuery();

			while (alumnoRs.next()) {
				AlumnoDTO a = new AlumnoDTO(alumnoRs.getInt(1), alumnoRs.getString(2), alumnoRs.getString(3), alumnoRs.getInt(4), alumnoRs.getInt(5));
				listaAlumnos.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaAlumnos;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio) {
		String sql = "INSERT INTO alumnos VALUES (?, ?, ?)";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public Integer actualizaralumno(String idOld, String idNew, String nombre, String idMunicipio) {
		String sql = "UPDATE alumnos SET id=?, nombre=?, id_municipio=? WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			ps.setString(4, idOld);
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	
	}

	@Override
	public Integer eliminarAlumno(String id) {
		
		
		String sql = "DELETE FROM alumnos WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa) {
		String sql = "INSERT INTO alumnos VALUES (?, ?, ?, ?)";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			if (famNumerosa == null) {
				ps.setInt(4, 0);
			}else {
				ps.setString(4, famNumerosa);
			}			
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public Integer actualizaralumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa) {
		String sql = "UPDATE alumnos SET id=?, nombre=?, id_municipio=?, familia_numerosa=? WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			if (famNumerosa == null) {
				famNumerosa = "0";
				ps.setString(4, famNumerosa);
			}else {
				famNumerosa = "1";
				ps.setString(4, famNumerosa);
			}
			ps.setString(5, idOld);
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}
	
	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		String sql = "SELECT familia_numerosa FROM alumnos WHERE id LIKE ?";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int famNumerosa = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idAlumno);					
			
			rs = ps.executeQuery();
			rs.next();
			famNumerosa = rs.getInt(1);
			
			if(famNumerosa==1) {
				return true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}

	


}
