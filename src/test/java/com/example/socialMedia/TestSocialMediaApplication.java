package com.example.socialMedia;

import org.springframework.boot.SpringApplication;

public class TestSocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.from(SocialMediaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
