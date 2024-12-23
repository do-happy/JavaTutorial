package javaStudy.basic.callBack.demo;

public interface UpperService {

    public void upperTaskAfterCallBottomService(String upperParam);

    public String callBottomService(final String param);

}