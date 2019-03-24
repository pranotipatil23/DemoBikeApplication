package com.bike.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bike.demo.modal.VYSucceed;

@RestController
@RequestMapping("/api/v1/salon/")
public class VYSucceedController {

	@GetMapping
	public List<VYSucceed> list() {
		List<VYSucceed> data = new ArrayList<>();
		return data;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody VYSucceed data) {
		
	}
	
	public VYSucceed get(@PathVariable("id") long id) {
		return new VYSucceed();
	}
}
