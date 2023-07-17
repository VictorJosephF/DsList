package com.victorfaria.dslist.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victorfaria.dslist.DTO.GameListDTO;
import com.victorfaria.dslist.entities.GameList;
import com.victorfaria.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
    @Autowired
    private GameListRepository gameListRepository;
    
    @Transactional(readOnly = true)
	public List<GameListDTO> findall(){
		List<GameList> result = gameListRepository.findAll();
		return  result.stream().map(x -> new GameListDTO(x)).toList();
	
	}
}
