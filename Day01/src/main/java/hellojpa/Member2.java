/*
package hellojpa;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity // @Entity(name="Member")JAP가 내부적으로 구분하기 위한 이름 (안 써도 된다. )
//@Entity 필수로 들어가는 어노테이션, 객체로 인식하게 하기 위함.  JPA가 관리하는 클래스이다
// 기본 생성자 필수
//@Table(name = "MBR")MBR테이블 과 매핑 된다
public class Member2 {

    // columnDefinition = "varchar(100) default 'EMPTHY'") 쿼리에 그대로 문자가 들어간다
//    nullable = false  ==  not null
    // unique = true 자동생성된 이상한 글자가 뜨게 되서 @Table자체에 거는것이 좋음
    @Id //id에 Pk값을 주기 위해 적용하는 어노테이션
    private Long id;

//    @Column(unique = true, length = 10,name = "username") //username이라는 DB컬럼과 맵핑시키기
//    회원 이름은 필수, 10자 초과X  username varchar(10), add constraint  unique (username)
    @Column(name = "name", insertable = true, updatable = true)// DB컬럼명은 name으로 사용하겠다는 의미
    private String username;// insertable = true, updatable = true db등록 변경 여부 . false를 쓰면 반영안됨


    private Integer age;

    @Enumerated(EnumType.STRING)    // DB에는 enum타입이 없는데 @Enumerated을 사용하면 된다
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)//datr,time, timestamp중 뭘 사용할 건지 지정
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate2;
    private LocalDateTime testLocalDateTime2;

    @Lob
    private String description;

    @Transient//특정 필드를 컬럼에 매핑하지 않음(매핑 무시). 메모리에서만 사용하겠다는 뜻
    // create에 생기지 않는다.
    private int temp;

    public Member2() {   // 기본생성자가 있어야함
    }

}
*/
