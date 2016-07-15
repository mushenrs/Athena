namespace java me.mushen.thrift.athena

include "base.thrift"


/*
 * 服务定义
 */
service AthenaService {
    /*
     * 描述: 返回"hello, \(name)"
     * 参数: name,名称.
     * 说明: name不能为空.
     * 创建时间: 2016-07-15
     * 创建人: RemiliaScarlet
     */
    base.StringResult sayHello(1:string name);
}