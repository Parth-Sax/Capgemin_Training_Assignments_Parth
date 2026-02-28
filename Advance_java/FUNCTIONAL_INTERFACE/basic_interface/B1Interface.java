package basic_interface;
// anonymous inner class -> An anonymous inner class is a class without a name that is created at the time of object creation to implement an interface or extend a class.

public interface B1 {
    public void m1();
}
class B2 {
    public static void main(String[] args) {
        B1 b = new B1() {
            @Override
            public void m1() {
                System.out.println("overriding m1 in class B2");
            }
        };
        b.m1();
    }
}
