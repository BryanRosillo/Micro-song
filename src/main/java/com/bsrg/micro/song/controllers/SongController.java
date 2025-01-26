package com.bsrg.micro.song.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrg.micro.song.models.Song;
import com.bsrg.micro.song.services.SongService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/song", produces="application/json")
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@PostMapping()
	public ResponseEntity<Object> createSong(@RequestBody @Valid Song song){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.songService.saveSong(song));
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Object> findSong(@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(this.songService.findSong(id));
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll(){
		return ResponseEntity.ok(this.songService.findAll());
	}
	
	@PatchMapping(path="/{id}")
	public ResponseEntity<Object> updateSong(@PathVariable("id") Long id, @RequestBody Song song){
		try {
			return ResponseEntity.ok(this.songService.updateSong(id, song));
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteSong(@PathVariable("id") Long id){
		this.songService.deleteSong(id);
		return ResponseEntity.ok().build();
	}

}
