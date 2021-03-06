package com.ant.rpc;

import com.ant.rpc.protocol.URL;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yingkuigou on 2016/8/21.
 */
public abstract class AbstractProxyInvoker<T> implements Invoker<T> {

    private final T proxy;

    private final Class<T> type;

    private final URL url;

    public AbstractProxyInvoker (T proxy, Class<T> type, URL url) {
        if (proxy == null) {
            throw new IllegalArgumentException ("proxy == null");
        }
        if (type == null) {
            throw new IllegalArgumentException ("interface == null");
        }
        if (!type.isInstance (proxy)) {
            throw new IllegalArgumentException (proxy.getClass ().getName () + " not implement interface " + type);
        }
        this.proxy = proxy;
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

    public boolean isAvailable () {
        return true;
    }

    public void destroy () {
    }

    @Override
    public Result invoke (Invocation invocation) {
        try {
            return new RpcResult (doInvoke (proxy, invocation.getMethodName (), invocation.getParameterTypes (),
                invocation.getArguments ()));
        }
        catch (InvocationTargetException e) {
            return new RpcResult (e.getTargetException ());
        }
        catch (Throwable e) {
            throw new RpcException ("Failed to invoke remote proxy method " + invocation.getMethodName () + " to "
                + getUrl () + ", cause: " + e.getMessage (), e);
        }
    }

    protected abstract Object doInvoke (T proxy, String methodName, Class<?>[] parameterTypes, Object[] arguments)
        throws Throwable;

    @Override
    public String toString () {
        return getInterface () + " -> " + getUrl () == null ? " " : getUrl ().toString ();
    }

}
