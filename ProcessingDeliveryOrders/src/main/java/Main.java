import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DeliveryOrder> orders = List.of(
                new DeliveryOrder(1, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.parse("2021-09-03")),
                new DeliveryOrder(2, "369 Woodside Court, Troy, NY 12180", LocalDate.parse("2021-09-05")),
                new DeliveryOrder(3, "837 Bowman Street, Helena, MT 59601", LocalDate.parse("2021-09-02")),
                new DeliveryOrder(4, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.parse("2021-09-03"))
        );

        System.out.println(ProcessDeliveryOrders.findFirstOrder(orders));

        ProcessDeliveryOrders.printAddressesToDeliverNJ(orders).forEach(deliveryOrder -> System.out.println(deliveryOrder.getAddress()));
        System.out.println(LocalDate.MIN);
    }
}

/*
final Scanner scanner = new Scanner(System.in);

List<DeliveryOrder> orders = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
        .map(i -> scanner.nextLine().split("\\|"))
        .map(parts -> new DeliveryOrder(
                Long.parseLong(parts[0]), parts[2], LocalDate.parse(parts[1])))
        .collect(Collectors.toList());
 */