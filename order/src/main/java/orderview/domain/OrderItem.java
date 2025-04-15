package orderview.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import orderview.OrderApplication;

@Entity
@Table(name = "OrderItem_table")
@Data
//<<< DDD / Aggregate Root
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Double price;

    public static OrderItemRepository repository() {
        OrderItemRepository orderItemRepository = OrderApplication.applicationContext.getBean(
            OrderItemRepository.class
        );
        return orderItemRepository;
    }
}
//>>> DDD / Aggregate Root
