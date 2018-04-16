package control;

import dao.ActionDao;
import interfaces.ICrud;
import model.Action;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionController extends Controller implements ICrud {

    private static ActionController actionController;
    private static double iof = 1.01;
    private static double corretagem = 0.5;


    public ActionController() {
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
                ActionDao.getActionDao().remove(name);
            }
        }
    }

    @Override
    public void update(Object action) {
        if (action != null) {
            Action cn = (Action) action;
            if (ActionDao.getActionDao().get(cn.getName()) != null) {
                if (read().isEmpty()) {
                    return;
                } else {
                    ActionDao.getActionDao().get(cn.getName()).setPrice(cn.getPrice());
                    ActionDao.getActionDao().persist();
                }
            }
        }
    }

    @Override
    public ArrayList<Action> read() {
        return new ArrayList<Action>(ActionDao.getActionDao().getList());
    }

    public static ActionController getActionController() {
        if (actionController == null) {
            actionController = new ActionController();
        }
        return actionController;
    }

    public static double getIof() {
        return iof;
    }

    public static void setIof(double iof) {
        ActionController.iof = iof;
    }

    public static double getCorretagem() {
        return corretagem;
    }

    public static void setCorretagem(double corretagem) {
        ActionController.corretagem = corretagem;
    }

    public static void setActionController(ActionController actionController) {
        ActionController.actionController = actionController;
    }

    public void receiveData(String name, double price) {
        Action action = new Action(name, price);
        create(action);
    }

    public void updateData(String name, double price) {
        Action action = new Action(name, price);
        update(action);
    }

    @Override
    public void create(Object action) {
        if (action != null) {
            Action act = (Action) action;
            System.out.println(act.getName() + " " + act.getPrice());
            ActionDao.getActionDao().put(act);
        }
    }

    public Map<String, Double> createWallet() {

        Map<String, Double> wallet = new HashMap<>();
        List<Action> actions = new ArrayList<>();

        for (int i = 0; i < read().size(); i++) {
            wallet.put(read().get(i).getName(), read().get(i).getPrice());
        }
        System.out.println(wallet);
        return wallet;
    }

    public void depositReal(double value) {
        System.out.println(UserController.getUserController().getSessionUser());
        double total = UserController.getUserController().getActionWallet("Real").getQtd() + value;
        UserController.getUserController().getActionWallet("Real").setQtd(total);
        Instant timeNow = Instant.now();
        String history = UserController.getUserController().getSessionUser().getName() + " - Depósito: R$" + value + " - Data: " + timeNow.toString();
        UserController.getUserController().getSessionUser().getHistory().add(history);
        UserController.getUserController().updatePersist();
    }

    public void exchange(double value, Action actionOut, Action actionIn) {
        if (value > UserController.getUserController().getActionWallet(actionOut.getName()).getQtd()) {
            System.out.println("Falta dinheiro " + actionOut.getName() + " " + actionIn.getName());
        } else {
            double walletActionOut = UserController.getUserController().getActionWallet(actionOut.getName()).getQtd() - value;
            double walletActionIn = UserController.getUserController().getActionWallet(actionIn.getName()).getQtd();
            double actionOutToActionIn;
            if (actionIn.getPrice() < actionOut.getPrice()) {
                actionOutToActionIn = ((value * actionOut.getPrice())/actionIn.getPrice()) + walletActionIn;
            }
            else {
                actionOutToActionIn = (value / actionIn.getPrice()) + walletActionIn;
            }
            UserController.getUserController().getActionWallet(actionOut.getName()).setQtd(walletActionOut);
            UserController.getUserController().getActionWallet(actionIn.getName()).setQtd(actionOutToActionIn);

            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Venda De: " + value + " " + actionOut.getName() + " Para: " + actionOutToActionIn + " " + actionIn.getName() + " - Data: " + timeNow.toString();
            UserController.getUserController().getSessionUser().getHistory().add(history);
            UserController.getUserController().updatePersist();
        }
    }

    public void withdrawReal(double value) {
        if (value <= UserController.getUserController().getActionWallet("Real").getQtd()) {
            UserController.getUserController().getActionWallet("Real").setQtd(UserController.getUserController().getActionWallet("Real").getQtd() - value);
//            UserController.getUserController().getSessionUser().getWallet().replace("Real", (UserController.getUserController().getSessionUser().getWallet().get("Real") - value));
            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Retirada: R$" + value + " - Data: " + timeNow.toString();
            UserController.getUserController().getSessionUser().getHistory().add(history);
            UserController.getUserController().updatePersist();
        } else {
            System.out.println("Falta dinheiro");
        }
    }

    public Action searchAction(String name) {
        return ActionDao.getActionDao().get(name);
    }

    public boolean verifyActionExistance(String name) {
        if (ActionDao.getActionDao().get(name) != null) {
            return true;
        }
        return false;
    }

    // Continue from here warning!

//    public double verifyActionQuantity(String name) {
//        if (UserController.getSessionUser() != null && name != null || name != "" || name != "Real") {
//            return (UserController.getSessionUser().getWallet().get(name) / ActionController.getActionController().searchAction("Real").getPrice());
//        }
//        return 0.0;
//    }

}
