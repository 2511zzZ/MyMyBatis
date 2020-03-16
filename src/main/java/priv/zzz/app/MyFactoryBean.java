package priv.zzz.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import priv.zzz.dao.UserDao;

import java.lang.reflect.Proxy;

@Component
public class MyFactoryBean implements FactoryBean {

    Class mapperInterface;

    // 为了支持XML配置,必须提供一个默认构造方法
    public MyFactoryBean(){}

    // 通过MapperScan方式
    // Spring会忽略传进来的类,需要在BeanDefinition时期传入
    public MyFactoryBean(Class mapperInterface){
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object getObject() throws Exception {
        Class[] classes = new Class[]{mapperInterface};
        return Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(),classes, new MyInvokationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface){
        this.mapperInterface = mapperInterface;
    }
}
