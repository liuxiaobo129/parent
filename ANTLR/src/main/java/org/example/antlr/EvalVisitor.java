package org.example.antlr;

import gen.org.example.antlr.ExprBaseVisitor;
import gen.org.example.antlr.ExprParser;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ExprBaseVisitor<Object> {
    private Map<String, Object> memory = new HashMap<>();
    private Map<String, Func> functions = new HashMap<>();

    @Override
    public Object visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Object value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Object visitPrintExpr(ExprParser.PrintExprContext ctx) {
        Object result = visit(ctx.expr()); // 获取表达式的值
        System.out.println(result); // 打印到控制台
        return null;
    }

    @Override
    public Object visitFunctionDef(ExprParser.FunctionDefContext ctx) {
        String funcName = ctx.ID().getText();
        String[] params = ctx.params() != null
                ? ctx.params().ID().stream().map(TerminalNode::getText).toArray(String[]::new)
                : new String[]{};
        functions.put(funcName, new Func(params, ctx.prog()));
        return null;
    }

    @Override
    public Object visitFunctionCall(ExprParser.FunctionCallContext ctx) {
        String funcName = ctx.ID().getText();
        Func func = functions.get(funcName);
        if (func == null) {
            throw new RuntimeException("Function not defined: " + funcName);
        }

        Map<String, Object> savedMemory = new HashMap<>(memory);
        for (int i = 0; i < ctx.args().expr().size(); i++) {
            Object argValue = visit(ctx.args().expr(i));
            memory.put(func.params[i], argValue);
        }

        for (ExprParser.StatContext stat : func.prog.stat()) {
            visit(stat);
        }

        memory = savedMemory;
        return null;
    }

    @Override
    public Object visitIfStmt(ExprParser.IfStmtContext ctx) {
        Object condition = visit(ctx.expr());
        if (condition instanceof Boolean && (Boolean) condition) {
            visit(ctx.prog(0));
        } else if (ctx.prog().size() > 1) {
            visit(ctx.prog(1));
        }
        return null;
    }

    @Override
    public Object visitWhileStmt(ExprParser.WhileStmtContext ctx) {
        while ((Boolean) visit(ctx.expr())) {
            visit(ctx.prog());
        }
        return null;
    }

    @Override
    public Object visitMulDiv(ExprParser.MulDivContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        if (left instanceof Integer && right instanceof Integer) {
            int leftInt = (Integer) left;
            int rightInt = (Integer) right;
            if (ctx.op.getType() == ExprParser.MUL) {
                return leftInt * rightInt;
            }
            return leftInt / rightInt;
        }
        throw new RuntimeException("Operands must be integers for multiplication/division");
    }

    @Override
    public Object visitAddSub(ExprParser.AddSubContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        if (left instanceof Integer && right instanceof Integer) {
            int leftInt = (Integer) left;
            int rightInt = (Integer) right;
            if (ctx.op.getType() == ExprParser.ADD) {
                return leftInt + rightInt;
            }
            return leftInt - rightInt;
        }

        if (left instanceof String && right instanceof String) {
            String leftInt = (String) left;
            String rightInt = (String) right;
            if (ctx.op.getType() == ExprParser.ADD) {
                return leftInt + rightInt;
            }
        }
        throw new RuntimeException("Operands must be integers for addition/subtraction");
    }

    @Override
    public Object visitBlock(ExprParser.BlockContext ctx) {

        // 创建一个新的作用域（内存环境）来存储局部变量
        Map<String, Object> savedMemory = new HashMap<>(memory);

        // 遍历语句块中的所有语句
        for (ExprParser.StatContext stat : ctx.prog().stat()) {
            visit(stat); // 调用 visit 方法执行每一条语句
        }

        // 恢复内存状态
        memory = savedMemory;
        return null;
    }

    @Override
    public Object visitComparison(ExprParser.ComparisonContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        if (left instanceof String && right instanceof String) {

            if (ctx.op.getType() == ExprParser.EQ) {

                return left.equals(right);
            }
        }

        throw new RuntimeException("Operands must be integers for visitComparison");
    }

    @Override
    public Object visitInt(ExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Object visitFloat(ExprParser.FloatContext ctx) {
        return Float.valueOf(ctx.FLOAT().getText());
    }

    @Override
    public Object visitString(ExprParser.StringContext ctx) {
        return ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1); // 去掉引号
    }

    @Override
    public Object visitTrue(ExprParser.TrueContext ctx) {
        return true;
    }

    @Override
    public Object visitFalse(ExprParser.FalseContext ctx) {
        return false;
    }

    @Override
    public Object visitId(ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return null;
    }

    private static class Func {
        String[] params;
        ExprParser.ProgContext prog;

        Func(String[] params, ExprParser.ProgContext prog) {
            this.params = params;
            this.prog = prog;
        }
    }
}