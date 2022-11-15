package service;

import cache.PlayerCache;
import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.PlayerRepository;

@Slf4j
@Service
@ComponentScan
@EnableAutoConfiguration
public class PlayerService {
    private final Player player;
    private final PlayerRepository playerRepository;
    private final PlayerCache playerCache;

    @Autowired
    private PlayerService(Player player,
                          PlayerRepository playerRepository,
                          PlayerCache playerCache) {
        this.player = player;
        this.playerRepository = playerRepository;
        this.playerCache = playerCache;

    }

    Player getPlayer() {
        return playerCache.getPlayer(player.getId());
    }


}
