import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Presiona una tecla para salir");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Presiona cualquier tecla para salir", SwingConstants.CENTER);
        frame.add(label);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Tecla presionada: " + e.getKeyChar());
                System.exit(0); // Termina el programa cuando se presiona una tecla
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.setVisible(true);
    }
}
