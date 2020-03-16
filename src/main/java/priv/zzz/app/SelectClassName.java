package priv.zzz.app;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SelectClassName {
    public static void main(String[] args){
//        String path = "priv.zzz.dao";
//        for(String name:selectByPackage(path)){
//            System.out.println(name);
//        }
//        System.out.println(getShortName(path));

    }

    public static List<String> selectByPackage(String packageName){
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
        return getClassName(filePath.replace("test-classes", "classes"), null);
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }
        return myClassName;
    }

    public static String getShortName(String fullName){
        String[] fullNameSplit = fullName.split("\\.");
        return fullNameSplit[fullNameSplit.length-1];
    }
}
