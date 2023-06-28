public class GerenciadorLPM {
    private int limiar;
    private int poderJoia;
    private int moeda;

    public GerenciadorLPM() {
        this.limiar = 7;
        this.poderJoia = 0;
        this.moeda = 3;
    }

    public int getLimiar() {
        return limiar;
    }

    public void setLimiar(int novoLimiar) {
        limiar += novoLimiar;
    }

    public int getPoderJoia() {
        return poderJoia;
    }

    public void setPoderJoia(int novoPoderJoia) {
        poderJoia += novoPoderJoia;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int novaMoeda) {
        moeda += novaMoeda;
    }

    // Funções para imprimir os valores dos atributos
    public void imprimirLimiar() {
        System.out.println("@ Limiar: " + getLimiar());
    }

    public void imprimirPoderJoia() {
        System.out.println("@ Poder da Joia: " + getPoderJoia());
    }

    public void imprimirMoeda() {
        System.out.println("@ Moedas: $" + getMoeda());
    }

}
