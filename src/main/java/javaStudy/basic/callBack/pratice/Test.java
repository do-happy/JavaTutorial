package javaStudy.basic.callBack.pratice;

public class Test {
    public static void main(String[] args) {
        //测试
        Student tom = new Tom();
        Teacher lee = new Teacher(tom);
        lee.askProblem(tom, lee);
        //结果
        //        等学生回答问题的时候老师玩了 1秒的手机
        //        等学生回答问题的时候老师玩了 2秒的手机
        //        等学生回答问题的时候老师玩了 3秒的手机
        //        work out
        //        the answer is 111
    }
}
