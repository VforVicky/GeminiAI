package com.gemini.AI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gemini.AI.DAO.GeminiClient;
import com.gemini.AI.Model.Prompts;

@Service
public class GeminiAiService {
	
	
	@Value("${gemini.api.key}")
    private String apiKey;
	
	@Autowired
	private GeminiClient geminiClient;

    public String getResponseFromGemini(Prompts query) {
        //String authorizationHeader = "Bearer " + apiKey;
        return geminiClient.getResponseFromGemini(query);
 }

}
