package control;

import dao.CoinDao;
import dao.DAO;
import model.Coin;
import model.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoinController extends Controller implements DAO {

    private static CoinController coinController;

    private Coin real = new Coin("Real", 1);
    private Coin putin = new Coin("Putin", 8.12);
    private Coin doge = new Coin("Doge", 3.5);
    private Coin marreta = new Coin("Marreta", 1.43);
    private Coin recayd = new Coin("Recayd", 4.09);

    public CoinController() {
        super();
    }

    @Override
    public void initiate() {

    }

    @Override
    public void save(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            CoinDao.getCoinDao().put(cn);
        }
    }

    @Override
    public void delete(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            if (CoinDao.getCoinDao().getList().isEmpty()) {
                return;
            } else {
                CoinDao.getCoinDao().remove(cn.getExtId());
            }
        }
    }

    @Override
    public void update(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            if (CoinDao.getCoinDao().get(cn.getExtId()) != null) {
                if (CoinDao.getCoinDao().getList().isEmpty()) {
                    return;
                } else {
                    CoinDao.getCoinDao().get(cn.getExtId()).setName(cn.getName());
                    CoinDao.getCoinDao().get(cn.getExtId()).setPrice(cn.getPrice());
                    CoinDao.getCoinDao().persist();
                }
            }
        }
    }

    public static CoinController getCoinController() {
        if (coinController == null) {
            coinController = new CoinController();
        }
        return coinController;
    }

    public static void setCoinController(CoinController coinController) {
        CoinController.coinController = coinController;
    }

    public ArrayList<Coin> listCoins() {
        return new ArrayList<Coin>(CoinDao.getCoinDao().getList());
    }

    public void receiveData(String name, double price) {
        Coin coin = new Coin(name, price);
        save(coin);
    }

    public Map<String, Double> createWallet() {
        Map<String, Double> wallet = new HashMap<>();
        wallet.put(real.getExtId(), real.getPrice() * 0);
        wallet.put(putin.getExtId(), putin.getPrice() * 0);
        wallet.put(doge.getExtId(), doge.getPrice() * 0);
        wallet.put(marreta.getExtId(), marreta.getPrice() * 0);
        wallet.put(recayd.getExtId(), recayd.getPrice() * 0);

        return wallet;
    }

    // Continue from here warning!

    public void depositReal(User user, double value) {
        user.getWallet().replace("Real", value);
        Instant timeNow = Instant.now();
        String history = user.getName() + "-" + value + "-" + timeNow.toString();
        user.getDepositHistory().add(history);
    }

}
