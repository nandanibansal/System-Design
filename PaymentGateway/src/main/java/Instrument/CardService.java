package Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService{

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.instrumentID = new Random().nextInt(100 - 10) + 10;
        cardInstrument.cardNumber = instrumentDO.cardNumber;
        cardInstrument.cvv = instrumentDO.cvvNumber;
        cardInstrument.instrumentType = InstrumentType.CARD;
        cardInstrument.userID = instrumentDO.userID;

        List<Instrument> userInstrumentList = userVsInstruments.get(cardInstrument.userID);
        if(userInstrumentList == null){
            userInstrumentList = new ArrayList<>();
            userVsInstruments.put(cardInstrument.userID, userInstrumentList);
        }
        userInstrumentList.add(cardInstrument);
        return mapCardInstrumentToInstrumentDO(cardInstrument);
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstruments = userVsInstruments.get(userID);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();
        for (Instrument instrument : userInstruments) {
            if(instrument.getInstrumentType() == InstrumentType.CARD){
                userInstrumentsFetched.add(mapCardInstrumentToInstrumentDO((CardInstrument) instrument));
            }
        }
        return userInstrumentsFetched;
    }

    public InstrumentDO mapCardInstrumentToInstrumentDO(CardInstrument cardInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.instrumentType = cardInstrument.instrumentType;
        instrumentDOObj.instrumentID = cardInstrument.instrumentID;
        instrumentDOObj.cardNumber = cardInstrument.cardNumber;
        instrumentDOObj.cvvNumber = cardInstrument.cvv;
        instrumentDOObj.userID = cardInstrument.userID;
        return instrumentDOObj;
    }
}
