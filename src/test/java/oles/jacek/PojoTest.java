package oles.jacek;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import nl.jqno.equalsverifier.internal.exceptions.AssertionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PojoTest {

    @Test
    void equalsVerifier_simple() {
        EqualsVerifier.simple().forClass(Pojo.class).verify();
    }

    @Test
    void equalsVerifier_strict_withoutRedefinedSubclass_fails() {
        try {
            EqualsVerifier.forClass(Pojo.class).verify();
        } catch (AssertionError e) {
            assertNotNull(e);
            assertEquals("""
                            EqualsVerifier found a problem in class oles.jacek.Pojo.
                            -> Subclass: equals is not final.
                            Make your class or your equals method final, or supply an instance of a redefined subclass using withRedefinedSubclass if equals cannot be final.
                                                
                            For more information, go to: https://www.jqno.nl/equalsverifier/errormessages
                            (EqualsVerifier 3.15.3, JDK 21 on Windows 11)""",
                    e.getMessage());
            assertNotNull(e.getCause());
            assertInstanceOf(AssertionException.class, e.getCause());
            assertNull(e.getCause().getMessage());
        }
    }

    @Test
    void equalsVerifier_strict_withRedefinedSubclass_succeeds() {
        EqualsVerifier.forClass(Pojo.class).withRedefinedSubclass(PojoRedefinedSubclass.class).verify();
    }

    @Test
    void equalsVerifier_strict_suppressStrictInheritance_succeeds() {
        EqualsVerifier.forClass(Pojo.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }
}