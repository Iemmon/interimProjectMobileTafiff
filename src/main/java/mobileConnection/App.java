package mobileConnection;

import mobileConnection.controller.TariffController;
import mobileConnection.model.TariffModel;
import mobileConnection.view.TariffView;

/**
 * @author kateryna
 */
public class App {
    public static void main(String[] args) {

        TariffController controller = new TariffController(new TariffModel(), new TariffView());
        controller.run();
    }
}
