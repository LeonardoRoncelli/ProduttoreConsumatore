import java.util.concurrent.TimeUnit;
import java.util.Random;
public class ProdCons extends Thread{
    Random random=new Random();
    static int []prodotti=new int[100];
    public void produce(){
        int elemento;
        for(int i=0;i< prodotti.length;i++){
            elemento=random.nextInt(100);
            prodotti[i]=elemento;
        }
    }
    public void stampa(){
        for(int i=0;i<prodotti.length;i++) {
            System.out.println(prodotti[i]);
        }
    }
    public void run(){
        stampa();
    }
    public static void main(String[] args) {
        ProdCons produttore=new ProdCons();
        ProdCons consumatore=new ProdCons();
        produttore.start();
        consumatore.start();
    }
}