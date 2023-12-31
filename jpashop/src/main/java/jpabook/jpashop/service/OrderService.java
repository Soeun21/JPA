package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    // 주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        
        // 엔티티 조회
        Member member = memberRepository.fineOne(memberId);
        Item item = itemRepository.findOne(itemId);
        
        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        
        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(),count);
        
        // 주문 생성
        Order order = Order.createOrder(member,delivery,orderItem);
        
        // 주문 저장
        orderRepository.save(order);// cascade옵션으로 order안의 orderList delivery를 자동으로persist 해준다
        // orderitem과 delivery는 order만 참조하고 라이프 사이클이 비슷하기 때문에 cascade를 할 수 있다
        return order.getId();
    }

    // 취소
    @Transactional
    public void cancelOrder(Long orderId){
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();
        // jpa가 변경된 내역을 알아서 업데이트 해준다
    }

    // 검색
    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAllByString(orderSearch);
    }



}
