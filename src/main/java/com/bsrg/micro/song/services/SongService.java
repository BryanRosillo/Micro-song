package com.bsrg.micro.song.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrg.micro.song.models.Song;
import com.bsrg.micro.song.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	public Song saveSong(Song song) {
		return this.songRepository.save(song);
	}
	
	public Song findSong(Long id) throws Exception {
		return this.songRepository.findById(id).orElseThrow(()-> new Exception("Song not found"));
	}
	
	public Iterable<Song> findAll(){
		return this.songRepository.findAll();
	}
	
	public void deleteSong(Long id) {
		this.songRepository.deleteById(id);
	}
	
	public Song updateSong(Long id, Song song) throws Exception {
		Song oldSong = this.findSong(id);
		oldSong.setName(song.getName());
		oldSong.setPath(song.getPath());
		oldSong.setPlays(song.getPlays());
		return this.saveSong(oldSong);
	}

}
