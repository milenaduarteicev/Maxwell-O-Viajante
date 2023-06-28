// Classe para representar uma aresta (ligação) entre cidades
public class Aresta {
    Cidade destino;
    int custo;

    public Aresta(Cidade destino, int custo) {
        this.destino = destino;
        this.custo = custo;
    }
}