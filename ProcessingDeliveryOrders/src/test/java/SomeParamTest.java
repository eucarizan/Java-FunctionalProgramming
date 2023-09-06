import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} processDelivery(input)")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample " +
                    ": " +
                    "1|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911; " +
                    "2|2021-09-05|369 Woodside Court, Troy, NY 12180; " +
                    "3|2021-09-02|837 Bowman Street, Helena, MT 59601; " +
                    "4|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911 " +
                    ": " +
                    "3|2021-09-02|837 Bowman Street, Helena, MT 59601; " +
                    "837 Bowman Street, Helena, MT 59601; " +
                    "112 Mammoth Street, Colorado Springs, CO 80911; " +
                    "369 Woodside Court, Troy, NY 12180",
    }, delimiter = ':')
    public void test(String name, String input, String expectedStr) {
        List<DeliveryOrder> orders = Arrays.stream(input.split("; "))
                .map(s -> s.split("\\|"))
                .map(parts -> new DeliveryOrder(Long.parseLong(parts[0]), parts[2], LocalDate.parse(parts[1])))
                .toList();

        List<String> expected = Arrays.stream(expectedStr.split("; "))
                .toList();

        List<String> result = new ArrayList<>();

        result.add(ProcessDeliveryOrders.findFirstOrder(orders).toString());
        ProcessDeliveryOrders.printAddressesToDeliver(orders).forEach(order -> result.add(order.getAddress()));

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testFindFirstOrderWithMultipleOrders() {
        List<DeliveryOrder> orders = List.of(
                new DeliveryOrder(1, "Address1", LocalDate.parse("2021-09-03")),
                new DeliveryOrder(2, "Address2", LocalDate.parse("2021-09-05")),
                new DeliveryOrder(3, "Address3", LocalDate.parse("2021-09-02"))
        );

        DeliveryOrder result = ProcessDeliveryOrders.findFirstOrder(orders);

        assertEquals(3, result.getOrderId());
        assertEquals("Address3", result.getAddress());
        assertEquals(LocalDate.parse("2021-09-02"), result.getDeliveryDate());
    }

    @Test
    public void testFindFirstOrderWithEmptyList() {
        List<DeliveryOrder> orders = List.of();

        DeliveryOrder result = ProcessDeliveryOrders.findFirstOrder(orders);

        assertEquals(-1, result.getOrderId());
        assertEquals("No address", result.getAddress());
        assertEquals("-999999999-01-01", result.getDeliveryDate().toString());
    }

    @Test
    public void testPrintAddressesToDeliverWithDuplicates() {
        List<DeliveryOrder> orders = List.of(
                new DeliveryOrder(1, "Address1", LocalDate.parse("2021-09-03")),
                new DeliveryOrder(2, "Address2", LocalDate.parse("2021-09-05")),
                new DeliveryOrder(3, "Address3", LocalDate.parse("2021-09-02")),
                new DeliveryOrder(4, "Address1", LocalDate.parse("2021-09-03"))
        );

        List<DeliveryOrder> result = ProcessDeliveryOrders.printAddressesToDeliver(orders);

        assertEquals(3, result.size());
        assertTrue(result.contains(new DeliveryOrder(1, "Address1", LocalDate.parse("2021-09-03"))));
        assertTrue(result.contains(new DeliveryOrder(2, "Address2", LocalDate.parse("2021-09-05"))));
        assertTrue(result.contains(new DeliveryOrder(3, "Address3", LocalDate.parse("2021-09-02"))));
    }

    @Test
    public void testPrintAddressesToDeliverWithEmptyList() {
        List<DeliveryOrder> orders = List.of();

        List<DeliveryOrder> result = ProcessDeliveryOrders.printAddressesToDeliver(orders);

        assertTrue(result.isEmpty());
    }

}
