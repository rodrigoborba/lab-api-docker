package br.com.uniciv.testapi;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResource {
	
	private final MessageRepository messageRepository;

	@Autowired
	public MessageResource(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Message> getAllMessages(){
		return messageRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postMessage(@RequestBody Message message) {
		message.setId(UUID.randomUUID());
		messageRepository.save(message);
	}

}
