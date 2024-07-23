import java.util.Random;

public class CompMind extends PointSystem  {
    static Random rn = new Random();


    public static String compMind(){
        if (compCardPoints>=183 ) {
            String[]probablity ={"d","d","d","d","d","d","d","d","b","b","b","b"};
            
            return probablity[rn.nextInt(probablity.length)];
        }
        if (compCardPoints>=150&&compCardPoints<183 ) {
            String[]probablity ={"d","d","d","d","d","b","b","b","b","b","b","b"};
            
            return probablity[rn.nextInt(probablity.length)];
        }
        if (compCardPoints>=114 && compCardPoints<150 ) {
            String[]probablity ={"d","d","b","b","b","b","b","b","b","b","b","b"};
            
            return probablity[rn.nextInt(probablity.length)];
        }
        if (compCardPoints>=80 && compCardPoints<114 ) {
            String[]probablity ={"d","b","b","b","b","b","b","b","b","b","d","s"};
            
            return probablity[rn.nextInt(probablity.length)];
        }
        if (compCardPoints>=38 && compCardPoints<80 ) {
            String[]probablity ={"b","b","b","b","b","b","b","b","b","b","b","s"};
            
            return probablity[rn.nextInt(probablity.length)];
        }
        else {
            String[]probablity ={"d","d","b","b","b","b","b","b","b","s","s","s"};
            
            return probablity[rn.nextInt(probablity.length)];
        }
    }
    public static void printCompDescision(){
        switch (compMind()) {

            case "b":
                moneyOnTable+=currBettingAmount;
                printcompdes=" COMP BET THE CURRENT AMOUNT  ";
                break;
            case "d":
                currBettingAmount=currBettingAmount*2;
                moneyOnTable+=currBettingAmount;
                printcompdes= "    COMP BET DOUBLE AMOUNT    ";
                break;
            case "s":
                    compWantToShow=true;
                    moneyOnTable+=currBettingAmount;
                    show();
                printcompdes= "       COMP WANTS TO SHOW     ";
                break;
            default:
                printcompdes= "  please enter a vaild input  ";
                break;
        }
           // length = 30
    }
    public static int countingCompPoints(){
        int a = Integer.valueOf(cards[sixCardsIndex[3]][2]);
        int b = Integer.valueOf(cards[sixCardsIndex[4]][2]);
        int c = Integer.valueOf(cards[sixCardsIndex[5]][2]);
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = (max+min)/2;


        if (cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[1]][0]) && cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[2]][0])) {
            return 180+a+b+c;     // trail
        }
        if (cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[1]][1])&& cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[2]][1]) && min+1==mid&&max-1==mid) {
            return 144+a+b+c;    // colour seq
        }
        if (min+1==mid&&max-1==mid) {
            return 108+a+b+c;   //  seq
        }
        if (cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[1]][1])&& cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[2]][1])) {
            
            return 73+a+c+b;    //colour
        }
        if (cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[1]][0]) || cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[2]][0]) ||cards[sixCardsIndex[1]][0].equals(cards[sixCardsIndex[2]][0]) && !(cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[1]][0]) && cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[2]][0])) ) {
            return 35+a+b+c;     // pairs
        }
         else   return a+b+c;

    }
}
