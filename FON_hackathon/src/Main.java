import javax.swing.*;
//Sierpinski trougao
// FON hackathon

public class Main {
    static boolean start = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Sierpinski trougao");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Zadatak_hackathon zadatak = new Zadatak_hackathon();
        frame.add(zadatak);
        frame.setVisible(true);
        while(true){
            zadatak.dottedTriangles();
            try {
                Thread.sleep(10);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}

