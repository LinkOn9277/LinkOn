package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    public Page<BoardDTO> getBoardList (Pageable pageable);
}
