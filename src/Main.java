import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Creamos una liga
        final String nombreLiga= "Liga de la L";
        final int equipos=20;
        final int edad=12;
        final int JORNADASJUGADAS=38;

        Equipo[] misEquipos = crearEquipos(equipos, edad);
        Arbitro[] misArbitros= crearArbitros(equipos/2);


        Liga miLiga = new Liga(nombreLiga,misEquipos,misArbitros);
        crearPartidosSilencioso(miLiga, JORNADASJUGADAS);
        Clasificacion clasificacionLiga = new Clasificacion (miLiga.getEquipos(),miLiga.getCalendario());

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
                    añadirResultados(miLiga);
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
    /*Este método crea partidos para rellenar el calendario introducido sin mostrar el resultado final
    * es decir, hay que pedirle a la liga despues de haber*/
    private static void crearPartidosSilencioso(Liga miLiga, int jornadasJugadas){
        Jornada [] jornadas = miLiga.getCalendario().getJornadas();
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
            miLiga.getCalendario().setJornadas(jornadas);
            jornadas[i].terminar();
        }
        System.out.println(miLiga.getCalendario());


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
    private static void añadirResultados(Liga miLiga){
        Calendario calendario=miLiga.getCalendario();
        Jornada jornadas[]= calendario.getJornadas();
        System.out.println("Actualmente hay: "+jornadas.length+" jornadas, cuantas desea añadir?:");
        int numNuevasJornadas=leerNumero();
        Jornada nuevaJornadas[]=new Jornada[jornadas.length+numNuevasJornadas];
        //copiamos las jornadas existentes en el nuevo array de jornadas
        for (int i=0;i<jornadas.length;i++){
            nuevaJornadas[i]=jornadas[i];
        }

        for(int i=jornadas.length;i<nuevaJornadas.length;i++){
            Jornada jornadaActual=new Jornada();
            System.out.println("Cuantos partidos quieres poner?:");
            int numPartidos=leerNumero();
            esperarPulsacion();
            //creamos un array de nuevos partidos con los partidos que queramos
            Partido[] partidos=new Partido[numPartidos];
            for (int j=0;j<numPartidos;j++){
                //creamos un nuevo partido
                //el for se encargará de rellenar el array de nuevos partidos con cada partido que creemos aqui
                Partido partido=new Partido();
                //mostramos los equipos disponibles para añadirlos al partido
                for(int k=0;k<miLiga.getEquipos().length;k++){
                    System.out.println("-"+k+miLiga.getEquipos()[k].getNombre());
                }
                System.out.println();
                System.out.println("Seleccione un equipo Local de los disponibles:");
                int seleccion=leerNumero();
                partido.setLocal(miLiga.getEquipos()[seleccion]);
                esperarPulsacion();

                //mostramos los equipos disponibles para añadirlos al partido
                System.out.println();
                System.out.println("Seleccione un equipo Visitante de los disponibles");
                seleccion=leerNumero();
                partido.setVisitante(miLiga.getEquipos()[seleccion]);
                esperarPulsacion();

                //ahora mostramos los arbitros para que el usuario los añada al partido
                limpiarPantalla();
                System.out.println("Ahora el arbitro");
                esperarPulsacion();
                for (int l=0;l<miLiga.getArbitros().length;l++){
                    System.out.println("-"+l+miLiga.getArbitros()[l].getNombre());
                }
                System.out.println("Escoja un arbitro para el partido de los disponibles");
                seleccion=leerNumero();
                partido.setArbitro(miLiga.getArbitros()[seleccion]);

                System.out.println("Equipos y Arbitros añadidos correctamente");
                System.out.println("Pulse Enter");
                esperarPulsacion();

                System.out.println("Quieres añadir los goles(1) o quieres que sea automático(2)?");
                int opcionSwitch=leerNumero();
                switch (opcionSwitch){
                    case 1:
                        System.out.println("Introduzca goles del equipo Local:");
                        int gLocal=leerNumero();
                        System.out.println("Introduzca goles del equipo Visitante");
                        int gVisitante=leerNumero();
                        partido.setgLocal(gLocal);
                        partido.setgVisitante(gVisitante);
                        break;

                    case 2:
                        int numero = (int) Math.floor(Math.random()*5);
                        partido.setgLocal(numero);
                        numero = (int) Math.floor(Math.random()*5);
                        partido.setgVisitante(numero);
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                partidos[j]=partido;
            }
            nuevaJornadas[i]=jornadaActual;
        }
        miLiga.getCalendario().setJornadas(nuevaJornadas);

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
