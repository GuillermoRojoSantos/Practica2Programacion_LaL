import java.util.Arrays;

public class Liga {
	
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
	
	public String toStringEquipos(Equipo[] equipos) {
		
		String listaEquipos="";
		for(Equipo e:equipos ) {
			listaEquipos+=e.getNombre()+"\n";
		}
		return listaEquipos;
	
		
	}
	@Override
	public String toString() {
		return "Nombre Liga: " + nombre +"\n" +"Equipos: "+ "\n" + toStringEquipos(this.equipos);
	}
	
	
}
