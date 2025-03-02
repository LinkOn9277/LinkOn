package com.example.demo.repository;

import com.example.demo.constant.ItemSellStatus;
import com.example.demo.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @PersistenceContext // EntityManager 빈을 주입
    EntityManager em;

    @Test
    @DisplayName("상품 저장 테스트")
    public void insertTest(){
        log.info("상품 등록 테스트 시작");
        for (int i = 0; i < 500; i++){
            Item item = new Item();
            item.setIname("상품 테스트 [" + i + "]"); // 상품명
            item.setPrice(1000); // 가격
            item.setItemDetail("테스트 상품 상세 설명[" + i + "]"); // 상세설명
            item.setItemSellStatus(ItemSellStatus.SELL); // 판매여부
            item.setStockNumber(100 + i); // 재고수량
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item result = itemRepository.save(item);
            log.info("상품 등록 테스트 종료" + result);
        }
    }

    @Test
    @DisplayName("상품 조회 테스트")
    public void readTest(){
        log.info("상품명으로 조회 테스트 시작");
        Optional<Item> optionalItem = itemRepository.findById(10L);
        // 예외처리 : 상품의 Pk가 존재하지 않는 경우
        try {
            Item item = optionalItem.orElseThrow(EntityNotFoundException::new);
            log.info("조회한 상품이 확인 되었습니다." + item);
        }catch (Exception e){
            log.info("상품이 존재하지 않습니다.");
            log.info("상품 조회 테스트 종료");
            e.printStackTrace();
        }
        log.info("상품 조회 테스트 종료");
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByInameTest(){
        log.info("상품명으로 검색하는 테스트 실행");
        String iname = "상품 테스트 [6]";

        List<Item> itemList = itemRepository.findByIname(iname);

        itemList.forEach(item -> log.info(item));

        log.info("상품명 검색 테스트 종료");
    }

    @Test
    @DisplayName("상품 가격으로 조회 테스트")
    public void priceTest(){
        log.info("상품 가격으로 상품 찾기 테스트 실행");
        int price = 1000;

        List<Item> itemList = itemRepository.findByPrice(price);

        itemList.forEach(item -> log.info(item));
        log.info("가격으로 상품 찾기 테스트 종료");
    }

    @Test
    public void inameOriDetailTest(){
        log.info("설명과 상품명으로 찾기 테스트 실행");
        String keyword = "상품 테스트 [6]";

        List<Item> itemList = itemRepository.findByInameOrItemDetail(keyword, keyword);

        itemList.forEach(item -> log.info(item));
        log.info("테스트 종료");
    }

    @Test
    @DisplayName("수정 테스트")
    public void updateTest(){
        Item item = itemRepository.findById(1L).get();

        item.setIname("상품명 수정");
        item.setPrice(100000);

        log.info("저장하려는 Entity : " + item);
    }

    @Test
    @DisplayName("삭제 테스트")
    public void delTest(){
        itemRepository.deleteById(500L);
    }

}