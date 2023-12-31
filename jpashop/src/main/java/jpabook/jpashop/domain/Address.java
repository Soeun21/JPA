package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/*
@Setter 를 제거하고, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자. JPA 스펙상 엔티
티나 임베디드 타입( @Embeddable )은 자바 기본 생성자(default constructor)를 public 또는
protected 로 설정해야 한다. public 으로 두는 것 보다는 protected 로 설정하는 것이 그나마 더 안전
하다.
> JPA가 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 때 리플랙션 같은 기술을 사용할 수
있도록 지원해야 하기 때문이다
*/
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected  Address(){}// public이 아니라 ptortectde로 해두면 jpa스펙상 만들어둔것이라고 생각하고
    // new로 생성하면 안되겠다고 생각하면 된다


    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
