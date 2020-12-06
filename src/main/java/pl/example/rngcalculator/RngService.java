package pl.example.rngcalculator;

import java.io.IOException;

public interface RngService<T> {

    T addTwoNumbers(Class<T> clazz) throws IOException;


}
