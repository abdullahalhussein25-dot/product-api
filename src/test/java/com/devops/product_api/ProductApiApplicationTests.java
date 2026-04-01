package com.devops.product_api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductApiApplicationTests {

    @Test
    void testHello() {
        HelloController controller = new HelloController();
        String result = controller.hello();
        assertEquals("Hello DevOps CI/CD Pipeline10", result);
    } 

    @Test
    void testStatus() {
        HelloController controller = new HelloController();
        String result = controller.status();
        assertEquals("Application 8", result);
    } 
}
