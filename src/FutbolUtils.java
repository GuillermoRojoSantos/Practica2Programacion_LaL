
public class FutbolUtils {
	 public void guardarEquipo (String nombreArchivo, Equipo equipo) {
		 
		 equipo= crearUnEquipo();
		 String nombre= equipo.getNombre()+".txt";

         //Este método recibe unequipo y un nombre de archivo y guarda el equipo

        //en un archivo con ese nombre

  }

 

  public Equipo cargarEquipo (String nombreArchivo) {

         //Este método recibe unnombre de Archivo y devuelve un equipo

  }

 

  public Equipo ordenarEquipo (Equipo equipo) {

         //Este método recibe un Equipo y ordena sus jugadores por apellidos y en

        //caso de igualdad de apellidos por nombre

  }

 

  //Añade las clases que consideres necesarias

  public static Equipo crearUnEquipo() {
		
		String [] nombreEquipos = {"Real Madrid", "Sevilla", "Betis", "Atletico de Madrid", "Barcelona", "Real Sociedad",
				"Villarreal","Rayo Vallecano", "Athletic de Bilbao", "Valencia C.F.", "Osasuna", "Celta de Vigo", "RCD Espanyol",
				"Granada","Elche C.F.", "Getafe", "R.C.D Mallorca", "Cadiz", "Alaves","Levante"};
		
		int numero = (int) Math.floor(Math.random()*nombreEquipos.length);
		
		String nombre= nombreEquipos[numero];
		
		
		Equipo equipo= new Equipo();
		equipo.setNombre(nombre);
		
		Entrenador entrenador= new Entrenador();
		entrenador= crearEntrenador(equipo);
		
		equipo.setEntrenador(entrenador);
		
		Jugador[] jugador = crearJugadores(10,12,equipo);
		equipo.setJugadores(jugador);
		
		return equipo;
		
	}
  private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "PiquÃ©","Bale (lesionado)",
				"Amunike","N'kono","ButragueÃ±o","SanchÃ­s","Neymar","Batistuta","Maradona",
				"PelÃ©","Beckenbauer"};
		Entrenador entrenador = new Entrenador();
		
		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		entrenador.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		entrenador.setApellidos(apellido1+" "+apellido2);
		
		//Equipo
		entrenador.setEquipo(equipo);
		
		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		entrenador.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		entrenador.setNumeroLicencia(licencia);
		
		return entrenador;
	}
  private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Pique","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchis","Neymar","Batistuta","Maradona",
				"Pele","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};
		
		//Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];
		
		for (int i=0; i<numeroJugadores; i++) {
			//Crear un Jugador
			Jugador jug = new Jugador();
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			jug.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//PosiciÃ³n
			numero = (int) Math.floor(Math.random()*posiciones.length);
			String posicion = posiciones[numero];
			jug.setPosicion(posicion);

			//Edad
			jug.setEdad(edad);

			//Dorsal
			jug.setDorsal(i+1);
			
			//Equipo
			jug.setEquipo(equipo);

			jugadores[i]=jug;

		}
		
		return jugadores;
	}


}
