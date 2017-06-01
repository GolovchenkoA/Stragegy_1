package ua.golovchenko.artem.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by art on 19.10.2016.
 * Источник: http://stackoverflow.com/questions/15519626/how-to-get-all-classes-names-in-a-package
 * Описание: Класс будет использоваться для поиска всех классов в определенном пакете
 * Дополнительное пояснение: это необходимо что бы автоматически создавать массив из всех возможных классов
 *В данном случае всех подклассов класса Building
 */
public class ClassFinder {

    private static final char PKG_SEPARATOR = '.';

    private static final char DIR_SEPARATOR = '/';

    private static final String CLASS_FILE_SUFFIX = ".class";

    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    public static List<Class<?>> find(String scannedPackage) throws IOException, ClassNotFoundException {
        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }
        /*File pathToClasses = new File(scannedUrl.getFile());*/
        File pathToClasses = new File(scannedUrl.getPath().replace("file:","")); // in console return file:\C:\java-projects\ instead C:\java-projects\. in IDE no problem
        List<Class<?>> classes = new ArrayList<Class<?>>();
        //System.out.println("Отладка.pathToClasses " + pathToClasses.toString());

/*        for (File file : pathToClasses.listFiles()) {
            System.out.println("Отладка.pathToClasses List " + file.toString());
            classes.addAll(find(file, scannedPackage));
        }*/


        if (pathToClasses.isDirectory()) { //work in IDE
            //System.out.println("Отладка.pathToClasses.listFiles() " + Arrays.toString(pathToClasses.listFiles()));

            for (File file : pathToClasses.listFiles()) {
                //System.out.println("Отладка.pathToClasses List " + file.toString());
                classes.addAll(find(file, scannedPackage));
            }

        } else { // work in console (Is jar-file)
            // source https://examples.javacodegeeks.com/core-java/net/urlclassloader/java-net-urlclassloader-example/
            //System.out.println("Отладка. Это jar-файл");
            int toIndex = pathToClasses.toString().indexOf("!");
            String pathToJar = (String)pathToClasses.toString().subSequence(0,toIndex);

            JarFile jar = new JarFile(pathToJar);

            /*URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };*/ //original
            System.out.println("pathToJar: " + pathToJar);
            URL[] urls = { new URL("file:" +pathToJar) };
            /*URLClassLoader loader = URLClassLoader.newInstance(urls);*/ //original
            URLClassLoader loader = new URLClassLoader(urls);
            //URLClassLoader loader = new URLClassLoader(new URL[]{jar.toURI().toURL()});
            for(JarEntry entry: Collections.list(jar.entries())){

                //System.out.println("Отладка. entry.getName(): " + entry.getName());

               /* if(entry.getName().endsWith(scannedPath + ".class")){*/
                if(isClassPath(scannedPackage,entry.getName())) {
                    //System.out.println("Отладка. loaded entry.getName(): " + entry.getName());
                    String className = entry.getName().replace("/", ".").replace(".class","");
                    //className = className.substring(0,className.length()-1);
                    //System.out.println("Отладка. loaded className: " + className);
                    classes.add(loader.loadClass(className));
                }
            }

        }


        return classes;
    }

    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();
        //System.out.println("Отладка scannedPackage + PKG_SEPARATOR + file.getName(): " + resource);
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }


    public static boolean isClassPath(String scannedPackage ,String classFullPath){
        /*Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");*/
        String pattern = "^(" + scannedPackage + ").*\\.class$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(classFullPath);
        return m.matches();
    }

}
