package com.liyang;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        BlockingDeque blockingDeque = new LinkedBlockingDeque();
        blockingDeque.size();
    }
}
