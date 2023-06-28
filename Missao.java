public class Missao {

    boolean missaoAceita = false;
    boolean missaoConcluida = false;
    int missaoAtual = 0;

    public void verificarMissoesVuneseEmpire() {
        if (missaoAtual == 0 && missaoAceita) {
            System.out.println(
                    "\u001B[3mMercador: Uma missão é ofertada a você." +
                            "\nVá até a cidade de  Ubud e receba a Glória dos Retornados." +
                            "\nDeseja aceitar a missão?" +
                            "\nS - Sim\nN - Não\u001B[0m");
            // input na main
        }
    }

    public void verificarMissoesKOKalb() {
        if (missaoAtual == 0 && missaoAceita) {
            System.out.println(
                    "\u001B[3mMercador: Uma missão é ofertada a você." +
                            "\nVá até a cidade de Grand Duchy of Smalia e receba as luvas do poder." +
                            "\nDeseja aceitar a missão?" +
                            "\nS - sim\nN - não\u001B[0m");
            // input na main
        }
    }

    public void verificarMissoesDefalsia() {
        if (missaoAtual == 0 && missaoAceita) {
            System.out.println(
                    "\u001B[3mMercador: Uma missão é ofertada a você." +
                            "\nVá até a cidade de Principality of Kasya e receba as botas do poder." +
                            "\nDeseja aceitar a missão?" +
                            "\nS - sim\nN - não\u001B[0m");
            // input na main
        }
    }

    
    





}
