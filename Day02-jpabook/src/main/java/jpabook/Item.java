package jpabook;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity

@Data
public class Item {

    @Id    @GeneratedValue
    @Column(name="ITEM_ID") //@Column으로 META-DATA를 추가하는 이유 : 다른 개발자가 해당 정보를 어노테이션을 통해 확인할 수 있다.
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;



}
