# jersey-prototype

#### 1.jersey是一个restful web service框架, 其与Spring的集成并不是很容易处理. 需要考虑到
- a.Spring的jar冲突
  jersey与Spring集成的包jersey-spring也包含Spring jar, 如beans...; 使用自定义的Spring jar需要使用<exclusions>消除
- b.JDK的版本

#### 2.项目整体基于Java配置Spring, 有一个bug需要注意
```
/**
 * 为什么需要配置这个Servlet, 告诉jersey不要找applicationContext.xml初始化Spring容器
 * 这是一个bug
 *
 * The important thing to note about this components is the @Order(1).
 * We want to make sure this initializer occurs before Jersey tries to create the app context.
 * If we fail to do this, Jersey will look for a applicationContext.xml Spring configuration file.
 * When it does not find it we will get a FileNotFoundException. Since we don’t want to use xml configuration,
 * we need to include the initializer.
 *
 * Annotation Order用来调整配置类的加载顺序
 *
 * @author rain
 * created on 2018/4/22
 */
@Order(1)
public class SpringInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("contextConfigLocation", "noop");
    }
}
```
#### 3.项目只是搭建了集成框架, 未详细配置Service, Dao, 事务等等Bean, 只是一个原型

#### 4.几个问题
- a.如何使用Maven忽略web.xml
- b.ContextLoaderListener加载的<contextLocationConfig>...noop, 有点op
