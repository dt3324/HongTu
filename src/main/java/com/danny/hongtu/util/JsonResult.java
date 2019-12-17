package com.danny.hongtu.util;

/**
 * @author danny
 */
public class JsonResult<T> {
    private int state;
    private T data;
    private String massage;

    public static JsonResult get() {
        return new JsonResult();
    }

    public static JsonResult get(Object e) {
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(e);
        return jsonResult;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
