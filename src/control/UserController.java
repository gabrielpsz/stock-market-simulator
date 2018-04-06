package control;

import dao.UserDao;
import interfaces.ICrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;
import model.WalletCoin;
import view.Wallet;

import java.util.*;

public class UserController extends Controller implements ICrud {

    private static UserController userController;
    private static User sessionUser;

    public UserController() {
        super();
    }

    @Override
    public void initiate() {

    }

    @Override
    public void create(Object user) {
        if (user != null) {
            User cn = (User) user;
            if (read().isEmpty()) {
                cn.setUserId(1);
                UserDao.getUserDao().put(cn);
            } else {
                int lastId = read().get(read().size() - 1).getUserId();
                int newId = lastId + 1;
                cn.setUserId(newId);
                UserDao.getUserDao().put(cn);
            }
        }
    }

    @Override
    public void delete(String login) {
        if (login != null) {
            if (read().isEmpty()) {
                return;
            } else {
                UserDao.getUserDao().remove(login);
            }
        }
    }

    public void updatePersist(){
        UserDao.getUserDao().persist();
    }

    @Override
    public void update(Object user) {
        if (user != null) {
            User cn = (User) user;
            if (UserDao.getUserDao().get(cn.getLogin()) != null) {
                if (read().isEmpty()) {
                    return;
                } else {
                    UserDao.getUserDao().get(cn.getLogin()).setCpf(cn.getCpf());
                    UserDao.getUserDao().get(cn.getLogin()).setName(cn.getName());
                    UserDao.getUserDao().get(cn.getLogin()).setPassword(cn.getPassword());
                    UserDao.getUserDao().persist();
                }
            }
        }
    }

    @Override
    public ArrayList<User> read() {
        return new ArrayList<User>(UserDao.getUserDao().getList());
    }
//
//    public void receiveData(String login, String password, String name, String cpf) {
//        User user = new User(login, password, name, cpf, CoinController.getCoinController().createWallet());
//        create(user);
//    }
//
//    public void updateData(String login, String password, String name, String cpf) {
//        User user = new User(login, password, name, cpf, CoinController.getCoinController().createWallet());
//        update(user);
//    }

    public static UserController getUserController() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    public static void setCoinController(UserController userController) {
        UserController.userController = userController;
    }

    public static User getSessionUser() {
        return sessionUser;
    }

    public static void setSessionUser(User sessionUser) {
        UserController.getUserController().sessionUser = sessionUser;
    }

    public User searchUser(String login) {
        return UserDao.getUserDao().get(login);
    }

    public boolean verifyUserExistance(String login) {
        if (UserDao.getUserDao().get(login) != null) {
            return true;
        }
        return false;
    }

    public boolean authenticateUser(String login, String password) {
        if (UserDao.getUserDao().get(login) != null) {
            if (read().isEmpty()) {
                return false;
            } else {
                if (UserDao.getUserDao().get(login).getPassword().equals(password)) {
                    setSessionUser(UserDao.getUserDao().get(login));
                    return true;
                }
            }
        }
        return false;
    }

    public WalletCoin getCoinWallet(String nome) {
        for (int i = 0; i < sessionUser.getWallet().size(); i++) {
            if (sessionUser.getWallet().get(i).getNameCoin().equals(nome)) {
                return sessionUser.getWallet().get(i);
            }
        }
        return null;
    }

    public List<WalletCoin> listaMoedasDoDOido(){
        return sessionUser.getWallet();
    }

    public List<WalletCoin> createWallet() {
        List<WalletCoin> walletCoin = new ArrayList<>();
        WalletCoin ww;
        for (int i = 0; i < CoinController.getCoinController().read().size(); i++) {
            ww = new WalletCoin(CoinController.getCoinController().read().get(i).getName(), 0);
            walletCoin.add(ww);
        }
        return walletCoin;
    }
    public ObservableList<WalletCoin> kRegaWallet() {
        List<WalletCoin> walletCoin = new ArrayList<>();
        WalletCoin w;
        for (int i = 0; i < CoinController.getCoinController().read().size(); i++) {
            w = new WalletCoin(CoinController.getCoinController().read().get(i).getName(), 0);
            walletCoin.add(w);
        }
        ObservableList<WalletCoin> ww = FXCollections.observableList(walletCoin);
        return ww;
    }
}
