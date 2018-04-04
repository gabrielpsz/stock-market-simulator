package control;

import dao.CoinDao;
import interfaces.ICrud;
import model.Coin;

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
    public void delete(String name) {
        if (name != null) {
            if (read().isEmpty()) {
                return;
            } else {
                CoinDao.getCoinDao().remove(name);
            }
        }
    }

    @Override
    public void update(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            if (CoinDao.getCoinDao().get(cn.getName()) != null) {
                if (read().isEmpty()) {
                    return;
                } else {
                    CoinDao.getCoinDao().get(cn.getName()).setPrice(cn.getPrice());
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

    public void updateData(String name, double price) {
        Coin coin = new Coin(name, price);
        update(coin);
    }

    @Override
    public void create(Object coin) {
        if (coin != null) {
            Coin cn = (Coin) coin;
            System.out.println(cn.getName() + " " + cn.getPrice());
            CoinDao.getCoinDao().put(cn);
//            if (read().isEmpty()) {
//                cn.setName("Real");
//            } else {
//                String lastId = read().get(read().size() - 1).getName();
//                int lastIntId = Integer.parseInt(lastId);
//                int newIntId = lastIntId + 1;
//                String newId = Integer.toString(newIntId);
//                cn.setExtId(newId);
//                CoinDao.getCoinDao().put(cn);
//            }
        }
    }

    public Map<String, Double> createWallet() {

        Map<String, Double> wallet = new HashMap<>();

        for (int i = 0; i < read().size(); i++) {
            wallet.put(read().get(i).getName(), read().get(i).getPrice() * 0);
        }

        return wallet;
    }

    public void depositReal(double value) {
        System.out.println(UserController.getUserController().getSessionUser());
        UserController.getUserController().getSessionUser().getWallet().replace("Real", value);
        Instant timeNow = Instant.now();
        String history = UserController.getUserController().getSessionUser().getName() + " - Depósito: R$" + value + " - Data: " + timeNow.toString();
        UserController.getUserController().getSessionUser().getHistory().add(history);
    }

    public void exchange(double value, Coin coinOut, Coin coinIn) {
        if (value > UserController.getUserController().getSessionUser().getWallet().get(coinOut.getName())) {
            System.out.println("Falta dinheiro " + coinOut.getName() + " " + coinIn.getName());
        } else {
            double walletCoinOut = UserController.getUserController().getSessionUser().getWallet().get(coinOut.getName()) - value;
            double walletCoinIn = UserController.getUserController().getSessionUser().getWallet().get(coinIn.getName());
            double coinOutToCoinIn = (value / coinIn.getPrice()) + walletCoinIn;

            UserController.getUserController().getSessionUser().getWallet().replace(coinOut.getName(), walletCoinOut);
            UserController.getUserController().getSessionUser().getWallet().replace(coinIn.getName(), coinOutToCoinIn);

            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Venda De: " + value + " " + coinOut.getName() + " Para: " + coinOutToCoinIn + " " + coinIn.getName() + " - Data: " + timeNow.toString();
            UserController.getUserController().getSessionUser().getHistory().add(history);
        }
    }

    public void withdrawReal(double value) {
        if (value <= UserController.getUserController().getSessionUser().getWallet().get("Real")) {
            UserController.getUserController().getSessionUser().getWallet().replace("Real", (UserController.getUserController().getSessionUser().getWallet().get("Real") - value));
            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Retirada: R$" + value + " - Data: " + timeNow.toString();
            UserController.getUserController().getSessionUser().getHistory().add(history);
        } else {
            System.out.println("Falta dinheiro");
        }
    }

    public Coin searchCoin(String name) {
        return CoinDao.getCoinDao().get(name);
    }

    public boolean verifyCoinExistance(String name) {
        if (CoinDao.getCoinDao().get(name) != null) {
            return true;
        }
        return false;
    }

    // Continue from here warning!

    public double verifyCoinQuantity(String name) {
        if (UserController.getSessionUser() != null && name != null || name != "" || name != "Real") {
            return (UserController.getSessionUser().getWallet().get(name) / CoinController.getCoinController().searchCoin("Real").getPrice());
        }
        return 0.0;
    }

}
