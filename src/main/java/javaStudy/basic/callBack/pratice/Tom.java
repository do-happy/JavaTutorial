package javaStudy.basic.callBack.pratice;

public class Tom implements Student {

    @Override
    public void resolveProblem(Teacher teacher) {
        try {
            //学生思考了3秒后得到了答案，通过老师提供的回调方法告诉老师。
            Thread.sleep(3000);
            System.out.println("work out");
            teacher.tellAnswer(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
