package com.zhang.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * MP自动填充Handler
 * @author admin
 *
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler{
	
	/**
     * 插入操作填充字段方法
     */
	public void insertFill(MetaObject metaObject) {
		/**
         * 填充操作者/更新者
         * DEMO中仅仅是举例,实际项目中这里其实可以根据业务进行判断
         * 例如从 Shrio中的 SecurityUtils.getSubject().getPrincipal()获取当前用户信息填充
         */
		this.strictInsertFill(metaObject, "createId", String.class, "ADMIN");
		this.strictInsertFill(metaObject, "updateId", String.class, "ADMIN");
		//填充时间
		Date date = new Date();
		this.strictInsertFill(metaObject, "createTime", Date.class, date);
		this.strictInsertFill(metaObject, "createTime", Date.class, date);
	}
	/**
     * 更新操作填充字段方法
     */
    public void updateFill(MetaObject metaObject) {
        Date date = new Date();
        this.strictUpdateFill(metaObject, "updateId", String.class, "ADMIN");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, date);
    }

}
