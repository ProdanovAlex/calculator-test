package com.prodanov;

public class NoSupportOperationException extends RuntimeException
{
    public NoSupportOperationException()
    {
        super();
    }

    public NoSupportOperationException(String s)
    {

        super(s);
        System.out.println(">>> EXCEPTION <<<");
    }
}
