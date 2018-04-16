package Job;

import control.ActionController;
import model.Action;

import java.util.Random;

public class UpdateValue implements Runnable {

    @Override
    public void run() {
        Action petrobras = new Action("PETR3", getDoubleValue());
        Action cemig = new Action("CMIG4", getDoubleValue());
        Action lojasamericanas = new Action("LAME4", getDoubleValue());
        Action natura = new Action("NATU3", getDoubleValue());
        ActionController.getActionController().update(petrobras);
        ActionController.getActionController().update(cemig);
        ActionController.getActionController().update(lojasamericanas);
        ActionController.getActionController().update(natura);
        System.out.println("Mudança de valor");
        System.out.println(petrobras.getName() +" - " +petrobras.getPrice());
        System.out.println(cemig.getName() +" - " +cemig.getPrice());
        System.out.println(lojasamericanas.getName() +" - " +lojasamericanas.getPrice());
        System.out.println(natura.getName() +" - " +natura.getPrice());
    }

    public double getDoubleValue() {
        Random rand = new Random();
        double n = 0.5 + (20.0 - 0.5) * rand.nextDouble();
        return n;
    }

}
