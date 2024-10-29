package com.gemini.AI.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.AI.Model.Contents;
import com.gemini.AI.Model.Prompts;
import com.gemini.AI.Model.Query;
import com.gemini.AI.Service.GeminiAiService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class QueryController {
	
	 @Autowired
	    private GeminiAiService geminiService;
	 
	
	 

	    @PostMapping("/query")
	    public ResponseEntity<String> handleQuery(@RequestBody Query query) {
	        // Call Gemini AI and get the response
	    	
	    	 Contents contents = new Contents();
	    	 Prompts prompts = new Prompts();
	    	 List<Query> queryList = new ArrayList<>();
	    	 List<Contents> contentsList = new ArrayList<>();
	    	 
	    	 queryList.add(query);
	    	 contents.setParts(queryList);
	    	 
	    	 contentsList.add(contents);
	    	 prompts.setContents(contentsList);
	    	 
	    	 String response = geminiService.getResponseFromGemini(prompts);

	        // Store response in a file
	        storeResponseInFile(response);

	        return ResponseEntity.ok(response);
	    }

	    private void storeResponseInFile(String response) {
	        try (FileWriter f = new FileWriter("response.txt")) {
	            f.write(response);
//	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
