package pl.example.rngcalculator;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/rng", produces = APPLICATION_JSON_VALUE)
@Api(tags = {"Rng"})
public class RngController {

    private final RngService<Integer> rngService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer JoinTwoNumbers() throws IOException {
        return rngService.addTwoNumbers(Integer.class);
    }


}
