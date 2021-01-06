package com.habr.annotation.exampleOne;

@ControlledObject(name="biscuits")
public class Cookies {

    @StartObject
    public void crateCookie(){
        // business logic
    }

    @StopObject
    public void stopCookie(){
        // business logic
    }
}
