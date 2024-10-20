import java.util.ArrayList;
import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String palabras = "hormiga babuino tejon murcielago oso castor camello gato almeja cobra pantera coyote cuervo ciervo perro burro pato aguila huron zorro rana cabra ganso halcon leon lagarto llama topo mono alce raton mula salamandra nutria buho panda loro paloma piton conejo carnero rata cuervo rinoceronte salmon foca tiburon oveja mofeta perezoso serpiente araña cigüeña cisne tigre sapo trucha pavo tortuga comadreja ballena lobo wombat cebra";
        String letras_abecedario = "a b c d e f g h i j k l m n ñ o p q r s t u v w x y z";

        String[] palabra = palabras.split(" ");

        ArrayList<String> array_letras = new ArrayList<>(); // Son las letras que ya han sido introducidas

        System.out.println("======================================");
        System.out.println("|| Bienvenido al juego del ahorcado ||");
        System.out.println("======================================");
        Thread.sleep(1000);
        boolean salir = false;

        ArrayList<Jugador> array_jugadores = new ArrayList<>();
        String nombre = "";

        boolean usuario_creado = false;
        do {
            int random = (int) (Math.random() * palabra.length);
            String palabra_seleccionada = palabra[1]; // Cambiar a random
            array_letras.clear();
            boolean jugado = false;

            System.out.println("1.Crear usuario 2.Ver estadísticas 3.Salir 4.Volver a jugar");
            int n = s.nextInt();

            if (n == 4) {
                if (usuario_creado) {
                    System.out.println("Entrando al juego...");

                    Thread.sleep(1000);
                    int contador = 0; // Contador de intentos restantes
                    boolean primera_vez = false;

                    do {
                        String letra = "";
                        boolean valido = true;
                        if (!primera_vez) { // Con esto consigo que se muestra la primera vez el
                            // ahorcado con los huecos de
                            // la palabra a adivinar
                            errores(0);
                            mostrar_palabra(palabra_seleccionada, array_letras, primera_vez);
                            System.out.println("");
                            primera_vez = true;

                        }
                        do {

                            valido = true;

                            boolean input_valido = false;
                            n = 0;
                            while (!input_valido) {

                                try { // Con esto consigo de que al usuario no le de error cuando se equivoque
                                    System.out.println("1.Escribe una letra 2.Escribir lo que es");
                                    n = s.nextInt();
                                    if (n != 1 && n != 2) {
                                        System.out.println("Por favor,debe introducir un número válido");

                                    } else {
                                        input_valido = true;

                                    }
                                } catch (Exception e) {
                                    System.out.println("Por favor,debe introducir un número");
                                    s.next(); // Limpio el buffer
                                }
                            }

                            if (n == 1) {
                                System.out.println("Letra:");
                                letra = s.next();

                                if (letras_abecedario.contains(letra)) {
                                    if (letra.length() > 1) { // En caso de introducir mas de una letra debera volver a
                                                              // intertarlo
                                        valido = false;
                                        System.out.println("Debe de introducir una letra");
                                    }
                                    if (array_letras.contains(letra)) { // En caso de repetir letras
                                        valido = false;
                                        System.out.println("No se puede repetir letras");
                                    }
                                    boolean correcto = false;
                                    for (int i = 0; i < palabra_seleccionada.length(); i++) { // Comprueba que la letra
                                                                                              // introducida
                                                                                              // este
                                                                                              // la palabra en caso de
                                                                                              // no estar
                                        if ((palabra_seleccionada.charAt(i) + "").equals(letra)) {
                                            correcto = true; // correcto seria true y entonces el contador de los
                                                             // intentos restantes
                                                             // sumaria 1
                                        }
                                    }

                                    if (!correcto) {
                                        contador++;
                                    }

                                    int acierto = 0;
                                    for (int i = 0; i < palabra_seleccionada.length(); i++) { // Comprueba en el array
                                                                                              // de las letras
                                                                                              // que
                                                                                              // seleccionamos con la
                                                                                              // palabra
                                                                                              // seleccionada
                                        if (array_letras.contains(palabra_seleccionada.charAt(i) + "")) {
                                            acierto++;
                                        } else {
                                            System.out.print("- ");

                                        }
                                    }

                                    if (acierto == palabra_seleccionada.length() - 1) { // En caso de los aciertos sean
                                                                                        // iguales a la
                                                                                        // longitud de la palabra
                                                                                        // seleccionada
                                                                                        // entonces
                                                                                        // habremos ganado
                                        contador = 8;
                                    }
                                    array_letras.add(letra);

                                } else {
                                    System.out.println("Debe introducir una letra del abecedario");
                                }

                            } else if (n == 2) {
                                System.out.println("Palabra:");

                                String palabra_adivinar = s.next();
                                if (palabra_adivinar.equals(palabra_seleccionada)) {
                                    System.out.println("Ganaste la palabra era " + palabra_seleccionada);

                                    contador = 8;
                                } else {
                                    contador++;
                                }
                            } else {
                                valido = false;
                            }
                            errores(contador);
                        } while (!valido);

                        if (contador > 7) {
                            System.out.println("Felicidades has ganado!");
                            for (Jugador jugador : array_jugadores) {
                                if (jugador.getNombre().equals(nombre)) {
                                    jugador.ganar_partida();
                                }
                            }
                        } else if (contador == 7) {
                            System.out.println("La palabra era: " + palabra_seleccionada);
                            for (Jugador jugador : array_jugadores) {
                                if (jugador.getNombre().equals(nombre)) {
                                    jugador.perder_partida();

                                }
                            }
                        } else {
                            mostrar_palabra(palabra_seleccionada, array_letras, primera_vez);
                        }

                    } while (contador < 7);
                } else {
                    System.out.println("Debe crear un usuario");
                }

            }
            if (n == 1) {
                usuario_creado = true;
                System.out.println("Nombre");
                nombre = s.next();
                System.out.println("Edad");
                int edad = s.nextInt();
                System.out.println("Sexo \n 1.Hombre 2.Mujer");
                int sexo = s.nextInt();
                if (sexo == 1) {
                    array_jugadores.add(new Jugador(0, 0, 0, nombre, edad, Sexo.hombre));

                } else if (sexo == 2) {
                    array_jugadores.add(new Jugador(0, 0, 0, nombre, edad, Sexo.mujer));

                }
                System.out.println("¿Desea jugar " + nombre + "?");
                System.out.println("1.Si 2.No");
                int respuesta = s.nextInt();
                if (respuesta == 1) {
                    System.out.println("Entrando al juego...");

                    Thread.sleep(1000);
                    int contador = 0; // Contador de intentos restantes
                    boolean primera_vez = false;

                    do {
                        String letra = "";
                        boolean valido = true;
                        if (!primera_vez) { // Con esto consigo que se muestra la primera vez el
                            // ahorcado con los huecos de
                            // la palabra a adivinar
                            errores(0);
                            mostrar_palabra(palabra_seleccionada, array_letras, primera_vez);
                            System.out.println("");
                            primera_vez = true;

                        }
                        do {

                            valido = true;

                            boolean input_valido = false;
                            n = 0;
                            while (!input_valido) {

                                try { // Con esto consigo de que al usuario no le de error cuando se equivoque
                                    System.out.println("1.Escribe una letra 2.Escribir lo que es");
                                    n = s.nextInt();
                                    if (n != 1 && n != 2) {
                                        System.out.println("Por favor,debe introducir un número válido");

                                    } else {
                                        input_valido = true;

                                    }
                                } catch (Exception e) {
                                    System.out.println("Por favor,debe introducir un número");
                                    s.next(); // Limpio el buffer
                                }
                            }

                            if (n == 1) {
                                System.out.println("Letra:");
                                letra = s.next();

                                if (letras_abecedario.contains(letra)) {
                                    if (letra.length() > 1) { // En caso de introducir mas de una letra debera volver a
                                                              // intertarlo
                                        valido = false;
                                        System.out.println("Debe de introducir una letra");
                                    }
                                    if (array_letras.contains(letra)) { // En caso de repetir letras
                                        valido = false;
                                        System.out.println("No se puede repetir letras");
                                    }
                                    boolean correcto = false;
                                    for (int i = 0; i < palabra_seleccionada.length(); i++) { // Comprueba que la letra
                                                                                              // introducida
                                                                                              // este
                                                                                              // la palabra en caso de
                                                                                              // no estar
                                        if ((palabra_seleccionada.charAt(i) + "").equals(letra)) {
                                            correcto = true; // correcto seria true y entonces el contador de los
                                                             // intentos restantes
                                                             // sumaria 1
                                        }
                                    }

                                    if (!correcto) {
                                        contador++;
                                    }

                                    int acierto = 0;
                                    for (int i = 0; i < palabra_seleccionada.length(); i++) { // Comprueba en el array
                                                                                              // de las letras
                                                                                              // que
                                                                                              // seleccionamos con la
                                                                                              // palabra
                                                                                              // seleccionada
                                        if (array_letras.contains(palabra_seleccionada.charAt(i) + "")) {
                                            acierto++;
                                        } else {
                                            System.out.print("- ");

                                        }
                                    }

                                    if (acierto == palabra_seleccionada.length() - 1) { // En caso de los aciertos sean
                                                                                        // iguales a la
                                                                                        // longitud de la palabra
                                                                                        // seleccionada
                                                                                        // entonces
                                                                                        // habremos ganado
                                        contador = 8;
                                    }
                                    array_letras.add(letra);

                                } else {
                                    System.out.println("Debe introducir una letra del abecedario");
                                }

                            } else if (n == 2) {
                                System.out.println("Palabra:");

                                String palabra_adivinar = s.next();
                                if (palabra_adivinar.equals(palabra_seleccionada)) {
                                    System.out.println("Ganaste la palabra era " + palabra_seleccionada);

                                    valido = true;
                                    contador = 8;
                                } else {
                                    contador++;
                                }
                            } else {
                                valido = false;
                            }
                            errores(contador);
                        } while (!valido);

                        if (contador > 7) {
                            System.out.println("Felicidades has ganado!");
                            for (Jugador jugador : array_jugadores) {
                                if (jugador.getNombre().equals(nombre)) {
                                    jugador.ganar_partida();
                                }
                            }
                        } else if (contador == 7) {
                            System.out.println("La palabra era: " + palabra_seleccionada);
                            for (Jugador jugador : array_jugadores) {
                                if (jugador.getNombre().equals(nombre)) {
                                    jugador.perder_partida();

                                }
                            }
                        } else {
                            mostrar_palabra(palabra_seleccionada, array_letras, primera_vez);
                        }

                    } while (contador < 7);

                }

            } else if (n == 2) {
                Thread.sleep(1000);

                System.out.println("Entrando a las estadísticas...");
                System.out.println(
                        "Entre todos los jugadores se han jugado: " + Jugador.getNumero_veces_jugadas_global()
                                + " partidas");
                for (Jugador jugador : array_jugadores) {

                    System.out.println(jugador.toString());

                }
            } else if (n == 3) {
                salir = true;
                System.out.println("Saliendo");
                Thread.sleep(1000);
                System.out.println("Gracias por haber jugador");

                Thread.sleep(1000);
            }

        } while (!salir);

    }

    public static void mostrar_palabra(String s, ArrayList array_letras, boolean primera_vez) {
        System.out.println("\n \n ");
        if (primera_vez) {
            System.out.println("--------");

            System.out.print("Letras introducidas: ");
            array_letras.forEach((n) -> System.out.print(n + " "));
            System.out.println("");
            System.out.println("--------");
            System.out.println("");
        }

        for (int i = 0; i < s.length(); i++) {
            if (array_letras.contains(s.charAt(i) + "")) {
                System.out.print(s.charAt(i) + " ");

            } else {
                System.out.print("- ");

            }
        }
        System.out.println("");
        for (int i = 0; i < s.length(); i++) {
            System.out.print("- ");
        }
    }

    public static void errores(int num) {
        switch (num) {
            case 0:
                intento0();
                break;
            case 1:
                intento1();
                break;
            case 2:
                intento2();
                break;
            case 3:
                intento3();
                break;
            case 4:
                intento4();
                break;
            case 5:
                intento5();
                break;
            case 6:
                intento6();
                break;
            case 7:
                intento7();
                break;

            default:
                break;
        }
    }

    public static void intento0() {
        System.out.println();
        System.out.println("+---+");
        System.out.println("|   |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento1() {
        System.out.println();

        System.out.println("+---+");
        System.out.println("|   |");
        System.out.println("O   |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento2() {
        System.out.println();

        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println(" |  |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento3() {
        System.out.println();

        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|  |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento4() {
        System.out.println();

        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento5() {
        System.out.println();

        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("/   |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento6() {
        System.out.println();

        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("/   |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento7() {
        System.out.println();

        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("/ \\ |");
        System.out.println("    |");
        System.out.println("=========");
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
        return "Jugador [nombre=" + nombre + ", edad=" + edad + super.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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

    public void ganar_partida() {
        numero_veces_ganadas++;
        jugar_partida();
    }

    public void perder_partida() {
        numero_veces_ganadas = numero_veces_ganadas - 1;
        jugar_partida();

    }

    public void jugar_partida() {
        numero_veces_jugadas_jugador++;
        numero_veces_jugadas_global++;

    }

    @Override
    public String toString() {
        return ", numero_veces_jugadas_jugador=" + numero_veces_jugadas_jugador + ", numero_veces_ganadas="
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