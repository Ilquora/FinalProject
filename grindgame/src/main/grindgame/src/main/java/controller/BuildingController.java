package controller;

import model.Building;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {
    private final BuildingService buildingService;
        public BuildingController (BuildingService buildingService){
            this.buildingService = buildingService;
        }
        @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBuilding (@RequestBody Building building)
        {
            buildingService.addBuilding(building);
        }   }

