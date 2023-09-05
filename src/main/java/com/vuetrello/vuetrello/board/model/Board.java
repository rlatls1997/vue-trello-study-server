package com.vuetrello.vuetrello.board.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Board {
	private final long id;
	private final String title;
	private final long userId;
	private final String bgColor;
}
