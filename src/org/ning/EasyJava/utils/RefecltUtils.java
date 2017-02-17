package org.ning.EasyJava.utils;

import java.lang.reflect.Method;

/**
 * refelect工具包
 * 
 * @author Lyon_Yan <br>
 *         <b>time</b>: 2015年10月31日 下午3:35:27
 */
public class RefecltUtils {

	private static final String SET_ = "set";
	private static final String GET_ = "get";

	/**
	 * 将属性的首字符大写，方便构造get，set方法
	 * 
	 * @author Lyon_Yan <br>
	 *         <b>time</b>: 2015年10月31日 下午3:35:46
	 * @param name
	 * @return
	 */
	public static String returnSetName(String name) {// 将属性的首字符大写，方便构造get，set方法
		return SET_ + returnUpperCaseFirstChar(name);
	}

	/**
	 * 将属性的首字符大写，方便构造get，set方法
	 * 
	 * @author Lyon_Yan <br>
	 *         <b>time</b>: 2015年10月31日 下午3:35:46
	 * @param name
	 * @return
	 */
	public static String returnGetName(String name) {// 将属性的首字符大写，方便构造get，set方法
		return GET_ + returnUpperCaseFirstChar(name);
	}

	/**
	 * 将属性的首字符大写，方便构造get，set方法
	 * 
	 * @author Lyon_Yan <br>
	 *         <b>time</b>: 2015年11月3日 上午11:03:52
	 * @param name
	 * @return
	 */
	public static String returnUpperCaseFirstChar(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	/** 
     * 利用递归找一个类的指定方法，如果找不到，去父亲里面找直到最上层Object对象为止。 
     *  
     * @param clazz 
     *            目标类 
     * @param methodName 
     *            方法名 
     * @param classes 
     *            方法参数类型数组 
     * @return 方法对象 
     * @throws Exception 
     */  
    public static Method getMethod(Class clazz, String methodName,  
            final Class... classes) throws Exception {  
        Method method = null;  
        try {  
            method = clazz.getDeclaredMethod(methodName, classes);  
        } catch (NoSuchMethodException e) {  
            try {  
                method = clazz.getMethod(methodName, classes);  
            } catch (NoSuchMethodException ex) {  
                if (clazz.getSuperclass() == null) {  
                    return method;  
                } else {  
                    method = getMethod(clazz.getSuperclass(), methodName,  
                            classes);  
                }  
            }  
        }  
        return method;  
    }  

}