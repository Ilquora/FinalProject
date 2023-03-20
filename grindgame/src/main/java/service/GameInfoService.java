package service;
import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class GameInfoService {

    private final PlayerService playerService;

    public GameInfoService(PlayerService playerService){
        this.playerService = playerService;
    }
    private void playerInfo () {
        Player player = playerService.getPlayer();
        log.info("Player {}: gold {} | wood {} | food {}",
                player.getId(), player.getGold(), player.getFood(), player.getWood());
    }




}






