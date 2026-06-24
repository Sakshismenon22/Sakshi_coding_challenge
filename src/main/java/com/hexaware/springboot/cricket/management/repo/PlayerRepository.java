package com.hexaware.springboot.cricket.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.springboot.cricket.management.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
