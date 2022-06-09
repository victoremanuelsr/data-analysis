package org.victoremanuelsr.dataanalysis.test.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.victoremanuelsr.dataanalysis.exceptions.DataAnalysisException;

public class DataAnalysisExceptionTest {
    @Test
    public void exceptionTest(){
        DataAnalysisException exception = Assertions.assertThrows(DataAnalysisException.class, () -> {
            throw new DataAnalysisException("Working");
        });
        Assertions.assertEquals("Working", exception.getMessage());
    }
}
