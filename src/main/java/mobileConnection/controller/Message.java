package mobileConnection.controller;

public enum Message {

    NUM_OF_CLIENTS("Number of clients : "),
    ENTER_NAME("Enter tariff name: "),
    TARIFF_CREATED("Tariff created and added to list"),
    DELETED(" was successfully deleted!"),
    NOT_DELETED(" was NOT deleted!"),
    INPUT_EXAMPLE_SEARCH("Input example: [SMS/MINUTE/MB/FEE] [from] [to]"),
    FILTER_APPLIED("Filter applied " +
            "\nEnter new values to add filter" +
            "\nType 'end' to see result "),
    NO_RESULT("No results for entered parameters"),
    INPUT_EXAMPLE_ADD("Input example: [Tariff name]/[sms price]/[minute price]/[internet price]/[monthly fee] "),
    INVALID_VALUE("Invalid value, try again");


    String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
