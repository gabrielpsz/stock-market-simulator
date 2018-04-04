package connection;

import control.CoinController;
import control.UserController;
import model.Coin;
import model.User;

public class Injector {

    private static Injector injector;

    public static void main(String[] args) {
        getInjector().injetarCadastros();
    }

    public void injetarCadastros() {

        Coin real = new Coin("Real", 1);
        Coin putin = new Coin("Putin", 8.12);
        Coin doge = new Coin("Doge", 3.5);
        Coin marreta = new Coin("Marreta", 1.43);
        Coin recayd = new Coin("Recayd", 4.09);

        CoinController.getCoinController().create(real);
        CoinController.getCoinController().create(putin);
        CoinController.getCoinController().create(doge);
        CoinController.getCoinController().create(marreta);
        CoinController.getCoinController().create(recayd);
        System.out.println(CoinController.getCoinController().read());

//        User marcelo = new User("mbros", "123123", "Marcelo Brosowicz de Paulo", "86454110087", CoinController.getCoinController().createWallet());
//        User victor = new User("goulartvic", "1928", "Victor Pereira Goulart", "12541462964", CoinController.getCoinController().createWallet());
//        User rodolfo = new User("rodolfoip", "12345", "Rodolfe Ilce Pereira", "83306016926", CoinController.getCoinController().createWallet());
//
//        UserController.getUserController().create(marcelo);
//        UserController.getUserController().create(victor);
//        UserController.getUserController().create(rodolfo);

//        CoinController.getCoinController().depositReal(5000.00);
//        Coin coinOut = CoinController.getCoinController().searchCoin("Real");
//        Coin coinIN = CoinController.getCoinController().searchCoin("Doge");
//        CoinController.getCoinController().exchange(100.00, coinOut, coinIN);
//        CoinController.getCoinController().withdrawReal(80.00);
//        CoinController.getCoinController().depositReal(300.00);
//        System.out.println(UserController.getUserController().searchUser("mbros").getHistory());
//        CoinController.getCoinController().depositReal(300.00);
//        Coin coinOut1 = CoinController.getCoinController().searchCoin("Real");
//        Coin coinIN2 = CoinController.getCoinController().searchCoin("Marreta");
//        CoinController.getCoinController().exchange(100.00, coinOut1, coinIN2);
//        CoinController.getCoinController().withdrawReal(80.00);
//        System.out.println(UserController.getUserController().searchUser("goulartvic").getHistory());
//        CoinController.getCoinController().depositReal(300.00);
//        Coin coinOut2 = CoinController.getCoinController().searchCoin("Real");
//        Coin coinIN3 = CoinController.getCoinController().searchCoin("Recayd");
//        CoinController.getCoinController().exchange(150.00, coinOut2, coinIN3);
//        CoinController.getCoinController().withdrawReal(90.00);
//        System.out.println(UserController.getUserController().searchUser("rodolfoip").getHistory());
    }

    public static Injector getInjector() {
        if (injector == null) {
            injector = new Injector();
        }
        return injector;
    }

    public static void setInjector(Injector injector) {
        Injector.injector = injector;
    }
}
