package com.zhang.util;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class BaseController {
	
	/**
     * 获取32位不重复的唯一ID
     * @return
     */
    public String getUUID(){
    	return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }

}
