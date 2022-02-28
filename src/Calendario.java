import java.util.Arrays;

public class Calendario {
	private Jornada[] jornadas;



	public Calendario(Equipo[] equipos,Arbitro[] arbitros) {

		int numeroEquipos = equipos.length;
		int numeroPartidos = numeroEquipos/2;
		int numeroJornadas = (numeroEquipos-1)*2;

		Equipo [][] emparejamientos = new Equipo[2][numeroPartidos];
		//Rellenar la columna 0
		for (int i=0;i<numeroPartidos;i++) {
			emparejamientos[0][i]=equipos[i];
		}
		//Rellenar la columna 1
		for (int j=numeroPartidos-1;j>=0;j--) {
			emparejamientos[1][j]=equipos[numeroEquipos-1-j];
		}


		this.jornadas = new Jornada[numeroJornadas];

		for (int i=0; i<numeroJornadas/2;i++) {

			Partido[] partidosIda = new Partido[numeroPartidos];
			Partido[] partidosVuelta = new Partido[numeroPartidos];

			for (int j=0; j<numeroPartidos; j++) {
				//Jornada Ida
				partidosIda[j] = new Partido();
				partidosIda[j].setLocal(emparejamientos[0][j]);
				partidosIda[j].setVisitante(emparejamientos[1][j]);
				partidosIda[j].setArbitro(arbitros[j]);

				//Jornada Vuelta
				partidosVuelta[j] = new Partido();
				partidosVuelta[j].setLocal(emparejamientos[1][j]);
				partidosVuelta[j].setVisitante(emparejamientos[0][j]);
				partidosVuelta[j].setArbitro(arbitros[j]);
			}

			//Metemos los datos en cada jornada
			jornadas[i]=new Jornada();
			jornadas[i].setPartidos(partidosIda);
			jornadas[jornadas.length-1-i]=new Jornada();
			jornadas[jornadas.length-1-i].setPartidos(partidosVuelta);

			//Reajustar Tabla Emparejamientos
			Equipo[][] auxEmp = new Equipo[2][numeroPartidos];
			for (int k=0;k<numeroPartidos;k++) {//lado izquierdo
				if (k==0) {
					auxEmp[0][0]=emparejamientos[0][0];
				}else if (k>0 && k<numeroPartidos-1) {
					auxEmp[0][k+1]=emparejamientos[0][k];
				}else {
					auxEmp[1][k]=emparejamientos[0][k];
				}
			}
			for (int k=0;k<numeroPartidos;k++) {//lado derecho
				if (k==0) {
					auxEmp[0][1]=emparejamientos[1][0];
				}else {
					auxEmp[1][k-1]=emparejamientos[1][k];
				}
			}
			emparejamientos=auxEmp;
		}


	}

	public Jornada[] getJornadas() {
		return jornadas;
	}

	public void setJornadas(Jornada[] jornadas) {
		this.jornadas = jornadas;
	}

	@Override
	public String toString() {
		String cadena="Calendario Oficial: \n";
		for (int i=0;i<this.jornadas.length;i++) {
			cadena+=(i+1)+"ª "+jornadas[i]+"\n";
		}
		return cadena;
	}



}
