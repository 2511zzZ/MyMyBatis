package priv.zzz.app;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.List;

/*
实例化MyFactoryBean
 */
public class ImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        // 获得包名,遍历
        Class clazz = Appconfig.class;
        String packagePath = ((MyScan) clazz.getAnnotation(MyScan.class)).path();
        List<String> classNames = SelectClassName.selectByPackage(packagePath);

        for(String className:classNames){

            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
            GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
            registry.registerBeanDefinition(SelectClassName.getShortName(className),genericBeanDefinition);
            // 最重要的地方
            // 让Spring通过构造方法自动注入
            genericBeanDefinition.setAutowireMode(3);
            genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(className);
        }

    }

}
