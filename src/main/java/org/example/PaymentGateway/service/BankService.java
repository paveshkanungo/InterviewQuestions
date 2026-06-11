package org.example.PaymentGateway.service;

import org.example.PaymentGateway.dto.InstrumentDTO;
import org.example.PaymentGateway.enums.InstrumentType;
import org.example.PaymentGateway.model.BankInstrument;
import org.example.PaymentGateway.model.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService {

    @Override
    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO) {
        // bank specific logic here
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setInstrumentID(new Random().nextInt(100-10)+10);
        bankInstrument.setBankAccountNumber(instrumentDTO.getBankAccountNumber());
        bankInstrument.setIfscCode(instrumentDTO.getIfsc());
        bankInstrument.setInstrumentType(instrumentDTO.getInstrumentType());
        bankInstrument.setUserID(instrumentDTO.getUserID());
        List<Instrument> userInstrumentsList = userVsInstrument.get(bankInstrument.getUserID());
        if(userInstrumentsList == null){
            userInstrumentsList = new ArrayList<>();
            userVsInstrument.put(bankInstrument.getUserID(), userInstrumentsList);
        }
        userInstrumentsList.add(bankInstrument);
        return mapBankInstrumentToBankInstrumentDTO(bankInstrument);
    }

    @Override
    public List<InstrumentDTO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstruments = userVsInstrument.get(userID);
        List<InstrumentDTO> userInstrumentsFetched = new ArrayList<>();
        for(Instrument instrument: userInstruments){
            if(instrument.getInstrumentType() == InstrumentType.BANK){
                userInstrumentsFetched.add(mapBankInstrumentToBankInstrumentDTO((BankInstrument) instrument));
            }
        }
        return userInstrumentsFetched;
    }

    public InstrumentDTO mapBankInstrumentToBankInstrumentDTO(BankInstrument bankInstrument){
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.setInstrumentType(bankInstrument.getInstrumentType());
        instrumentDTO.setInstrumentID(bankInstrument.getInstrumentID());
        instrumentDTO.setBankAccountNumber(bankInstrument.getBankAccountNumber());
        instrumentDTO.setIfsc(bankInstrument.getIfscCode());
        instrumentDTO.setUserID(bankInstrument.getUserID());
        return instrumentDTO;
    }
}
