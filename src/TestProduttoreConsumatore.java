public class TestProduttoreConsumatore {
    public static void main(String[] args) {
        Produttore prod=new Produttore("Produttore");
        Consumatore cons=new Consumatore("Consumatore");
        prod.start();
        cons.start();
    }
}