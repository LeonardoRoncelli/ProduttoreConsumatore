import java.util.concurrent.Semaphore;
import java.util.Random;
public class Produttore extends Thread{
    private int[]prodotti;
    private String nome;
    private Semaphore vuoto;
    private Semaphore pieno;
    private int posiziona;
    public Produttore(int[]prodotti,String nome,Semaphore vuoto,Semaphore pieno){
        this.prodotti=prodotti;
        this.nome=nome;
        this.vuoto=vuoto;
        this.pieno=pieno;
        posiziona=0;
    }
    public void setProdotti(int[]prodotti){
        this.prodotti=prodotti;
    }
    public int[]getProdotti(){
        return prodotti;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
    public void setVuoto(Semaphore vuoto){
        this.vuoto=vuoto;
    }
    public Semaphore getVuoto(){
        return vuoto;
    }
    public void setPieno(Semaphore pieno){
        this.pieno=pieno;
    }
    public Semaphore getPieno(){
        return pieno;
    }
    public void setPosiziona(int posiziona){
        this.posiziona=posiziona;
    }
    public int getPosiziona(){
        return posiziona;
    }
    public void produce(int p){
        try{
            vuoto.acquire();
            prodotti[posiziona]=p;
            posiziona=(posiziona+1)%prodotti.length;
            System.out.println("Thread "+nome+" ha prodotto "+p);
            pieno.release();
        }catch (Exception e){
            System.out.println("Thread "+nome+" errore nella produzione di: "+e);
        }
    }
    public void run(){
        Random random=new Random();
        while(true){
            try{
                produce(random.nextInt(101));
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Thread "+nome+" errore nel run: "+e);
            }
        }
    }
}