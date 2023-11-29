package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    // 테스트 생성 : ctrl + shift + t

    private final EntityManager em;


    public void save(Item item){
        if(item.getId() == null){   // id 값이 없다면 새로 생성한 객체를 의미
            em.persist(item);   // 새로 생성한 객체를 신규로 등록
        } else {    // 값이 있다면 디비에 등록된 값을 가져온 것
            em.merge(item); // 대충 업데이트를 의미
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }

    public List<Item> findAll(){
        return  em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }



}


