package product.processed;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiaryTest {
    
    @Test
    public void checkDiscountTest(){
        Diary diary = new Diary(null, 0, 0, null);
        int expectedOutput = 0;
        int actualOutput = diary.checkDiscount(7);
        assertEquals(expectedOutput, actualOutput);
    }
}
