package mobileConnection.controller.utilities;

public class Converter {

        public static String anyListToString(Object[] list, String separator, boolean last){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< list.length; i++){
                sb.append(list[i].toString());
                if(i < list.length-1 || last){
                    sb.append(separator);
                }
            }
            return sb.toString();
        }
}
