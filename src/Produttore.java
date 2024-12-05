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
}