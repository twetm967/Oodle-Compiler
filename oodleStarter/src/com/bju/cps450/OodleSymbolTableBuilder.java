
package com.bju.cps450;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.application.Application;
import com.bju.cps450.node.*;

/**
 * Created by ethanmcgee on 2/24/16.
 */
public class OodleSymbolTableBuilder extends DepthFirstAdapter {

    private Token lastToken;

    private void reportError(String error) {
        Application.addSemanticError();
        if(lastToken != null) {
            System.out.println(Application.getTokenFileAndLine(lastToken) + error);
        } else {
            System.out.println(error);
        }
    }

    @Override
    public void inAStart(AStart node) {
        Application.getSymbolTable().beginScope();
    }


    @Override
    public void outAVarDecl(AVarDecl node) {
        lastToken = node.getIdentifier();
        try {
            Application.getSymbolTable().addVariableDeclaration(node.getIdentifier().getText(), Application.getNodeProperties(node.getType()).getType());
        } catch(Exception e) {
            reportError(e.getMessage());
        }
    }

    @Override
    public void inAClassDecl(AClassDecl node) {
        lastToken = node.getStart();
        try {
            Application.getSymbolTable().addClassDeclaration(node.getStart().getText());
        } catch(Exception e) {
            reportError(e.getMessage());
        }
        Application.getSymbolTable().beginScope();
    }

    @Override
    public void outAClassDecl(AClassDecl node) {
        try {
            Application.getSymbolTable().endScope();
        } catch (Exception e) {
            reportError(e.getMessage());
        }
    }

    @Override
    public void inAMethod(AMethod node) {
        lastToken = node.getIdentifier();
        try {
            Application.getSymbolTable().addMethodDeclaration(node.getIdentifier().getText());
        } catch (Exception e) {
            reportError(e.getMessage());
        }
        Application.getSymbolTable().beginScope();
    }

    @Override
    public void outAMethod(AMethod node) {
        Application.getSymbolTable().getCurrentMethodDeclaration().setType(Application.getNodeProperties(node.getType()).getType());
        try {
            Application.getSymbolTable().endScope();
        } catch (Exception e) {
            reportError(e.getMessage());
        }
    }

    @Override
    public void outAArg(AArg node) {
        lastToken = node.getIdentifier();
        try {
            Application.getSymbolTable().addArgumentDeclaration(node.getIdentifier().getText(), Application.getNodeProperties(node.getType()).getType());
        } catch (Exception e) {
            reportError(e.getMessage());
        }
    }
}
