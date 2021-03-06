import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeFactorsCalculatorTest {

    private long input;
    private List<Long> expectedOutput;

    @Parameters(name="Prime factors of {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1L, Collections.emptyList()},
                {2L, Collections.singletonList(2L)},
                {9L, Arrays.asList(3L, 3L)},
                {8L, Arrays.asList(2L, 2L, 2L)},
                {12L, Arrays.asList(2L, 2L, 3L)},
                {901255L, Arrays.asList(5L, 17L, 23L, 461L)},
                {93819012551L, Arrays.asList(11L, 9539L, 894119L)}
        });
    }

    public PrimeFactorsCalculatorTest(long input, List<Long> expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void test() {
        assertEquals(expectedOutput, new PrimeFactorsCalculator().calculatePrimeFactorsOf(input));
    }

}
