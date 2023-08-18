import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CalculatorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    StringBuilder sb;
    @Before
    public void setUp() {
        sb = new StringBuilder();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void givenDefault10WhenEvaluatedThenExpectCorrectOutput() {
        Calculator.of(10)
                .consume(value -> sb.append(value).append(System.lineSeparator()))
                .eval(value -> value * 10)
                .eval(value -> value + 5)
                .consume(sb::append);

        String result = sb.toString().replaceAll("\r", "");

        String expected = """
                10
                105""";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenDefault10WhenEvaluatedWithArithmeticExceptionThenExpectExceptionIsHandled() {
        Calculator.of(10)
                .consume(value -> sb.append(value).append(System.lineSeparator()))
                .eval(value -> value * 10)
                .eval(value -> value + 5)
                .consume(sb::append)
                .eval(value -> value / 0)
                .consume(System.out::println);

        String result = sb.toString().replaceAll("\r", "");

        String expected = """
                10
                105""";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenDefaultNullWhenEvaluatedThenExpectNullIsHandled() {
        Calculator.of((Integer) null)
                .eval(value -> value * 10)
                .eval(value -> value + 5)
                .consume(System.out::println);

        Assert.assertEquals("", outputStreamCaptor.toString());
    }

    @Test
    public void givenValue10WhenEvalWithNullThenPrintNothing() {
        Calculator.of(10)
                .eval(value -> value + 5)
                .consume(System.out::println)
                .eval(value -> null)
                .consume(System.out::println);

        Assert.assertEquals("15\r\n", outputStreamCaptor.toString());
    }

}