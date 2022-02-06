

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear una Lista de Equipo
		
		/*int edad = (int) Math.floor(Math.random()*15)+4;
		int numeroEquipos = (int) Math.floor(Math.random()*13)+4;
		Equipo[] listaEquipos = crearEquipos(numeroEquipos, edad);*/
		
		//Imprimimos los equipos
		/*System.out.println("Numero de equipos: "+numeroEquipos);
		for (Equipo e: listaEquipos) {
			System.out.println(e.getNombre());
		}*/
/*probamos creacion de partido*/
//		Equipo equipoLocal= new Equipo();
//		equipoLocal.setNombre("Barcelona");
//		Equipo equipoVisitante= new Equipo();
//		equipoVisitante.setNombre("Real Madrid");
//		Arbitro arbitro = new Arbitro();
//		arbitro.setNombre("Martinez Munuera");
//		String fecha= "12 de mayo";
//
//
//		for (Partido p: crearPartido(equipoLocal,equipoVisitante,arbitro,5,fecha,"19:00")) System.out.println(p+"\n");
		
		for(Jornada j: crearJornada(10,"3 dias")) {
			System.out.println(j+"\n");
		}

		
		

		

		


	}

	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
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

			//Posición
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


	private static Equipo[] crearEquipos(int numeroEquipos,int edad) {
		
		String [] nombreEquipos = {"Real Madrid", "Sevilla", "Betis", "Atlético de Madrid", "Barcelona", "Real Sociedad",
				"Villarreal","Rayo Vallecano", "Athletic de Bilbao", "Valencia C.F.", "Osasuna", "Celta de Vigo", "RCD Espanyol",
				"Granada","Elche C.F.", "Getafe", "R.C.D Mallorca", "Cádiz", "Alavés","Levante"};
		
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
								"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
								"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos= new Equipo[numeroEquipos];
		
		for (int i=0; i<numeroEquipos; i++) {
			//Creamos Equipo
			Equipo equipo = new Equipo();


			
			//Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*nombreEquipos.length);
			String barrio= nombreEquipos[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];

			//Definimos el club en base al nombre del barrio
			equipo.setClub(barrio+" F.C.");
			
			//Las pegamos con un "de" en medio
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}
			
			equipo.setNombre(nombre);
			//Continuamos con entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);
			
			//Meter los jugadores
			int numeroJugadores=(int) Math.floor(Math.random()*7)+15;
			Jugador[] jugadores = crearJugadores(numeroJugadores,edad,equipo);
			equipo.setJugadores(jugadores);
			
			//Meter el equipo en el array de equipos
			
			listaEquipos[i]=equipo;
			
			
		
		}
		return listaEquipos;
		
	}

	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
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

	/*private static Liga[] crearLiga(){
			Liga ligaFutbol=new Liga();
		ligaFutbol.setLigaNombre("BBVA");
		ligaFutbol.setEquipos(crearEquipos(10,10));
		
		System.out.println(ligaFutbol.toString());






	}*/
	private static Partido[] crearPartido(Equipo equipoLocal, Equipo equipoVisitante, Arbitro arbitro, int numPartidos, String fecha, String horaJuego){

		Partido [] listaPartidos= new Partido[numPartidos];
		

		for(int i=0;i<numPartidos;i++){

			Partido partido= new Partido();
			partido.setEquipoLocal(equipoLocal);
			partido.setEquipoVisitante(equipoVisitante);
			partido.setfecha(fecha);
			partido.setHoraJuego(horaJuego);
			partido.setArbitro(arbitro);

			listaPartidos[i]=partido;

		}





	/*	Partido partido= new Partido();
		partido.setEquipoLocal(equipoLocal);
		partido.setEquipoVisitante(equipoVisitante);
		partido.setArbitro(arbitro);
		partido.setfecha(fecha);
		partido.setHoraJuego(horaJuego);*/


		
		return listaPartidos;




	}


	private static Jornada [] crearJornada( int cantJornada, String duracionJornada){
		
//		Partido [] partido= new Partido[1]; 
		Equipo equipoLocal= new Equipo();
		equipoLocal.setNombre("Barcelona");
		Equipo equipoVisitante= new Equipo();
		equipoVisitante.setNombre("Real Madrid");
		Arbitro arbitro = new Arbitro();
		arbitro.setNombre("Martinez Munuera");
		String fecha= "12 de mayo";
		
		int numJornada=10;
		
		
		
		
		Jornada[] listaJornada= new Jornada [cantJornada];
		
		for(int i=0;i<cantJornada;i++) {
			Jornada jornada=new Jornada();
			Partido[] partido= crearPartido(equipoLocal,equipoVisitante,arbitro,5,"8 de mayo","18:00");
			jornada.setPartidos(partido);
			jornada.setNumJornada(numJornada);
			jornada.setDuracionJornada(duracionJornada);
			numJornada++;
			
			
			listaJornada[i]=jornada;
		}
		
		


		return listaJornada;

	}


}
