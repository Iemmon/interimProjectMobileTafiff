package mobileConnection.controller;

import mobileConnection.model.TariffFilter;
import mobileConnection.model.TariffModel;
import mobileConnection.model.entity.tariff.TariffField;
import mobileConnection.view.TariffView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TariffController {

    private TariffModel model;
    private TariffView view;

    public TariffController(TariffModel model, TariffView view) {
        this.model = model;
        this.view = view;
        this.model.createOperator("MTS");
    }

    public void run() {

        while (true) {
            view.print("CHOOSE OPTION: ");
            for (MenuOption option : MenuOption.values()) {
                view.print(option.info);
            }
            MenuOption input = getValidInput();

            switch (input) {
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
            view.print("\n");
        }
    }

    private void removeTariff() {
        view.print("Enter tariff name to delete: ");
        String tariffName = InputUtility.scanForInput();
        if (model.deleteTariff(tariffName)) {
            view.print(tariffName + " was successfully deleted!");
        } else {
            view.print(tariffName + " was NOT deleted!");
        }
    }

    private void searchTariff() {

        TariffFilter filter = model.getOperator().getFilter();

        while (true) {
            view.print("Choose parameters to search by: ");
            view.print(Converter.anyListToString(TariffField.values(), ", ", false));
            view.print("Enter in the following order: [Search parameter] [min value] [max value]");
            view.print("Or type anything else to exit and see the result");

            String inputString = InputUtility.scanForInput();
            Pattern pattern = Pattern.compile("(?<param>(" + Converter.anyListToString(TariffField.values(), "|", false) + "))\\s(?<left>\\d+)\\s(?<right>\\d+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputString);

            if (matcher.matches()) {
                String param = matcher.group("param").toUpperCase();
                int left = Integer.parseInt(matcher.group("left"));
                int right = Integer.parseInt(matcher.group("right"));
                filter = filter.getTariffsByParameter(param, Math.min(left, right), Math.max(left, right));

            } else {
                view.print("Invalid value, returning results... ");
                break;
            }
        }
        view.print(Converter.anyListToString(filter.getTariffs().toArray(), "\n", true));
    }

    private MenuOption getValidInput() {
        String input;
        while (true) {
            input = InputUtility.scanForInput().trim().toUpperCase();
            if (input.matches("(" + Converter.anyListToString(MenuOption.values(), "|", false) + ")")) {
                break;
            }
            view.print("Invalid value, try again: ");
        }
        return MenuOption.valueOf(input);

    }

    private void addTariff() {
        view.print("Enter values like this: Tariff name/sms price/minute price/internet price/monthly fee ");
        String tariffString = InputUtility.scanForInput();
        Pattern pattern = Pattern.compile("(?<name>[^\\/]+)\\/(?<sms>\\d+[.,]?\\d*)\\/(?<minute>\\d+[.,]?\\d*)\\/(?<mb>\\d+[.,]?\\d*)\\/(?<fee>\\d+)");
        Matcher matcher = pattern.matcher(tariffString);
        if (matcher.matches()) {
            model.createTariff(
                    matcher.group("name"),
                    matcher.group("sms"),
                    matcher.group("minute"),
                    matcher.group("mb"),
                    matcher.group("fee")
            );
            view.print("Tariff created and added to list");
        } else {
            view.print("Invalid value, try again: ");
        }
    }

    private void showTariffs() {
        view.print(Converter.anyListToString(model.getOperator().getTariffs().toArray(), "\n-------\n", false));
    }

    private void sortByFee() {
        view.print(Converter.anyListToString(model.sortTariffByFee().toArray(), "\n--------\n", true));
    }

    private void getNumOfClients() {
        view.print("Enter tariff name: ");
        int numOfClients = model.getOperator().getNumOfClientsByTariff(InputUtility.scanForInput());
        view.print("Number of clients :" + numOfClients);
    }
}
