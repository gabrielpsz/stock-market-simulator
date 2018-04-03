package control;

import dao.UserDao;
import interfaces.ICrud;
import model.User;

import java.util.ArrayList;

public class UserController extends Controller implements ICrud {

    private static UserController userController;

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

    @Override
    public ArrayList<User> read() {
        return new ArrayList<User>(UserDao.getUserDao().getList());
    }

    public void receiveData(String login, String password, String name, String cpf) {
        User user = new User(login, password, name, cpf, CoinController.getCoinController().createWallet());
        create(user);
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
