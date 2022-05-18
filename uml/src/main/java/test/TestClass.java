package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestClass {
    public static void main(String[] args) {
        int syntheticConstructors = 0;
        Constructor<?>[] constructors = SyntheticConstructorDemo.NestedClass
                .class.getDeclaredConstructors();
//        assertEquals("This class should contain only two constructors",
//                2, constructors.length);
        for (Constructor<?> c : SyntheticConstructorDemo.class.getConstructors()) {
            System.out.println("Constructor: " + c.getName() +
                    ", isSynthetic: " + c.isSynthetic()+", arg:"+c.getParameters().length);
        }
        System.out.println("===nest");

        for (Constructor<?> c : constructors) {

            System.out.println("Constructor: " + c.getName() +
                    ", isSynthetic: " + c.isSynthetic()+", arg:"+c.getParameters().length+","+c.isAccessible());

            for (Parameter parameter : c.getParameters()) {

                System.out.println(parameter.getType());
            }
            if(!c.isSynthetic()){
                try {
                    c.setAccessible(true);
                    System.out.println(c.newInstance(new SyntheticConstructorDemo()));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (c.isSynthetic()) {
                syntheticConstructors++;
            }
        }

//        assertEquals(1, syntheticConstructors);
    }
    public static void isBridge() {
        int syntheticMethods = 0;
        Method[] methods = BridgeMethodDemo.class.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method: " + m.getName() + ", isSynthetic: " +
                    m.isSynthetic() + ", isBridge: " + m.isBridge());
            if (m.isSynthetic()) {
                syntheticMethods++;
               /* assertTrue("The synthetic method in this class should also be a bridge method",
                        m.isBridge());*/
            }
        }
  /*      assertEquals("There should be exactly 1 synthetic bridge method in this class",
                1, syntheticMethods);*/
    }

    public static void isSynthetic(){
        Method[] methods = SyntheticMethodDemo.NestedClass.class
                .getDeclaredMethods();
    /*    assertEquals("This class should contain only two methods",
                2, methods.length);*/

        for (Method m : methods) {
            System.out.println("Method: " + m.getName() + ", isSynthetic: " +
                    m.isSynthetic());
         /*   assertTrue("All the methods of this class should be synthetic",
                    m.isSynthetic());*/
        }
        System.out.println("========outer");
        for (Method m : SyntheticMethodDemo.class
                .getDeclaredMethods()) {
            System.out.println("Method: " + m.getName() + ", isSynthetic: " +
                    m.isSynthetic());
        }
    }
}
