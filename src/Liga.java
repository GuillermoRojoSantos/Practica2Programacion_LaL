
public class Liga extends Arbitro{
	
	private String nombre;
	private Equipo[] equipos;
	private Calendario calendario;
	private Arbitro[] arbitros;
	private Clasificacion clasificacion;

	public void setLigaNombre (String nombre){
		this.nombre=nombre;
	}
	public String getLigaNombre (){
		return nombre;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
}
