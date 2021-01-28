package com.harden.backend_study.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class MovieLocalCacheImpl extends ConcurrentHashMap implements LocalCache {
}
