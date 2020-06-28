package com.bridgelabz.annotation.services;

import com.bridgelabz.annotation.utility.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample
{
    @Override
    @MethodInfo(author = "Aniket Dakhare", date = "24 June 2020", comments = "Main Method", revision = 5 )
    public String toString()
    {
        return "Overridden toString Method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "24 June 2020")
    public static void oldMethod()
    {
        System.out.println("Old method, don't use it.");
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            for (Method method : AnnotationExample.class.getMethods())
            {
                //checks if MethodInfo annotation is present for method
                if (method.isAnnotationPresent(MethodInfo.class))
                {
                    try
                    {
                        //iterates all the annotation present in method
                        for (Annotation annotation : method.getDeclaredAnnotations())
                        {
                            System.out.println("Annotation in Method '" + method + "' : " + annotation);
                        }
                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if (methodInfo.revision() == 5)
                        {
                            System.out.println("Method with revision no. 5 = " + method);
                        }
                    }
                    catch (Throwable ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
    }
}
