package com.vuetrello.vuetrello.board.service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vuetrello.vuetrello.board.dto.BoardCreate;
import com.vuetrello.vuetrello.board.model.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private static final List<Board> boards = new ArrayList<>();

	static {
		boards.add(Board.builder()
			.id(1)
			.title("보드1")
			.userId(1)
			.bgColor("#333")
			.build());
		boards.add(Board.builder()
			.id(2)
			.title("보드2")
			.userId(1)
			.bgColor("#362")
			.build());
		boards.add(Board.builder()
			.id(3)
			.title("보드3")
			.userId(2)
			.bgColor("#431")
			.build());
	}

	@Override
	public List<Board> getBoards(long userId) {
		return boards.stream()
			.filter(board -> board.getUserId() == userId)
			.collect(Collectors.toList());
	}

	@Override
	public void createBoard(BoardCreate boardCreate, long userId) {
		Board board = Board.builder()
			.id(boards.size() + 1)
			.title(boardCreate.getTitle())
			.userId(userId)
			.bgColor(makeBackgroundColor())
			.build();

		boards.add(board);
	}

	private String makeBackgroundColor() {
		Color color = new Color((int)(Math.random() * 0x1000000));

		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}
}
