package control;

import dao.UserDao;
import interfaces.ICrud;
import model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void receiveData(String login, String password, String name, String cpf) {
        User user = new User(login, password, name, cpf, CoinController.getCoinController().createWallet());
        create(user);
    }

    public void updateData(String login, String password, String name, String cpf) {
        User user = new User(login, password, name, cpf, CoinController.getCoinController().createWallet());
        update(user);
    }

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

    public List<String> listWallet() {
        if (getSessionUser() != null) {
            List<String> walletList = new ArrayList<>();
            List<String> coinNameList = getSessionUser().getWallet().keySet().stream().collect(Collectors.toList());
            List<Double> coinValuesList = getSessionUser().getWallet().values().stream().collect(Collectors.toList());

            for (int i = 0; i < 5; i++) {
                String coin = "Name: "+coinNameList.get(i)+ "-R$" + coinValuesList.get(i).toString();
                System.out.println(coin);
                walletList.add(coin);
            }
            return walletList;
        }
        return null;
    }

}
