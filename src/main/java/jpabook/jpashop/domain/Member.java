package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 나는 연관관계의 거울입니다. 할때 mappedBy 추가
    @OneToMany(mappedBy = "member")
    List<Order> orders = new ArrayList<>();

}