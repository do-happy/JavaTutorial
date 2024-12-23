package javaStudy.basic.callBack.pratice;

public class Teacher implements CallBack{
    private Student student;

    Teacher(Student student) {
        this.student = student;
    }

    void askProblem (Student student, Teacher teacher) {
        //main方法是主线程运行，为了实现异步回调，这里开启一个线程来操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                student.resolveProblem(teacher);
            }
        }).start();
        //老师让学生做题以后，等待学生回答的这段时间，可以做别的事，比如玩手机.\
        //而不需要同步等待，这就是回调的好处。
        //当然你可以说开启一个线程让学生做题就行了，但是这样无法让学生通知老师。
        //需要另外的机制去实现通知过程。
        // 当然，多线程中的future和callable也可以实现数据获取的功能。
        for (int i = 1;i < 4;i ++) {
            System.out.println("等学生回答问题的时候老师玩了 " + i + "秒的手机");
        }
    }

    @Override
    public void tellAnswer(int res) {
        System.out.println("the answer is " + res);
    }
}