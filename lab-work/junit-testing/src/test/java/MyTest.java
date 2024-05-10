import org.example.ArrayUtils;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class MyTest {

    @Test
    public void emptyArray(){
        int[] input = {};
        int expected = 0;
        int actual = ArrayUtils.find(input);
        assertEquals(expected, actual);

    }
    @Test
    public void singleOddNumber(){
        int[] input= {1};
        int expected= 1;
        int actual = ArrayUtils.find(input);
        assertEquals(expected, actual);
        }
        @Test
    public void onrOddNumberOneEvenNumber(){
        int[] input= {1,2};
        int expected =-1;
        int actual = ArrayUtils.find(input);
        assertEquals(expected, actual);
        }

    }


