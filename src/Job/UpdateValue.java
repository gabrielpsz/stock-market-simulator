package Job;

import control.CoinController;
import model.Coin;

import java.util.Random;

public class UpdateValue implements Runnable {

    @Override
    public void run() {
        Coin putin = new Coin("Putin", getDoubleValue());
        Coin doge = new Coin("Doge", getDoubleValue());
        Coin marreta = new Coin("Marreta", getDoubleValue());
        Coin recayd = new Coin("Recayd", getDoubleValue());
        CoinController.getCoinController().update(putin);
        CoinController.getCoinController().update(doge);
        CoinController.getCoinController().update(marreta);
        CoinController.getCoinController().update(recayd);
        System.out.println("Mudança de valor");
    }

    public double getDoubleValue() {
        Random rand = new Random();
        double n = 0.5 + (20.0 - 0.5) * rand.nextDouble();
        return n;
    }

}
