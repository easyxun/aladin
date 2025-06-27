package com.library.aladin.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {

	@GetMapping("/")
	public String test() {
		log.info("test!!!!!!!!!!!!!!!!");
		return "ok";
	}
}