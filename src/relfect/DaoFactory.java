package relfect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dao.MessageDao;
import dao.TableIDao;
import table.Message;

public class DaoFactory {
private static String packageName=TableIDao.class.getPackageName();
public static <T extends TableIDao>T getInstance(String name)
{
	if(name.indexOf(".")==-1)
	{
		name=packageName+"."+name;
	}
	TableIDao td=null;
	Class tc=TableIDao.class;
	
	try {
		Class Dao=Class.forName(name);
		Method Get=null;
		
		if(tc.isAssignableFrom(Dao))
		{
			System.out.println("父类");
			Get=Dao.getMethod("getInstance");
			td=(TableIDao) Get.invoke(null);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(td==null)
	{
		System.err.println("调用反射失败");
	}
	return (T)td;	
}
public static void main(String []args)
{
	MessageDao Dao=DaoFactory.<MessageDao>getInstance("MessageDao");
	System.err.println(Dao.getClass().getName());
}

}
