
public class EquipoClasificacion {
	private Equipo equipo;
	private int puntos;
	private int jugados;
	private int ganados;
	private int empatados;
	private int perdidos;
	private int gFavor;
	private int gContra;
	private int difGoles;
	

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getJugados() {
		return jugados;
	}

	public void setJugados(int jugados) {
		this.jugados = jugados;
	}

	public int getEmpatados() {
		return empatados;
	}

	public void setEmpatados(int empatados) {
		this.empatados = empatados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}

	public int getgFavor() {
		return gFavor;
	}

	public void setgFavor(int gFavor) {
		this.gFavor = gFavor;
	}

	public int getgContra() {
		return gContra;
	}

	public void setgContra(int gContra) {
		this.gContra = gContra;
	}

	public int getDifGoles() {
		return difGoles;
	}

	public void setDifGoles(int difGoles) {
		this.difGoles = difGoles;
	}
	
	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public void addGolesFavor (int goles) {
		this.gFavor+=goles;
		this.difGoles+=goles;
	}
	
	public void addGolesContra (int goles) {
		this.gContra+=goles;
		this.difGoles-=goles;
	}
	
	public void addPartidoGanado() {
		this.ganados++;
		this.puntos+=3;
		this.jugados++;
	}
	public void addPartidoPerdido() {
		this.jugados++;
		this.perdidos++;
	}
	public void addPartidoEmpatado() {
		this.jugados++;
		this.empatados++;
		this.puntos++;
		
	}

	@Override
	public String toString() {
		return  equipo.getNombre() +"\t\t"+ "puntos=" + puntos  + jugados +  "\t"
				+ ganados + ", empatados=" + empatados + ", perdidos=" + perdidos + ", gFavor=" + gFavor + ", gContra="
				+ gContra + ", difGoles=" + difGoles + "/n";
	}
}
