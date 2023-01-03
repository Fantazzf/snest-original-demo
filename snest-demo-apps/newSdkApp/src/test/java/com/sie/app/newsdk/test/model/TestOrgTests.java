package com.sie.app.newsdk.test.model;

import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.loaders.PropertyLoader;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lijun10
 * @date 2022/12/8 15:10
 */

public class TestOrgTests {


    @Test
    public void testOne2many() throws InvocationTargetException, IllegalAccessException {

        for (Field declaredField : TestOrg.class.getDeclaredFields()) {
            declaredField.setAccessible(true);
            OneToMany oneToMany = declaredField.getAnnotation(OneToMany.class);
            if(oneToMany != null){
                for (Method declaredMethod : oneToMany.getClass().getDeclaredMethods()) {
                    if(!PropertyLoader.OBJECT_METHODS.contains(declaredMethod.getName())) {
                        System.out.print(declaredMethod.getName());
                        System.out.print(":");
                        Object object = declaredMethod.invoke(oneToMany);
                        if (object.getClass().isArray()) {
                            Assert.assertTrue(StringUtils.join((Object[]) object, ",").equals("PERSIST,MERGE,DELETE"));
                        } else {
                            System.out.print(object);
                        }
                        System.out.print("\t\n");
                    }
                }
            }
        }

    }
}
