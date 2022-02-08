import java.util.Arrays;

public class Partido {

	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Arbitro arbitro;
	private String horaJuego;
	private int golesLocal;
	private int golesVisitante;
	
	
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
	
	
	public String getHoraJuego() {
		return horaJuego;
	}

	public void setHoraJuego(String horaJuego) {
		this.horaJuego = horaJuego;
	}
	@Override
	public String toString() {
		return "EquipoLocal " + equipoLocal.getNombre()+" VS " +  equipoVisitante.getNombre()  +
	          " equipoVisitante"+"\n" + "Arbitro " + arbitro.getNombre()+" "+arbitro.getApellidos()
				+"\n" + " horaJuego " + horaJuego+"\n"+"\n" ;
	}
