package controller;

import model.CraftReceipt;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CraftReceiptService;

import java.awt.*;

@RestController
@RequestMapping("/receipts")
public class CraftReceiptController {
    private final CraftReceiptService craftReceiptService;
    public CraftReceiptController (CraftReceiptService craftReceiptService){
        this.craftReceiptService = craftReceiptService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCraftReceipt (@RequestBody CraftReceipt receipt){
        craftReceiptService.addCraftReceipt(receipt);
    }
}
