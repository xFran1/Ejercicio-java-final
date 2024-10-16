import java.util.ArrayList;
import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String palabras = "hormiga babuino tejon murcielago oso castor camello gato almeja cobra pantera coyote cuervo ciervo perro burro pato aguila huron zorro rana cabra ganso halcon leon lagarto llama topo mono alce raton mula salamandra nutria buho panda loro paloma piton conejo carnero rata cuervo rinoceronte salmon foca tiburon oveja mofeta perezoso serpiente araña cigüeña cisne tigre sapo trucha pavo tortuga comadreja ballena lobo wombat cebra";
        String[] palabra = palabras.split(" ");
        int random = (int) (Math.random() * palabra.length);
        String palabra_seleccionada = palabra[1];
        ArrayList<String> array_letras = new ArrayList<>(); // Son las letras que ya han sido introducidas

        int contador = 0;
        do {
            String letra = "";
            boolean valido = true;

            do {
                valido = true;
                System.out.println("1.Escribe una letra 2.Escribir lo que es");
                int n = s.nextInt();
                if (n == 1) {
                    System.out.println("Letra:");
                    letra = s.next();
                    if (letra.length() > 1) {
                        valido = false;
                        System.out.println("Debe de introducir una letra");
                    }
                    if (array_letras.contains(letra)) {
                        valido = false;
                        System.out.println("No se puede repetir letras");
                    }
                    boolean correcto = false;
                    for (int i = 0; i < palabra_seleccionada.length(); i++) {
                        if ((palabra_seleccionada.charAt(i) + "").equals(letra)) {
                            correcto = true;
                        }
                    }
                    int acierto = 0;
                    for (int i = 0; i < palabra_seleccionada.length(); i++) {
                        if (array_letras.contains(palabra_seleccionada.charAt(i) + "")) {
                            acierto++;
                        } else {
                            System.out.print("- ");

                        }
                    }

                    if (acierto == palabra_seleccionada.length() - 1) {
                        contador = 8;
                    }

                    if (!correcto) {
                        contador++;
                    } else {

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
            } else if (contador == 7) {
                System.out.println("La palabra era: " + palabra_seleccionada);
            } else {
                array_letras.add(letra);
                mostrar_palabra(palabra_seleccionada, array_letras);
            }

        } while (contador < 7);
    }

    public static void mostrar_palabra(String s, ArrayList array_letras) {
        System.out.println("\n \n \n \n \n \n \n \n \n");
        System.out.println("--------");
        System.out.print("Letras introducidas: ");
        array_letras.forEach((n) -> System.out.print(n + " "));
        System.out.println("");
        System.out.println("--------");
        System.out.println("");

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

        System.out.println("+---+");
        System.out.println("|   |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento1() {
        System.out.println("+---+");
        System.out.println("|   |");
        System.out.println("O   |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento2() {
        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println(" |  |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento3() {
        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|  |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento4() {
        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento5() {
        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("/   |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento6() {
        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("/   |");
        System.out.println("    |");
        System.out.println("=========");
    }

    public static void intento7() {
        System.out.println(" +--+");
        System.out.println(" |  |");
        System.out.println(" O  |");
        System.out.println("/|\\ |");
        System.out.println("/ \\ |");
        System.out.println("    |");
        System.out.println("=========");
    }
}
