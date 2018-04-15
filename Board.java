import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel{

    Cell board[][];
    Cell boardTmp[][];
    int x;
    int y;
    Random a;
    JFrame frame;

    public Board(int x, int y, JFrame frame){
        this.board = new Cell[x][y];
        this.boardTmp = new Cell[x][y];
        this.x = x;
        this.y = y;
        a = new Random();
        InitCell();
        initRandom();
        this.frame = frame;

    }

    public void InitCell(){
        for (int i = 0; i<this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                board[i][j] = new Cell();
                boardTmp[i][j] = new Cell();
            }
    }}

   public void initRandom(){
        for (int i = 0; i<this.x; i++){
            for(int j = 0; j<this.y; j++){
                if(a.nextInt(100)>80){
                    board[i][j].setAlive(true);
                }
            }
        }
    }


    public int checkNeibours(int x, int y){
        int count = 0;

        if (x == 0 && y ==0){
            if(board[x+1][y].isAlive()){count++;}
            if(board[x][y+1].isAlive()){count++;}
            if(board[x+1][y+1].isAlive()){count++;}
        } //1

        else if (x == 0 && y == this.y-1){
            if(board[1][y].isAlive()){count++;}
            if(board[1][y-1].isAlive()){count++;}
            if(board[0][y-1].isAlive()){count++;}
        } //2

        else if (x == this.x -1 && y == 0){
            if(board[x][1].isAlive()){count++;}
            if(board[x-1][1].isAlive()){count++;}
            if(board[x-1][0].isAlive()){count++;}

        } //3
        else if (x == this.x -1 && y == this.y -1){
            if(board[x][y-1].isAlive()){count++;}
            if(board[x-1][y].isAlive()){count++;}
            if(board[x-1][y-1].isAlive()){count++;}
        } //4
        //X ^  y < >
        else if (x > 0 && x<this.x-1 && y == 0){
            if(board[x-1][y].isAlive()){count++;}
            if(board[x-1][y+1].isAlive()){count++;}
            if(board[x][y+1].isAlive()){count++;}
            if(board[x+1][y+1].isAlive()){count++;}
            if(board[x+1][y].isAlive()){count++;}

        } //5

        else if (x == this.x -1 && (y>0 && y<this.y -1)){
            if(board[x][y-1].isAlive()){count++;}
            if(board[x][y+1].isAlive()){count++;}
            if(board[x-1][y-1].isAlive()){count++;}
            if(board[x-1][y+1].isAlive()){count++;}
            if(board[x-1][y].isAlive()){count++;}
        } //6

        else if (x > 0 && x<this.x-1 && y == this.y -1){
            if(board[x-1][y].isAlive()){count++;}
            if(board[x-1][y-1].isAlive()){count++;}
            if(board[x][y-1].isAlive()){count++;}
            if(board[x+1][y-1].isAlive()){count++;}
            if(board[x+1][y].isAlive()){count++;}
        } //7

        else if (x == 0 && (y>0 && y<this.y -1)){
            if(board[x][y-1].isAlive()){count++;}
            if(board[x][y+1].isAlive()){count++;}
            if(board[x+1][y-1].isAlive()){count++;}
            if(board[x+1][y+1].isAlive()){count++;}
            if(board[x+1][y].isAlive()){count++;}
        } //8

        else if (x>0 && y>0 && x<this.x-1 && y<this.y-1){
            if(board[x-1][y-1].isAlive()){count++;}
            if(board[x-1][y].isAlive()){count++;}
            if(board[x-1][y+1].isAlive()){count++;}
            if(board[x][y-1].isAlive()){count++;}
            if(board[x][y+1].isAlive()){count++;}
            if(board[x+1][y-1].isAlive()){count++;}
            if(board[x+1][y].isAlive()){count++;}
            if(board[x+1][y+1].isAlive()){count++;}
        }//9
        return count;
    }


    public void fillBoard(){
        for (int i=0; i<this.x; i++){
            for (int j=0; j<this.y; j++){
                int a = checkNeibours(i,j);
                //System.out.println(Integer.toString(i)+" "+Integer.toString(j)+" "+Integer.toString(a));
                if((a==3 || a==2) && board[i][j].isAlive()) {boardTmp[i][j].setAlive(true);}
                else if(a==3 && !board[i][j].isAlive()) {boardTmp[i][j].setAlive(true);}
                else if(a<2 || a>3) {boardTmp[i][j].setAlive(false);}

            }
        }
        for (int i=0; i<this.x; i++){
            for (int j=0; j<this.y; j++){
                board[i][j].setAlive(boardTmp[i][j].isAlive());
            }
        }
    }

   /* public void draw(){
        for(int i=0; i<this.x; i++){
            for (int j=0; j<this.y; j++){
                if(board[i][j].isAlive()){
                    System.out.print(Integer.toString(1) + ' ');
                } else {System.out.print("  ");}
            }
            System.out.println("");
        }
        System.out.println("");
    }*/


      public void paintComponent(Graphics g){
          super.paintComponent(g);
          this.setBackground(Color.LIGHT_GRAY);
          g.setColor(Color.BLACK);
         for(int i=0; i<this.x; i++){
            for (int j=0; j<this.y; j++){
                if(board[i][j].isAlive()){
                    g.fillRect(i*7,j*7,7,7);
                } else {}
            }

        }

    }



}
