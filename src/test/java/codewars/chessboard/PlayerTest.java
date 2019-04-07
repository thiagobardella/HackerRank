package codewars.chessboard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void checkChessboard() {


        assertEquals("[0]", Player.game(0));
        assertEquals("[1, 2]", Player.game(1));
        assertEquals("[32]", Player.game(8));
        Player.game(100000000);



    }

}