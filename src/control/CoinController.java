package control;

import dao.CoinDao;
import dao.UserDao;
import interfaces.ICrud;
import model.Coin;
import model.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoinController extends Controller implements ICrud {

    private static CoinController coinController;
    private static double iof = 1.01;
    private static double corretagem = 0.5;


    public CoinController() {
        super();
    }

    @Override
    public void initiate() {

    }

    @Override
    public void delete(String extendedId) {
        if (extendedId != null) {
            if (read().isEmpty()) {
                return;
            } else {
                CoinDao.getCoinDao().remove(extendedId);
            }
        }
    }

    @Override
    public void update(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            if (CoinDao.getCoinDao().get(cn.getExtId()) != null) {
                if (read().isEmpty()) {
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

    public static double getIof() {
        return iof;
    }

    public static void setIof(double iof) {
        CoinController.iof = iof;
    }

    public static double getCorretagem() {
        return corretagem;
    }

    public static void setCorretagem(double corretagem) {
        CoinController.corretagem = corretagem;
    }

    public static void setCoinController(CoinController coinController) {
        CoinController.coinController = coinController;
    }

    public void receiveData(String name, double price) {
        Coin coin = new Coin(name, price);
        create(coin);
    }

    public void updateData(String extendedId, String name, double price) {
        Coin coin = new Coin(name, price);
        coin.setExtId(extendedId);
        update(coin);
    }

    @Override
    public void create(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            if (read().isEmpty()) {
                cn.setExtId("1");
                CoinDao.getCoinDao().put(cn);
            } else {
                String lastId = read().get(read().size() - 1).getExtId();
                int lastIntId = Integer.parseInt(lastId);
                int newIntId = lastIntId + 1;
                String newId = Integer.toString(newIntId);
                cn.setExtId(newId);
                CoinDao.getCoinDao().put(cn);
            }
        }
    }

    public Map<String, Double> createWallet() {

        Map<String, Double> wallet = new HashMap<>();

        for (int i = 0; i < read().size(); i++) {
            wallet.put(read().get(i).getExtId(), read().get(i).getPrice() * 0);
        }

        return wallet;
    }

    public void depositReal(double value) {
        UserController.getUserController().getSessionUser().getWallet().replace("1", value);
        Instant timeNow = Instant.now();
        String history = UserController.getUserController().getSessionUser().getName() + " - Depósito: R$" + value + " - Data: " + timeNow.toString();
        UserController.getUserController().getSessionUser().getHistory().add(history);
    }

    public void exchange(double value, Coin coinOut, Coin coinIn) {
        if (value > UserController.getUserController().getSessionUser().getWallet().get(coinOut.getExtId())) {
            System.out.println("Falta dinheiro");
        } else {
            double walletCoinOut = UserController.getUserController().getSessionUser().getWallet().get(coinOut.getExtId()) - value + ((iof * UserController.getUserController().getSessionUser().getWallet().get(coinOut.getExtId()) / 100)) + ((corretagem * UserController.getUserController().getSessionUser().getWallet().get(coinOut.getExtId()) / 100));
            double walletCoinIn = UserController.getUserController().getSessionUser().getWallet().get(coinIn.getExtId());
            double coinOutToCoinIn = (value / coinIn.getPrice()) + walletCoinIn;

            UserController.getUserController().getSessionUser().getWallet().replace(coinOut.getExtId(), walletCoinOut);
            UserController.getUserController().getSessionUser().getWallet().replace(coinIn.getExtId(), coinOutToCoinIn);

            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Venda De: " + value + " " + coinOut.getName() + " Para: " + coinOutToCoinIn + " " + coinIn.getName() + " - Data: " + timeNow.toString();
            UserController.getUserController().getSessionUser().getHistory().add(history);
        }
    }

    public void withdrawReal(double value) {
        if (value <= UserController.getUserController().getSessionUser().getWallet().get("1")) {
            UserController.getUserController().getSessionUser().getWallet().replace("1", (UserController.getUserController().getSessionUser().getWallet().get("1") - value));
            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Retirada: R$" + value + " - Data: " + timeNow.toString();
            UserController.getUserController().getSessionUser().getHistory().add(history);
        } else {
            System.out.println("Falta dinheiro");
        }
    }

    public Coin searchCoin(String extendedId) {
        return CoinDao.getCoinDao().get(extendedId);
    }

    public boolean verifyCoinExistance(String extendedId) {
        if (CoinDao.getCoinDao().get(extendedId) != null) {
            return true;
        }
        return false;
    }

    // Continue from here warning!

    public double verifyCoinQuantity(String extendedId) {
        if (UserController.getSessionUser() != null && extendedId != null || extendedId != "" || extendedId != "1") {
            return (UserController.getSessionUser().getWallet().get(extendedId) / CoinController.getCoinController().searchCoin("1").getPrice());
        }
        return 0.0;
    }

}
