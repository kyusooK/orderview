package orderview.domain;

import orderview.domain.OrderPlaced;
import orderview.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Order_table")
@Data

//<<< DDD / Aggregate Root
public class Order  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String userId;
    
    private Integer qty;
    
    private String address;

    private String productName;

    @PostPersist
    public void onPostPersist(){
        // OrderItem Repository를 통해 조회
        OrderItemRepository orderItemRepository = OrderItem.repository();
        
        // 예: productName으로 조회하는 경우
        String searchProductName = this.getProductName(); // 실제 검색할 상품명으로 변경 필요
        OrderItem foundOrderItem = orderItemRepository.getOrderItem(searchProductName);
        
        // 조회 결과 처리 예시
        if (foundOrderItem != null) {
            System.out.println("조회된 상품: " + foundOrderItem.getProductName());
        }

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
