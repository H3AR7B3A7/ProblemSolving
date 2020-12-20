package be.dog.d.steven.strings;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {

    @Test
    void reversing_some_string_test(){
        String reversed = StringMethods.reverseString("test");
        assertEquals(reversed, "tset");
    }

    @Test
    void number_of_letters_in_alphabet_used_test(){
        int number = StringMethods.numberOfLettersUsed(".abcdef,-@abcdef");
        assertEquals(6, number);
    }

    @Test
    void remove_chars_from_second_string_test(){
        String filteredString = StringMethods.removeCharsContainedInSecondString("India", "in");
        assertEquals("da", filteredString);
    }

    @Test
    void frequency_of_highest_frequency_character_test(){
        Map.Entry<Character, Integer> entry = StringMethods.highestFrequencyCharacter("Java");
        assertEquals(new AbstractMap.SimpleEntry<>('a',2),entry);
    }

    @Test
    void check_if_second_string_is_rotation(){
        assertFalse(StringMethods.isRotation("Java", "aJva"));
        assertTrue(StringMethods.isRotation("Java", "avaJ"));
    }


}