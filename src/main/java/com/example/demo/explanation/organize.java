package com.example.demo.explanation;

public class organize {
    // =====================================================================================

    // ※ Lombok 라이브러리 자주 사용하는 어노테이션
    // @Getter / Setter : 코드를 컴파일할 때 속성들에 대한 Getter/Setter 메소드 생성
    // @ToString : toString() 메서도 생성
    // @ToString( exclude={ "변수명" } ) : 원하지 않는 속성을 제외한 toString() 메소드 생성
    // @NonNull : 해당 변수가 null 체크 , NullPointException 예외발생
    // @EqualsAndHashCode : equals()와 hashCode() 메서드 생성
    // @Builder : 빌더 패턴을 이용한 객체 생성
    // @NoArgsConstructor : 파라미터가 없는 기본 생성자 생성
    // @AllArgsConstructor : 모든 속성에 대한 생성자 생성
    // @RequiredArgsConstructor : 모든 속성에 대한 생성자 생성
    // @Value : 불변(immutable) 클래스 생성

    // =====================================================================================

    // ※ JPAQuery 데이터 반환 메소드
    // List<T> fetch() : 조회 결과 리스트 반환
    // T fetchOne() : 조회 대상이 1건인 경우 제네릭으로 지정한 타입 변환
    // T fetchFirst() : 조회 대상 중 1건만 반환
    // Long fetchCount() : 조회 대상 개수 반환
    // QueryResult<T> fetchResults() : 조회한 리스트와 전체 개수를 포함한 QueryResults 반환

    // =====================================================================================

    // long count(Predicate) : 조건에 맞는 데이터의 총 개수 반환
    // boolean exists(Predicate) : 조건에 맞는 데이터 존재 여부 반환
    // Iterable findAll(Predicate) : 조건에 맞는 모든 데이터 반환
    // Page<T> finAll(Predicate, Pageable) : 조건에 맞는 페이지 데이터 반환
    // Iterable findAll(Predicate, Sort) : 조건에 맞는 데이터 반환
    // T findOne(Predicate) : 조건에 맞는 데이터 1개 반환

    // =====================================================================================

    // ※ Entity Manager
    // ● 영속성 컨텍스트에 접근하여 Entity 대한 DB 작업을 제공
    // ● 내부적으로 DB 커넥션을 사용해서 DB 접근
    // Entity Manager 메서드
    // ● find() : 영속성 컨텍스트에서 Entity 검색하고 영속성 컨텍스트에 없을 경우 DB → 데이터를 찾아 영속성 컨텍스트에 저장
    // ● persist() : Entity → 영속성 컨텍스트에 저장
    // ● remove() : Entity 클래스 → 영속성 컨텍스트에서 삭제
    // ● flush() : 영속성 컨텍스트에 저장된 내용을 DB 반영

    // =====================================================================================

    // ※ Entity 생명주기 세부 내용
    // 비영속(new) : new 키워드를 통해 생성된 상태로 영속성 컨텍스트와 관련이 없는 상태
    // 영속(managed)
    // ● Entity 영속성 컨텍스트에 저장된 상태로 영속성 컨텍스트에 의해 관리되는 상태
    // ● 영속 상태에서 DB에 저장되지 않으며, 트랜잭션 커밋 시점에 DB에 반영
    // 준영속 상태(detached) : 영속성 컨텍스트에 Entity 저장되었다가 분리된 상태
    // 삭제 상태(removed) : 영속성 컨텍스트와 DB에서 삭제된 상태


}
