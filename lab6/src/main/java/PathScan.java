import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathScan {
    public static List<Class<?>> find(String scannedPackage){
        String scannedPath = scannedPackage.replace(".","/");
        URL scannedURL = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        System.out.println(scannedURL.toString());
        if (scannedURL == null){
            throw new IllegalArgumentException("Bad package "+ scannedPackage);
        }
        File scannedDir = new File(scannedURL.getFile());
        System.out.println("Parent: "+scannedDir.getAbsoluteFile().exists());
        List<Class<?>> classes = new ArrayList<>();
        for (File file: scannedDir.listFiles()){
            classes.addAll(find(file, scannedPackage));
        }
        return classes;

    }

    public static List<Class<?>> find(File file, String scannedPackage){
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + "." + file.getName();
        if (file.isDirectory()){
            for (File child: file.listFiles()){
                classes.addAll(find(child,resource));
            }
        } else if(resource.endsWith(".class")){
            String className = resource.substring(0, resource.length() - 6);
            try{
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;
    }

    
}
