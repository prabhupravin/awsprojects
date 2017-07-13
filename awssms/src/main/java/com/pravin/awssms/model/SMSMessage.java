/**
 * 
 */
package com.pravin.awssms.model;

import lombok.Data;

/**
 * @author pravin
 *
 */
@Data
public class SMSMessage {

	private String isdcode;
	
	private String mobileNumber;
	
	private String message;
}
