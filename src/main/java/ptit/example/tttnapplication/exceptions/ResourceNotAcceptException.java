package ptit.example.tttnapplication.exceptions;

public class ResourceNotAcceptException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceNotAcceptException(String message){
        super(message);
    }
}
