package com.xyb.base.entity;

public class ResponseBase {

    private Integer rtnCode;

    private String msg;

    private Object data;

    public ResponseBase(){

    }

    public ResponseBase(Integer rtnCode, String msg, Object data){
        super();
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }

    public static void main(String[] args) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setRtnCode(200);
        responseBase.setMsg("success");
        responseBase.setData("111");
        System.out.println(responseBase.toString());
    }

    public Integer getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(Integer rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseBase that = (ResponseBase) o;

        if (rtnCode != null ? !rtnCode.equals(that.rtnCode) : that.rtnCode != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = rtnCode != null ? rtnCode.hashCode() : 0;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "rtnCode=" + rtnCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
