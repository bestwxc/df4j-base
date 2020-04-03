package com.df4j.v2.base.lock;

/**
 * 分布式锁
 */
public interface DistributedLock {

    /**
     * 分布式锁，枷锁
     * @param key
     * @param timeout
     */
    void lock(String key, long timeout);

    /**
     * 解锁
     * @param key
     */
    void unlock(String key);
}
