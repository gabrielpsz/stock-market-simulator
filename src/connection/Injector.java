package connection;

import control.ActionController;
import model.Action;

public class Injector {

    private static Injector injector;

    public static void main(String[] args) {
        getInjector().injetarCadastros();
    }

    public void injetarCadastros() {

        Action real = new Action("Real", 1);
        Action petrobras = new Action("PETR3", 1);
        Action cemig = new Action("CMIG4", 1);
        Action lojasamericanas = new Action("LAME4", 1);
        Action natura = new Action("NATU3", 1);

        ActionController.getActionController().create(natura);
        ActionController.getActionController().create(lojasamericanas);
        ActionController.getActionController().create(cemig);
        ActionController.getActionController().create(petrobras);
        ActionController.getActionController().create(real);

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
