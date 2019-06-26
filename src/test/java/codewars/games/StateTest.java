package codewars.games;

import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {

    private static void testing(String s, String exp) {
        System.out.println("s:\n" + s);
        String ans = State.byState(s);
        System.out.println("Actual:\n" + ans);
        System.out.println("Expect:\n" + exp);
        System.out.println(ans.equals(exp));
        assertEquals(exp, ans);
    }
    @Test
    public void test() {

        String ad0="John Daggett, 341 King Road, Plymouth MA\n" +
                "Alice Ford, 22 East Broadway, Richmond VA\n" +
                "Orville Thomas, 11345 Oak Bridge Road, Tulsa OK\n" +
                "Terry Kalkas, 402 Lans Road, Beaver Falls PA\n" +
                "Eric Adams, 20 Post Road, Sudbury MA\n" +
                "Hubert Sims, 328A Brook Road, Roanoke VA\n" +
                "Amy Wilde, 334 Bayshore Pkwy, Mountain View CA\n" +
                "Sal Carpenter, 73 6th Street, Boston MA";

        String ad3="John Daggett, 341 King Road, Plymouth MA\n" +
                "Alice Ford, 22 East Broadway, Richmond VA\n" +
                "Sal Carpenter, 73 6th Street, Boston MA";

        String a="Massachusetts\n..... John Daggett 341 King Road Plymouth Massachusetts\n..... Sal Carpenter 73 6th Street Boston Massachusetts\n Virginia\n..... Alice Ford 22 East Broadway Richmond Virginia";
        testing(ad3, a);

        a="California\n..... Amy Wilde 334 Bayshore Pkwy Mountain View California\n Massachusetts\n..... Eric Adams 20 Post Road Sudbury Massachusetts\n..... John Daggett 341 King Road Plymouth Massachusetts\n..... Sal Carpenter 73 6th Street Boston Massachusetts\n Oklahoma\n..... Orville Thomas 11345 Oak Bridge Road Tulsa Oklahoma\n Pennsylvania\n..... Terry Kalkas 402 Lans Road Beaver Falls Pennsylvania\n Virginia\n..... Alice Ford 22 East Broadway Richmond Virginia\n..... Hubert Sims 328A Brook Road Roanoke Virginia";
        testing(ad0, a);
    }
}