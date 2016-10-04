package me.mushen.athena.java.innerclass;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-30
 */
public class DotThis {
    void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }
}
