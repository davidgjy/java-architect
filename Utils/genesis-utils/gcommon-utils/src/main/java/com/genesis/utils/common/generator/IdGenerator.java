package com.genesis.utils.common.generator;

import java.util.UUID;

public class IdGenerator {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    
}
