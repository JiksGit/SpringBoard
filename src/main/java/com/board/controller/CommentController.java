package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.CommentDTO;
import com.board.service.CommentService;
import com.google.gson.JsonObject;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = {"/comments", "/comments/{idx}"}, method= {RequestMethod.POST, RequestMethod.PATCH})
	public JsonObject registerComment(@PathVariable(value="idx", required = false) Long idx, @RequestBody final CommentDTO params) {
		JsonObject jsonObj = new JsonObject();
		
		try {
			boolean isRegistered = commentService.registerComment(params);
			jsonObj.addProperty("result", isRegistered);
		} catch(DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");
		} catch(Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}
		return jsonObj;
	}
	
	@GetMapping(value = "/comments/{boardIdx}")
	public List<CommentDTO> getCommentList(@PathVariable("boardIdx") Long boardIdx, @ModelAttribute("params") CommentDTO params){
		List<CommentDTO> commentList = commentService.getCommentList(params);
		return commentList;
	}
}
