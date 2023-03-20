package converter;

import entity.CraftElementEntity;
import model.CraftElement;
import org.springframework.stereotype.Component;

@Component
public class CraftElementConverter {
    public CraftElement convert (CraftElementEntity entity){
        return  new CraftElement(entity.getCraftElementId(),entity.getCraftElementName(),entity.getQuantity());
    }
    public  CraftElementEntity convert (CraftElement model){
        return new CraftElementEntity(model.getCraftElementId(), model.getCraftElementName(), model.getQuantity());
    }
}
