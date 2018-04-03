package control;

import dao.CoinDao;
import interfaces.ICrud;
import model.Coin;
import model.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoinController extends Controller implements ICrud {

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
    public void create(Object coin) {
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

    @Override
    public ArrayList<Coin> read() {
        return new ArrayList<Coin>(CoinDao.getCoinDao().getList());
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

    public void receiveData(String name, double price) {
        Coin coin = new Coin(name, price);
        create(coin);
    }

    public static void main(String[] args) {
        CoinController coinRegister = new CoinController();
        User user = new User("Teste", "teste", "Teste", "TOMANOCU", coinRegister.createWallet());
        coinRegister.depositReal(user, 200);
        Coin coinOut = coinRegister.real;
        Coin coinIN = coinRegister.doge;
        coinRegister.exchange(user, 100, coinOut, coinIN);
        System.out.println(user.getWallet());
        coinRegister.withdrawReal(user, 80);
        System.out.println(user.getWallet());
        coinRegister.depositReal(user, 300);
        System.out.println(user.getHistory());

    }

    // Continue from here warning!

    public Map<String, Double> createWallet() {
        Map<String, Double> wallet = new HashMap<>();
        wallet.put(real.getName(), real.getPrice() * 0);
        wallet.put(putin.getName(), putin.getPrice() * 0);
        wallet.put(doge.getName(), doge.getPrice() * 0);
        wallet.put(marreta.getName(), marreta.getPrice() * 0);
        wallet.put(recayd.getName(), recayd.getPrice() * 0);

        return wallet;
    }

    public void depositReal(User user, double value) {
        user.getWallet().replace("Real", value);
        Instant timeNow = Instant.now();
        String history = user.getName() + "- Depósito: R$" + value + "- Data:" + timeNow.toString();
        user.getHistory().add(history);
    }

    public void exchange(User user, double value, Coin coinOut, Coin coinIn) {
        if (value > user.getWallet().get(coinOut.getName())) {
            System.out.println("Falta dinheiro");
        } else {
            double walletCoinOut = user.getWallet().get(coinOut.getName()) - value;
            double walletCoinIn = user.getWallet().get(coinIn.getName());
            double coinOutToCoinIn = (value / coinIn.getPrice()) + walletCoinIn;

            user.getWallet().replace(coinOut.getName(), walletCoinOut);
            user.getWallet().replace(coinIn.getName(), coinOutToCoinIn);
        }
    }

    public void withdrawReal(User user, double value) {
        if (value <= user.getWallet().get("Real")) {
            user.getWallet().replace("Real", (user.getWallet().get("Real") - value));
            Instant timeNow = Instant.now();
            String history = user.getName() + "- Retirada: R$" + value + "- Data:" + timeNow.toString();
            user.getHistory().add(history);
        } else {
            System.out.println("Falta dinheiro");
        }
    }

}
