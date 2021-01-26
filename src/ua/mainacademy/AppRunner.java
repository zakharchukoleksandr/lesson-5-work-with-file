package ua.mainacademy;

import java.util.logging.Logger;

public class AppRunner {

    private static final Logger LOGGER=Logger.getLogger(AppRunner.class.getName());
    public static void main(String[] args) {
        Integer number = 15;
       // Integer divider=3;
        Integer divider=0;

        if (divider.equals(0)){
            LOGGER.warning(String.format("Divider  is zero !!! " ));
            return;

        }
        Integer result=number/divider;

        //LOGGER.info(String.valueOf(result));
        //LOGGER.info(String.valueOf(number/divider));
        //LOGGER.info(String.format("Result is %d " , number/divider));
        LOGGER.info(String.format("Result is %d " , result));

    }
}
