package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.model.response.BasicResponse;
import com.ssafy.model.service.ArtistService;

@Controller
public class ArtistController {
	@Autowired
	private ArtistService artistService;

	@GetMapping("/api/public/artist/list")
	public Object getMuseumList(@RequestParam int start) {
		BasicResponse response = new BasicResponse();

		response.data = artistService.findArtistlimit(start);
		if (response.data != null) {
			response.status = true;
			response.message = "조회에 성공하였습니다.";
		} else {
			response.status = false;
			response.message = "조회에 실패하였습니다.";
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/api/public/artist/find")
	public Object getMuseumList(@RequestParam String artistName, @RequestParam int start) {
		BasicResponse response = new BasicResponse();
		
		response.data = artistService.findArtistByArtistNamelimit('%' + artistName + '%', start);
		if (response.data != null) {
			response.status = true;
			response.message = "조회에 성공하였습니다.";
		} else {
			response.status = false;
			response.message = "조회에 실패하였습니다.";
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/api/public/artist/detail")
	public Object FindArtistDetail(@RequestParam String artistName) {
		BasicResponse response = new BasicResponse();

		response.data = artistService.findArtistDetail(artistName);
		response.status = (response.data != null) ? true : false;

		if (response.status) {
			response.message = "조회에 성공하였습니다.";
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.message = "조회에 실패하였습니다.";
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}
}
