/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab0;

/**
 *
 * @author CPere
 */
public class MandatoryStringException extends IllegalArgumentException{

    private final static String msg = "method argument is mandatory";
    
    public MandatoryStringException() {
        super(msg);
    }

    public MandatoryStringException(String s) {
       // because we do not care customer provided String s, we use msg
        super(msg);
    }

    public MandatoryStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public MandatoryStringException(Throwable cause) {
        super(cause);
    }
    
    
    
}
