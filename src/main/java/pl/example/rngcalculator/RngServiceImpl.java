package pl.example.rngcalculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Double.parseDouble;
import static pl.example.rngcalculator.RngRestClient.generateRandomNumber;

@Service
@RequiredArgsConstructor
public class RngServiceImpl implements RngService<String> {

    @Value("${rng-calc.min}")
    private int min;
    @Value("${rng-calc.max}")
    private int max;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String addTwoNumbers(Class<String> clazz) throws IOException {
        String firstNumber = generateRandomNumber(mapper, min, max);
        Double secondNumber = generateSecondNumber(min, max);
        double result = parseDouble(firstNumber) + secondNumber;
        return clazz.cast(Double.toString(result));
    }

    private Double generateSecondNumber(int min, int max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

}
