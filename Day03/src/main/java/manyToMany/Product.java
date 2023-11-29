package manyToMany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

/*    @ManyToMany   다대일
    @JoinColumn(name = "productList")
    private List<Member4> member3List = new ArrayList<>();*/

    // 일대다로 변경
    @OneToMany(mappedBy = "product")
    private List<MemberProduct> Products = new ArrayList<>();


}
