package controller;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;


    @Autowired
    public PlayerController (PlayerService playerService){
        this.playerService = playerService;

    }
    @PostMapping(consumes = {"application/json"})
    public void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);
    }
    @GetMapping (produces = {"application/json"},path = "/{playerId}")
    public Player getPlayer (@PathVariable Long playerId){
        return playerService.getPlayer();
    }
    @PostMapping (consumes = {"application/json"},path = "/{playerId}/buildings")
    public void createBuilding (@PathVariable Long playerId,@RequestParam Long receiptId) {
        playerService.createBuilding(playerId,receiptId);
    }
}
