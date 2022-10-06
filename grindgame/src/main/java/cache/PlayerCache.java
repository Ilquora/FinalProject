package cache;

import model.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerCache {
    private final Map<Long, Player> cache = new HashMap<>();

    public Player getPlayer (Long id) {
        return cache.get(id);
    }
}
