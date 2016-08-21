package com.ant.rpc;

import com.ant.rpc.protocol.URL;

/**
 * Created by yingkuigou on 2016/8/21.
 */
public abstract class AbstractInvoker<T> implements Invoker<T> {

    private final Class<T> type;

    private final URL url;

    protected AbstractInvoker (Class<T> type, URL url) {
        if (type == null) {
            throw new IllegalArgumentException ("service type == null");
        }
        if (url == null) {
            throw new IllegalArgumentException ("service url == null");
        }
        this.type = type;
        this.url = url;
    }

    @Override
    public Class<T> getInterface () {
        return type;
    }

    public URL getUrl () {
        return url;
    }

    @Override
    public Result invoke (Invocation inv) {
        try {
            return doInvoke (inv);
        }
        catch (Throwable throwable) {
            return new RpcResult (throwable);
        }
    }

    protected abstract Result doInvoke (Invocation invocation)
        throws Throwable;
}
