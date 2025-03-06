package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> , Search{
    // 쿼리 메소드를 이용할 때 가장 많이 사용하는 문법으로 find 사용
    // 엔티티의 이름은 생략이 가능
    // By 뒤에는 검색할 때 사용할 변수의 이름을 적어줌
    // find + (엔티티 이름) + By + 변수이름

    public List<Item> findByIname(String iname); // 상품의 이름을 이용하여 데이터를 조회

    public List<Item> findByPrice(int price); // 가격으로 검색

    public List<Item> findByInameOrItemDetail(String iname, String detail); // 상품명과 상세설명으로 찾기

    public List<Item> findByCreateBy(String email); // 판매하는 상품 목록보기

    @Query("select i from Item i where i.iname like '%' || :keyword || '%' or i.itemDetail like concat('%' , :keyword , '%') ")
    public List<Item> selectInDetail(String keyword);


}
