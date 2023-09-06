import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessDeliveryOrders {

    public static DeliveryOrder findFirstOrder(List<DeliveryOrder> orders) {
        return orders.stream()
                .min(DeliveryOrder.getComparatorByDeliveryDate())
                .orElse(new DeliveryOrder());
    }

    public static List<DeliveryOrder> printAddressesToDeliver(List<DeliveryOrder> orders) {
        return orders.stream()
                .sorted(DeliveryOrder.getComparatorByDeliveryDate())
                .distinct()
                .toList();
    }

    public static List<DeliveryOrder> printAddressesToDeliverNJ(List<DeliveryOrder> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(DeliveryOrder::getDeliveryDate).thenComparing(DeliveryOrder::getAddress))
                .distinct()
                .collect(Collectors.toList());
    }
}
