package com.cos.JUnitTest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository 적어야 스프링 IoC에 빈으로 등록이 되는데 
// JpaRePository 를 extends 하면 생락가능함 .
// JpaRepository는 CRUD 함수를 들고 있음.
public interface BookRepository extends JpaRepository<Book, Integer>{    // <오브젝트,id의 데이터타입>

}
