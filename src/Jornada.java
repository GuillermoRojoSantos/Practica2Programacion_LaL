import java.util.Arrays;

public class Jornada {

	private Partido[] partidos;
	private int numJornada;
	private String duracionJornada;
	private boolean terminada=false;


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


	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}
	public void terminar() {
		this.terminada=true;
	}

	@Override
	public String toString() {
		return "Jornada "  + "\n" +
				Arrays.toString(partidos);
	}
}
