import java.util.ArrayList;
import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String palabras = "hormiga babuino tejon murcielago oso castor camello gato almeja cobra pantera coyote cuervo ciervo perro burro pato aguila huron zorro rana cabra ganso halcon leon lagarto llama topo mono alce raton mula salamandra nutria buho panda loro paloma piton conejo carnero rata cuervo rinoceronte salmon foca tiburon oveja mofeta perezoso serpiente araña cigüeña cisne tigre sapo trucha pavo tortuga comadreja ballena lobo wombat cebra";
        String[] palabra = palabras.split(" ");
        int random = (int) (Math.random() * palabra.length);
        String palabra_seleccionada = palabra[random];
        ArrayList<String> array_letras = new ArrayList<>(); // Son las letras que ya han sido introducidas

        int contador = 0;
        do {
            mostrar_palabra(palabra_seleccionada);
            String letra = "";
            boolean valido = true;

            do {
                valido = true;
                System.out.println("Escribe una letra");
                letra = s.next();
                if (letra.length() > 1) {
                    valido = false;
                    System.out.println("Debe de introducir una letra");
                }
                if (array_letras.contains(letra)) {
                    valido = false;
                    System.out.println("No se puede repetir letras");
                }

            } while (valido);

        } while (contador < 7);
    }

    public static void mostrar_palabra(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print("- ");
        }
        System.out.println(s);
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
