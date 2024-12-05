import java.util.Random;
import java.util.concurrent.Semaphore;
public class Consumatore extends Thread{
    private int[]prodotti;
    private String nome;
    private Semaphore vuoto;
    private Semaphore pieno;
    private int sottrai;
    public Consumatore(int[]prodotti,String nome,Semaphore vuoto,Semaphore pieno){
        this.prodotti=prodotti;
        this.nome=nome;
        this.vuoto=vuoto;
        this.pieno=pieno;
        sottrai=0;
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
    public void setSottrai(int sottrai){
        this.sottrai=sottrai;
    }
    public int getSottrai(){
        return sottrai;
    }
}