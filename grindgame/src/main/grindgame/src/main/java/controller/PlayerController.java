package controller;



import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {}

  //  private final PlayerService playerService;
  //  @Autowired
  // public PlayerController (PlayerService playerService) {
  //     this.playerService = playerService;
  // }

// @PostMapping(consumes = {"application/json"}) {
//        public void addPlayer(@RequestBody Player player){
//
//         PlayerService.addPlayer(player);
//
//     }
// };
//
