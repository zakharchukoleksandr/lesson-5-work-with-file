package ua.mainacademy.exeption;

public class MyOwnException extends RuntimeException{


    public MyOwnException(String message) {
        super(message);

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
