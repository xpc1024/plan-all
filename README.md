>由于本人购买的服务器和域名已到期,很抱歉暂时无法为大家提供在线生成健身计划服务

>如需生成,请自行部署前后端项目,或联系本人微信252645816,代为生成

# 步骤
---
## **后端**
## 1.下载后端项目资源包
### 1.1 新建数据库,名称为plan,编码utf-8mb4,排序规则随意
### 1.2 将后端资源文件夹下的plan.sql执行,完成数据库表创建
### 1.3 修改application.yml启动配置文件,将数据库地址,密码,端口等替换
### 1.4 启动项目,启动成功后记住该端口号

## **前端**
## 2.下载前端项目资源包
### 2.1将该资源包上传至宿主机指定目录
### 2.2修改Nginx配置,用Nginx做前后端资源的代理

>Nginx参考配置
```txt
    # 省略其它Nginx配置项
    server{
        listen  80; # 项目访问端口号
        server_name  localhost;
        location / {
                root   /home/plan-front; #这里代理到前端资源存放的位置,比如我把前端资源plan-front放在了/home目录下,那这里就写/home/plan-front
                index  index.html index.htm;
                }
        location ^~ /api/ {
                proxy_pass http://127.0.0.1:7777/; #这里代理到你后端服务成功启动的IP+端口,域名亦可
                }
        }

如果前后端部署正确,打开浏览器输入IP+Port(nginx配置的)访问此项目,可以看到此界面:
![界面1](https://iknow.hs.net/69ec41f9-fadf-4c94-b0e4-c0b7f25858c5.png)

按照自己需要,下拉选择对应项,点击生成按钮后滑动滑块解锁

耐心等待几秒,便可生成你想要的健身计划!

![界面2](https://iknow.hs.net/f19fba77-ff9c-4792-8a17-44cc9d057d92.png)

生成好的健身计划,可以点击在线预览或是下载,下载支持单个下载和全量压缩包,里面内容非常齐全,


只要你能坚持按照计划做好训练,饮食,作息,三个月逆袭,半年脱胎换骨,Trust Me!

![界面3](https://iknow.hs.net/e58f0f8b-5bfb-4dba-aacb-ebda0c11171c.png)

![界面4](https://iknow.hs.net/61077e36-ac94-427d-a192-613e34bdf2ae.png)

![界面5](https://iknow.hs.net/7dba2bb6-4e6d-4a03-ab43-237275a9434b.png)


如果上述计划或系统有帮助到您,可以帮忙点亮小星星⭐,支持一下作者辛苦劳动的成果!


最后感谢您的信任和支持,老汉健身,祝您早日收获完美身材!
