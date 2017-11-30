package com.oumuv.core;
import org.apache.shiro.SecurityUtils;  
import org.apache.shiro.subject.Subject;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
/** 
 * Shiro权限标签(Velocity版) 
 *  
 * @author chenshun 
 * @email sunlightcs@gmail.com 
 * @date 2016年12月3日 下午11:32:47 
 */  
public class VelocityShiro {  
  
    private Logger logger = LoggerFactory.getLogger(getClass());  
  
    /** 
     * 是否拥有该权限 
     *  
     * @param permission 
     *            权限标识 
     * @return true：是 false：否 
     */  
    public boolean hasPermission(String permission) {  
        logger.info(permission);  
        Subject subject = SecurityUtils.getSubject();  
        return subject != null && subject.isPermitted(permission);  
    }  
  
    public String run(String string){
    	return string;
    }
    /** 
     * 是否拥有该权限 
     *  
     * @param permission 
     *            权限标识 
     * @return true：是 false：否 
     */  
    public static boolean hasPermissionInMethod(String permission) {  
        Subject subject = SecurityUtils.getSubject();  
        return subject != null && subject.isPermitted(permission);  
    }  
  
}  