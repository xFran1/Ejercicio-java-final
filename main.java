import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class main {
    public static void main(String[] args) {

        // LocalDateTime fecha = LocalDateTime.now();
        // System.out.println(fecha);
        // delaySegundo();
        // delaySegundo();

        // delayMilisegundo();
        // delayMilisegundo();
        // delayMilisegundo();
        // delayMilisegundo();

        // LocalDateTime fecha2 = LocalDateTime.now();
        // System.out.println(fecha2);

        // Period period = getPeriod(fecha, fecha2);

        // double time[] = getTime(fecha, fecha2);

        // System.out.println(time[2] + " segundo");
        // System.out.println(time[3] + " milisegundos");

    }

    private static void delayMilisegundo() {

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void delaySegundo() {

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static Period getPeriod(LocalDateTime dob, LocalDateTime now) {
        return Period.between(dob.toLocalDate(), now.toLocalDate());
    }

    private static double[] getTime(LocalDateTime dob, LocalDateTime now) {
        Duration duration = Duration.between(dob, now);

        double seconds = duration.getSeconds();

        double ms = duration.getNano() / 100000000;
        double hours = seconds / 3600;
        double minutes = ((seconds % 3600) / 60);
        double secs = (seconds % 60);

        return new double[] { hours, minutes, secs, ms };
    }

}

class Jugador {
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_final;
    private String nombre_usuario;
    private String dinero;

}
