package com.harden.backend_study.cache;

import java.util.Collections;

public interface CustomCacheManager {
    AbstractCustomCache getCache(String name);
    Collections getCacheStorageNames();
}
