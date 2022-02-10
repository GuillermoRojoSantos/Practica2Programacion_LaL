
public final class Jugador extends Persona{
	private String categoria;
	private String posicion;
	private int dorsal;
	private Equipo equipo;

	public static Jugador generarJugador(){
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Pique","Bale (lesionado)",
				"Amunike","N'kono","Butrague�o","Sanchis","Neymar","Batistuta","Maradona",
				"Pele","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};
		//Nombre Jugador
		Jugador jugador=new Jugador();
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		jugador.setNombre(nombre);
		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		jugador.setApellidos(apellido1+" "+apellido2);
		//Posicion
		numero = (int) Math.floor(Math.random()*posiciones.length);
		String posicion = posiciones[numero];
		jugador.setPosicion(posicion);
		//Edad
		numero = (int) Math.floor(Math.random()*(40-21));
		jugador.setEdad(numero);
		//Categoría
		jugador.setCategoria(jugador.getEdad());


		return jugador;
	}
	
	@Override
	public void setEdad(int edad) {
		super.setEdad(edad);
		categoria=setCategoria(edad);

	}

	public String getCategoria() {
		return categoria;
	}
	private String setCategoria(int edad) {
		switch(edad) {
		case 4:
		case 5:
			return "Chupetín";
		case 6:
		case 7:
			return "Prebenjamín";
		case 8:
		case 9:
			return "Benjamín";
		case 10:
		case 11:
			return "Alevín";
		case 12:
		case 13:
			return "Infantil";
		case 14:
		case 15:
			return "Cadete";
		case 16:
		case 17:
		case 18:
			return "Juvenil";
		default:
			return "N/A";
			
		}
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public String toString() {
		return super.toString()+", "+categoria+"\n"+
				"Equipo: "+equipo.getNombre()+"\n"+
				"Dorsal: "+dorsal+" Posición: "+posicion+"\n";
	}

	
}
