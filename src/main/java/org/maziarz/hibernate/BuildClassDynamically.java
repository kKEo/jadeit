package org.maziarz.hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.wicket.util.io.IOUtils;

public class BuildClassDynamically {
	private static final String CLASS_NAME = "Foo5";

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		StringBuilder sb = new StringBuilder();

		// sb.append("package gen;");

		sb.append("import java.util.List;");

		sb.append("import javax.persistence.Column;");
		sb.append("import javax.persistence.GeneratedValue;");
		sb.append("import javax.persistence.Entity;");
		sb.append("import javax.persistence.Id;");
		sb.append("import javax.persistence.ManyToMany;");
		sb.append("\n");
		sb.append("@Entity");
		sb.append("\n");
		sb.append("public class " + CLASS_NAME + " {");
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
		sb.append("public String toString() { return \"Reflection rulez 6\";}");
		sb.append("}");

		String code = sb.toString();

		File f = new File("/tmp/" + CLASS_NAME + ".java");
		FileOutputStream fileOutputStream = new FileOutputStream(f);
		IOUtils.write(code, fileOutputStream);
		fileOutputStream.close();

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		// compiler.run(null, null, null, f.getAbsolutePath());

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(f);
		// .getJavaFileObjectsFromStrings(Arrays.asList("Foo.java"));
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
		boolean success = task.call();
		fileManager.close();
		System.out.println("Success: " + success);
		System.out.println(diagnostics.getDiagnostics());

		System.out.println(compilationUnits.iterator().next().toUri().toURL());

		URLClassLoader sysloader = new URLClassLoader(new URL[] { new File("/tmp/").toURI().toURL() },
				BuildClassDynamically.class.getClassLoader());

		// URL[] urls = sysloader.getURLs();
		// Class<?> classToLoad = Class.forName ("Foo", true, child);
		// Method method = classToLoad.getDeclaredMethod ("toString");
		// Object instance = classToLoad.newInstance();
		// Object result = method.invoke (instance);

		// URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Class<?> sysclass = URLClassLoader.class;

		Method method = sysclass.getDeclaredMethod("addURL", new Class[] { URL.class });
		method.setAccessible(true);
		method.invoke(sysloader, new Object[] { f.toURI().toURL() });

		Class<?> classToLoad = Class.forName(CLASS_NAME, true, sysloader);
		method = classToLoad.getDeclaredMethod("toString");
		Object instance = classToLoad.newInstance();
		Object result = method.invoke(instance);

		new GenrateDDLs().printDdl(classToLoad);

		System.out.println(result);

		// f.delete();
		// new File(CLASS_NAME+".class").delete();

	}
}
