import java.util.Scanner;

public class Mercador {

    Scanner sc = new Scanner(System.in);
    GerenciadorLPM gerenciador = new GerenciadorLPM();

    public void menuQuestinario() {
        System.out.println("");
        System.out.print("\u001B[3mMercador: \u001B[0m");
        System.out.println("\u001B[3mA. Quantas moedas de transporte você tem?\u001B[0m");
        gerenciador.imprimirMoeda();
        System.out.println("\u001B[3mB. De onde você vem?\u001B[0m");
        System.out.println("\u001B[3mC. Para onde você vai?\u001B[0m");
        System.out.println("\u001B[3mD. Deseja trocar suas moedas por limiar na jóia?" +
                "\n1 - Sim\n2 - Não\u001B[0m");
        System.out.print("Resposta: ");
    }

    public int decisoesQuestionario(int opcaoMoedaLimiar, int distancia) {
        if (gerenciador.getMoeda() < 5) {
            if (distancia < 3) {
                if (opcaoMoedaLimiar == 1) {
                    gerenciador.setMoeda(-1);
                    gerenciador.setLimiar(1);
                    System.out.println("-1 Moeda, +1 Limiar");
                    //gerenciador.imprimirMoeda();
                    //gerenciador.imprimirLimiar();
                } else {
                    gerenciador.setMoeda(-1);
                    System.out.println("-1 Moeda");
                    //gerenciador.imprimirMoeda();
                }
            } else {
                if (opcaoMoedaLimiar == 1) {
                    gerenciador.setMoeda(-1);
                    gerenciador.setLimiar(2);
                    System.out.println("-1 Moeda, +2 Limiar");
                    //gerenciador.imprimirMoeda();
                    //gerenciador.imprimirLimiar();
                } else {
                    gerenciador.setMoeda(2);
                    System.out.println("+2 Limiar");
                    //gerenciador.imprimirMoeda();
                }
            }
            return gerenciador.getMoeda();
        } else {
            if (distancia < 3) {
                if (opcaoMoedaLimiar == 1) {
                    gerenciador.setMoeda(-3);
                    gerenciador.setLimiar(2);
                    System.out.println("-3 Moeda, +2 Limiar");
                    //gerenciador.imprimirMoeda();
                    //gerenciador.imprimirLimiar();
                } else {
                    gerenciador.setMoeda(-2);
                    System.out.println("-2 Moeda");
                    //gerenciador.imprimirMoeda();
                }
            } else {
                if (opcaoMoedaLimiar == 1) {
                    gerenciador.setMoeda(-1);
                    gerenciador.setLimiar(3);
                    System.out.println("-1 Moeda, +3 Limiar");
                    //gerenciador.imprimirMoeda();
                    //gerenciador.imprimirLimiar();
                } else {
                    gerenciador.setMoeda(-3);
                    System.out.println("-3 Moeda");
                    //gerenciador.imprimirMoeda();
                }
            }
            return gerenciador.getMoeda();
        }
    }

}
