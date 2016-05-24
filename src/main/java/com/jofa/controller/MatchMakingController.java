package com.jofa.controller;

import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jofa.elo.exception.EloNotFoundException;
import com.jofa.elo.exception.EloNotSavedException;
import com.jofa.elo.model.Elo;
import com.jofa.elo.service.EloService;

import com.jofa.match.exception.MatchNotFoundException;
import com.jofa.match.exception.MatchNotSavedException;
import com.jofa.match.model.Match;
import com.jofa.match.service.MatchService;


@RestController
@RequestMapping("/user")
public class MatchMakingController {

	private static MatchService matchService = new MatchService();
	private static EloService eloService = new EloService();
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MatchMakingController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}
	/*
	@RequestMapping(value = "/registerUser",  method = RequestMethod.POST)
	public ResponseEntity registerUser(@RequestBody User user) {
		try {
			userService.persist(user);
		} catch (UserNotSavedException e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}*/
	
	

}
