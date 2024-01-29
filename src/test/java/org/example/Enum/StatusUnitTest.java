package org.example.Enum;

import org.example.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class StatusUnitTest {

    @Test
    void testEnumValues(){
        Assertions.assertEquals("New", Status.NEW.getLabel());
        Assertions.assertEquals("Active", Status.ACTIVE.getLabel());
        Assertions.assertEquals("Complete", Status.COMPLETE.getLabel());
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void testEnumLabels(Status status){
        Assertions.assertEquals(status.getLabel().toUpperCase(),status.name());
    }
}
