package dao;

import model.User;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class UserDao {

    private static UserDao userDao;
    private HashMap<String, User> userCache;
    private String filename = "users.cla";

    public UserDao() {

        super();
        userCache = new HashMap<>();
        load();

    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }

        return userDao;

    }

    public static void setUserDao(UserDao userDao) {
        UserDao.userDao = userDao;
    }

    private void load() {
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);

            this.userCache = (HashMap<String, User>) oi.readObject();

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

    public void put(User User) {
        if (User != null) {
            userCache.put(User.getLogin(), User);
            persist();
        }
    }

    public void persist() {
        try {
            FileOutputStream fout = new FileOutputStream(filename);

            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(userCache);

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

    public User get(String login) {

        if (login != null) {
            return userCache.get(login);
        }

        return null;

    }

    public void remove(String login) {
        userCache.remove(login);
        persist();
    }

    public Collection<User> getList() {
        return userCache.values();
    }

}
