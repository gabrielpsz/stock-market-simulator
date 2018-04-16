package dao;

import model.Action;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class ActionDao {

    private static ActionDao actionDao;
    private HashMap<String, Action> actionCache;
    private String filename = "actions.cla";

    public ActionDao() {

        super();
        actionCache = new HashMap<>();
        load();

    }

    public static ActionDao getActionDao() {
        if (actionDao == null) {
            actionDao = new ActionDao();
        }

        return actionDao;

    }

    public static void setActionDao(ActionDao actionDao) {
        ActionDao.actionDao = actionDao;
    }

    private void load() {
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);

            this.actionCache = (HashMap<String, Action>) oi.readObject();

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

    public void put(Action Action) {
        if (Action != null) {
            actionCache.put(Action.getName(), Action);
            persist();
        }
    }

    public void persist() {
        try {
            FileOutputStream fout = new FileOutputStream(filename);

            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(actionCache);

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

    public Action get(String name) {

        if (name != null) {
            return actionCache.get(name);
        }

        return null;

    }

    public void remove(String name) {
        actionCache.remove(name);
        persist();
    }

    public Collection<Action> getList() {
        return actionCache.values();
    }

    public HashMap<String, Action> getActionCache() {
        return actionCache;
    }

}
