package com.gemini.AI.DAO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gemini.AI.Model.Prompts;

@FeignClient(name = "gemini-client", url = "${gemini.api.url}")
public interface GeminiClient {
	
	 @PostMapping("/gemini-1.5-flash:generateContent?key=(Your API Key)")
	    String getResponseFromGemini(@RequestBody Prompts query);
	    // @RequestHeader("Authorization") String authorizationHeader


}
