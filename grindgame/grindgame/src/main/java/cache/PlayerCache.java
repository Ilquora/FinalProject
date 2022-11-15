package cache;

import model.Player;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class PlayerCache {
    private final Map<Long, Player> playerCache = new HashMap<>();
    public void addPlayer(Player player) {
       playerCache.put(player.getId(), player);
    }
    public Player getPlayer (Long id) {
        return playerCache.get(id);
    }
}
