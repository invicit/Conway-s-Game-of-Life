

public class Application {


    public static void main(String[] args){


        Thread aaa = new Thread(new Game());
        aaa.start();

    }

}
