package com.browserstack;
import org.testng.SkipException;
import org.testng.annotations.Test;
public class BstackSkipTest {
    @Test
    public void addSkipTest() throws Exception {
        throw new SkipException("Skipping this exception");
    }
}

