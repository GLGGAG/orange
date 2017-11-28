package com.orange;

import com.orange.config.OrangeBootBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author GLGGAG
 */
@SpringBootApplication
public class OrangeApplication {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OrangeApplication.class);
        app.setBanner(new OrangeBootBanner());
        //关闭Banner图
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
}
