package com.vuetrello.vuetrello.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vuetrello.vuetrello.board.dto.BoardCreate;
import com.vuetrello.vuetrello.board.model.Board;
import com.vuetrello.vuetrello.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/boards")
	public List<Board> getBoards(@SessionAttribute("id") long id) {
		return boardService.getBoards(id);
	}

	@PostMapping("/boards")
	public void createBoard(@SessionAttribute("id") long id, @RequestBody BoardCreate boardCreate) {
		boardService.createBoard(boardCreate, id);
	}
}
