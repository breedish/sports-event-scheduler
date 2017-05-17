package com.breedish.ses.repository;

import com.breedish.ses.domain.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
}
