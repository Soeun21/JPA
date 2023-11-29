package manyToMany;



import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member3 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;


    @Column(name = "USERNAME")
    private String username;

    // 비추천함 그래서 OneToMany ManyToOne을 사용해서 중간테이블 추가함
    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> productList = new ArrayList<>();


    // 다대다에서 일대다로 변경하기
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();





}
