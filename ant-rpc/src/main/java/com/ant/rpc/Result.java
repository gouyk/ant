package com.ant.rpc;

import java.util.Map;

/**
 * Created by yingkuigou on 2016/8/21.
 */
public interface Result {
    /**
     * Get invoke result.
     *
     * @return result. if no result return null.
     */
    Object getValue ();

    /**
     * Get exception.
     *
     * @return exception. if no exception return null.
     */
    Throwable getException ();

    /**
     * Has exception.
     *
     * @return has exception.
     */
    boolean hasException ();

    /**
     * Recreate.
     * <code>
     * if (hasException()) {
     * throw getException();
     * } else {
     * return getValue();
     * }
     * </code>
     *
     * @return result.
     * @throws if has exception throw it.
     */
    Object recreate ()
        throws Throwable;

    /**
     * get attachments.
     *
     * @return attachments.
     */
    Map<String, String> getAttachments ();

    /**
     * get attachment by key.
     *
     * @return attachment value.
     */
    String getAttachment (String key);

    /**
     * get attachment by key with default value.
     *
     * @return attachment value.
     */
    String getAttachment (String key, String defaultValue);
}
