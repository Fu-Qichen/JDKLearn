package org.epr.multitask;

interface IFun {
    void fun();
}

class FunImpl implements IFun {
    @Override
    public void fun() {
        System.out.println("外部类:lambda is fun");
    }
}

public class ThreadLambda {


    public static void main(String[] args) {

        class FunImpl implements IFun {
            @Override
            public void fun() {
                System.out.println("局部内部类:lambda is fun");
            }
        }

        IFun fun = new FunImpl();
        fun.fun();

        new IFun() {
            @Override
            public void fun() {
                System.out.println("匿名内部类:lambda is fun");
            }
        }.fun();

        ((IFun) () -> System.out.println("lambda:lambda is fun")).fun();

    }

    static class FunImpl implements IFun {
        @Override
        public void fun() {
            System.out.println("静态内部类:lambda is fun");
        }
    }
}

