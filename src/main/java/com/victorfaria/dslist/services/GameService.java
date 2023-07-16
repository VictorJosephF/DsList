package com.victorfaria.dslist.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorfaria.dslist.DTO.GameMinDTO;
import com.victorfaria.dslist.entities.Game;
import com.victorfaria.dslist.repositories.GameRepository;

@Service
public class GameService {
	
    @Autowired
    private GameRepository gameRepository;
    
	public List<GameMinDTO> findall(){
		List<Game> result = gameRepository.findAll();
		return  result.stream().map(x -> new GameMinDTO(x)).toList();
	
	}
}
