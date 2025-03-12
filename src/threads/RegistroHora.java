package threads;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;

public class RegistroHora extends Thread{
    private boolean contadortempo = true;
    private boolean verificadorteclaenter = false;

    public RegistroHora(){
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setOpacity(0.0f);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    verificadorteclaenter = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void run(){
        while(contadortempo){
            LocalDateTime currentTime = LocalDateTime.now();
            System.out.println("Hora Atual: "+ currentTime);

            if(verificadorteclaenter){
                break;
            }
        }
    }

}
