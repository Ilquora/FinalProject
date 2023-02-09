package converter;


import entity.CraftElementEntity;
import entity.CraftReceiptEntity;
import model.CraftElement;
import model.CraftReceipt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CraftReceiptConverter {
    private final CraftReceiptConverter converter;
  public CraftReceiptConverter (CraftReceiptConverter converter){
      this.converter = converter;
}
public CraftReceipt convert (CraftReceiptEntity entity, List<CraftElement> craftElementList){
    return new CraftReceipt(entity.getId(), entity.getReceiptName(),craftElementList,);
}
    }

