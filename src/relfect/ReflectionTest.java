package relfect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


public class ReflectionTest {

	//超类即是父类
	public static void printConstructors(Class cl)
	{
		Constructor constructor[]=cl.getConstructors();
	
		for(Constructor c:constructor)
		{
			String name=c.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(c.getModifiers());
			
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(name+"(");
			Class []paramTypes=c.getParameterTypes();
			for(int i=0;i<paramTypes.length;i++)
			{
				if(i!=0)System.out.print(",");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(")");
		}
	}
	public static void printMethods(Class cl)
	{
		Method[] methods=cl.getMethods();
		for(Method c:methods)
		{
			Class reType=c.getReturnType();
			String name=c.getName();
			System.out.println(" ");
			String modifiers=Modifier.toString(c.getModifiers());
			
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(reType.getName()+" "+name+"(");
			Class []paramTypes=c.getParameterTypes();
			for(int i=0;i<paramTypes.length;i++)
			{
				if(i!=0)System.out.print(",");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(")");
		}
	}
	public static void printFields(Class cl)
	{
		Field[] fields=cl.getDeclaredFields();
		for(Field c:fields)
		{
			Class type=c.getType();
			String name=c.getName();
			System.out.println(" ");
			String modifiers=Modifier.toString(c.getModifiers());
			
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.println(type.getName()+" "+name);
		}
	}
	public static void main(String []args) throws ClassNotFoundException
	{
		String name;
		if(args.length>0)name=args[0];
		else {
			var in=new Scanner(System.in);
			System.out.println("Enter a ClassName");
			name="table.TableI";
		}
		Class cl=Class.forName(name);
		Class supercl=cl.getSuperclass();
		String modifiers=Modifier.toString(cl.getModifiers());
		if(modifiers.length()>0) {
			System.out.print(modifiers+" ");
		}
		System.out.print("class "+cl.getName());
		if(supercl!=null&&supercl!=Object.class)
		{
			System.out.println("extends "+supercl.getName());
		}
		System.out.println("\n{");
		printConstructors(cl);
		System.out.println();
		printMethods(cl);
		System.out.println();
		printFields(cl);
		System.out.println();
		
	}
}
