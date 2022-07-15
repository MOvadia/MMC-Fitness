package com.proj.restapi.actionresult;

import java.io.Serializable;

public class ActionResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public static enum Result {
        SUCCESS,
        FAILED,
        ERROR
    }
}
