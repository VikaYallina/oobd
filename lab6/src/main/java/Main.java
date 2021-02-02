import annotation.Column;
import annotation.Entity;
import domain.Client;
import domain.Person;
import graph.GraphModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static String PATH_FOR_SCAN = "domain";

    public static void main(String[] args) {

        GraphModel graph = new GraphModel();

        /* Сканируем пакет PATH_FOR_SCAN для поиска классов-сущностей  */
        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
        if (classList != null)
            //classList.stream().filter(c -> classIsEntity(c)).forEach();

            System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            System.out.println("\tFields of class " + cl.getName());
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("\t\t" + field.getName());
            }
        }

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classList) {
            /* Сканируем методы классов */
            System.out.println("\tFields of class " + cl.getName());
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }
        }


        System.out.println("STEP 4: scan class annotations:");
        Annotation[] annotations = Person.class.getAnnotations();
        if (annotations != null) {
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Entity.class)) {
                    System.out.println("\tPerson is entity!");
                }
            }
        }

        System.out.println("STEP 5: scan fields annotations:");

        Field[] fields = Person.class.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] fannotations = f.getAnnotations();
            for (Annotation a : fannotations) {
                if (a.annotationType().equals(Column.class)) {
                    System.out.println(String.format("\tField %s %s is attribute!", f.getType().getName(),f.getName()));
                }
            }
        }

        System.out.println("STEP 6: get superclass:");

        Class superClass = Client.class.getSuperclass();
        System.out.println("\tSuper class of Client is " + superClass.getName());

        superClass = Person.class.getSuperclass();
        System.out.println("\tSuper class of Person is " + superClass.getName());
    }

    private static boolean classIsEntity(Class<?> c) {
        Annotation[] annotations = c.getAnnotations();
        for (Annotation a : annotations) {
            if (a.equals(Entity.class)) {
                return true;
            }
        }
        return false;
    }

    private static void addEntityToGraph(Class<?> c, GraphModel graph) {
    }
}
