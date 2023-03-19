package com.vis.sqsdemo;

import com.vis.sqsdemo.producer.CustomMessage;
import com.vis.sqsdemo.producer.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsDemoApplication {
	private final Publisher publisher;

	public SqsDemoApplication(Publisher publisher) {
		this.publisher = publisher;
		this.publisher.sendMessage(new CustomMessage("New test"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SqsDemoApplication.class, args);
	}

}
