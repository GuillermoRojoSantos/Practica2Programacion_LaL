import java.util.Arrays;

public class Jornada {
	
	private Partido [] partidos;
	private  int numJornada;
	private  String duracionJornada;


	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}

	public int getNumJornada() {
		return numJornada;
	}

	public void setNumJornada(int numJornada) {
		this.numJornada = numJornada;
	}


	@Override
	public String toString() {
		return "Jornada "+getNumJornada()+"\n" +
				  Arrays.toString(partidos);
	}
}
