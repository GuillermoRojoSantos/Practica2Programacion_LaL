public class Calendario  {

	private Liga liga;
	private Jornada[] jornada;
	private int fecha;
	
	
	public Calendario(Liga liga) {
		this.liga=liga;
		generarCalendario();
		
	}
	

	private void generarCalendario() {
		Equipo[] equipos=liga.getEquipos();
		Equipo[][] enfrentamientos= new Equipo[2][equipos.length/2];
		Jornada[] jornadas= new Jornada[(equipos.length-1)*2];
		//mitad izquierda
		for (int i=0;i<equipos.length/2;i++ ) {
		    enfrentamientos[0][i]=equipos[i];
		}
		//mitad derecha
		for (int j=equipos.length/2-1;j>=0;j--) {
		    enfrentamientos[1][j]=equipos[equipos.length-1-j];
		}
		//Generamos las jornadas
		for (int i=0; i<jornadas.length/2;i++) {

		    //Generamos dos arrays de partidos
		    Partido[] partidosIda = new Partido[enfrentamientos.length];
		    Partido[] partidosVuelta = new Partido[enfrentamientos.length];

		    for (int j=0; j<enfrentamientos[0].length;j++) {
		        partidosIda[i].setEquipoLocal(enfrentamientos[0][j]);
		        partidosIda[i].setEquipoVisitante(enfrentamientos[1][j]);
		        
		        partidosVuelta[i].setEquipoLocal(enfrentamientos[1][j]);
		        partidosVuelta[i].setEquipoVisitante(enfrentamientos[0][j]);
		    }
		    //Asignamos los partidos a la de ida
		    jornadas[i].setPartidos(partidosIda);
		    //Asignamos los partidos a la de vuelta
		    jornadas[i+jornadas.length-1].setPartidos(partidosVuelta);
		    
		    
		    //Mover la tabla de enfrentamientos
		}
		
	}


	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public Jornada[] getJornada() {
		return jornada;
	}

	public void setJornada(Jornada[] jornada) {
		this.jornada = jornada;
	}
	
}
