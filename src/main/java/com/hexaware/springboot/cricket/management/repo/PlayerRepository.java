package com.hexaware.springboot.cricket.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.springboot.cricket.management.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	Optional<Player> findByPlayerNameContainingIgnoreCase(String playerName);
}
