package codeWars.createPhoneNumber;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class createPhoneNumberTest {

    @Test
    void createPhoneNumber() {
        assertEquals("(123) 456-7890", createPhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}