package com.spring_ai.backend.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	private final ChatModel chatModel;
	
	public ChatService(ChatModel chatModel) {
		this.chatModel = chatModel;
	}
	
	public String generateResponse(String prompt) {
		return chatModel.call(prompt);
	}
	
	public String generateResponseWithContext(String prompt){
		ChatResponse response = chatModel.call(
				new Prompt(prompt,
				        OpenAiChatOptions.builder()
				            .model("gpt-4o")
				            .temperature(0.4)
				        .build()
				        ));
		return response.getResult().getOutput().getText();
		
	}

}
