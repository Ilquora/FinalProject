package service;

import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Field;
@Slf4j

public class GameInfoService {

    private void playerInfo() {
        Player player = PlayerService.getPlayer();
        log.info("Player {}: gold {} | wood {} | food {}", player.getId(), player.getGold(), player.getFood(), player.getWood());
    }

    @Scheduled
            (cron = "0 0/10 * * * *")
    public void doSomething() {
      playerInfo();
    }
}



//  public static void main(String[] args) {
//      Player player = new Player();
//      Field[] playerField = player.getClass().getDeclaredFields();
//      for(Field field : playerField) {
//          System.out.println(field);
//      }
//  }


