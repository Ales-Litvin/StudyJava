package by.epam.learn.exception;

import java.io.IOException;

public class MyException extends Exception{

}

class A{
    public void f() throws IOException {}
}


class B extends A{
    @Override
    public void f() throws IOException {}
}