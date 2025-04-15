package orderview.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import orderview.domain.*;
import orderview.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer qty;
    private String address;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
