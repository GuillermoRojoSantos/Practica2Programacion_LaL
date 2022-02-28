import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Creamos una liga
        final String nombreLiga= "Liga de la L";
        final int equipos=20;
        final int edad=12;
        final int JORNADASJUGADAS=15;

        Equipo[] misEquipos = crearEquipos(equipos, edad);
        Arbitro[] misArbitros= crearArbitros(equipos/2);


        Liga miLiga = new Liga(nombreLiga,misEquipos,misArbitros);
        Calendario miCalendario = miLiga.getCalendario();
        crearPartidosSilencioso(miLiga.getCalendario(), JORNADASJUGADAS);
        Clasificacion clasificacionLiga = new Clasificacion (misEquipos,miCalendario);

        imprimirMenu();
        int opcionMenu= sc.nextInt();
        while (opcionMenu!=10){
            switch (opcionMenu){
                case 1:
                    System.out.println(miLiga.getClasificacion());
                    break;
                case 2:
                    System.out.println(miLiga.getCalendario());
                    break;

                case 3:
                    //aqui se introduciran los resultados
                    break;


                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            esperarPulsacion();
            limpiarPantalla();
            imprimirMenu();
            opcionMenu=sc.nextInt();
        }

    }

    /*UTILIDADES*/
    public static void imprimirMenu(){
        System.out.println("*************************************************************************************************************");
        System.out.println("*************************************** Bienvenido a la liga ************************************************");
        System.out.println("                                         1 Ver clasificaciones.");
        System.out.println("                                         2 Ver Calendarios.");
        System.out.println("                                         3 Introducir Resultados.");
        System.out.println("                                         10 Salir");
        System.out.println("*************************************************************************************************************");
    }
    private static void limpiarPantalla() {
        for (int i = 0 ; i < 10 ; i++)
        {
            System.out.println();
        }
    }
    private static void esperarPulsacion(){
        Scanner sc= new Scanner(System.in);
        sc.nextLine();
    }
    private static String leerPulsacion(){
        Scanner sc= new Scanner(System.in);
        String resultado= sc.nextLine();
        return resultado;
    }
    private static int leerNumero(){
        Scanner sc= new Scanner(System.in);
        int resultado= sc.nextInt();
        return resultado;
    }

    /*CREADORES DE OBJETOS (ARRAYS)*/
    private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
        //Listado de Nombres, Apellidos, Posiciones para generador random
        String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
                "Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
                "Sasha","Billie","Masha","Pingu"};
        String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqu�","Bale (lesionado)",
                "Amunike","N'kono","Butrague�o","Sanch�s","Neymar","Batistuta","Maradona",
                "Pel�","Beckenbauer"};
        String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};

        //Estructura de Array de Jugadores
        Jugador[] jugadores = new Jugador[numeroJugadores];

        for (int i=0; i < numeroJugadores; i++) {
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

            //Posici�n
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

            //Imprime jugadores de los equipos creados anteriormente.
            //System.out.println(jug);
        }

        return jugadores;
    }
    public static Arbitro[] crearArbitros(int numArbitros){
        //Listado de Nombres, Apellidos, Posiciones para generador random
        String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
                "Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
                "Sasha","Billie","Masha","Pingu"};
        String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
                "Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
                "Pelé","Beckenbauer"};
        Arbitro[] arbitros=new Arbitro[numArbitros];

        for(int i=0; i<numArbitros; i++) {
            Arbitro arbitro = new Arbitro();

            //Nombre
            int numero = (int) Math.floor(Math.random() * nombres.length);
            String nombre = nombres[numero];
            arbitro.setNombre(nombre);

            //Apellidos
            numero = (int) Math.floor(Math.random() * apellidos.length);
            String apellido1 = apellidos[numero];
            numero = (int) Math.floor(Math.random() * apellidos.length);
            String apellido2 = apellidos[numero];
            arbitro.setApellidos(apellido1 + " " + apellido2);

            //Edad
            int edad = (int) Math.floor(Math.random() * 47) + 18;
            arbitro.setEdad(edad);
            //Licencia
            int licencia = (int) Math.floor(Math.random() * 100000);
            arbitro.setLicencia(licencia);


            arbitros[i] = arbitro;

        }
        return arbitros;
    }
    private static Equipo[] crearEquipos(int numeroEquipos,int edad) {

        String [] nombreBarrios = {"El Candado", "Huelin", "Tiro Pich�n", "Rinc�n de la Victoria", "La Rosaleda", "Torremolinos",
                "Velez M�laga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
                "Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva M�laga", "Casas Blancas",
                "La Palmilla","Los Asperones","Campanillas","La Corta"};
        String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
                "Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
                "Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

        Equipo [] listaEquipos= new Equipo[numeroEquipos];

        for (int i=0; i<numeroEquipos; i++) {
            //Creamos Equipo
            Equipo equipo = new Equipo();

            //Elegimos random un nombre y una mascota de las listas respectivas.
            int numero = (int) Math.floor(Math.random()*nombreBarrios.length);
            String barrio= nombreBarrios[numero];
            numero = (int) Math.floor(Math.random()*mascotas.length);
            String mascota= mascotas[numero];


            //Definimos el club en base al nombre del barrio
            equipo.setClub(barrio+" F.C.");

            //Las pegamos con un "de" en medio
            String nombre;
            if (barrio.startsWith("El "))
            {
                barrio = barrio.substring(3);
                nombre = mascota + " del "+ barrio;
            }
            else
            {
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


            listaEquipos[i] = equipo;
            //System.out.println("*************************************************************************************************************");
        }
        return listaEquipos;

    }

    /*CREADORES DE OBJETOS  (UN SOLO OBJETO)*/
    private static Entrenador crearEntrenador(Equipo equipo) {
        //Listado de Nombres, Apellidos, Posiciones para generador random
        String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
                "Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
                "Sasha","Billie","Masha","Pingu"};
        String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqu�","Bale (lesionado)",
                "Amunike","N'kono","Butrague�o","Sanch�s","Neymar","Batistuta","Maradona",
                "Pel�","Beckenbauer"};
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

        //System.out.println(entrenador);

        return entrenador;
    }
    private static Arbitro crearArbitro() {
        //Listado de Nombres, Apellidos, Posiciones para generador random
        String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
                "Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
                "Sasha","Billie","Masha","Pingu"};
        String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
                "Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
                "Pelé","Beckenbauer"};
        Arbitro arbitro = new Arbitro();

        //Nombre
        int numero = (int) Math.floor(Math.random()*nombres.length);
        String nombre = nombres[numero];
        arbitro.setNombre(nombre);

        //Apellidos
        numero = (int) Math.floor(Math.random()*apellidos.length);
        String apellido1 = apellidos[numero];
        numero = (int) Math.floor(Math.random()*apellidos.length);
        String apellido2 = apellidos[numero];
        arbitro.setApellidos(apellido1+" "+apellido2);

        //Edad
        int edad = (int) Math.floor(Math.random()*47)+18;
        arbitro.setEdad(edad);
        //Licencia
        int licencia = (int) Math.floor(Math.random()*100000);
        arbitro.setLicencia(licencia);

        return arbitro;
    }

    /*OPCIONES DEL MENU*/
   /* private static void verClasificacion(){

        Clasificacion clasificacion = new Clasificacion (misEquipos,miCalendario);
        System.out.println(clasificacion);

    }*/
    private static void verCalendario(){
        //Crear una liga
        final int EQUIPOS=20;
        final int EDAD=12;
        final String NOMBRELIGA="Liga Profesional";
        final int JORNADASJUGADAS=15;

        Equipo[] misEquipos = crearEquipos(EQUIPOS, EDAD);

        Arbitro[] arbitros= new Arbitro[EQUIPOS/2];
        for (int i=0; i<arbitros.length;i++) {
            arbitros[i]=crearArbitro();
        }

        Liga miLiga = new Liga(NOMBRELIGA,misEquipos,arbitros);
        System.out.println(miLiga.getCalendario());

    }





    private static void generarPartidos(Calendario calendario, int jornadasJugadas) {
        Jornada [] jornadas = calendario.getJornadas();
        int totalJornadas = jornadas.length;
        final int MAXIMOGOLES=7;

        for (int i=0; i<jornadasJugadas && i<totalJornadas;i++) {

            Partido [] partidos = jornadas[i].getPartidos();

            for (Partido par: partidos) {
                int golesLocales = (int) Math.floor(Math.random()*MAXIMOGOLES);
                int golesVisitantes = (int) Math.floor(Math.random()*MAXIMOGOLES);
                par.setgLocal(golesLocales);
                par.setgVisitante(golesVisitantes);
                System.out.println(par);
            }
            jornadas[i].terminar();
        }

    }

    /*private static void crearLiga() {
        //Crear una liga
        final int EQUIPOS=20;
        final int EDAD=12;
        final String NOMBRELIGA="Liga Profesional";
        final int JORNADASJUGADAS=15;

        Equipo[] misEquipos = crearEquipos(EQUIPOS, EDAD);

        Arbitro[] arbitros= new Arbitro[EQUIPOS/2];
        for (int i=0; i<arbitros.length;i++) {
            arbitros[i]=crearArbitro();
        }

        Liga miLiga = new Liga(NOMBRELIGA,misEquipos,arbitros);
        System.out.println(miLiga.getCalendario());


        Calendario miCalendario = miLiga.getCalendario();
        generarPartidos(miCalendario,JORNADASJUGADAS);

        Clasificacion clasificacion = new Clasificacion (misEquipos,miCalendario);
        System.out.println(clasificacion);


    }*/

    private static void crearLiga(){

    }



    private static void crearPartidosSilencioso(Calendario calendario, int jornadasJugadas){
        Jornada [] jornadas = calendario.getJornadas();
        int totalJornadas = jornadas.length;
        final int MAXIMOGOLES=7;

        for (int i=0; i<jornadasJugadas && i<totalJornadas;i++) {

            Partido [] partidos = jornadas[i].getPartidos();

            for (Partido par: partidos) {
                int golesLocales = (int) Math.floor(Math.random()*MAXIMOGOLES);
                int golesVisitantes = (int) Math.floor(Math.random()*MAXIMOGOLES);
                par.setgLocal(golesLocales);
                par.setgVisitante(golesVisitantes);
            }
            jornadas[i].terminar();
        }

    }











    /*private Liga createLiga(){
        final String nombreLiga= "Liga de la L";
        final int equipos=20;
        final int edad=12;
        final int JORNADASJUGADAS=15;

        Equipo[] misEquipos = crearEquipos(equipos, edad);
        Arbitro[] misArbitros= crearArbitros(equipos/2);

        Liga miLiga = new Liga(nombreLiga,misEquipos,misArbitros);

        return miLiga;
    }*/

//falta acabarla
    //esta clase se usa para que el usuario pueda crear una liga desde cero
    private Liga crearLigaAMano(){

       //"Creamos" el objeto de liga y a continuacion le añadiremos
      // atributos poco a poco

        //nombre Liga
        System.out.println("Introduzca nombre de la Liga");
        String nombreLiga=leerPulsacion();
        esperarPulsacion();
        //Equipos liga
        System.out.println("Introduzca cuantos equipos: ");
        int numEquipos=leerNumero();
        esperarPulsacion();
        System.out.println("Introduzca edad equipos: ");
        int edadEquipos=leerNumero();
        esperarPulsacion();
        //Arbitros Liga
        System.out.println("Introduzca cuantos arbitros: ");
        int numArbitros=leerNumero();
        Liga liga= new Liga(nombreLiga,crearEquipos(numEquipos,edadEquipos),crearArbitros(numArbitros));

        Calendario calendario=liga.getCalendario();


        return liga;
    }

}
