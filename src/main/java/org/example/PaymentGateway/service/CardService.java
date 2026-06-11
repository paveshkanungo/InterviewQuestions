package org.example.PaymentGateway.service;

import org.example.ATM.Card;
import org.example.PaymentGateway.dto.InstrumentDTO;
import org.example.PaymentGateway.enums.InstrumentType;
import org.example.PaymentGateway.model.CardInstrument;
import org.example.PaymentGateway.model.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService {

    @Override
    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO) {
        // card specific logic here
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.setInstrumentID(new Random().nextInt(100-10) + 10);
        cardInstrument.setCardNumber(instrumentDTO.getCardNumber());
        cardInstrument.setCvvNumber(instrumentDTO.getCvv());
        cardInstrument.setInstrumentType(InstrumentType.CARD);
        cardInstrument.setUserID(instrumentDTO.getUserID());
        List<Instrument> userInstrumentsList = userVsInstrument.get(instrumentDTO.getUserID());
        if(userInstrumentsList == null){
            userInstrumentsList = new ArrayList<>();
            userVsInstrument.put(instrumentDTO.getUserID(), userInstrumentsList);
        }
        userInstrumentsList.add(cardInstrument);
        return mapCardInstrumentToInstrumentDTO(cardInstrument);
    }

    @Override
    public List<InstrumentDTO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstruments = userVsInstrument.get(userID);
        List<InstrumentDTO> userInstrumentFetched = new ArrayList<>();
        for(Instrument instrument: userInstruments){
            if(instrument.getInstrumentType() == InstrumentType.CARD){
                userInstrumentFetched.add(mapCardInstrumentToInstrumentDTO( (CardInstrument) instrument));
            }
        }
        return userInstrumentFetched;
    }

    public InstrumentDTO mapCardInstrumentToInstrumentDTO(CardInstrument cardInstrument){
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.setInstrumentType(cardInstrument.getInstrumentType());
        instrumentDTO.setInstrumentID(cardInstrument.getInstrumentID());
        instrumentDTO.setCardNumber(cardInstrument.getCardNumber());
        instrumentDTO.setCvv(cardInstrument.getCvvNumber());
        instrumentDTO.setUserID(cardInstrument.getUserID());
        return instrumentDTO;
    }
}
