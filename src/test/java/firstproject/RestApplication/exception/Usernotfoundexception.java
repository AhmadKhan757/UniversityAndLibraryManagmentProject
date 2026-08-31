package firstproject.RestApplication.exception;

public class Usernotfoundexception extends RuntimeException{
    public Usernotfoundexception(String message){
        super(message);
    }
}
