# ExecuteShell

[![version](https://jitpack.io/v/EndureBlaze/executeshell.svg)](https://jitpack.io/#EndureBlaze/executeshell)

ExecuteShell 是一个可以让你在你的 Android 项目上方便快速使用 shell 指令的开源库

使用 Kotlin 编写，完全支持 Java 调用

## 性能

便捷，快速，所有功能均可一行代码完成调用

## 配置要求

ExecuteShell 最低支持到Android [Ice Cream Sandwich](https://developer.android.com/about/versions/android-4.0-highlights.html) (API 14)

## 开始使用

> 版本号请看顶部

### Gradle

1.在项目根目录的 build.gradle 添加如下代码

```java
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
}
```

2.在需要使用模块(一般为app)的 build.gradle 中添加依赖

```Java
dependencies {
    implementation 'com.github.EndureBlaze:executeshell:$version'
}
```

### Maven

1.首先需要添加 JitPack 仓库

```HTML
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

2.然后添加依赖

```HTML
    <dependency>
        <groupId>com.github.EndureBlaze</groupId>
        <artifactId>executeshell</artifactId>
        <version>$version</version>
    </dependency>
```

## 功能说明

### 检测 root 状态

```kotlin
ExecuteShell.haveRoot()；
```

使用后返回 boolean 类型数据
返回 true 为有 root 权限
返回 false 为无 root 权限

### 执行 shell 指令且返回详细结果

```kotlin
ExecuteShell.execRootShell(shell_str);
```

shell_str 是转换为 String 类型的 shell 指令
执行成功后返回 String 类型的结果
执行失败则返回 `""`

即空白的 String (非 null)

### 执行 shell 指令不返回详细结果

```kotlin
ExecuteShell.execRootShellSilent(shell_str);
```

shell_str 是转换为 String 类型的 shell 指令
执行成功后返回 int 类型的结果
返回 0 代表执行成功
返回其他数字代表执行失败

## 演示

可以在 [sample](https://github.com/EndureBlaze/executeshell/tree/master/sample) 查看详细使用，或者下载 [apk](https://cdn.jsdelivr.net/gh/EndureBlaze/ExecuteShell/sample.apk) 实际查看使用结果

## 关于依赖库

本项目没有使用任何依赖库

## 反馈

在使用中如果有麻烦，或者出现 bug 请及时提交 issues

## 混淆(Proguard)

如果你有使用 Proguard 请添加如下代码

```Java
-keep public class cn.endureblaze.executeshell.ExecuteShell
```

## 其他作品

[Kirby Assistant](https://github.com/EndureBlaze/Kirby-Assistant)

License
-------
MIT License

Copyright (c) 2019 Haocun Ni

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
