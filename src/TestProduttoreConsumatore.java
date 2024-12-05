import java.util.concurrent.Semaphore;
public class TestProduttoreConsumatore {
    public static void main(String[]args){
        int[]prodotti=new int[10];
        Semaphore pieno=new Semaphore(0);
        Semaphore vuoto=new Semaphore(prodotti.length);
        Produttore prod=new Produttore(prodotti,"Produttore",vuoto,pieno);
        Consumatore cons=new Consumatore(prodotti,"Consumatore",vuoto,pieno);
        prod.start();
        cons.start();
    }
}