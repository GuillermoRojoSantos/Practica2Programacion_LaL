
public class Partido {

	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Arbitro arbitro;
	private String fecha;
	private String horaJuego;
	
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	public String getfecha() {
		return fecha;
	}
	public void setfecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraJuego() {
		return horaJuego;
	}

	public void setHoraJuego(String horaJuego) {
		this.horaJuego = horaJuego;
	}
	@Override
	public String toString() {
		return "Partido:"+" "+"\n"+ "Fecha:"+" " +fecha+
				"\n"+"Equipo Local: " + equipoLocal.getNombre()+" VS " +
				 equipoVisitante.getNombre() +" Equipo Visitante"  +
				"\n"+ "Arbitro: " + arbitro.getNombre()+" \n"+"Hora juego "+horaJuego+"\n";

	}
}
