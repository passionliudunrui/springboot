--------------------springboot整合mybatis---------------------------------------
1.整合pom.xml文件 注意里面的版本信息，引入musql驱动的时候确认是否带cj
2.配置.yml的信息 注意格式和对齐等
3.建立整体架构  dao(存放了数据库操作的接口)  entity(存放了实体类POJO对象)  service(存放了组件)
    1.dao层里面写一个接口 一个表一个dao 里面是接口中的方法。
    2.在resources中建立一个mapper文件,名字为...Mapper.xml
        （1）mapper.xml中的namespace是绑定接口。 全限定接口名  mapper.xml中的resultType 返回值是全限定包名  如果在yml中配置了type-aliases-package 可以简写
        （2）mapper.xml中的select的标签 id绑定接口中具体的方法
        （3）在yml配置的时候注意 classpath:  chasspath*: 指的是生成的target下的classes 下面的包
        （4）在启动类上添加 @MapperScan（存放了dao包的扫描路径）
    3.service层添加一个接口   然后写一个实现类  这个类注解@Servive (这个类对象交给容器)


---------------------mybatis的本地缓存----------------------------------------
1.sqlSession级别的缓存   一级
2.sqlSessionFactory级别的缓存  二级

---------------------mybatis自身缓存结合redis实现分布式缓存----------------------------------------
1.mybatis中的应用级别缓存（二级缓存） sqlsessionFactory级别缓存 所有的会话共享
2.如何开启缓存（二级缓存）
    a.mapper.xml   <cache/>
3.查看cache标签的实现
    通过了orrg.apache.ibatis.chache.impl.PerpetualCache实现
4.自定义RedisCache实现
    a.通过mybatis默认的源码得知，自定义cache实现 implements Cache接口 并对里面的方法实现
    b.<cache type="xxxx.RedisCache">


----------------------------mybatis的知识点--------------------------
1.关于参数的匹配问题  
    如果是传入了对象类型  直接 id=#{id}
    如果只是传入了基本的数据类型  注意在mapper.xml文件中加入parameterType 指定数据类型




---------------------------分布式缓存和本地缓存的优缺点------------------------
4.使用mybatis的缓存也需要序列化
5.分布式缓存和本地缓存的优缺点
1.支持大数据量存储，不受应用进程重启影响：分布式缓存由于是独立部署的进程，拥有自身独立的内存空间，不会受到应用进程重启的影响，在应用进程重启时，分布式缓存的数据依然存在。
2.对于数据量而言，由于不需要占用应用程序的内存空间，并且一般支持以集群的方式扩展，故可以进行大数据量的数据缓存。
3.数据读写分离，高性能，高可用：分布式缓存一般支持数据副本机制，可以实现读写分离，故可以解决高并发场景中的数据读写性能问题。并且由于在多个缓存节点存储数据，提高了缓存数据的可用性，避免某个缓存节点宕机导致数据不可用问题。
4.数据集中存储，保证数据一致性：当应用进程采用集群方式部署时，集群的每个部署节点都通过一个统一的分布式缓存进行数据存取操作，故不存在本地缓存中的数据更新问题，保证了不同节点的应用进程的数据一致性问题。
5.数据跨网络传输，性能低于本地缓存：由于分布式缓存是独立部署的进程，并且一般都是与应用进程位于不同的机器，故需要通过网络来进行数据传输，这样相对于本地缓存性能较低。














-------------------------将一个初始化的项目提交到github------------------
1.git init
2.git add .
3.git remote add origin https://github.com/passionliudunrui/springboot.git
4.git branch(查看分支)   git branch passion(创建分支)  git checkout passion(选择分支)
5.git push -u origin passion  
6.git push -u origin master
test

    



--------------------------MVC原理-----------------------------------
一、客户端发送请求的总体过程

DispatcherServlet是SpringMVC的入口，DispatcherServlet其实也是一个Servlet。服务器处理客户端请求的步骤如下：
1、DispatcherServlet继承FrameworkServlet，当客户端发送请求的时候， 会调用Servlet对应的doGet、doPost、doDelete等方法。
2、doGet、doPost、doDelete里面会调用processRequest方法
3、processRequest方法进一步调用doService方法
4、DispatcherServlet实现了doService方法，在doService方法中对Request参数进行处理，然后调用doDispatch方法
5、在doDispatch方法中获取并调用处理器映射器、处理器适配器，获取并返回执行结果。
DispatcherServlet是Web中处于比较核心的位置，被称为前端控制器。SpringMVC中常用的几个概念，处理器映射器（HandlerMapping）、处理器适配器（HandlerAdapter）和视图解析器（ViewResolver）都在DispatcherServlet的doDispatch中有所体现。

二、springMVC工作原理
下面是文字步骤说明：
1、用户发送请求到前端控制器（DispatcherServlet）。
2、前端控制器请求处理器映射器（HandlerMapping）去查找处理器（Handler）。
3、找到以后处理器映射器（HandlerMappering）向前端控制器返回执行链（HandlerExecutionChain）。
4、前端控制器（DispatcherServlet）调用处理器适配器（HandlerAdapter）去执行处理器（Handler）。
5、处理器适配器去执行Handler。
6、处理器执行完给处理器适配器返回ModelAndView。
7、处理器适配器向前端控制器返回ModelAndView。
8、前端控制器请求视图解析器（ViewResolver）去进行视图解析。
9、视图解析器向前端控制器返回View。
10、前端控制器对视图进行渲染。
11、前端控制器向用户响应结果。


