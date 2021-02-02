package com.exam.JsonMap.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "postss")
public class Posts {

  
    private Long userId;
    @Id
    private Long id;
    private String title;
    private String body;
    
    
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Object object) {
		this.userId = (Long) object;
	}
	public Long getId() {
		return id;
	}
	public void setId(Object object) {
		this.id = (Long) object;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(Object object) {
		this.title = (String) object;
	}
	public String getBody() {
		return body;
	}
	public void setBody(Object object) {
		this.body = (String) object;
	}
    
    
    
    
    
    


   
}
