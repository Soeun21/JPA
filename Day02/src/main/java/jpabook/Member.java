package jpabook;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Member {

    @Id @GeneratedValue //생략하면 Auto전략
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(length = 10)
    private String name;

    private String city;

    private String street;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
