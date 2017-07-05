/**
 * 
 */
package com.pravin.awssms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author pravin
 *
 */
@EnableAutoConfiguration
@ComponentScan("com.pravin.awssms")
public class Main {

	public static void main(String[] args){
		SpringApplication.run(Main.class,args);
	}
}
