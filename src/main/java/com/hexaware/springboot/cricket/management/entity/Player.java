package com.hexaware.springboot.cricket.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players_table")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	private int jerseyNumber;
	private String role;
	private int totalMatches;
	private String teamName;
	private String countryName;
	private String description;
	
	
	public Player(){
		
		
	}
	
	
	public Player(int playerId, String playerName, int jerseyNumber, String role, int totalMatches, String teamName,
			String countryName, String description) {
		
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.countryName = countryName;
		this.description = description;
		
		
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setJerseyNumber(int jersesyNumber) {
		this.jerseyNumber = jersesyNumber;
	}
	
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}
	
	public int getTotalMatches() {
		return totalMatches;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}


	@Override
	public String toString() {
		return "PlayerDTO [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", countryName="
				+ countryName + ", description=" + description + "]";
	}
	
	
}
