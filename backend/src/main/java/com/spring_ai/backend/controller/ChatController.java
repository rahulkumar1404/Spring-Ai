package com.spring_ai.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/ask-ai")
	public String getChatResponse(@RequestParam String prompt) {
		return chatService.generateResponse(prompt);
	}
	
	@GetMapping("/ask-ai-options")
	public String getChatResponseWithOptions(@RequestParam String prompt) {
		return chatService.generateResponseWithContext(prompt);
	}
	
}