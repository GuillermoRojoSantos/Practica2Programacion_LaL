public class Calendario {
    private Jornada[] jornadas;
    
    public Calendario (Equipo[] equipos, Arbitro[] arbitros){
        int numeroEquipos = equipos.length;
        int numeroPartidos=numeroEquipos/2;
        int numeroJornadas=(numeroEquipos-1)*2;
        Equipo[][] emparejamientos= new Equipo[2][numeroPartidos];
        //Rellenar Columna 0
        for (int i=0; i<numeroPartidos;i++){
            emparejamientos[0][i]=equipos[i];
        }
        //rellenar columna 1
        for (int j=numeroPartidos-1;j>=0;j--){
            emparejamientos[0][j]=equipos[numeroEquipos-j];
        }
        this.jornadas=new Jornada[(numeroJornadas)];
        for (int i=0; i<jornadas.length/2;i++) {
            //reajustar tabla enfrebntamientos
            Equipo[][] auxEmp = new Equipo[2][numeroPartidos];
            for (int j=0; j<numeroPartidos; j++){//lado izquierdo
                if(j==0){
                    auxEmp[0][0]=emparejamientos[0][0];
                }else if(j>0 && j<numeroPartidos-1){
                    auxEmp[0][j+1]=emparejamientos[0][j];
                }else{
                    auxEmp[1][j]=emparejamientos[0][j];
                }
            }
            for (int k=0;k<numeroPartidos;k++){//lado derecho
                if(k==0){
                    auxEmp[0][1]=emparejamientos[1][0];
                }else {
                    auxEmp[1][k]=emparejamientos[1][k];
                }
            }
            emparejamientos=auxEmp;
            //Generamos dos arrays de partidos
            Partido[] partidosIda = new Partido[emparejamientos.length];
            Partido[] partidosVuelta = new Partido[emparejamientos.length];
            for (int j=0; j<emparejamientos[0].length;j++) {
                partidosIda[i].setEquipoLocal(emparejamientos[0][j]);
                partidosIda[i].setEquipoVisitante(emparejamientos[1][j]);
                partidosVuelta[i].setEquipoLocal(emparejamientos[1][j]);
                partidosVuelta[i].setEquipoVisitante(emparejamientos[0][j]);
            }
            //Asignamos los partidos a la de ida
            jornadas[i].setPartidos(partidosIda);
            //Asignamos los partidos a la de vuelta
            jornadas[i+jornadas.length-1].setPartidos(partidosVuelta);
        }
    }

	public Jornada[] getJornadas() {
		return jornadas;
	}

	public void setJornadas(Jornada[] jornadas) {
		this.jornadas = jornadas;
	}


	
}
