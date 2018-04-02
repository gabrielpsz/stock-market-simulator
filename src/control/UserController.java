package control;

import dao.CoinDao;
import dao.DAO;
import dao.UserDao;
import model.User;

import java.util.ArrayList;

public class UserController extends Controller implements DAO {

    private static UserController userController;

    public UserController() {
        super();
    }

    @Override
    public void initiate() {

    }

    @Override
    public void save(Object user) {
        if (user != null) {
            User cn = (User) user;
            UserDao.getUserDao().put(cn);
        }
    }

    @Override
    public void delete(Object user) {
        if (user != null) {
            User cn = (User) user;
            if (UserDao.getUserDao().getList().isEmpty()) {
                return;
            } else {
                UserDao.getUserDao().remove(cn.getLogin());
            }
        }
    }

    @Override
    public void update(Object user) {
        if (user != null) {
            User cn = (User) user;
            if (UserDao.getUserDao().get(cn.getLogin()) != null) {
                if (UserDao.getUserDao().getList().isEmpty()) {
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

    public static UserController getUserController() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    public static void setCoinController(UserController userController) {
        UserController.userController = userController;
    }

    public ArrayList<User> listUsers() {
        return new ArrayList<User>(UserDao.getUserDao().getList());
    }

    public void receiveData(String login, String password, String name, String cpf) {
        User user = new User(login, password, name, cpf, CoinController.getCoinController().createWallet());
        save(user);
    }

    public boolean authenticateUser(String login, String password) {
        if (UserDao.getUserDao().get(login) != null) {
            if (UserDao.getUserDao().getList().isEmpty()) {
                return false;
            } else {
                if (UserDao.getUserDao().get(login).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }


}
