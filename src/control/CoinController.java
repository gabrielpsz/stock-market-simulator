package control;

import dao.CoinDao;
import dao.DAO;
import model.Coin;

import java.util.ArrayList;

public class CoinController extends Controller implements DAO {

    private static CoinController coinController;

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
            if (CoinDao.getCoinDao().getList().isEmpty()) {
                CoinDao.getCoinDao().put(cn);
            }
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

    public void receiveData(String extId, String name, float price) {
        Coin coin = new Coin(extId, name, price);
        save(coin);
    }

    public ArrayList<Coin> listCoins() {
        return new ArrayList<Coin>(CoinDao.getCoinDao().getList());
    }

}
