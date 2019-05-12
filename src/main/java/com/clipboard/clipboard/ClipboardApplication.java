package com.clipboard.clipboard;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClipboardApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		 ConfigurableApplicationContext contexto = new SpringApplicationBuilder(ClipboardApplication.class)
        .headless(false)
        .bannerMode(Banner.Mode.OFF)
        .run(args);
	}
	
	 @Override
	    public void run(String... args) throws Exception {
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame();
	            frame.setVisible(true);
	        });
	    }

}
