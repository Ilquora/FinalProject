package service;
import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@SpringBootApplication
@EnableScheduling
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

    @Scheduled
            (cron = "0 0/10 * * * *")
    public void doSomething() {
        playerInfo();

    }
//при ЗАКАЗЕ этого строения будет проверка по этому списку что у игрока есть золото 100 и дерево 50, а gives это то сколько будет ГЕНЕРИРОВАТЬСЯ ресурсов

}



//  public static void main(String[] args) {
//      Player player = new Player();
//      Field[] playerField = player.getClass().getDeclaredFields();
//      for(Field field : playerField) {
//          System.out.println(field);
//      }
//  }


