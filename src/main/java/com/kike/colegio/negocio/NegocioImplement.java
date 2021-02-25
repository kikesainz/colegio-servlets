package com.kike.colegio.negocio;


import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImplement;
import com.kike.colegio.dao.impl.AsignaturaDAOImplement;

public class NegocioImplement implements INegocio{
	
	@Override
	public Double calcularTasa(String idAlumno, String idAsignatura) {
		
		AsignaturaDAO asig = new AsignaturaDAOImplement();
		AlumnoDAO al = new AlumnoDAOImplement();
		
		int numAsigMatriculadas = asig.obtenerNumeroAsignaturasMatriculadas(idAlumno); 
		Double tasa =asig.obtenerTasaAsignatura(idAsignatura);
		
		if ((numAsigMatriculadas >= 3) && (numAsigMatriculadas <= 5)) { //70%
			tasa = tasa * 0.7;
		}else if(numAsigMatriculadas >= 6) { //50%
			tasa = tasa * 0.5;
		}
		
		if(al.esFamiliaNumerosa(idAlumno)) {//Si es un alumno con familia numerosa -> 50%
			tasa = tasa * 0.5; 
		}		
		
		return tasa;
		
	}
}
