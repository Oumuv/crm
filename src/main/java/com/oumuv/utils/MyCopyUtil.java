package com.oumuv.utils;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;

/**
 * @version V1.0
 * @author ZhuRT
 * @Description 类说明：对象属性拷贝操作工具
 */
public class MyCopyUtil {

	/**
	 * 拷贝共有属性到目录对象 
	 * 源对象属性为null则不拷贝到目标属性，目标属性保持原值
	 * tag 拷贝至目标对象 
	 * src 拷贝的源对象 
	 * noprops 目标对象中无需拷贝的属性
	 * 
	 **/
	public static void copyProp(Object tag, Object src, String[] noprops) {
		noprops = noprops == null ? new String[] { "class" } : noprops;
		PropertyDescriptor[] tagPds = PropertyUtils.getPropertyDescriptors(tag);
		PropertyDescriptor[] srcPds = PropertyUtils.getPropertyDescriptors(src);
		String[] srcPdsName = new String[srcPds.length];
		for (int i = 0; i < srcPds.length; i++) {
			srcPdsName[i] = srcPds[i].getName();
		}
		// 迭代目标对象
		for (PropertyDescriptor tagPd : tagPds) {
			if (ArrayUtils.indexOf(noprops, tagPd.getName()) >= 0) {
				continue;
			}
			if (!(ArrayUtils.indexOf(srcPdsName, tagPd.getName()) >= 0)) {
				continue;
			}
			try {
				if (tagPd.getWriteMethod() == null) // 无setter方法的属性无需拷
					continue;
				else if (PropertyUtils.getProperty(src, tagPd.getName()) == null) // src的属性值为空时不用拷
					continue;
			} catch (Exception e) {
				continue;
			}
			// 拷属性
			try {
				PropertyUtils.setProperty(tag, tagPd.getName(),
						PropertyUtils.getProperty(src, tagPd.getName()));
			} catch (Exception e) {
				throw new RuntimeException("拷贝属性" + tagPd.getName() + "不成功！", e);
			}
		}
	}

	/** 把可序列化对象深复制把要复制的对象所引用的对象都复制了一遍(关键：执行序列化和反序列化来进行深度拷贝) */

	public static <T extends Serializable> List<T> deepCopy(List<T> src) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out;
		List<T> dest = null;
		try {
			out = new ObjectOutputStream(byteOut);
			out.writeObject(src);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(
					byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			@SuppressWarnings("unchecked")
			List<T> destTag = (List<T>) in.readObject();
			dest = destTag;
		} catch (IOException e) {
			throw new RuntimeException("拷贝属性不成功！", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("拷贝属性不成功！", e);
		}
		return dest;
	}

	/**
	 * 提供类型转换功能的拷贝，即发现两个JavaBean的同名属性为不同类型时，在支持的数据类型范围内进行转换
	 * 源对象覆盖目标对象
	 */
	public static void copyProperties(Object dest, Object orig) {
		if (orig == null) {
			return;
		}
		try {
			PropertyUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("拷贝属性不成功！", e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException("拷贝属性不成功！", e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("拷贝属性不成功！", e);
		}
	}
	
    /**
     * 将对象属性拷贝到某个类，不格式化任何数据
     * 
     * @param destCalss
     *            生成的类
     * @param origObj
     *            目标对象
     */
    public static <T> T copyProperties(Class<T> destCalss, Object origObj) {
        T result = null;
        try {
            result = destCalss.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        copyProperties(result, origObj);
        return result;
    }

}
