package converter;


import entity.CraftElementEntity;
import entity.CraftReceiptEntity;
import model.CraftElement;
import model.CraftReceipt;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CraftReceiptConverter {
    private final CraftElementConverter converter;

    public CraftReceiptConverter(CraftElementConverter converter)
    {
        this.converter = converter;
    }

    public CraftReceipt convert(CraftReceiptEntity entity, List<CraftElement> craftElementList) {
        return new CraftReceipt(entity.getId(), entity.getReceiptName(), craftElementList, entity.getPrice(), entity.getQuantity());
    }


    public CraftReceiptEntity convert(CraftReceipt model) {

        return new CraftReceiptEntity(model.getId(), model.getReceiptName(), model.getPrice(),
                model.getQuantity(), model.getCraftElements().stream().map(converter::convertToModel).collect(Collectors.toList()));
    }
}
