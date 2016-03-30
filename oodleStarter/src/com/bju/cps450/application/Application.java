package com.bju.cps450.application;

import com.bju.cps450.instruction.InstructionSet;
import com.bju.cps450.node.Node;
import com.bju.cps450.node.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tcwetmore on 3/12/16.
 */
public class Application {
    public static class NodePropertiesContainer {
        private Type type;
        private InstructionSet code;

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public InstructionSet getCode() {
            return code;
        }

        public void setCode(InstructionSet code) {
            this.code = code;
        }
    }

    private static Map<Node, NodePropertiesContainer> nodePropertyMap = new HashMap<>();

    public static NodePropertiesContainer getNodeProperties(Node node) {
        if(nodePropertyMap.get(node) == null) {
            nodePropertyMap.put(node, new NodePropertiesContainer());
        }
        return nodePropertyMap.get(node);
    }

    private static SymbolTable symbolTable = new SymbolTable();

    public static SymbolTable getSymbolTable() {
        return symbolTable;
    }

    private static ArrayList<String> filenames = new ArrayList<>();
    private static ArrayList<Integer> maxLinesPerFile = new ArrayList<>();

    public static void addFile(String filename, int lines) {
        filenames.add(filename);
        maxLinesPerFile.add(lines);
    }

    public static String getTokenFileAndLine(Token t) {
        int line = t.getLine(), i;
        for(i = 0; i < maxLinesPerFile.size() && line > maxLinesPerFile.get(i); ++i) {
            line -= maxLinesPerFile.get(i);
        }
        return filenames.get(i) + ":" + line + "," + t.getPos() + ":";
    }

    private static int lexicalErrors = 0;
    private static int parseErrors = 0;
    private static int semanticErrors = 0;

    public static void addLexicalError() {
        lexicalErrors++;
    }

    public static void addParseError() {
        parseErrors++;
    }

    public static void addSemanticError() { semanticErrors++; }

    public static boolean hasErrors() {
        return lexicalErrors > 0 || parseErrors > 0 || semanticErrors > 0;
    }

    public static void printErrorCounts() {
        System.out.println(lexicalErrors + " lexical errors found");
        System.out.println(parseErrors + " parse errors found");
        System.out.println(semanticErrors + " semantic errors found");
        System.out.println((lexicalErrors + parseErrors + semanticErrors) + " errors found");
    }
}
