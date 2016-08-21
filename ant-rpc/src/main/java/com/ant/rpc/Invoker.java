package com.ant.rpc;

/**
 * Created by yingkuigou on 2016/8/21.
 */
public interface Invoker<T> {

    /**
     * 获取调用服务接口
     *
     * @return service interface.
     */
    Class<T> getInterface ();

    /**
     * invoke 调用
     *
     * @param invocation
     * @return result
     * @throws Exception
     */
    Result invoke (Invocation invocation) throws Exception;
}
