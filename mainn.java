import java.util.Scanner;

public class mainn {
    static int playerAccount = 100000;
    static int currBettingAmount = 1000;
    static int moneyOnTable = 0;
    static int[] sixCardsIndex = PointSystem.shuffle();
    static String[] hiddenPlayerCards = {".....CARD 1...." , ".....CARD 2...." ,".....CARD 3...."};
    static String[] hiddenCompCards =   {".....CARD 1...." , ".....CARD 2...." ,".....CARD 3...."};

    static int playerCardPoints=0;
    static int compCardPoints=0;
    static int winningAmount=0;

    
    static Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void homePage() {
        clearScreen();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|            _______               _______    ________   _________  _________  _________             |");
        System.out.println("|                   |             |       |  |        |      |          |          |                 |");
        System.out.println("|                   |             |       |  |        |      |          |          |                 |");
        System.out.println("|              _____|             |_______|  |________|      |          |          |                 |");
        System.out.println("|                   |             |          |        |      |          |          |                 |");
        System.out.println("|                   |             |          |        |      |          |          |                 |");
        System.out.println("|            _______|             |          |        |      |          |      ____|____             |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                PLAY( P )                                            EXIT ( E )                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        
        String s = "";
        while (true) {
            s = sc.next();
            if (s.equals("p")) {
                break;
            }
            if (s.equals("e")) {
                break;
            }
        }
        if (s.equals("p")) {
            confirmationWindow();
        }
        if (s.equals("e")) {
            System.exit(0);
        }

    }

    public static void confirmationWindow() {
        // confirms wheather the player wants to continue or not
        String s = "";
        clearScreen();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|            _______               _______    ________   _________  _________  _________             |");
        System.out.println("|                   |             |       |  |        |      |          |          |                 |");
        System.out.println("|                   |             |       |  |        |      |          |          |                 |");
        System.out.println("|              _____|             |_______|  |________|      |          |          |                 |");
        System.out.println("|                   |             |          |        |      |          |          |                 |");
        System.out.println("|                   |             |          |        |      |          |          |                 |");
        System.out.println("|            _______|             |          |        |      |          |      ____|____             |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                             YOUR CURRENT AMOUNT IS : "+playerAccount);
        System.out.println("|                                                                                                    |");
        System.out.println("|                                    PRESS ( C ) TO CONTINUE                                         |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        while (true) {
            s = sc.next();
            if (s.equals("c")) {
                setEverything();
                break;
            }
            if (!s.equals("c")) {
                System.out.println("enter a valid input ");
            }
        }
    }

    public static void table() {

        clearScreen();

        // pack show bet doubleBet LeaveTheTable ExitTheGame
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                           AMOUNT : $ "+playerAccount);
        System.out.println("|                                                                                                    |");
        System.out.println("|                COMPUTER                                                 PLAYER                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("|              "+hiddenCompCards[0]+"                                        "+hiddenPlayerCards[0]+"                |");
        System.out.println("|              "+hiddenCompCards[1]+"                                        "+hiddenPlayerCards[1]+"                |");
        System.out.println("|              "+hiddenCompCards[2]+"                                        "+hiddenPlayerCards[2]+"                |");
        System.out.println("|                                                                                                    |");
        System.out.println("|          "+CompMind.printCompDescision()+"                    "+printDescision()+"          |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                   MONEY ON THE TABLE : "+moneyOnTable);
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|              SHOW ( S )        BET ( B )         DOUBLE BET ( D )        SEE CARDS ( C )           |");
        System.out.println("|                                 $ "+currBettingAmount+"            $ "+currBettingAmount*2+"                            ");
        System.out.println("|       LEAVE THE TABLE ( L )                         EXIT THE GAME ( E )                            |");
        System.out.println("|                                                                                                    |");
        System.out.println("------------------------------------------------------------------------------------------------------");

    }
    static String input = "";       // for takeINput() and printDescision() only .

    public static void takeInput() {

        input = sc.next();
        switch (input) {
            case "b":
            printDescision();
                bet();
                break;
            case "d":
            printDescision();
                doubleBet();
                break;

            case "s":
            printDescision();
                show();
                break;
            case "l":
            printDescision();
                LeaveTheTable();
                break;
            case "e":
            printDescision();
                exitTheGame();
                break;
            case "c":
            printDescision();
            seeCards();
            default:
            printDescision();
                break;
        }
        // it will take input from user for every action when and only when the player
        // is on the table .
    }

    public static void exitTheGame() {
        System.exit(0);
        //will exit the game
    }

    public static void LeaveTheTable() {
        // will leave the table , losing all his bet money
        setEverything();
        homePage();
    }


    public static void show() {
        // will show both player and comp cards  , and move on to winning screen
        hiddenPlayerCards[0] =PointSystem.cards[sixCardsIndex[0]][0]+" of "+PointSystem.cards[sixCardsIndex[0]][1];
        hiddenPlayerCards[1] =PointSystem.cards[sixCardsIndex[1]][0]+" of "+PointSystem.cards[sixCardsIndex[1]][1];
        hiddenPlayerCards[2] =PointSystem.cards[sixCardsIndex[2]][0]+" of "+PointSystem.cards[sixCardsIndex[2]][1];

        hiddenCompCards[0] =PointSystem.cards[sixCardsIndex[3]][0]+" of "+PointSystem.cards[sixCardsIndex[3]][1];
        hiddenCompCards[1] =PointSystem.cards[sixCardsIndex[4]][0]+" of "+PointSystem.cards[sixCardsIndex[4]][1];
        hiddenCompCards[2] =PointSystem.cards[sixCardsIndex[5]][0]+" of "+PointSystem.cards[sixCardsIndex[5]][1];

        winningPage();
    }

    public static void seeCards(){
        hiddenPlayerCards[0] =PointSystem.cards[sixCardsIndex[0]][0]+" of "+PointSystem.cards[sixCardsIndex[0]][1];
        hiddenPlayerCards[1] =PointSystem.cards[sixCardsIndex[1]][0]+" of "+PointSystem.cards[sixCardsIndex[1]][1];
        hiddenPlayerCards[2] =PointSystem.cards[sixCardsIndex[2]][0]+" of "+PointSystem.cards[sixCardsIndex[2]][1];
    }


    public static void doubleBet() {
        playerAccount-=currBettingAmount*2;
        moneyOnTable+=currBettingAmount*2;
        currBettingAmount = currBettingAmount*2;
        
        // bet double amount 
    }

    public static void bet() {
        playerAccount-=currBettingAmount;
        moneyOnTable+=currBettingAmount;
        // bet curr amount
    }

    public static String printDescision() {
        // it will print the descision
        switch (input) {
            case "c":
                return "        SEE YOUR CARDS        ";
            case "b":
                return "  YOU BET THE CURRENT AMOUNT  ";
            case "d":
                return "     YOU BET DOUBLE AMOUNT    ";
            case "s":
                return "        YOU WANT TO SHOW      ";
            default:
                return "your descisions will show here";
        }
    }

    private static void winningPage() {
        clearScreen();
        winningAmount = moneyOnTable;
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                           AMOUNT : $ "+playerAccount);
        System.out.println("|                                                                                                    |");
        System.out.println("|                COMPUTER                                                 PLAYER                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("|             "+hiddenCompCards[0]+"                                       "+hiddenPlayerCards[0]+"                |");
        System.out.println("|             "+hiddenCompCards[1]+"                                       "+hiddenPlayerCards[1]+"                |");
        System.out.println("|             "+hiddenCompCards[2]+"                                       "+hiddenPlayerCards[2]+"                |");
        System.out.println("|                                                                                                    |");
        System.out.println("|----------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                   MONEY ON THE TABLE : $ "+moneyOnTable);
        System.out.println("|                                     YOU WON -->  $ "+winningAmount+"                                              ");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                  CONTINUE( C )                                                 EXIT( E )           |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("------------------------------------------------------------------------------------------------------");
        String s = "";
        while (true) {
            s = sc.next();
            if (s.equals("c")) {
                setEverything();
                break;
            }
            if (s.equals("e")) {
                System.exit(0);
            }
        }

    }
    private static void setEverything() {
        currBettingAmount = 1000;
        playerAccount+= winningAmount;
        winningAmount=0;
        moneyOnTable=0;
        hiddenCompCards[0]=".....CARD 1....";
        hiddenCompCards[1]=".....CARD 2....";
        hiddenCompCards[2]=".....CARD 3....";
        hiddenPlayerCards[0]=".....CARD 1....";
        hiddenPlayerCards[1]=".....CARD 2....";
        hiddenPlayerCards[2]=".....CARD 3....";
        sixCardsIndex= PointSystem.shuffle();

    }

    public static void main(String[] args) {
        homePage();
        while (true) {
            table();
            takeInput();
            CompMind.compMind();

        }
    }
}