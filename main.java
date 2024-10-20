public class main {
    public static void main(String[] args) {

    }
}

enum Sexo {
    hombre, mujer
}

class Jugador extends Juego {

    private String nombre;
    private int edad;
    private Sexo sexo;

    public Jugador(int numero_veces_jugadas_jugador, int numero_veces_ganadas, int numero_veces_perdidas, String nombre,
            int edad, Sexo sexo) {
        super(numero_veces_jugadas_jugador, numero_veces_ganadas, numero_veces_perdidas);
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return super.toString() + "Jugador [nombre=" + nombre + ", edad=" + edad + "]";
    }

}

class Juego {
    private static int numero_veces_jugadas_global;

    private int numero_veces_jugadas_jugador;
    private int numero_veces_ganadas;
    private int numero_veces_perdidas;

    public Juego(int numero_veces_jugadas_jugador, int numero_veces_ganadas, int numero_veces_perdidas) {
        this.numero_veces_jugadas_jugador = numero_veces_jugadas_jugador;
        this.numero_veces_ganadas = numero_veces_ganadas;
        this.numero_veces_perdidas = numero_veces_perdidas;
    }

    @Override
    public String toString() {
        return "Juego [numero_veces_jugadas_jugador=" + numero_veces_jugadas_jugador + ", numero_veces_ganadas="
                + numero_veces_ganadas + ", numero_veces_perdidas=" + numero_veces_perdidas + "]";
    }

    public static int getNumero_veces_jugadas_global() {
        return numero_veces_jugadas_global;
    }

    public static void setNumero_veces_jugadas_global(int numero_veces_jugadas_global) {
        Juego.numero_veces_jugadas_global = numero_veces_jugadas_global;
    }

    public int getNumero_veces_jugadas_jugador() {
        return numero_veces_jugadas_jugador;
    }

    public void setNumero_veces_jugadas_jugador(int numero_veces_jugadas_jugador) {
        this.numero_veces_jugadas_jugador = numero_veces_jugadas_jugador;
    }

    public int getNumero_veces_ganadas() {
        return numero_veces_ganadas;
    }

    public void setNumero_veces_ganadas(int numero_veces_ganadas) {
        this.numero_veces_ganadas = numero_veces_ganadas;
    }

    public int getNumero_veces_perdidas() {
        return numero_veces_perdidas;
    }

    public void setNumero_veces_perdidas(int numero_veces_perdidas) {
        this.numero_veces_perdidas = numero_veces_perdidas;
    }

}