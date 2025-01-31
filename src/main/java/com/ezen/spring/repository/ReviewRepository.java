package com.ezen.spring.repository;

import com.ezen.spring.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Board, Long> {
}
