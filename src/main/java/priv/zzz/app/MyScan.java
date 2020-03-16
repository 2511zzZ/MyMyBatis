package priv.zzz.app;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(ImportBeanDefinitionRegister.class)
public @interface MyScan {
    String path();
}
