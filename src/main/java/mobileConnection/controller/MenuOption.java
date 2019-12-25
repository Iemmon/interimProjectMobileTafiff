package mobileConnection.controller;

public enum MenuOption {

        SHOW("Type 'SHOW' to see all tariffs"),
        ADD("Type 'ADD' to add new tariff"),
        DELETE("Type 'DELETE' to delete tariff"),
        SORT("Type 'SORT' to sort tariffs by fee"),
        FIND("Type 'FIND' to find tariff by parameter"),
        CLIENTS("Type 'CLIENTS' to see number of clients using certain tariff"),
        END("Type 'END' to exit");

        String info;

    MenuOption(String info) {
            this.info = info;
        }

}
