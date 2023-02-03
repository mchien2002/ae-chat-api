package com.ae_chat.aechatapi.helper;

public class Response {
    private Boolean status;
    private String message;
    private Object error;
    private Object data;
    public Response(Boolean _status, String _message, Object _error, Object _data) {
        this.status = _status;
        this.message = _message;
        this.error = _error;
        this.data = _data;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean _status) {
        this.status = _status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String _message) {
        this.message = _message;
    }
    public Object getError() {
        return error;
    }
    public void setError(Object _error) {
        this.error = _error;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object _data) {
        this.data = _data;
    }
}