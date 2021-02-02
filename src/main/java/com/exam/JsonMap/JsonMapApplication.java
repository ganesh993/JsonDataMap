package com.exam.JsonMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.exam.JsonMap.domain.Posts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exam.JsonMap.service.PostsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class JsonMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonMapApplication.class, args);
	}
	
	
//	@Bean
//	CommandLineRunner runner(PostsService userService){
//	    return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<Posts>> typeReference = new TypeReference<List<Posts>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/posts.json");
//			try {
//				List<Posts> posts = mapper.readValue(inputStream,typeReference);
//				userService.save(posts);
//				System.out.println("Users Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save users: " + e.getMessage());
//			}
//	    };
//	}

}
