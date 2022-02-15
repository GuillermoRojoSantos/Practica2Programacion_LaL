import java.util.Arrays;

public class Clasificacion {

	private EquipoClasificacion[] tabla;

	public Clasificacion(Equipo[] equipos, Calendario calendario) {
		int numeroEquipos = equipos.length;

		this.tabla = new EquipoClasificacion[numeroEquipos];

		// crear tabla clasificacion
		for (int i = 0; i < numeroEquipos; i++) {
			this.tabla[i] = new EquipoClasificacion();
			this.tabla[i].setEquipo(equipos[i]);
		}
		// tenemos que cambiar el numero de jornadas a jugar

		// Rellenamos la tabla de clasificacion
		Jornada[] jornadas = calendario.getJornadas();

		for (Jornada jor : jornadas) {
			if (jor.isTerminada()) {

				Partido[] partidos = jor.getPartidos();
				for (Partido par : partidos) {
					// quien es el local
					Equipo local = par.getEquipoLocal();
					// quien es el visitante
					Equipo visitante = par.getEquipoVisitante();

					// Buscarlos en la clasificacion
					int contador = 0;
					EquipoClasificacion localClas = tabla[contador];
					while (localClas.getEquipo() != local) {
						contador++;
						localClas = tabla[contador];
					}
					contador = 0;
					EquipoClasificacion visitClas = tabla[contador];

					while (visitClas.getEquipo() != visitante) {
						contador++;
						visitClas = tabla[contador];
					}
					// Veamos los goles

					int golesLocal = par.getGolesLocal();
					int golesVisitante = par.getGolesVisitante();

					// Actualizamos tabla
					// Resolvemos goles
					localClas.addGolesFavor(golesLocal);
					localClas.addGolesContra(golesVisitante);
					visitClas.addGolesFavor(golesVisitante);
					visitClas.addGolesContra(golesLocal);

					// Resolvemos puntos
					if (golesLocal > golesVisitante) { // Victoria local
						localClas.addPartidoGanado();
						visitClas.addPartidoPerdido();
					} else if (golesVisitante > golesLocal) {// victoria visitante
						visitClas.addPartidoGanado();
						visitClas.addPartidoPerdido();
					} else {// empate
						visitClas.addPartidoEmpatado();
						localClas.addPartidoEmpatado();
					}
				}
			}

		}

		// Reordenamos la tabla

		ordenar();
	}

	private void ordenar() {
		int n = tabla.length;
		EquipoClasificacion temp = null;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (vaDebajo(tabla[j - 1], tabla[j])) {
					// swap elements
					temp = tabla[j - 1];
					tabla[j - 1] = tabla[j];
					tabla[j] = temp;
				}

			}
		}

	}

	private boolean vaDebajo(EquipoClasificacion equipo1, EquipoClasificacion equipo2) {
		if (equipo1.getPuntos() < equipo2.getPuntos()) { // primer criterio puntos
			return true;
		} else if (equipo1.getPuntos() > equipo2.getPuntos()) {
			return false;
		} else { // A igualdad de puntos diferencia de goles
			if (equipo1.getDifGoles() < equipo2.getDifGoles()) {
				return true;
			} else if (equipo1.getDifGoles() > equipo2.getDifGoles()) {
				return false;
			} else {// A igualdad de puntos y dif goles. Partidos ganados
				if (equipo1.getGanados() < equipo2.getGanados()) {
					return true;
				} else {
					return false;
				}
			}
		}

	}

	public EquipoClasificacion[] getTabla() {
		return tabla;
	}

	public void setTabla(EquipoClasificacion[] tabla) {
		this.tabla = tabla;
	}

	@Override
	public String toString() {
		String cadena = "Equipo\t\t" + "puntos\t" + "jugados\t" + "ganados\t" + " E\t" + "P\t" + "gF\t" + "gC\t"
				+ "dfG\t" + "/n";

		for (EquipoClasificacion eqclas : this.tabla) {
			cadena += eqclas;
		}
		return cadena;
	}

}