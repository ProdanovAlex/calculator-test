package com.prodanov;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Calculator {

    Calculator() {
        this.show_hint();
        this.listenUserPrompt();
    }

    Calculator(String szCommand)
    {
        //this.show_hint();
        this.sendCommand(szCommand);
        this.listenUserPrompt();
    }

    private void show_hint()
    {
        System.out.println("Use this as a simple calculator");
        System.out.println("There are following available operation: ");
        System.out.println("Addition: 125 + 456");
        System.out.println("Subtraction: 321 - 123");
        System.out.println("Multiplication: 15 * 3");
        System.out.println("Division: 81 / 9");
        System.out.println("Power of: 2 ** 3. Result: 8");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter an expression or CTRL+D to exit");
    }

    private void sendCommand(String szCommand)
    {
        byte[] btCommand = szCommand.getBytes();
        ByteArrayInputStream pIn = new ByteArrayInputStream(btCommand);
        System.setIn(pIn);
    }

    private void listenUserPrompt()
    {
        Scanner prompt = new Scanner(System.in);
        while (true)
        {
            String szIn = null;
            try
            {
                szIn = prompt.nextLine();
            }
            catch (Exception ex)
            {
                szIn = null;
            }

            if (szIn == null)
            {
                break;
            }
            else
            {
                double fRes = parseInput(szIn);
                System.out.println("The result of your operation is: " + fRes);
            }
        }
    }

    private double parseInput(String userInput)
    {
        System.out.println("_____________________________________________________");
        System.out.println("The request command: " + userInput);

        double result = 0.0;
        int index = -1;
        int lastIndex = -1;
        int len = userInput.length();

        if ((index = userInput.indexOf("+")) > 0 && userInput.lastIndexOf("+") == index)
        {
            result = add(userInput.substring(0, index).trim(), userInput.substring(index + 1, len));
        }
        else if ((index = userInput.indexOf("-")) > 0 && userInput.lastIndexOf("-") == index)
        {
            result = sub(userInput.substring(0, index).trim(), userInput.substring(index + 1, len));
        }
        else if ((index = userInput.indexOf("/")) > 0 && userInput.lastIndexOf("/") == index)
        {
            Double tempDouble = Double.valueOf(userInput.substring(index + 1, len));
            if (tempDouble == 0) {
                throw new NoSupportOperationException("No support operation");
            }
            else {
                result = div(userInput.substring(0, index).trim(), userInput.substring(index + 1, len));
            }

        }
        else if ((index = userInput.indexOf("*")) > 0 && (lastIndex = userInput.lastIndexOf("*")) == (index + 1))
        {
            result = pow(userInput.substring(0, index).trim(), userInput.substring(lastIndex + 1, len));
        }
        else if ((index = userInput.indexOf("*")) > 0 && userInput.lastIndexOf("*") == index)
        {
            result = mult(userInput.substring(0, index).trim(), userInput.substring(index + 1, len));
        }
        else
        {
            throw new NoSupportOperationException("No support operation");

        }
        return result;
    }

    private double add(String first, String second) {
        return Double.valueOf(first) + Double.valueOf(second);
    }

    private double sub(String first, String second) {
        return Double.valueOf(first) - Double.valueOf(second);
    }

    private double div(String first, String second) {
        return Double.valueOf(first) / Double.valueOf(second);
    }

    private double mult(String first, String second) {
        return Double.valueOf(first) * Double.valueOf(second);
    }

    private double pow(String first, String second) {
        return Math.pow(Double.valueOf(first), Double.valueOf(second));
    }


}

