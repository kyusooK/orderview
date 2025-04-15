package orderview.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import orderview.domain.*;
import orderview.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;

    public StockDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
