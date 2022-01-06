package com.shop.puppyshop.order;

import com.shop.puppyshop.constant.BaseEntityTime;
import com.shop.puppyshop.constant.OrderStatus;
import com.shop.puppyshop.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Table(name = "orders")
@Entity
public class Order extends BaseEntityTime {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderData;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    /* 주문 상품 엔티티와 일대다 매핑을 합니다. 외래키가 order_item 테이블에 있으므로 연관 관계와 주인은
       OrderItem 엔티티입니다. Order 엔티티가 주인이 아니므로 "mappedBy" 속성으로 연관 관계의 주인을
       설정 합니다. 속성의 값으로 "order"를 적어준 이유는 OrderItem에 있는 Order에 의해 관리된다는 의미로
       해석하시면 됩니다. 즉 연관ㄱ 관계의 주인의 필드인 order를 mappedBy의 값으로 세팅하면 됩니다.
    * */
    // 하나의 주문이 여러 개의 주문 상품을 갖으므로 List 자료형을 사용해서 매핑
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

}
