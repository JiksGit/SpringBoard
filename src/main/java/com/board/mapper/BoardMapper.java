package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper
public interface BoardMapper {
	public int insertBoard(BoardDTO params);
	public BoardDTO selectBoardDetail(long idx);
	public int updateBoard(BoardDTO params);
	public int deleteBoard(long idx);
	public List<BoardDTO> selectBoardList(BoardDTO params);
	public int selectBoardTotalCount(BoardDTO params);
}
