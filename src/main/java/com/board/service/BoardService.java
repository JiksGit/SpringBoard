package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardService {
	public boolean registerBoard(BoardDTO params);
	public BoardDTO getBoardDetail(long idx);
	public boolean deleteBoard(long idx);
	public List<BoardDTO> getBoardList(BoardDTO params);
}
