/**
 * 
 */
package com.pravin.awssms.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pravin
 *
 */
@RestController
public class MainController {

	@RequestMapping("/hello")
	public String home(){
		return "Hello AWS";
	}
}
