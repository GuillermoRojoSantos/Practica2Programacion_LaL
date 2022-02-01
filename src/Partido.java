
public class Partido {

	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Arbitro arbitro;
	private String fecha;
	
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

	@Override
	public String toString() {
		return "Partido{" +
				"equipoLocal=" + equipoLocal.getNombre() +
				", equipoVisitante=" + equipoVisitante.getNombre() +
				", arbitro=" + arbitro.getNombre() +
				", fecha='" + fecha + '\'' +
				'}';
	}
}
