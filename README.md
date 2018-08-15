# spx2wav.jar 使用
功能介绍：将.speex文件解码为*.wav文件

## 环境：
1. Linux
2. JDK 1.6

## 步骤：
### 1. 安装libspeex

> 从 https://github.com/wintterHub/spx2wav.git 的resources目录下载 speex-1.2.0.tar.gz

> 解压 tar zxvf speex-1.2.0.tar.gz

> 进入解压后的文件夹执行 sudo make install

### 2. 打包

> 从 https://github.com/wintterHub/spx2wav.git 中获得 release

> 进入release文件夹执行如下命令:

> make -f makefile-linux [若此命令报错，请查看下方“常见问题”#1]

> make -f makefile-linux install

### 3. 使用方式 [使用时报错，请查看下方“常见问题”#2]

> Java类中调用示例: SpeexUtils.decode("a.speex", "a.wav");

> 命令测试示例: java -jar spx2wav.jar a.speex a.wav
    
### 4. 测试文件

> 从 https://github.com/wintterHub/spx2wav.git 的resources目录中获取以下两个speex音频文件进行测试

> ./resources/a.speex

> ./resources/b.speex

## 常见问题

> 1.make -f makefile-linux 命令执行报错

先执行如下命令（-I 后面跟的参数可能需要根据实际JDK安装位置进行修改），再执行make -f makefile-linux
```
gcc -c -fPIC util_speex_SpeexUtils.c -I/usr/local/java/jdk1.8.0_152/include -I/usr/local/java/jdk1.8.0_152/include/linux1

gcc -c -fPIC TRSpeex.c -I/usr/local/java/jdk1.8.0_152/include -I/usr/local/java/jdk1.8.0_152/include/linux1

gcc -c -fPIC fifo.c -I/usr/local/java/jdk1.8.0_152/include -I/usr/local/java/jdk1.8.0_152/include/linux1
```

> 2.缺少动态连接库.so--cannot open shared object file: No such file or directory

有以下两种解决办法

1.用ln将需要的so文件链接到/usr/lib或者/lib这两个默认的目录下边

```
ln -s /where/you/install/lib/*.so /usr/lib

sudo ldconfig
```

2.修改/etc/ld.so.conf
```
vim /etc/ld.so.conf

增加一行 include /where/you/install/lib

sudo ldconfig
```

## 参考文档
https://github.com/guoguo11/JSpeex-util

Author: zhaochangjin@zving.com