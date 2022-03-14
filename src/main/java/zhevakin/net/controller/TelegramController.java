package zhevakin.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhevakin.net.DAO.OTSDao;
import zhevakin.net.DAO.TGWDao;
import zhevakin.net.configure.OTSDriver;
import zhevakin.net.model.*;
import zhevakin.net.model.aufTelegram.BotTelegram;
import zhevakin.net.model.aufTelegram.MiddleTelegram;
import zhevakin.net.model.aufTelegram.TopTelegram;
import zhevakin.net.model.deleteTelegram.ConfirmedDeleteTelegrams;
import zhevakin.net.model.deliveringTelegram.DeliveringBotTelegram;
import zhevakin.net.model.deliveringTelegram.DeliveringMiddleTelegram;
import zhevakin.net.model.deliveringTelegram.DeliveringTopTelegram;
import zhevakin.net.model.deliveringTelegram.ShipmentTelegram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/telegrams/")
public class TelegramController {

    @Autowired
    OTSDriver otsDriver;
    @Autowired
    OTSDao otsDao;

    @Autowired
    TGWDao tgwDao;

    public TelegramController(OTSDriver otsDriver) {
        this.otsDriver = otsDriver;
    }


    @RequestMapping(method = RequestMethod.PUT)
    public int makeDeliveringTelegrams(@RequestBody List<TelegramAdapter> adapters) throws SQLException {
        List<Telegram> telegrams = new ArrayList<>();
        for (TelegramAdapter adapter : adapters) {
            telegrams.addAll(createDeliveringTelegrams(adapter));
        }
        return tgwDao.addTelegrams(telegrams);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int makeTelegrams(@RequestBody List<TelegramAdapter> adapters) throws SQLException {
        List<Telegram> telegrams = new ArrayList<>();
        for (TelegramAdapter adapter : adapters) {
            telegrams.addAll(createTelegrams(adapter));
        }
        return tgwDao.addTelegrams(telegrams);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteTelegrams(@RequestBody List<TelegramAdapter> adapters) throws SQLException {

        List<Telegram> telegrams = new ArrayList<>();
        for (TelegramAdapter adapter : adapters) {
            String trxId =  adapter.getTrxId();
            String aufNr = adapter.getAufNr();
            Telegram telegram = new ConfirmedDeleteTelegrams(trxId,aufNr);
            telegrams.add(telegram);
        }
        return tgwDao.addTelegrams(telegrams);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public int shipmentTelegrams(@RequestBody List<TelegramAdapter> adapters) throws SQLException {
        List<Telegram> telegrams = new ArrayList<>();
        for (TelegramAdapter adapter : adapters) {
            String trxId =  adapter.getTrxId();
            String aufNr = adapter.getAufNr();
            Telegram telegram = new ShipmentTelegram(trxId,aufNr);
            telegrams.add(telegram);
        }
        return tgwDao.addTelegrams(telegrams);
    }

    private List<Telegram> createDeliveringTelegrams(TelegramAdapter adapter) throws SQLException {

        String trxId = adapter.getTrxId();
        String aufNr = adapter.getAufNr();
        String clickAndCollect = adapter.getAufStatus();
        if (clickAndCollect.equals("null")) clickAndCollect = "";
        Telegram deliveringTopTelegram = new DeliveringTopTelegram(trxId, aufNr, clickAndCollect);
        Telegram deliveringBotTelegram = new DeliveringBotTelegram(trxId, aufNr);

        List<Telegram> telegrams = new ArrayList<>();

        telegrams.add(deliveringTopTelegram);

        List<String> items = otsDao.findItems(aufNr);

        for (int i=0; i<items.size(); i++) {
            Telegram middleTelegram = new DeliveringMiddleTelegram(trxId, aufNr, String.valueOf(i+1));
            telegrams.add(middleTelegram);
        }

        telegrams.add(deliveringBotTelegram);

        return telegrams;

    }

    private List<Telegram> createTelegrams(TelegramAdapter adapter) throws SQLException {
        String trxId =  adapter.getTrxId();
        String aufNr = adapter.getAufNr();
        String aufStatus = adapter.getAufStatus();
        String aupMgSoll="1";
        String aupMgFehl="0";
        String aupMgIst="1";
        String aupMgEhWws="ST";

        Telegram topTelegram = new TopTelegram(trxId, aufNr, aufNr, aufStatus, aufNr);
        Telegram botTelegram = new BotTelegram(trxId, aufNr);
        List<Telegram> telegrams = new ArrayList<>();

        telegrams.add(topTelegram);

        List<String> items = otsDao.findItems(aufNr);

        for (int i=0; i<items.size(); i++) {
            Telegram middleTelegram = new MiddleTelegram(trxId, aufNr, String.valueOf(i+1), aupMgSoll, aupMgFehl, aupMgIst,
                    aupMgEhWws, items.get(i));
            telegrams.add(middleTelegram);
        }

        telegrams.add(botTelegram);

        return telegrams;
    }

}
