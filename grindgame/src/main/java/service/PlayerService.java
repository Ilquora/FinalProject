package service;

import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlayerRepository;

@Slf4j
@Service
public class PlayerService {
    private final Player player;
private final PlayerRepository playerRepository;
@Autowired
    public PlayerService(Player player, PlayerRepository playerRepository) {
        this.player = player;
        this.playerRepository = playerRepository;
    }

     private PlayerRepository getPlayer (Player player, PlayerRepository playerRepository){
return playerRepository;
     }
}
