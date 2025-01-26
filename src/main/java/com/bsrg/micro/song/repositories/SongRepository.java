package com.bsrg.micro.song.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.bsrg.micro.song.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	
	Song save(Song song);
	Optional<Song> findById(Long id);
	Iterable<Song> findAll();
	void deleteById(Long id);

}
