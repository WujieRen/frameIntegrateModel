# 1. pom.xml
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
        <junit.version>4.11</junit.version>
        <spring.version>5.0.5.RELEASE</spring.version>
        <fileupload.version>1.3.1</fileupload.version>
        <validator.version>5.0.2.Final</validator.version>
        <hibernatecore.version>5.2.12.Final</hibernatecore.version>
        <mybatis.version>3.4.5</mybatis.version>
        <mysql.version>6.0.6</mysql.version>
        <dbcp.version>1.4</dbcp.version>
        <json.version>2.7.4</json.version>
      </properties>

    <dependencies>
        <!--junit-->
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>${junit.version}</version>
          <scope>test</scope>
        </dependency>
        <!-- 与注解相关 -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>${spring.version}</version>
        </dependency>
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-web</artifactId>
          <version>${spring.version}</version>
        </dependency>
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-webmvc</artifactId>
          <version>${spring.version}</version>
        </dependency>
        <!-- 声明事务 -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-tx</artifactId>
          <version>${spring.version}</version>
        </dependency>
        <!-- 面向切面编程:Aspect Oriented Program -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-aop</artifactId>
          <version>${spring.version}</version>
        </dependency>
        <dependency>
          <groupId>org.aspectj</groupId>
          <artifactId>aspectjweaver</artifactId>
          <version>1.8.13</version>
        </dependency>
        <!-- 可以不要 -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context-support</artifactId>
          <version>${spring.version}</version>
        </dependency>
    
        <!-- 上传文件 -->
        <dependency>
          <groupId>commons-fileupload</groupId>
          <artifactId>commons-fileupload</artifactId>
          <version>${fileupload.version}</version>
        </dependency>
        <!-- 上传文件（设置文件上传大小等） -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-webmvc-portlet</artifactId>
          <version>4.3.11.RELEASE</version>
        </dependency>
        
        <!-- Hibernate -->
        <!--<dependency>
          <groupId>org.hibernate</groupId>
          <artifactId>hibernate-core</artifactId>
          <version>${hibernatecore.version}</version>
        </dependency>-->
            
        <!-- MyBatis -->
        <dependency>
          <groupId>org.mybatis</groupId>
          <artifactId>mybatis</artifactId>
          <version>${mybatis.version}</version>
        </dependency>
    
        <!-- mysql-->
        <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>${mysql.version}</version>
        </dependency>
        <!-- dbcp数据连接池 -->
        <dependency>
          <groupId>commons-dbcp</groupId>
          <artifactId>commons-dbcp</artifactId>
          <version>${dbcp.version}</version>
        </dependency>
    
        <!-- 数据验证 -->
        <dependency>
          <groupId>org.hibernate</groupId>
          <artifactId>hibernate-validator</artifactId>
          <version>${hibernate.version}</version>
        </dependency>
    
        <!-- json支持 -->
        <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-core</artifactId>
          <version>${json.version}</version>
        </dependency>
        <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-annotations</artifactId>
          <version>${json.version}</version>
        </dependency>
        <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-databind</artifactId>
          <version>${json.version}</version>
        </dependency>
    </dependencies>
  
# 2. 系统级别配置：application.xm（作用范围：系统上下文）
+ Hibernate
  - 1.开启注解
  - 2.处理事务和Hibernate整合
    - 2.1 数据源(DataSource)
    - 2.2 将DataSource注入到SessionFactory
    - 2.3 将SessionFactory注入到事务中
    - 2.4 在SessionFactory中，设置查找Hibernate实体映射类（基于注解方式）
+ MyBatis
  - 1.开启注解
  - 2.处理事务和MyBatis整合
    - 2.1 数据源(DataSource)
    - 2.2 将DataSource注入到SqlSessionFactory
    - 2.3 将SqlSessionFactory注入到事务中
    - 2.4 在SessionFactory中，别名

   
# 3. controller级别配置：spring-servlet.xml（控制层上下文）
1. 开启SpringMVC注解和业务组件注解
2. 视图解析器
3. 可选
    - 处理静态资源文件
    - 文件上传
    - 异常处理

# 4. web.xml
+ Hibernate
  - 1.加载spring.xml
  - 2.配置过滤器
    - 2.1字符过滤器
    - 2.2延迟加载过滤器(OSIV)
  - 3.配置spring监听器
  - 4.配置springMVC核心控制器

+ MyBatis
  - 1.加载spring.xml
  - 2.配置过滤器
    - 2.1字符过滤器
  - 3.配置spring监听器
  - 4.配置springMVC核心控制器

# 5. 关于application.xml和spring-servlet.xml
1. 配置建议
  - ApplicationContext.xml
    - 整个web程序需要共享的一些组件，如：DAO、数据库的ConnectionFactory等。
  - servletname-servlet.xml
    - 和Servlet相关的一些组件，如：Controller、ViewResovler等。
> 配置建议参考自：https://juejin.im/post/5a38be61f265da431c706d2d
    
# 6. 关于classpath:和classpath*:
1. classpath：只会到你的class路径中查找找文件。
2. classpath*：不仅包含class路径，还包括jar文件中（class路径）进行查找。
> 注意： 用classpath*:需要遍历所有的classpath，所以加载速度是很慢的；因此，在规划的时候，应该尽可能规划好资源文件所在的路径，尽量避免使用classpath*  

>reference:  
https://blog.csdn.net/xing_sky/article/details/77934078   
https://blog.csdn.net/kkdelta/article/details/5507799

# 7. F&A
1. org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactory' defined in class path resource [spring.xml]: ... Cause: java.lang.IllegalArgumentException: **Mapped Statements collection already contains value for com.ssm.demo.model.User.getUserList**
  - 原因：spring.xml中连续导入两次。（还可能是因为在XXXMapper.xml中有两个id的值相同）
  ![图片1](https://github.com/WujieRen/frameIntegrateModel/tree/master/ssmIntegrateDemo/src/main/resources/img/1.png)
  - 解决：去掉一个
2. pom打包不起作用:
  - 原因：不知。
  - 解决：删除自带的<pluginManagement/>后就好了。
3. Error:Cannot build Artifact :war exploded because it is included into a circular dependency
  - 原因：pom打的war包有问题
  - Ctrl+Shift+S，删除Artifacts下的war包重新装载tomcat。
4. setUserMapper()爆红线：UserMapper cant autoware
  - 原因：不知道（好像是扫描器给定粒度的问题，粒度给小后红线消失。但粒度太小导致有东西扫描不到）
  - 解决：
```$xslt
<!-- 设置spring去哪个包找注解的类 -->
<!-- 这个扫描粒度会导致 XXX cant autowared??? -->
<context:component-scan base-package="com.ssm.demo.mapper" /> 
```
5. org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactory' defined in class path resource [spring.xml]: ...  Could not open ServletContext resource [/dao/UserMapper.xml]
  - 原因：原因就是这里，但是不知道为什么昨天改了以后也不行，今天又好了。可能是昨天环境中有一些bad dependency，以后类似这种问题可以把整个环境重启试试。
```$xslt
<!-- 创建SqlSessionFactory -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <!-- 引用的数据源 -->
    <property name="dataSource" ref="dataSource"/>
    <property name="mapperLocations">
        <array>
            <value>classpath*:dao/UserMapper.xml</value>
            <!-- 这种方式需要修改pom,将.xml文件打包 -->
            <!--<value>com/ssm/demo/mapper/UserMapper.xml</value>-->
        </array>
    </property>
    <!--这两种方式都行，用其中之一即可-->
    <!--<property name="configLocation" value="classpath:mybatis.xml"/>-->
    <!-- 别名 -->
    <property name="typeAliasesPackage" value="com.ssm.demo.model"/>
</bean>
```
  - 解决：
```
<!-- 修改value如下 -->
<value>classpath:com/ssm/demo/mapper/UserMapper.xml</value>
``` 