package javaStudy.basic.callBack.demo;

public class UpperServiceImpl implements UpperService {

    private BottomService bottomService;

    @Override

    public void upperTaskAfterCallBottomService(String upperParam) {

        System.out.println(upperParam + " upperTaskAfterCallBottomService() execute.");

    }

    public UpperServiceImpl(BottomService bottomService) {

        this.bottomService = bottomService;

    }

    @Override

    public String callBottomService(final String param) {

        return bottomService.bottom(param + " callBottomService.bottom() execute --> ");

    }

}