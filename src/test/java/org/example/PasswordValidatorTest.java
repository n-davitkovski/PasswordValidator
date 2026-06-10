package org.example;

import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void shouldAcceptValidPassword() {
        assertTrue(validator.isValid("Password1!"));
    }

    @Test
    void shouldAcceptPasswordWithExactly8Characters() {
        assertTrue(validator.isValid("Abcde1!f"));
    }

    @Test
    void shouldAcceptPasswordWithExactly20Characters() {
        assertTrue(validator.isValid("Abcdefghijklmno1!Pqr"));
    }

    @Test
    void shouldRejectPasswordWithExactly7Characters() {
        assertFalse(validator.isValid("Abcd1!E"));
    }

    @Test
    void shouldRejectPasswordWithExactly21Characters() {
        assertFalse(validator.isValid("Abcdefghijklmnop1!Qrs"));
    }

    @Test
    void shouldAcceptPasswordWithAllowedSpecialCharacter() {
        assertTrue(validator.isValid("Password1!"));
    }

    @Test
    void shouldRejectPasswordWithDisallowedSpecialCharacterOnly() {
        assertFalse(validator.isValid("Password1?"));
    }

    @Test
    void shouldRejectNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldRejectEmptyPassword() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void shouldRejectPasswordWithoutUppercaseLetter() {
        assertFalse(validator.isValid("password1!"));
    }

    @Test
    void shouldRejectPasswordWithoutLowercaseLetter() {
        assertFalse(validator.isValid("PASSWORD1!"));
    }

    @Test
    void shouldRejectPasswordWithoutDigit() {
        assertFalse(validator.isValid("Password!"));
    }

    @Test
    void shouldRejectPasswordContainingSpaces() {
        assertFalse(validator.isValid("Password 1!"));
    }

    @Test
    void shouldRejectPasswordShorterThan8Characters() {
        assertFalse(validator.isValid("Ab1!cd"));
    }

    @Test
    void shouldRejectPasswordLongerThan20Characters() {
        assertFalse(validator.isValid("Abcdefghijklmnopq1!Rst"));
    }

    @Test
    void shouldRejectPasswordWithMultipleRuleViolations() {
        assertFalse(validator.isValid("password"));
    }
}
