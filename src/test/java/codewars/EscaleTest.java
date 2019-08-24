package codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class EscaleTest extends Escale {

    @Test
    public void should() {
        String s = "Sun 10:00-20:00" +"\n" + "Fri 05:00-10:00" + "\n" + "Fri 16:30-23:50" +"\n" + "Sat 10:00-24:00" + "\n" + "Sun 01:00-04:00";

        Escale.solution(s);
    }

}