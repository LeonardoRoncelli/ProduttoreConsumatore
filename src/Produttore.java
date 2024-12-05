import java.util.Random;
public class Produttore extends Thread{
    public static final int[] prodotti=new int[10];
    public static int aggiungi=0;
    public static int sottrai=0;
    public final String nome;
    public Produttore(String nome) {
        this.nome= nome;
    }
    public void produce(int p){
        synchronized (prodotti){
            while ((aggiungi+1)%prodotti.length==sottrai){
                try {
                    prodotti.wait();
                } catch (Exception e) {
                    System.out.println("Thread "+nome+" interrotto "+e);
                }
            }
            prodotti[aggiungi]=p;
            aggiungi=(aggiungi + 1)%prodotti.length;
            System.out.println("Thread "+nome+" ha prodotto "+ p);
            prodotti.notifyAll();
        }
    }
    public void run() {
        Random random = new Random();
        while (true){
            try {
                produce(random.nextInt(101));
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println("Thread " + nome+ " interrotto "+e);
            }
        }
    }
}