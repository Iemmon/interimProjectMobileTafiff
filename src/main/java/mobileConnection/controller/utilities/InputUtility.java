package mobileConnection.controller.utilities;

import java.util.Scanner;

public class InputUtility {

    private static Scanner sc = new Scanner(System.in);

    public static String scanForInput(){
        return sc.nextLine();
    }
}
