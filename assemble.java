public class assemble extends mainn{
    public static void playerTurn(){
        takeInput();
    }
    public static void compTurn(){
        CompMind.compMind();
        CompMind.printCompDescision();
    }
    public static void main(String[] args) {
        homePage();
        table();
        while (true) {
            table();
            playerTurn();
            if (playerWantToShow==true) {
                winningScreen();
                afterRound();
                continue;
            }
            table();
            compTurn();
            if (compWantToShow==true) {
                winningScreen();
                afterRound();
                continue;
            }
            table();

        }
    }
    private static void winningScreen() {
        if (compCardPoints>playerCardPoints) {
            winningAmount=0;
        }
        else winningAmount = moneyOnTable;

        moneyOnTable=0;
        clearScreen();
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                           AMOUNT : $ "+playerAccount);
        System.out.println("|                                                                                                    |");
        System.out.println("|                COMPUTER                                                 PLAYER                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("|              "+hiddenCompCards[0]+"                                        "+hiddenPlayerCards[0]+"                |");
        System.out.println("|              "+hiddenCompCards[1]+"                                        "+hiddenPlayerCards[1]+"                |");
        System.out.println("|              "+hiddenCompCards[2]+"                                        "+hiddenPlayerCards[2]+"                |");
        System.out.println("|                                                                                                    |");
        System.out.println("|          "+printcompdes+"                    "+printDescision()+"          |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                   YOU WON : $ "+winningAmount);
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|              CONTINUE ( C )                                           EXIT( E )                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("------------------------------------------------------------------------------------------------------");

    }
}
