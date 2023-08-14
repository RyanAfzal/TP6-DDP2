package product.processed;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiaryTest {
    
    @Test
    public void checkDiscountTest(){
        Diary diary = new Diary("Keju", 30000, 20, "06 08 2023");
        int expectedOutput = 20;
        int actualOutput = diary.checkDiscount(7);
        assertEquals(expectedOutput, actualOutput);
    }
}
