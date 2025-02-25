package org.example.app1.compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;

public class JavaCompilerWithVersionExample {

    public static void main(String[] args) {

        System.out.println( System.getProperty("user.dir"));
        // 获取 JavaCompiler 实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // 检查编译器是否可用
        if (compiler == null) {
            System.err.println("Java 编译器不可用，请确保你使用的是 JDK 而不是 JRE。");
            return;
        }

        // 定义要编译的 Java 源文件路径
        String sourceFilePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/compiler/HelloWorld.java";

        // 创建一个包含源文件的 File 对象
        File sourceFile = new File(sourceFilePath);

        // 检查源文件是否存在
        if (!sourceFile.exists()) {
            System.err.println("源文件 " + sourceFilePath + " 不存在。");
            return;
        }

        // 定义编译参数，指定 JDK 版本
        String[] compileOptions = {
//                "-source", "1.8",  // 指定源代码版本为 Java 8
//                "-target", "1.8",  // 指定生成的字节码兼容 Java 8
                "-d", "bin",       // 指定编译输出目录为 bin 文件夹
                "-g"               // 生成调试信息
        };

        // 组合编译选项和源文件路径
        String[] allArgs = new String[compileOptions.length + 1];
        System.arraycopy(compileOptions, 0, allArgs, 0, compileOptions.length);
        allArgs[allArgs.length - 1] = sourceFilePath;

        // 调用编译器的 run 方法进行编译
        int result = compiler.run(null, null, null, allArgs);

        // 检查编译结果
        if (result == 0) {
            System.out.println("编译成功！");
        } else {
            System.out.println("编译失败，错误代码: " + result);
        }


    }
}