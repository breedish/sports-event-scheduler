package com.breedish.ses.controller;

import com.breedish.ses.domain.Player;
import com.breedish.ses.dto.request.RegisterPlayerRequest;
import com.breedish.ses.dto.response.PlayerFullDto;
import com.breedish.ses.service.PlayerService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api/public/v1/players", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class PlayerController {

    private final PlayerService playerService;

    private final DozerBeanMapper mapper;

    @Autowired
    public PlayerController(PlayerService playerService, DozerBeanMapper dozerBeanMapper) {
        this.playerService = playerService;
        this.mapper = dozerBeanMapper;
    }

    @PostMapping
    public ResponseEntity<PlayerFullDto> registerPlayer(@Valid @RequestBody RegisterPlayerRequest request) {
        return ok(mapper.map(playerService.register(request), PlayerFullDto.class));
    }

    @GetMapping
    public Page<PlayerFullDto> findPlayers(Pageable pageable) {
        return playerService.find(pageable).map(p -> mapper.map(p, PlayerFullDto.class));
    }

    @GetMapping(value = "/{id}")
    public Player getPlayer(@PathVariable @Min(1) Long id) {
        return playerService.getPlayer(id);
    }
}
