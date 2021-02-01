package ua.mainacademy;

import ua.mainacademy.exeption.MyOwnException;

import java.util.logging.Logger;

public class AppRunner {

    private static final Logger LOGGER = Logger.getLogger(AppRunner.class.getName());

    //public static void main(String[] args) throws  Exception {
        public static void main(String[] args)  {

            Integer number = 15;
        // Integer divider=3;
//        Integer divider = 0;
        Integer divider = null;
//         Integer divider = 3;
        String price = "123.00 UAH";

            boolean result= true;
            try {
                result = isNotValid(divider);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result) {
           // LOGGER.warning("Divider is not valid");
            throw new MyOwnException("Divider is not valid");

        }
//        if (divider.equals(0)) {
//            throw new RuntimeException("Divider is zero!!!");
//        }
//        if (isNotValid(divider)) {
//            throw new RuntimeException("Divider is zero!!!");
//        }
        try {
            Integer res = number / divider;
            LOGGER.info(String.format("Result is %d ", res));

            Integer csatInteger = Integer.valueOf("price");

        } catch (ArithmeticException e) {
            //           e.printStackTrace();
            LOGGER.severe("Divider is zero !!!");

//           } catch (NumberFormatException e) {
//        //           e.printStackTrace();
//        LOGGER.severe("Cast error !!!");

        } catch (Exception e) {
            //           e.printStackTrace();
            LOGGER.severe("General error !!!");
        } finally {
            LOGGER.info("Program is completed");
        }

       /* if (divider.equals(0)){
            LOGGER.warning(String.format("Divider  is zero !!! " ));
            return;

        }*/
        // Integer result = number / divider;

        //LOGGER.info(String.valueOf(result));
        //LOGGER.info(String.valueOf(number/divider));
        //LOGGER.info(String.format("Result is %d " , number/divider));
        //LOGGER.info(String.format("Result is %d ", result));

    }

//    private static boolean isNotValid(Integer divider) {
//        try {
//            return divider.equals(0);
//
//        } catch (Exception e) {
// //           e.printStackTrace();
//        }
  //      return true;
        private static boolean isNotValid(Integer divider) throws Exception {
        return divider.equals(0);
    }
}
