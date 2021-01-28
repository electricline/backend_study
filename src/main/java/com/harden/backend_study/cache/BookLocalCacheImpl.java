package com.harden.backend_study.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class BookLocalCacheImpl extends ConcurrentHashMap implements LocalCache {

}
