package com.genesis.utils.common.generator;

import java.util.UUID;

public class Salter {
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
    
    
}
