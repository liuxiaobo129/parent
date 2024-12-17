package org.example.antlr;

import gen.org.example.antlr.ExprLexer;
import gen.org.example.antlr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
        // 输入：包含字符串和其他操作
        String input = "x = 'Hello'\n" +
                "y = 'World'\n" +
                "z = x + y\n" +
                "print z\n";
//                +
//                "if z == 'HelloWorld' then {" +
//                "   print 'Match!'\n" +
//                "} else {" +
//                "    print 'No match!'\n" +
//                " }end\n";
        CharStream inputStream = CharStreams.fromString(input);

        // 创建词法分析器和解析器
        ExprLexer lexer = new ExprLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        // 解析输入
        ParseTree tree = parser.prog();

        // 创建访问者并执行
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);

    }
}