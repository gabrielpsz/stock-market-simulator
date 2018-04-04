package dao;

import model.Coin;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class CoinDao {

    private static CoinDao coinDao;
    private HashMap<String, Coin> coinCache;
    private String filename = "coins.cla";

    public CoinDao() {

        super();
        coinCache = new HashMap<>();
        load();

    }

    public static CoinDao getCoinDao() {
        if (coinDao == null) {
            coinDao = new CoinDao();
        }

        return coinDao;

    }

    public static void setCoinDao(CoinDao coinDao) {
        CoinDao.coinDao = coinDao;
    }

    private void load() {
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);

            this.coinCache = (HashMap<String, Coin>) oi.readObject();

            oi.close();
            fin.close();

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void put(Coin Coin) {
        if (Coin != null) {
            coinCache.put(Coin.getName(), Coin);
            persist();
        }
    }

    public void persist() {
        try {
            FileOutputStream fout = new FileOutputStream(filename);

            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(coinCache);

            oo.flush();
            fout.flush();

            oo.close();
            fout.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Coin get(String extendedId) {

        if (extendedId != null) {
            return coinCache.get(extendedId);
        }

        return null;

    }

    public void remove(String extendedId) {
        coinCache.remove(extendedId);
        persist();
    }

    public Collection<Coin> getList() {
        return coinCache.values();
    }

    public HashMap<String, Coin> getCoinCache() {
        return coinCache;
    }

}
