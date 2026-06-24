package com.hexaware.springboot.cricket.management.service;

import java.util.List;

import com.hexaware.springboot.cricket.management.dto.PlayerDTO;
import com.hexaware.springboot.cricket.management.exception.PlayerNotFoundException;

public interface IPlayerService {

	PlayerDTO getPlayerById(int playerId) throws PlayerNotFoundException;
	
	List<PlayerDTO> getAllPlayers();
	
	PlayerDTO createPlayer(PlayerDTO player);
	
	PlayerDTO updatePlayer(PlayerDTO player) throws PlayerNotFoundException;
	
	void deletePlayerById(int playerId) throws PlayerNotFoundException;
	
	PlayerDTO getByPlayerName(String playerName) throws PlayerNotFoundException;
}
