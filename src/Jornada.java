public class Jornada {
    private int fecha;
    private int numJornada;
    public int numPartidos;

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }

    private Partido[] partidos;

}
