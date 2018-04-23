package control;

import dao.ActionDao;
import interfaces.ICrud;
import model.Action;
import model.WalletAction;

import java.text.DecimalFormat;
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

    public void depositReal(double quantidade) {
        System.out.println(UserController.getUserController().getSessionUser());
        System.out.println(UserController.getUserController().getActionWallet("Real"));
        double total = UserController.getUserController().getActionWallet("Real").getQtd() + quantidade;
        UserController.getUserController().getActionWallet("Real").setQtd(total);
        Instant timeNow = Instant.now();
        String history = UserController.getUserController().getSessionUser().getName() + " - Depósito: R$" + quantidade + " - Data: " + timeNow.toString();
        UserController.getUserController().getSessionUser().getHistory().add(history);
        UserController.getUserController().updatePersist();
    }

    public void compra(double quantidade, Action saldo, Action acaoComprada) {
        if (quantidade * acaoComprada.getPrice() >  UserController.getUserController().getActionWallet(saldo.getName()).getQtd()) {
            System.out.println("Falta dinheiro " + saldo.getName() + " " + acaoComprada.getName());
        } else {
            Double valorCompra = acaoComprada.getPrice() * quantidade;
            UserController.getUserController().getActionWallet(acaoComprada.getName()).setQtd(quantidade);
            Double saldoAtual = UserController.getUserController().getActionWallet(saldo.getName()).getQtd() - valorCompra;
            System.out.println(saldoAtual);
            UserController.getUserController().getActionWallet(saldo.getName()).setQtd(saldoAtual);
            UserController.getUserController().updatePersist();
        }
    }

    public void venda(double quantidade, Action acaoVendida, Action saldo) {
        Double saldoTotal = UserController.getUserController().getActionWallet(saldo.getName()).getQtd();
        saldoTotal += acaoVendida.getPrice() * quantidade;
        System.out.println("Saldo total = " + saldoTotal);
        Double quantidadeDeAcoes = UserController.getUserController().getActionWallet(acaoVendida.getName()).getQtd();
        UserController.getUserController().getActionWallet(acaoVendida.getName()).setQtd(quantidadeDeAcoes - quantidade);
        UserController.getUserController().getActionWallet(saldo.getName()).setQtd(saldoTotal);
        UserController.getUserController().updatePersist();
    }

    public void withdrawReal(double quantidade) {
        if (quantidade <= UserController.getUserController().getActionWallet("Real").getQtd()) {
            UserController.getUserController().getActionWallet("Real").setQtd(UserController.getUserController().getActionWallet("Real").getQtd() - quantidade);
//            UserController.getUserController().getSessionUser().getWallet().replace("Real", (UserController.getUserController().getSessionUser().getWallet().get("Real") - quantidade));
            Instant timeNow = Instant.now();
            String history = UserController.getUserController().getSessionUser().getName() + " - Retirada: R$" + quantidade + " - Data: " + timeNow.toString();
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

    public Double getSaldoNaoRealizado() {
        Double saldoNaoRealizado = 0.0;
        for (WalletAction action : UserController.getSessionUser().getWallet()) {
            if (action.getNameAction().equals("Real")) {
                saldoNaoRealizado += action.getQtd();
            } else {
                saldoNaoRealizado += action.getQtd() * searchAction(action.getNameAction()).getPrice();
            }
        }
        return Math.round(saldoNaoRealizado * 100) / 100d;
    }

    public Double getSaldoTotal() {
        Double saldo = UserController.getUserController().getActionWallet("Real").getQtd();
        return Math.round(saldo * 100) / 100d;
    }

    public Double getValorTotalAcoes() {
        Double valorTotalAcoes = 0.0;
        for (WalletAction action : UserController.getSessionUser().getWallet()) {
            if (!action.getNameAction().equals("Real")) {
                valorTotalAcoes = UserController.getUserController().getActionWallet(action.getNameAction()).getQtd() * searchAction(action.getNameAction()).getPrice();
                UserController.getUserController().getActionWallet(action.getNameAction()).setValue(valorTotalAcoes);
            }
        }
        UserController.getUserController().updatePersist();
        return valorTotalAcoes;
    }
}
