package com.vuetrello.vuetrello.board.service;

import java.util.List;

import com.vuetrello.vuetrello.board.dto.BoardCreate;
import com.vuetrello.vuetrello.board.model.Board;

public interface BoardService {

	List<Board> getBoards(long userId);

	void createBoard(BoardCreate boardCreate, long userId);
}
