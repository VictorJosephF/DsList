package com.victorfaria.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorfaria.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
