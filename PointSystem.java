import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PointSystem extends mainn {

    static String[][] cards = { { " ACE ", "DIAMOND", "13" },
            { " KING", "DIAMOND", "12" },
            { "QUEEN", "DIAMOND", "11" },
            { " JACK", "DIAMOND", "10" },
            { "  10 ", "DIAMOND", "9" },
            { "   9 ", "DIAMOND", "8" },
            { "   8 ", "DIAMOND", "7" },
            { "   7 ", "DIAMOND", "6" },
            { "   6 ", "DIAMOND", "5" },
            { "   5 ", "DIAMOND", "4" },
            { "   4 ", "DIAMOND", "3" },
            { "   3 ", "DIAMOND", "2" },
            { "   2 ", "DIAMOND", "1" },

            { " ACE ", " SPADE ", "13" },
            { " KING", " SPADE ", "12" },
            { "QUEEN", " SPADE ", "11" },
            { " JACK", " SPADE ", "10" },
            { "  10 ", " SPADE ", "9" },
            { "   9 ", " SPADE ", "8" },
            { "   8 ", " SPADE ", "7" },
            { "   7 ", " SPADE ", "6" },
            { "   6 ", " SPADE ", "5" },
            { "   5 ", " SPADE ", "4" },
            { "   4 ", " SPADE ", "3" },
            { "   3 ", " SPADE ", "2" },
            { "   2 ", " SPADE ", "1" },

            { " ACE ", " CLUB  ", "13" },
            { " KING", " CLUB  ", "12" },
            { "QUEEN", " CLUB  ", "11" },
            { " JACK", " CLUB  ", "10" },
            { "  10 ", " CLUB  ", "9" },
            { "   9 ", " CLUB  ", "8" },
            { "   8 ", " CLUB  ", "7" },
            { "   7 ", " CLUB  ", "6" },
            { "   6 ", " CLUB  ", "5" },
            { "   5 ", " CLUB  ", "4" },
            { "   4 ", " CLUB  ", "3" },
            { "   3 ", " CLUB  ", "2" },
            { "   2 ", " CLUB  ", "1" },

            { " ACE ", " HEART ", "13" },
            { " KING", " HEART ", "12" },
            { "QUEEN", " HEART ", "11" },
            { " JACK", " HEART ", "10" },
            { "  10 ", " HEART ", "9" },
            { "   9 ", " HEART ", "8" },
            { "   8 ", " HEART ", "7" },
            { "   7 ", " HEART ", "6" },
            { "   6 ", " HEART ", "5" },
            { "   5 ", " HEART ", "4" },
            { "   4 ", " HEART ", "3" },
            { "   3 ", " HEART ", "2" },
            { "   2 ", " HEART ", "1" },
    };

    // it will just return the descisions based on the card point of comp
    // should not contain any extra variable , all variable should be created in
    // mainn class

    public static int[] shuffle() {
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] arr = { (int) list.get(2), (int) list.get(5), (int) list.get(7), (int) list.get(9), (int) list.get(11),
                (int) list.get(13) };
        return arr;
    }

    public static int countingPlayerPoints() {
        int a = Integer.valueOf(cards[sixCardsIndex[0]][2]);
        int b = Integer.valueOf(cards[sixCardsIndex[1]][2]);
        int c = Integer.valueOf(cards[sixCardsIndex[2]][2]);
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = (max + min) / 2;

        if (cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[1]][0])
                && cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[2]][0])) {
            return 180 + a + b + c; // trail
        }
        if (cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[1]][1])
                && cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[2]][1]) && min + 1 == mid && max - 1 == mid) {
            return 144 + a + b + c; // colour seq
        }
        if (min + 1 == mid && max - 1 == mid) {
            return 108 + a + b + c; // seq
        }
        if (cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[1]][1])
                && cards[sixCardsIndex[0]][1].equals(cards[sixCardsIndex[2]][1])) {

            return 73 + a + c + b; // colour
        }
        if (cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[1]][0])
                || cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[2]][0])
                || cards[sixCardsIndex[1]][0].equals(cards[sixCardsIndex[2]][0])
                        && !(cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[1]][0])
                                && cards[sixCardsIndex[0]][0].equals(cards[sixCardsIndex[2]][0]))) {
            return 35 + a + b + c; // pairs
        } else
            return a + b + c;

    }
}
