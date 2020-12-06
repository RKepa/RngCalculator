package pl.example.rngcalculator;

import lombok.Data;

@Data
public class RngResultDto<T> {
    final T result;
}
