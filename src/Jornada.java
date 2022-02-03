import java.util.Arrays;

public class Jornada {
	
	private Partido [] partidos;
	private  int numJornada;
	private  String duracionJornada;
	private  String horaJuego;

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

	public String getDuracionJornada() {
		return duracionJornada;
	}

	public void setDuracionJornada(String duracionJornada) {
		this.duracionJornada = duracionJornada;
	}

	public String getHoraJuego() {
		return horaJuego;
	}

	public void setHoraJuego(String horaJuego) {
		this.horaJuego = horaJuego;
	}

	@Override
	public String toString() {
		return "Jornada{" +
				"partidos=" + Arrays.toString(partidos) +
				", numJornada=" + numJornada +
				", duracionJornada='" + duracionJornada + '\'' +
				", horaJuego='" + horaJuego + '\'' +
				'}';
	}
}
