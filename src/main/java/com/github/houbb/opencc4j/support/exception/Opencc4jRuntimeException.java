package com.github.houbb.opencc4j.support.exception;

/**
 * 2018/2/11
 * 运行时异常
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class Opencc4jRuntimeException extends RuntimeException {

    /**    
     *  opencc4j runtime exception    
     */    
    public Opencc4jRuntimeException() {
        //This is just an empty constructor
    }

    /**    
     *  opencc4j runtime exception    
     *    
     * @param message message    
     */    
    public Opencc4jRuntimeException(String message) {
        super(message);
    }

    /**    
     *  opencc4j runtime exception    
     *    
     * @param message message    
     * @param cause cause    
     */    
    public Opencc4jRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**    
     *  opencc4j runtime exception    
     *    
     * @param cause cause    
     */    
    public Opencc4jRuntimeException(Throwable cause) {
        super(cause);
    }

    /**    
     *  opencc4j runtime exception    
     *    
     * @param message message    
     * @param cause cause    
     * @param enableSuppression enable suppression    
     * @param writableStackTrace writable stack trace    
     */    
    public Opencc4jRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
