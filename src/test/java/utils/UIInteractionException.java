package utils;

public class UIInteractionException extends RuntimeException {

    String action;
    Throwable source;

    //todo add to listener

    public UIInteractionException(String action, Throwable source) {
        this.action = action;
        this.source = source;
    }


}
