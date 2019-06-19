package com.example.demo;

import com.example.demo.service.ImageUploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private ImageUploadService imageUploadService;

	@Test
	public void test() throws Exception {
        imageUploadService.add();
	}

}
