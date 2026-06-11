package org.example.PaymentGateway.controller;

import org.example.PaymentGateway.dto.InstrumentDTO;
import org.example.PaymentGateway.enums.InstrumentType;
import org.example.PaymentGateway.model.Instrument;
import org.example.PaymentGateway.service.InstrumentService;
import org.example.PaymentGateway.service.InstrumentServiceFactory;

import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController(){
        instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO){
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentDTO.getInstrumentType());
        return instrumentService.addInstrument(instrumentDTO);
    }

    public List<InstrumentDTO> getAllInstruments(int userID){
        InstrumentService bankInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);
        List<InstrumentDTO> instrumentDTOList = bankInstrumentService.getInstrumentsByUserID(userID);
        instrumentDTOList.addAll(cardInstrumentService.getInstrumentsByUserID(userID));
        return instrumentDTOList;
    }

    public InstrumentDTO getInstrumentByID(int userID, int instrumentID){
        List<InstrumentDTO> instrumentDTOList = getAllInstruments(userID);
        for(InstrumentDTO instrumentDTO: instrumentDTOList){
            if(instrumentDTO.getInstrumentID() == instrumentID){
                return instrumentDTO;
            }
        }
        return null;
    }
}
