package relfect;

import java.lang.reflect.InvocationTargetException;

public class MyTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub检查型异常
	//获取Class对象
	Integer io=1;
	Class co=io.getClass();//第一种方法调用Object类中的getClass()
	Class cl=Class.forName("java.util.List");//第二种使用静态方法forname
	System.out.println(cl.getName());
	cl=int[].class;//第三中类型或关键字+.class
	System.out.println(cl.getName());
	cl.getConstructor().newInstance();//创建一个新的对象
	}

}
