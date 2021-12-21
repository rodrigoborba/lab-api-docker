package br.com.uniciv.testapi;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class Message implements Serializable {
	
	@Id
	private UUID id;
	
	private String message;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
