package com.ant.rpc;

import java.util.Map;

/**
 * Created by yingkuigou on 2016/8/21.
 */
public interface Invocation {

    /**
     * get method name.
     *
     * @return method name.
     * @serial
     */
    String getMethodName ();

    /**
     * get parameter types.
     *
     * @return parameter types.
     * @serial
     */
    Class<?>[] getParameterTypes ();

    /**
     * get arguments.
     *
     * @return arguments.
     * @serial
     */
    Object[] getArguments ();

    /**
     * get attachments.
     *
     * @return attachments.
     * @serial
     */
    Map<String, String> getAttachments ();

    /**
     * get attachment by key.
     *
     * @return attachment value.
     * @serial
     */
    String getAttachment (String key);

    /**
     * get attachment by key with default value.
     *
     * @return attachment value.
     * @serial
     */
    String getAttachment (String key, String defaultValue);

    /**
     * get the invoker in current context.
     *
     * @return invoker.
     * @transient
     */
    Invoker<?> getInvoker ();
}
