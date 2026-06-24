package com.hexaware.springboot.cricket.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springboot.cricket.management.dto.PlayerDTO;
import com.hexaware.springboot.cricket.management.exception.PlayerNotFoundException;
import com.hexaware.springboot.cricket.management.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	IPlayerService service;
	
	@GetMapping("/getall")
	public List<PlayerDTO> getAllPlayers() {
		
		return service.getAllPlayers();
		
	}
	
	@GetMapping("/get-player-by-id/{playerId}")
	public PlayerDTO getPlayerById(@PathVariable int playerId) throws PlayerNotFoundException {
		
		return service.getPlayerById(playerId);
	}
	
	
	@PostMapping("/create-new")
	public PlayerDTO createNewPlayer(@RequestBody @Valid PlayerDTO player) {
		
		return service.createPlayer(player);
	}
	
	
	@PutMapping("/update-player")
	public PlayerDTO updatePlayer(@RequestBody @Valid PlayerDTO player) throws PlayerNotFoundException {
		
		return service.updatePlayer(player);
	}
	
	
	@DeleteMapping("/delete-player/{playerId}")
	public void deletePlayer(@PathVariable int playerId) throws PlayerNotFoundException{
		
		service.deletePlayerById(playerId);
	}
	
	@GetMapping("/get-player-by-name/{playerName}")
	public PlayerDTO getPlayerByName(@PathVariable String playerName) throws PlayerNotFoundException{
		
		return service.getByPlayerName(playerName);
		
	}
}
