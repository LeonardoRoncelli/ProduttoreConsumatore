public class Consumatore extends Thread{
    private final String nome;
    public Consumatore(String nome) {
        this.nome=nome;
    }
    public void consuma() {
        synchronized (Produttore.prodotti){
            while (Produttore.sottrai ==Produttore.aggiungi){
                try {
                    Produttore.prodotti.wait();
                } catch (Exception e) {
                    System.out.println("Thread "+nome+" interrotto"+e);
                }
            }
            System.out.println("Thread "+nome+" ha consumato "+Produttore.prodotti[Produttore.sottrai]);
            Produttore.sottrai=(Produttore.sottrai + 1)%Produttore.prodotti.length;
            Produttore.prodotti.notifyAll();
        }
    }
    public void run(){
        while (true){
            try{
                Thread.sleep(1500);
                consuma();
            }catch (Exception e){
                System.out.println("Thread "+nome+" interrotto " + e);
            }
        }
    }
}