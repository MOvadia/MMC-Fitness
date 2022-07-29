package com.proj.restapi.actionresult;

import java.io.Serializable;

public class ActionResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Result result;
    private final String message;

    public ActionResult(Result result, String message) {
        super();
        this.result = result;
        this.message = message;
    }

    public static enum Result {
        SUCCESS,
        FAILED,
        ERROR
    }

    public static <T> ActionResult<T> failed(String message) {
        return new ActionResult<>(Result.FAILED, message);
    }

    public static <T> ActionResult<T> successMessage(String message) {
        return new ActionResult<>(Result.SUCCESS, message);
    }
}
