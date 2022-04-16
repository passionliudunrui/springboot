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
    














-------------------------将一个初始化的项目提交到github------------------
1.git init
2.git add .
3.git remote add origin https://github.com/passionliudunrui/springboot.git
4.git branch(查看分支)   git branch passion(创建分支)  git checkout passion(选择分支)
5.git push -u origin passion  
6.git push -u origin master
test

    