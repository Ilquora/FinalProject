package service;

import converter.CraftElementConverter;
import converter.CraftReceiptConverter;
import entity.CraftReceiptEntity;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import model.CraftReceipt;
import org.springframework.stereotype.Service;
import repository.CraftElementRepository;
import repository.CraftReceiptRepository;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@Service
public class CraftReceiptService {
    private final CraftElementRepository craftElementRepository;
    private final CraftElementConverter craftElementConverter;
    private  final CraftReceiptRepository craftReceiptRepository;
    private final CraftReceiptConverter craftReceiptConverter;
    public  CraftReceiptService (CraftReceiptConverter craftReceiptConverter,CraftElementConverter
                                 craftElementConverter,CraftReceiptRepository craftReceiptRepository,
                                 CraftElementRepository craftElementRepository) {
        this.craftElementConverter = craftElementConverter;
        this.craftReceiptConverter = craftReceiptConverter;
        this.craftReceiptRepository = craftReceiptRepository;
        this.craftElementRepository = craftElementRepository;
    }
    @Transactional
    public  void addCraftReceipt (CraftReceipt craftReceipt){
        craftReceipt.getCraftElements().forEach(craftElement -> craftElementRepository.save(craftElementConverter.convert(craftElement)));
        CraftReceiptEntity craftReceiptEntity = craftReceiptRepository.save(craftReceiptRepository.save(craftReceiptConverter.convert(craftReceipt)));
        log.info("Receipt created : {}",craftReceiptEntity);
    }

}
