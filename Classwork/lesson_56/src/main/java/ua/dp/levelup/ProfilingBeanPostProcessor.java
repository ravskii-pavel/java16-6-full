package ua.dp.levelup;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by java on 16.06.2017.
 */
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> beans = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object o, String beanName) throws BeansException {
        
        System.out.println(beanName + " - Before initialization");
        Class<?> beanClass = o.getClass();
        //System.out.println(beanName);
        //for(Class c : beanClass){
        for(Method m : beanClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(Profiling.class)){
                beans.put(beanName, beanClass);
                return o;
            }
        }
        // }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //System.out.println(beans.containsKey(beanName));
        //System.out.println(bean);
        if(beans.containsKey(beanName)){
            Class beanClass = beans.get(beanName);
            System.out.println(beanName + " - After initialization");
            Method[] beanMethods = beanClass.getDeclaredMethods();
                System.out.println(beanClass.getDeclaredMethods()[0]);
                return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.isAnnotationPresent (Profiling.class)) {
                            System.out.println("Start Profiling");
                            long start = System.nanoTime();

                            Object result = method.invoke(args);

                            System.out.println("End Profiling eith time" + (System.nanoTime() - start));
                            return result;
                        }

                        return method.invoke(args);
                    }
                });
        }
        return bean;
    }
}
