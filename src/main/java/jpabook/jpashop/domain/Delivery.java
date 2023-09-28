package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    /*ORDINAL을 사용할 경우 해당 ENUM에 맞는 값이 숫자로 추가되는데, 1,2,3,4 등
      중간에 새로운 값들이 추가 될경우 해당 숫자가 한번씩 밀려서 큰일난다.(꼭 STRING 사용)
     */
    private DeliveryStatus status;

}
