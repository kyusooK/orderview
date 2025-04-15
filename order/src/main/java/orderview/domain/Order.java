package orderview.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import lombok.Data;
import orderview.OrderApplication;


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
        
        // productName으로 조회
        String searchProductName = this.getProductName();
        OrderItem foundOrderItem = orderItemRepository.getOrderItem(searchProductName);
        
        // 조회 결과가 없으면 예외 발생
        if (foundOrderItem == null) {
            throw new IllegalArgumentException("상품을 찾을 수 없습니다: " + searchProductName);
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
