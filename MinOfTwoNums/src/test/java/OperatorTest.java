import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class OperatorTest {

    @Test
    public void whenGiven6and7ThenExpect6() {
        int num1 = 6;
        int num2 = 7;

        assertThat(Operator.function.apply(num1, num2)).isEqualTo(6);
    }
}
