package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class CraftReceipt {
    private Long id;
    private String receiptName;
    private List<CraftElement> craftElements;
    private int quantity;
    private int price;
}
