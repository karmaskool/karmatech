package com.impact.karma.messaging.mq.activemq.classic.producer.util;

import java.util.UUID;

public class BasicUtil {
	 
    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
