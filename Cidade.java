import java.util.ArrayList;
import java.util.List;

// Classe para representar um nó do grafo
class Cidade {
    String nome;
    List<Aresta> ligacoes;

    public Cidade(String nome) {
        this.nome = nome;
        this.ligacoes = new ArrayList<>();
    }

    public void adicionarLigacao(Cidade destino, int custo) {
        Aresta aresta = new Aresta(destino, custo);
        ligacoes.add(aresta);
    }
}