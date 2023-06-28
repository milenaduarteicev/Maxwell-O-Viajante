class Main {
    public static void main(String[] args) {
        Cidade cidadeA = new Cidade("Ubud");
        Cidade cidadeB = new Cidade("Kingdom of Legmod");
        Cidade cidadeC = new Cidade("Principality of Nekikh");
        Cidade cidadeD = new Cidade("Principality of Gritesthr");
        Cidade cidadeE = new Cidade("Protectorate of Dogrove");
        Cidade cidadeF = new Cidade("Kingdom of Lastwatch");
        Cidade cidadeG = new Cidade("Grand Duchy of Smalia");
        Cidade cidadeH = new Cidade("Kingdom of Oldcalia");
        Cidade cidadeI = new Cidade("Kingdom of Kalb");
        Cidade cidadeJ = new Cidade("Aymar League");
        Cidade cidadeK = new Cidade("Defalsia");
        Cidade cidadeL = new Cidade("Vunese Empire");
        Cidade cidadeM = new Cidade("Principality of Karhora");
        Cidade cidadeN = new Cidade("Chandir Sultanate");
        Cidade cidadeO = new Cidade("Bun");
        Cidade cidadeP = new Cidade("Principality of Kasya");
        Cidade cidadeQ = new Cidade("Nargumun");

        // Adicionar as ligações entre as cidades
        cidadeA.adicionarLigacao(cidadeB, 2); //
        cidadeA.adicionarLigacao(cidadeC, 1); //

        cidadeB.adicionarLigacao(cidadeA, 0); //
        cidadeB.adicionarLigacao(cidadeC, 1); //
        cidadeB.adicionarLigacao(cidadeD, 5); //
        cidadeB.adicionarLigacao(cidadeE, 3); //
        cidadeB.adicionarLigacao(cidadeH, 4); //

        cidadeC.adicionarLigacao(cidadeA, 0); //
        cidadeC.adicionarLigacao(cidadeB, 2); //
        cidadeC.adicionarLigacao(cidadeD, 5); //

        cidadeD.adicionarLigacao(cidadeB, 2); //
        cidadeD.adicionarLigacao(cidadeC, 1); //
        cidadeD.adicionarLigacao(cidadeE, 2); //
        cidadeD.adicionarLigacao(cidadeF, -2); //

        cidadeE.adicionarLigacao(cidadeB, 2); //
        cidadeE.adicionarLigacao(cidadeD, 5); //
        cidadeE.adicionarLigacao(cidadeF, -2); //
        cidadeE.adicionarLigacao(cidadeH, 4); //

        cidadeF.adicionarLigacao(cidadeD, 5); //
        cidadeF.adicionarLigacao(cidadeE, -3); //
        cidadeF.adicionarLigacao(cidadeG, 1); //
        cidadeF.adicionarLigacao(cidadeH, 4); //

        cidadeG.adicionarLigacao(cidadeF, 2); //
        cidadeG.adicionarLigacao(cidadeH, 4); //

        cidadeH.adicionarLigacao(cidadeB, 2); //
        cidadeH.adicionarLigacao(cidadeE, 3); //
        cidadeH.adicionarLigacao(cidadeF, -2); //
        cidadeH.adicionarLigacao(cidadeG, 1); //
        cidadeH.adicionarLigacao(cidadeI, 2); //
        cidadeH.adicionarLigacao(cidadeJ, 1); //
        cidadeH.adicionarLigacao(cidadeK, -3); //

        cidadeI.adicionarLigacao(cidadeH, 4); //
        cidadeI.adicionarLigacao(cidadeJ, 1); //
        cidadeI.adicionarLigacao(cidadeL, 0); //

        cidadeJ.adicionarLigacao(cidadeH, 4); //
        cidadeJ.adicionarLigacao(cidadeI, 2); //
        cidadeJ.adicionarLigacao(cidadeK, -3); //
        cidadeJ.adicionarLigacao(cidadeL, 0); //
        cidadeJ.adicionarLigacao(cidadeM, -2); //
        cidadeJ.adicionarLigacao(cidadeN, 1); //
        cidadeJ.adicionarLigacao(cidadeO, 5); //
        cidadeJ.adicionarLigacao(cidadeQ, 0); //

        cidadeK.adicionarLigacao(cidadeH, 4); //
        cidadeK.adicionarLigacao(cidadeJ, 1); //

        cidadeL.adicionarLigacao(cidadeI, 0); //
        cidadeL.adicionarLigacao(cidadeJ, 1); //
        cidadeL.adicionarLigacao(cidadeN, 1); //

        cidadeM.adicionarLigacao(cidadeJ, 1); //
        cidadeM.adicionarLigacao(cidadeQ, 0); //

        cidadeN.adicionarLigacao(cidadeJ, 1); //
        cidadeN.adicionarLigacao(cidadeL, 0); //
        cidadeN.adicionarLigacao(cidadeO, 5); //
        cidadeN.adicionarLigacao(cidadeP, -7); //

        cidadeO.adicionarLigacao(cidadeJ, 1); //
        cidadeO.adicionarLigacao(cidadeN, 1); //
        cidadeO.adicionarLigacao(cidadeQ, 0); //

        cidadeP.adicionarLigacao(cidadeN, 1); //

        cidadeQ.adicionarLigacao(cidadeJ, 1); //
        cidadeQ.adicionarLigacao(cidadeM, -2); //
        cidadeQ.adicionarLigacao(cidadeO, 5); //

        // Iniciar o jogo
        Game.game(cidadeA);
    }

}