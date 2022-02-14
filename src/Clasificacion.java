import java.util.Arrays;

public class Clasificacion {
	
	private EquipoClasificacion[] tabla;
	
	public Clasificacion(Equipo[] equipos, Calendario calendario) {
		int numeroEquipos=equipos.length;
			
		this.tabla= new EquipoClasificacion[numeroEquipos];
		
		//crear tabla clasificacion
		for(int i=0; i<numeroEquipos; i++) {
			this.tabla[i]= new EquipoClasificacion();
			this.tabla[i].setEquipo(equipos[i]);
		}
		//tenemos que cambiar el numero de jornadas a jugar
		
		//Rellenamos la tabla de clasificacion
		Jornada [] jornadas = calendario.getJornadas();
		
		for (Jornada jor: jornadas) {
			Partido [] partidos= jor.getPartidos();
			for (Partido par: partidos) {
				//quien es el local
				Equipo local = par.getEquipoLocal();
				//quien es el visitante
				Equipo visitante = par.getEquipoVisitante();
				
				//Buscarlos en la clasificacion
				int contador = 0 ;	
				EquipoClasificacion localClas = tabla[contador];
				while (localClas.getEquipo()!= local) {
					contador++;
					localClas=tabla[contador];
				}
				contador = 0;
				EquipoClasificacion visitClas= tabla[contador];
				
				while (visitClas.getEquipo()!= visitante) {
					contador++;
					visitClas=tabla[contador];
				}
				//Veamos los goles
				
				int golesLocal= par.getGolesLocal();
				int golesVisitante = par.getGolesVisitante();
				
				//Actualizamos tabla
				//Resolvemos goles
				localClas.addGolesFavor(golesLocal);
				localClas.addGolesContra(golesVisitante);
				visitClas.addGolesFavor(golesVisitante);
				visitClas.addGolesContra(golesLocal);
				
				
				//Resolvemos puntos
				if ( golesLocal>golesVisitante) { //Victoria local
					localClas.addPartidoGanado();
					visitClas.addPartidoPerdido();
				}else if (golesVisitante>golesLocal){//victoria visitante
					visitClas.addPartidoGanado();
					visitClas.addPartidoPerdido();
				}else {//empate
					visitClas.addPartidoEmpatado();
					localClas.addPartidoEmpatado();
				}
			}
		}
		
		//Reordenamos la tabla
	}

	public EquipoClasificacion[] getTabla() {
		return tabla;
	}

	public void setTabla(EquipoClasificacion[] tabla) {
		this.tabla = tabla;
	}

	@Override
	public String toString() {
		String cadena=  "Equipo\t\t"+ "puntos\t" + "jugados\t" +  
				 "ganados\t" + " E\t"  + "P\t" + "gF\t"+  "gC\t"
				 + "dfG\t" + "/n";
		
		for ( EquipoClasificacion eqclas: this.tabla) {
			cadena+=eqclas;
		}
		return cadena;
	}
	
	
	

	
}