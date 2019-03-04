package com.prodanov;

import org.junit.Test;

import java.io.ByteArrayInputStream;

public class CalculatorTest
{
    private void sendCommand(String szCommand)
    {
        byte[] btCommand = szCommand.getBytes();
        ByteArrayInputStream pIn = new ByteArrayInputStream(btCommand);
        System.setIn(pIn);
    }



    @Test
    public void Positive_Add ()
    {
        this.sendCommand("10+3");
        new Calculator();
    }
    @Test
    public void Positive_Sub ()
    {
        new Calculator("10-3");
    }
    @Test
    public void Positive_Div ()
    {
        new Calculator("10/3");
    }
    @Test
    public void Positive_Mult ()
    {
        new Calculator("10*3");
    }
    @Test
    public void Positive_Pow ()
    {
        new Calculator("10**3");
    }


    @Test(expected = NoSupportOperationException.class)
    public void Negative_OneNumber ()
    {
        new Calculator("100");
    }
    @Test(expected = NoSupportOperationException.class)
    public void Negative_DoublePlus ()
    {
        new Calculator("10++2");
    }
    @Test(expected = NoSupportOperationException.class)
    public void Negative_DoubleMinus ()
    {
        new Calculator("10--2");
    }
    @Test(expected = NumberFormatException.class)
    public void Negative_DifferentMathOperation ()
    {
        new Calculator("10*/*2");
    }
    @Test(expected = NoSupportOperationException.class)
    public void Negative_DivisionByZero ()
    {
        new Calculator("10/0");
    }
    @Test(expected = NumberFormatException.class)
    public void Negative_MultWithCharacter ()
    {
        new Calculator("10*avc");
    }
    @Test(expected = NoSupportOperationException.class)
    public void Negative_TripleSign  ()
    {
        new Calculator("10***3");
    }

}
