import java.util.concurrent.TimeUnit;
public class ProdCons extends Thread{
    static int []prod=new int[100];

    public void run(){

    }
    public static void main(String[] args) {
        ProdCons produttore=new ProdCons();
        ProdCons consumatore=new ProdCons();
        produttore.start();
        consumatore.start();
    }
}