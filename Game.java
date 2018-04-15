import javax.swing.*;
public class Game implements Runnable {

    Board board;
    JFrame frame;

    public Game(){
        int a = 100;
        int b = 100;
        this.frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board = new Board(a, b, this.frame);
        frame.add(board);
        frame.setSize(750, 700);
        frame.setVisible(true);
    }


    @Override
    public void run() {
       while(true){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.board.fillBoard();
        frame.repaint();

    }}
}
