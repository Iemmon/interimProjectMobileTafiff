package mobileConnection.controller;

import mobileConnection.controller.utilities.Converter;
import mobileConnection.controller.utilities.InputUtility;
import mobileConnection.model.TariffFilter;
import mobileConnection.model.TariffModel;
import mobileConnection.view.TariffView;

import java.util.regex.Pattern;

public class TariffController {

    private TariffModel model;
    private TariffView view;

    public TariffController(TariffModel model, TariffView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            for (MenuOption option : MenuOption.values()) {
                view.print(option.info);
            }
            String input = getValidInput(Converter.anyListToString(MenuOption.values(), "|", false));

            switch (MenuOption.valueOf(input.toUpperCase())) {
                case SHOW:
                    showTariffs();
                    break;
                case ADD:
                    addTariff();
                    break;
                case FIND:
                    searchTariff();
                    break;
                case SORT:
                    sortByFee();
                    break;
                case DELETE:
                    removeTariff();
                    break;
                case CLIENTS:
                    getNumOfClients();
                    break;
                case END:
                    System.exit(0);
            }
        }
    }

    private void removeTariff() {
        view.print(Message.ENTER_NAME.toString());
        String tariffName = InputUtility.scanForInput();
        if (model.deleteTariff(tariffName)) {
            view.print(tariffName + Message.DELETED);
        } else {
            view.print(tariffName + Message.NOT_DELETED);
        }
    }

    private void searchTariff() {
        view.print(Message.INPUT_EXAMPLE_SEARCH.toString());
        TariffFilter filter = model.getOperator().getFilter();
        while (true) {
            String inputString = getValidInput("((SMS|MINUTE|MB|FEE)\\s(\\d+)\\s(\\d+))|END");
            String[] result = inputString.split("\\s");
            if (!inputString.equals("END")) {
                filter = filter.getTariffsByParameter(result[0].toUpperCase(),
                                Math.min(Integer.parseInt(result[1]), Integer.parseInt(result[2])),
                                Math.max(Integer.parseInt(result[1]), Integer.parseInt(result[2])));
                view.print(Message.FILTER_APPLIED.toString());
            } else {
                if( filter.getTariffs().size() == 0){
                    view.print(Message.NO_RESULT.toString());
                } else {
                    view.print(Converter.anyListToString( filter.getTariffs().toArray(), "\n", true));
                }
                break;
            }
        }
    }

    private void addTariff() {
        view.print(Message.INPUT_EXAMPLE_ADD.toString());
        String tariffString = getValidInput("([^\\/]+)\\/(\\d+[.]?\\d*)\\/(\\d+[.]?\\d*)\\/(\\d+[.,]?\\d*)\\/(\\d+)");
        String[] tariffData = tariffString.split("/");
        model.createTariff(tariffData[0], tariffData[1], tariffData[2], tariffData[3], tariffData[4]);
        view.print(Message.TARIFF_CREATED.toString());
    }

    private void showTariffs() {
        view.print(Converter.anyListToString(model.getOperator().getTariffs().toArray(), "\n-------\n", false));
    }

    private void sortByFee() {
        view.print(Converter.anyListToString(model.sortTariffByFee().toArray(), "\n--------\n", true));
    }

    private void getNumOfClients() {
        view.print(Message.ENTER_NAME.toString());
        int numOfClients = model.getOperator().getNumOfClientsByTariff(InputUtility.scanForInput());
        view.print(Message.NUM_OF_CLIENTS.toString() + numOfClients);
    }

    private String getValidInput(String patternStr) {
        String input = InputUtility.scanForInput();
        while (!Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE).matcher(input).matches()) {
            view.print(Message.INVALID_VALUE.toString());
            input = InputUtility.scanForInput();
        }
        return input.toUpperCase();
    }
}
