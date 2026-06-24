package com.hexaware.springboot.cricket.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springboot.cricket.management.dto.PlayerDTO;
import com.hexaware.springboot.cricket.management.entity.Player;
import com.hexaware.springboot.cricket.management.exception.PlayerNotFoundException;
import com.hexaware.springboot.cricket.management.repo.PlayerRepository;

@Service
public class PlayerServiceImp implements IPlayerService {

	@Autowired
	PlayerRepository repo;

	@Override
	public PlayerDTO getPlayerById(int playerId) throws PlayerNotFoundException {

		Player player = repo.findById(playerId)
				.orElseThrow(() -> new PlayerNotFoundException("No matching records found!!"));

		PlayerDTO dto = new PlayerDTO();

		dto.setPlayerId(player.getPlayerId());
		dto.setCountryName(player.getCountryName());
		dto.setDescription(player.getDescription());
		dto.setJerseyNumber(player.getJerseyNumber());
		dto.setPlayerName(player.getPlayerName());
		dto.setRole(player.getRole());
		dto.setTeamName(player.getTeamName());
		dto.setTotalMatches(player.getTotalMatches());

		return dto;

	}

	@Override
	public List<PlayerDTO> getAllPlayers() {

		List<Player> players = repo.findAll();

		List<PlayerDTO> list = new ArrayList<>();

		

		for (Player player : players) {
			
			PlayerDTO dto = new PlayerDTO();

			dto.setPlayerId(player.getPlayerId());
			dto.setCountryName(player.getCountryName());
			dto.setDescription(player.getDescription());
			dto.setJerseyNumber(player.getJerseyNumber());
			dto.setPlayerName(player.getPlayerName());
			dto.setRole(player.getRole());
			dto.setTeamName(player.getTeamName());
			dto.setTotalMatches(player.getTotalMatches());

			list.add(dto);

		}

		return list;
	}

	@Override
	public PlayerDTO createPlayer(PlayerDTO dto) {

		Player player = new Player();

		player.setCountryName(dto.getCountryName());
		player.setDescription(dto.getDescription());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setPlayerName(dto.getPlayerName());
		player.setRole(dto.getRole());
		player.setTeamName(dto.getTeamName());
		player.setTotalMatches(dto.getTotalMatches());

		player = repo.save(player);

		PlayerDTO dto1 = new PlayerDTO();

		dto1.setPlayerId(player.getPlayerId());
		dto1.setCountryName(player.getCountryName());
		dto1.setDescription(player.getDescription());
		dto1.setJerseyNumber(player.getJerseyNumber());
		dto1.setPlayerName(player.getPlayerName());
		dto1.setRole(player.getRole());
		dto1.setTeamName(player.getTeamName());
		dto1.setTotalMatches(player.getTotalMatches());

		return dto1;
	}

	@Override
	public PlayerDTO updatePlayer(PlayerDTO dto) throws PlayerNotFoundException {

		Player player = repo.findById(dto.getPlayerId())
				.orElseThrow(() -> new PlayerNotFoundException("No matching player record found..."));

		player.setCountryName(dto.getCountryName());
		player.setDescription(dto.getDescription());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setPlayerName(dto.getPlayerName());
		player.setRole(dto.getRole());
		player.setTeamName(dto.getTeamName());
		player.setTotalMatches(dto.getTotalMatches());

		player = repo.save(player);

		PlayerDTO dto1 = new PlayerDTO();

		dto1.setPlayerId(player.getPlayerId());
		dto1.setCountryName(player.getCountryName());
		dto1.setDescription(player.getDescription());
		dto1.setJerseyNumber(player.getJerseyNumber());
		dto1.setPlayerName(player.getPlayerName());
		dto1.setRole(player.getRole());
		dto1.setTeamName(player.getTeamName());
		dto1.setTotalMatches(player.getTotalMatches());

		return dto1;

	}

	@Override
	public void deletePlayerById(int playerId) throws PlayerNotFoundException {
		
		if(!repo.existsById(playerId)) {
			
			throw new PlayerNotFoundException("Invalid Player ID...");
		
		}
		
		repo.deleteById(playerId);
	}

	@Override
	public PlayerDTO getByPlayerName(String playerName) throws PlayerNotFoundException {
		
		Player player =  repo.findByPlayerNameContainingIgnoreCase(playerName).orElseThrow(() -> new PlayerNotFoundException("No matching player name found"));
		
		PlayerDTO dto = new PlayerDTO();
		
		dto.setPlayerId(player.getPlayerId());
		dto.setCountryName(player.getCountryName());
		dto.setDescription(player.getDescription());
		dto.setJerseyNumber(player.getJerseyNumber());
		dto.setPlayerName(player.getPlayerName());
		dto.setRole(player.getRole());
		dto.setTeamName(player.getTeamName());
		dto.setTotalMatches(player.getTotalMatches());
		
		return dto;
		
		
	}

}
