package org.json.junit;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class M5test {
    @Test
    public void testAsyncConversionSuccess() throws InterruptedException {

        String xml = "<root><test>value</test></root>";
        StringReader xmlReader = new StringReader(xml);

        //to synchronize the asynchronous operation
        CountDownLatch latch = new CountDownLatch(1);

        //Success Callback

        //consumers
        //List<String> names = Arrays.asList("John", "Jane", "Doe");
        //Consumer<String> printConsumer = name -> System.out.println(name);
        //names.forEach(printConsumer);
        
        Consumer<JSONObject> successCallback = (JSONObject json) -> {
            // asserts correct value
            assertEquals("value", json.getJSONObject("root").getString("test"));
            latch.countDown(); // Signal that the operation is complete
        };

        //failing the error callback
        Consumer<Exception> errorCallback = (Exception e) -> fail("Error callback should not be called");

        //perform the asynchronous operation
        XML.toJSONObjectAsync(xmlReader, successCallback, errorCallback);

        //wait for the operation to complete, with a timeout return true if completed within time false otherwise
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
    @Test
    public void testAsyncComplexConversionSuccess() throws InterruptedException {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        StringReader xmlReader = new StringReader(xml);

        //to synchronize the asynchronous operation
        CountDownLatch latch = new CountDownLatch(1);

        //Success Callback
        Consumer<JSONObject> successCallback = (JSONObject json) -> {
            // asserts correct value
            assertEquals("{\"contact\":{\"nick\":\"Crista\",\"address\":{\"zipcode\":92614,\"street\":\"Ave of Nowhere\"},\"name\":\"Crista Lopes\"}}", json.toString());
            latch.countDown(); // Signal that the operation is complete
        };

        //failing the error callback
        Consumer<Exception> errorCallback = (Exception e) -> fail("Error callback should not be called");

        //perform the asynchronous operation
        XML.toJSONObjectAsync(xmlReader, successCallback, errorCallback);

        //wait for the operation to complete, with a timeout return true if completed within time false otherwise
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test
    public void testAsyncConversionFailure() throws InterruptedException {
        // Simulate a scenario that will lead to failure, e.g., invalid XML
        StringReader xmlReader = new StringReader("<root><test>broken</root>"); // Malformed XML

        // Latch for synchronizing the asynchronous operation
        CountDownLatch latch = new CountDownLatch(1);

        // Success Callback (should not be called in this test)
        Consumer<JSONObject> successCallback = (JSONObject json) -> fail("Success callback should not be called");

        // Error Callback
        Consumer<Exception> errorCallback = (Exception e) -> {
            assertNotNull(e);
            latch.countDown(); // Signal that the operation is complete
        };

        // Perform the asynchronous operation
        XML.toJSONObjectAsync(xmlReader, successCallback, errorCallback);

        // Wait for the operation to complete, with a timeout
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
}