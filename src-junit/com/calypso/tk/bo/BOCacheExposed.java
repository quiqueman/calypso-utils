/**
 * 
 */
package com.calypso.tk.bo;

/**
 * Class to expose the BOCache implementation and use it in unit testing
 * 
 */
public class BOCacheExposed extends BOCache {
    public static CacheImpl getImplementation() {
        return _impl;
    }
}
