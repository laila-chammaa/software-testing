package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {
    //logic will be implemented in the customerRegistrationService

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }

    @Test
    void itShouldValidatePhoneNumber() {
        //Given a phone number
        String phoneNumber = "+10000000000";
        // When
        boolean isValid = underTest.test(phoneNumber);
        //That
        assertThat(isValid).isTrue();
    }

    @Test
    void itShouldInvalidateLongerPhoneNumber() {
        //Given a phone number
        String phoneNumber = "+10000000000000";
        // When
        boolean isValid = underTest.test(phoneNumber);
        //That
        assertThat(isValid).isFalse();
    }

    @Test
    void itShouldInvalidateIncorrectPhoneNumber() {
        //Given a phone number
        String phoneNumber = "10000000000000";
        // When
        boolean isValid = underTest.test(phoneNumber);
        //That
        assertThat(isValid).isFalse();
    }

    //SO much better like this, replaces all previous tests:

    @ParameterizedTest
    @CsvSource({
            "+10000000000,true",
            "10000000000, false",
            "+123, false"
    })
    void itShouldValidatePhoneNumber(String phoneNumber, boolean expected) {
        //Given a phone number
        // When
        boolean isValid = underTest.test(phoneNumber);
        //That
        assertThat(isValid).isEqualTo(expected);
    }

}
