package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void isValidDate() {
        // null date
        assertFalse(Date.isValidDate(null));

        // blank date
        assertFalse(Date.isValidDate(""));
        assertFalse(Date.isValidDate("   "));

        // wrong format: YYYY-MM-DD instead of DD-MM-YYYY
        assertFalse(Date.isValidDate("2026-03-01"));

        // wrong separator
        assertFalse(Date.isValidDate("01/03/2026"));
        assertFalse(Date.isValidDate("01 03 2026"));

        // wrong digit counts
        assertFalse(Date.isValidDate("1-3-2026"));
        assertFalse(Date.isValidDate("01-3-2026"));
        assertFalse(Date.isValidDate("1-03-2026"));
        assertFalse(Date.isValidDate("01-03-26"));

        // non-numeric characters
        assertFalse(Date.isValidDate("ab-cd-efgh"));

        // valid dates in DD-MM-YYYY format
        assertTrue(Date.isValidDate("01-03-2026"));
        assertTrue(Date.isValidDate("31-12-2025"));
        assertTrue(Date.isValidDate("15-06-2024"));
    }
}
