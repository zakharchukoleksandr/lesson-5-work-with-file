package ua.mainacademy;

import ua.mainacademy.model.ConnectionInfo;
import ua.mainacademy.servise.FileManager;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class AppRunnerFile {
    private static final Logger LOGGER = Logger.getLogger(AppRunnerFile.class.getName());

    public static void main(String[] args) {
//        LOGGER.info(String.format("Date is %s", new Date(0) ));
//        LOGGER.info(String.format("Date is %s", new Date().getTime() ));
//       LOGGER.info(String.format("Date is %s", new Date() ));
        ConnectionInfo connectionInfo = new ConnectionInfo(123456, new Date().getTime(), "123.456.123.123");
        FileManager.writeConnectionInfoToFile(connectionInfo, "text.txt");

        List<ConnectionInfo> connections=FileManager.readConnectionInfoFromFile("text.txt");
        //LOGGER.info(String.format("The first element is %s", connections.get(0).toString()));
        LOGGER.info(String.format("The first element is %s", connections.get(0)));

        FileManager.copyFile("cat.jpg", "copyCat.jpg");
        FileManager.moveFile("cat.jpg", "otherCopyCat.jpg");
    }

}

