package com.exam.JsonMap.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.JsonMap.domain.Posts;
import com.exam.JsonMap.service.PostsService;



@Controller
public class PostsController {

	private String message = "Hello World";
	
	@Autowired
	private PostsService postsService;

	@RequestMapping("/")
	public String showJson(Map<String, Object> model) throws ParseException {

		// ModelAndView model = new ModelAndView();
		//ModelMap model = new ModelMap();

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/posts");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("responsecode: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inline = "";

				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				System.out.println("\nJSON Response in String format");

				// Close the stream when reading the data has been finished

				sc.close();

				System.out.println(inline);
				model.put("StringJson", inline);
				JSONParser parser = new JSONParser();
				JSONArray jsonarray = (JSONArray) parser.parse(inline);
				System.out.println("jsonarray" + jsonarray);
				
				Posts post = new Posts();
				
				for (Object object : jsonarray) {
					JSONObject jsonObject=(JSONObject)object;
					
					Long userid =    (Long) jsonObject.get("userId");
					Long id =    (Long) jsonObject.get("id");
					String title =  (String) jsonObject.get("title");
					String body =  (String) jsonObject.get("body");
					
					System.out.println("user id: "+ userid);
					System.out.println("id: "+ id);
					System.out.println("title : "+ title);
					System.out.println("body : "+ body);
					
					
				post.setUserId(jsonObject.get("userId"));
				post.setId(jsonObject.get("id"));
				post.setTitle(jsonObject.get("title"));
				post.setBody(jsonObject.get("body"));
				
				
				Long uid = postsService.save(post).getId();
				if(uid != null) {
					System.out.println("Value present");
				}
				else {
					System.out.println("Value Absnt");
				}
				
					
					
				}
				
				

				model.put("jsonarray", jsonarray);
				
				
				
				
			} else {
				System.out.println("GET request not worked");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("message", this.message);

		

		return "showJsonData";
	}

}
