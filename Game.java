import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    static boolean missaoAceita = false;
    static boolean missaoConcluida = false;
    static int missaoAtual = 0;

    public static void game(Cidade cidadeInicial) {

        Scanner sc = new Scanner(System.in);
        Cidade cidadeAtual = cidadeInicial;
        List<Cidade> cidadesVisitadas = new ArrayList<>();
        Mercador mercador = new Mercador();
        Missao missao = new Missao();

        System.out.println("");
        System.out.println("###### INICIANDO O JOGO ######");
        System.out.println("");

        GerenciadorLPM ger = new GerenciadorLPM();

        while (true) {
            System.out.println("Você está na cidade " + cidadeAtual.nome);
            System.out.println("- Moeda: $" + ger.getMoeda());
            ger.imprimirLimiar();
            ger.imprimirPoderJoia();

            // Verificar se existem cidades vizinhas para viajar
            List<Aresta> ligacoes = cidadeAtual.ligacoes;
            if (ligacoes.isEmpty()) {
                System.out.println("Você não pode viajar para nenhuma cidade. Fim de jogo!");
                break;
            }

            System.out.println("");
            System.out.println("Opções de cidades para viajar:");
            for (int i = 0; i < ligacoes.size(); i++) {
                Aresta aresta = ligacoes.get(i);
                System.out.println((i + 1) + ". Cidade " + aresta.destino.nome + " (Custo: $" + aresta.custo + ")");
            }

            // Obter a escolha do jogador
            System.out.print("Resposta: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            // Obter a aresta correspondente à escolha do jogador
            Aresta arestaEscolhida = ligacoes.get(escolha - 1);

            // Local de conversa com o mercador
            if (escolha < 1 || escolha > ligacoes.size()) {
                System.out.println("Escolha inválida");
            }

            // Verificar se o jogador possui dinheiro suficiente para viajar
            if (ger.getMoeda() < arestaEscolhida.custo) {
                System.out.println("");
                System.out.println("VOCÊ MORREU POR SER POBRE!!!"
                        + arestaEscolhida.destino.nome);
                System.out.println("");
                System.out.println("Fim de jogo!");
                break;
            } else if (ger.getLimiar() < ger.getPoderJoia()) {
                System.out.println("VOCÊ MORREU POR SER FRACO!!! Limiar < Poder");
                break;
            }

            // Viajar para a cidade escolhida
            cidadeAtual = arestaEscolhida.destino;
            ger.setMoeda(-arestaEscolhida.custo);
            cidadesVisitadas.add(cidadeAtual);

            System.out.println("");
            System.out.println("Viajando para a cidade " + cidadeAtual.nome);
            System.out.println("Custo da viagem: $" + arestaEscolhida.custo);
            System.out.println();

            System.out.println(">>>>>>> VIAJANDO <<<<<<<");
            System.out.println("");

            // menu abandonar missão
            if (missaoAceita || missaoAtual == 0) {
                System.out.println("Você não possui missões para abandonar! Digite: PASS");
            } else if (!missaoAceita && missaoAtual == 1) {
                System.out.println("Você está na cidade de " + cidadeAtual.nome +
                        "\ne possui uma missão para abandonar, deseja concluir a missão? (S/N)");
            }
            System.out.print("Resposta: ");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("S") && !missaoAceita && missaoAtual == 1) {
                System.out.println("Continue sua jornada!");
            } else if (resposta.equalsIgnoreCase("PASS")) {
                System.out.println("Continue sua jornada!");
            } else {
                missaoAceita = false;
                missaoAtual -= 1;
                System.out.println("A missão foi abandonada. Continue sua jornada!");
            }
            System.out.println("");

            if (cidadeAtual.nome.equals("Kingdom of Kalb")) {
                missao.verificarMissoesKOKalb();
            } else if (cidadeAtual.nome.equals("Defalsia")) {
                missao.verificarMissoesDefalsia();
            } else if (cidadeAtual.nome.equals("Vunese Empire")) {
                missao.verificarMissoesVuneseEmpire();
            } else {
                System.out.println("Você está em uma cidade diferente. Digite PASS! ");
            }
            System.out.print("Resposta: ");
            String respostaMissao = sc.nextLine();
            System.out.println("");

            if (respostaMissao.equalsIgnoreCase("PASS")) {
                System.out.println("Sem missões para aceitar. Continue sua jornada!");
            } else if (cidadeAtual.nome.equals("Kingdom of Kalb")) {
                if (respostaMissao.equalsIgnoreCase("S") && missaoAtual == 0 && missaoAceita) {
                    ger.setMoeda(ger.getMoeda() + 4);
                    missaoAceita = true;
                    ger.imprimirMoeda();
                    System.out.println("Status missão: aceita!");
                    missaoAtual += 1;
                } else {
                    System.out.println("Missão rejeitada. Continue sua jornada.");
                }
            } else if (cidadeAtual.nome.equals("Defalsia")) {
                if (respostaMissao.equalsIgnoreCase("S") && missaoAtual == 0 && missaoAceita) {
                    ger.setMoeda(ger.getMoeda() + 6);
                    missaoAceita = true;
                    ger.imprimirMoeda();
                    System.out.println("Status missão: aceita!");
                    missaoAtual += 1;
                } else {
                    System.out.println("Missão rejeitada. Continue sua jornada.");
                }
            } else if (cidadeAtual.nome.equals("Vunese Empire")) {
                if (respostaMissao.equalsIgnoreCase("S") && missaoAtual == 0 && missaoAceita) {
                    ger.setMoeda(ger.getMoeda() + 1);
                    missaoAceita = true;
                    ger.imprimirMoeda();
                    System.out.println("Status missão: aceita!");
                    missaoAtual += 1;
                } else {
                    System.out.println("Missão rejeitada. Continue sua jornada.");
                }
            }

            System.out.println("");

            if (cidadeAtual.nome.equals("Grand Duchy of Smalia")
                    || cidadeAtual.nome.equals("Principality of Kasya")
                    || cidadeAtual.nome.equals("Ubud")) {
                if (!missaoAceita && missaoConcluida) {
                    System.out.println(
                            "\u001B[3mMercador: Você tem uma missão nesta cidade." +
                                    "\nDeseja concluir a missão?" +
                                    "\nS - sim\nN - não\u001B[0m");
                }

            } else {
                System.out.println("Você não possui missões para receber recompensa! Digite: PASS");
            }
            System.out.print("Resposta: ");
            String concluirMissao = sc.nextLine();
            System.out.println("");

            if (cidadeAtual.nome.equals("Grand Duchy of Smalia")) {
                if (!missaoAceita && missaoConcluida) {
                    if (concluirMissao.equalsIgnoreCase("S")) {
                        ger.setMoeda(ger.getMoeda() + 2);
                        ger.setLimiar(ger.getLimiar() + 2);
                        missaoConcluida = true;
                        missaoAtual -= 1;
                        System.out.println("\u001B[3mMercador: VOCÊ RECEBEU AS LUVAS DO PODER.\u001B[0m");
                        ger.imprimirMoeda();
                        ger.imprimirLimiar();
                    } else {
                        System.out.println("Você decidiu abandonar a missão.");
                        missaoAceita = false;
                        missaoAtual -= 1;
                    }
                }
            } else if (cidadeAtual.nome.equals("Principality of Kasya")) {
                if (!missaoAceita && missaoConcluida) {
                    if (concluirMissao.equalsIgnoreCase("S")) {
                        ger.setMoeda(ger.getMoeda() + 3);
                        ger.setLimiar(ger.getLimiar() + 1);
                        missaoConcluida = true;
                        missaoAtual -= 1;
                        System.out.println("\u001B[3mMercador: VOCÊ RECEBEU AS BOTAS DO PODER.\u001B[0m");
                        ger.imprimirMoeda();
                        ger.imprimirLimiar();
                    } else {
                        System.out.println("Você decidiu abandonar a missão.");
                        missaoAceita = false;
                        missaoAtual -= 1;
                    }
                } else if (cidadeAtual.nome.equals("Ubud")) {
                    if (!missaoAceita && missaoConcluida) {
                        if (concluirMissao.equalsIgnoreCase("S")) {
                            ger.setMoeda(ger.getMoeda() + 10);
                            ger.setLimiar(ger.getLimiar() - 4);
                            missaoConcluida = true;
                            missaoAtual -= 1;
                            System.out.println("\u001B[3mMercador: VOCÊ RECEBEU A GLÓRIA DOS RETORNADOS.\u001B[0m");
                            ger.imprimirMoeda();
                            ger.imprimirLimiar();
                        } else {
                            System.out.println("Você decidiu abandonar a missão.");
                            missaoAceita = false;
                            missaoAtual -= 1;
                        }
                    }
                }
            } else if (concluirMissao.equalsIgnoreCase("PASS")) {
                System.out
                        .println(
                                "Sem missões disponíveis, sem recompensa. Continue sua jornada!");
            }
            System.out.println("");

            // Questionário mercador
            System.out.println("------------------------------------------------------------------------");
            System.out.print("\u001B[3mMercador: \u001B[0m");
            System.out.println("\u001B[3mA. Quantas moedas de transporte você tem?\u001B[0m");
            ger.imprimirMoeda();
            System.out.println("\u001B[3mB. Qual custo de onde você vem e para onde você vai?\u001B[0m");
            System.out.println("Custo: $" + arestaEscolhida.custo);
            System.out.println("\u001B[3mD. Deseja trocar suas moedas por limiar na jóia?" +
                    "\n1 - Sim\n2 - Não\u001B[0m");
            System.out.print("Resposta: ");
            int opcaoMoedaLimiar = sc.nextInt();
            sc.nextLine();
            System.out.println("------------------------------------------------------------------------");
            mercador.decisoesQuestionario(opcaoMoedaLimiar, arestaEscolhida.custo);
            System.out.println("");
            ger.imprimirMoeda();

            if (ger.getLimiar() < ger.getPoderJoia() || ger.getMoeda() == 0 || cidadeAtual.nome.equals("Nargumun")) {
                break;
            }

        }

        System.out.println("");
        System.out.println("##### Fim #####");
        // Exibir informações finais do jogo
        System.out.print("Cidades visitadas: ");
        for (Cidade cidade : cidadesVisitadas) {
            System.out.print(cidade.nome + " -> ");
        }
        System.out.println("");
        ger.imprimirMoeda();
        ger.imprimirLimiar();
        ger.imprimirPoderJoia();
        System.out.println("Última cidade visitada: " + cidadeAtual.nome);

        sc.close();
    }

}