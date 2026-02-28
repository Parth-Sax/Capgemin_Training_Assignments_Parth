package basic_interface;

import java.net.StandardSocketOptions;

public interface A {
    public void m1();
//    public void m2();
//    public void m3();
    default void m4(){
        System.out.println("m4 from interface A");
    }
}
class B implements A {
    public void m1() {
        System.out.println("m1 method");
    }
    public void m2() {
        System.out.println("m2 method");
    }
    public void m3() {
        System.out.println("m3 method");
    }
}
class C implements A {
    public void m1() {
        System.out.println("m1 method of C");
    }

    @Override
    public void m4() {
        System.out.println("m4 from C");
    }
}
