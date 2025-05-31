package com.mac286.postfix;

import com.mac286.Queue.iOurQueue;
import com.mac286.linkedList.OurLinkedList;
import com.mac286.stacks.OurStack;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Postfix {
    private String expression;
    private iOurQueue<String> inFix, postFix;

    public Postfix(String expr){
        this.expression = expr;
        inFix = new OurLinkedList<>();
        postFix = new OurLinkedList<>();
        this.generateInfix();
        this.generatePostFix();
    }

    public String expression(){
        return expression;
    }

    public String getInFix(){
        return inFix.toString();
    }
    public String getPostFix(){
        return postFix.toString();
    }

    private boolean isOperator(char c){
        return (c == '+' || c == '-' || c == '*' || c == '/') ;
    }

    private boolean isParenthesis(char c){
        return (c == '(' || c ==')');
    }

    public void generateInfix(){
        int len = expression.length();
        if (len == 0){
            throw new NoSuchElementException();
        }

        if (inFix == null) { //for safety
            inFix = new OurLinkedList<>();
        }
        for(int i = 0; i < len; i ++){
            while(i < len && expression.charAt(i) == ' ') i ++;

            if(isOperator(expression.charAt(i)) || isParenthesis(expression.charAt(i))){
                //add it to the infix
                inFix.add("" + expression.charAt(i));
            }
            else if(Character.isDigit(expression.charAt(i))){
                //this is a digit there is a number here, extract it.

                int start = i;
                while(Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') i ++;

                //i is the index of a character that is not a digit

                int endInd = i;
                String operand  = expression.substring(start, endInd); //now the operand is a number

                //add the operand to the inFix queue

                inFix.add(operand);
                i--; //decrease i by 1 because the for loop will increase it by one
            }
            else System.out.println("There is a problem!");
        }


    }

    public void generatePostFix(){
        if(inFix.isEmpty()){
            this.generateInfix();
        }

        OurStack<String> S = new OurStack<String>();
        while(!inFix.isEmpty()){
            String item = inFix.remove();

            if(item.equals("(")){
                S.push(item);
                continue;
            }

            if(item.equals(")")){
                while(!S.peek().equals("(") && !S.isEmpty()){  //instead of S.peek() != "("
                    postFix.add(S.pop());
                }
                //Discard open (

                S.pop();
                continue;
            }

            if(Character.isDigit(item.charAt(0)) || item.charAt(0) == '.'){
                postFix.add(item);
                continue;
            }

            if(isOperator(item.charAt(0))){
                if(S.isEmpty() || !isOperator(S.peek().charAt(0)) || lowerPrecedence(S.peek(), item)){
                    S.push(item);
                    continue;
                }
                //else
                    while(!S.isEmpty() && isOperator(S.peek().charAt(0)) && !lowerPrecedence(S.peek(), item)){
                        postFix.add(S.pop());
                    }

                S.push(item);

            }

        }

        while(!S.isEmpty()) postFix.add(S.pop());
    }

    private boolean lowerPrecedence(String op1, String op2){
        return (op1.equals("+") || op1.equals("-")) && (op2.equals("*") || op2.equals("/"));
    }

    public double evaluate(){
        if(postFix.isEmpty()){
            throw new NoSuchElementException();
        }

        OurStack<String> evaluateStack = new OurStack<>();
        double operand1, operand2, result;
        while(!postFix.isEmpty()){
            if(Character.isDigit(postFix.peek().charAt(0))){
                evaluateStack.push(postFix.remove());
                continue;
            }
            //evaluateStack.push(postFix.remove());
            if(isOperator(postFix.peek().charAt(0))){
                //determine which operator is it? and compute the latest 2 numbers
                if(postFix.peek().equals("+")){
                    operand2 = Double.parseDouble(evaluateStack.pop());
                    operand1 = Double.parseDouble(evaluateStack.pop());
                    result = operand1 + operand2;
                    evaluateStack.push(String.valueOf(result));
                    postFix.remove();//everytime you use a operate, remember to remove it, otherwise it will loop forever.
                }

                else if(postFix.peek().equals("-")){
                    operand2 = Double.parseDouble(evaluateStack.pop());
                    operand1 = Double.parseDouble(evaluateStack.pop());
                    result = operand1 - operand2;
                    evaluateStack.push(String.valueOf(result));
                    postFix.remove();
                }

                else if(postFix.peek().equals("*")){
                    operand2 = Double.parseDouble(evaluateStack.pop());
                    operand1 = Double.parseDouble(evaluateStack.pop());
                    result = operand1 * operand2;
                    evaluateStack.push(String.valueOf(result));
                    postFix.remove();

                }

                else if(postFix.peek().equals("/")){
                    operand2 = Double.parseDouble(evaluateStack.pop());
                    operand1 = Double.parseDouble(evaluateStack.pop());
                    result = operand1 / operand2;
                    evaluateStack.push(String.valueOf(result));
                    postFix.remove();
                }

            }


        }

        return Double.parseDouble(evaluateStack.peek());  //You cannot limit the decimal directly

    }

}
