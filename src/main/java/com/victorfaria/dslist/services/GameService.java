package com.victorfaria.dslist.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victorfaria.dslist.DTO.GameDTO;
import com.victorfaria.dslist.DTO.GameMinDTO;
import com.victorfaria.dslist.entities.Game;
import com.victorfaria.dslist.projections.GameMinProjection;
import com.victorfaria.dslist.repositories.GameRepository;

@Service
public class GameService {
	
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
    	Game result = gameRepository.findById(id).get();
    	GameDTO dto = new GameDTO(result);
    	return dto;
    }
    @Transactional(readOnly = true)
	public List<GameMinDTO> findall(){
		List<Game> result = gameRepository.findAll();
		return  result.stream().map(x -> new GameMinDTO(x)).toList();
	
	}
    @Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
    	List<GameMinProjection> result = gameRepository.searchByList(listId);
		return  result.stream().map(x -> new GameMinDTO(x)).toList();
	
	}
}

