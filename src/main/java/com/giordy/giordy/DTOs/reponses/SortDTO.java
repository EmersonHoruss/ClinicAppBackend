package com.giordy.giordy.DTOs.reponses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;

@Getter
public class SortDTO {
    private List<OrderDTO> orders;

    public SortDTO(Page page){
        Iterator<Sort.Order> iterator = page.getSort().iterator();
        while(iterator.hasNext()){
            Sort.Order order = iterator.next();
            String property = order.getProperty();
            String direction = order.getDirection().name();
            orders.add(new OrderDTO(property, direction));
        }
    }

    @AllArgsConstructor
    public class OrderDTO {
        private String property;
        private String direction;
    }
}
