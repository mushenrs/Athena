package me.mushen.athena.java.concurrency.immutableobject;

/**
 * @Desc 彩信中心路由规则管理器
 * 模式角色: ImmutableObject.ImmutableObject
 * @Author Remilia
 * @Create 2016-10-19
 */
public final class MMSCRouter {
    // 用volatile修饰, 保证多线程环境下改变量的可见性
    private static volatile MMSCRouter router = new MMSCRouter();


}
