package org.maziarz.hibernate;

import java.io.StringReader;
import java.lang.reflect.Method;

import org.codehaus.janino.SimpleCompiler;

public class StringExecutor {
	private static final String CLASS_NAME = "Foo";

	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("import java.util.List;");

		sb.append("import javax.persistence.Column;");
		sb.append("import javax.persistence.GeneratedValue;");
		sb.append("import javax.persistence.Entity;");
		sb.append("import javax.persistence.Id;");
		sb.append("import javax.persistence.ManyToMany;");
		sb.append("\n");
		sb.append("@Entity");
		sb.append("\n");
		sb.append("public class "+CLASS_NAME+" {");
		sb.append("\n");
		sb.append("@Id");
		sb.append("\n");
		sb.append("@GeneratedValue");
		sb.append("\n");
		sb.append("private Long id;");
		sb.append("\n");
		sb.append("private String name;");
		sb.append("\n");
		sb.append("@Column(length = 3000)");
		sb.append("\n");
		sb.append("private String descrition;");
		sb.append("\n");
		sb.append("public String toString() { System.out.println(\"Hello JPA\")}");
		sb.append("}");
		
//		String codeStr = "public class @Entity" + CLASS_NAME + " {" + "public static void main(String[] args){"
//				+ "System.out.println(\"Hello \" + args[0]);}}";
		String codeStr = sb.toString();
		
		System.out.println(codeStr);
		
		SimpleCompiler compiler = new SimpleCompiler();
		compiler.cook(new StringReader(codeStr)); // compile the string
		
		Class<?> cl = compiler.getClassLoader().loadClass(CLASS_NAME);
		// Invoke the "public static main(String[])" method
		Object o = cl.newInstance();
		
		Method toString = cl.getMethod("toString", new Class[0]);
		toString.invoke(o, new Object[]{});
		
//		Method mainMeth = cl.getMethod("main", new Class[] { String[].class });
//		String[] methArgs = new String[] { "world" };
//		mainMeth.invoke(null, new Object[] { methArgs });
	} 
} 
