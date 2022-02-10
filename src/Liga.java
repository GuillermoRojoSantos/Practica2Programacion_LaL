import java.util.Arrays;

public class Liga {

	@Override
	public String toString() {
		return "Liga{" +
				"nombreLiga='" + nombreLiga + '\'' +
				", equipos=" + Arrays.toString(equipos) +
				", calendario=" + calendario +
				", arbitros=" + Arrays.toString(arbitros) +
				", clasificacion=" + clasificacion +
				'}';
	}

	public String getNombreLiga() {
		return nombreLiga;
	}

	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Arbitro[] getArbitros() {
		return arbitros;
	}

	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros = arbitros;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	private String nombreLiga;
	private Equipo[] equipos;
	private Calendario calendario;
	private Arbitro[] arbitros;
	private Clasificacion clasificacion;


	public String toStringEquipos(Equipo[] equipos) {
		
		String listaEquipos="";
		for(Equipo e:equipos ) {
			listaEquipos+=e.getNombre()+"\n";
		}
		return listaEquipos;
	
		
	}

	
	
}
