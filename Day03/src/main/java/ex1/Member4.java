package ex1;



import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member4 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;


    private String name;
    private String city;
    private String street;
    private String zipcode;

    // 비추천함 그래서 OneToMany ManyToOne을 사용해서 중간테이블 추가함
    @ManyToMany
    @JoinTable(name = "member")
    private List<Order> orders = new ArrayList<>();








}
