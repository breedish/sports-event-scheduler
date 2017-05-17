package com.breedish.ses.service;

import com.breedish.ses.domain.Player;
import com.breedish.ses.dto.request.RegisterPlayerRequest;
import com.breedish.ses.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player register(@Valid RegisterPlayerRequest request) {
        Player.PlayerBuilder playerBuilder = Player.builder();
        playerBuilder.email(request.getEmail())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .name(request.getName())
            .phone(request.getPhone());
        return playerRepository.save(playerBuilder.build());
    }

    public Page<Player> find(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    public Player getPlayer(Long id) {
        return playerRepository.findOne(id);
    }
}
