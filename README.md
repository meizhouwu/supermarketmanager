springboot+ssm+thymeleaf
所有展示功能实现，采用同步的方式，异步自行了解


#配置数据库，连接服务器需要加上?characterEncoding=utf-8&serverTimezone=UTC&&useSSL=false
spring:
    datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://39.105.168.84:3306/supermarketmanager?characterEncoding=utf-8&serverTimezone=UTC&&useSSL=false
        username: study
        password: taylor1989swift.

由于数据库放在服务器，导入项目后，须在[application.yml]中更改数据库配置