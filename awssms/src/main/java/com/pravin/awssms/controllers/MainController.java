/**
 * 
 */
package com.pravin.awssms.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

/**
 * @author pravin
 *
 */
@RestController
public class MainController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/hello")
	public String home(){
		return "Hello AWS";
	}
	
	//@SuppressWarnings("deprecation")
	@RequestMapping("/sendSMS")
	public String sendSms(
			@RequestParam("number") String mobileNumber,
			@RequestParam("message") String message){
		
		//Credentials
		/*
		 * Following environment variables are required
		 *  AWS_REGION
		 *  AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY
		 * */
		AWSCredentialsProvider credentials = new EnvironmentVariableCredentialsProvider();
		
		//create a new SNS client and set endpoint
		AmazonSNS snsClient = 	
				AmazonSNSClientBuilder.standard()
				
				.withCredentials(credentials).build();	                           
		//snsClient.setRegion(Regions.getCurrentRegion());
		
		//Send SMS to a phone
		Map<String, MessageAttributeValue> smsAttributes =
		        new HashMap<String, MessageAttributeValue>();
		smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
		        .withStringValue("mySenderID") //The sender ID shown on the device.
		        .withDataType("String"));
		smsAttributes.put("AWS.SNS.SMS.MaxPrice", new MessageAttributeValue()
		        .withStringValue("0.50") //Sets the max price to 0.50 USD.
		        .withDataType("Number"));
		smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
		        .withStringValue("Promotional") //Sets the type to promotional.
		        .withDataType("String"));
		
		PublishRequest request = new PublishRequest();
		request.withMessage(message);
		request.withPhoneNumber(mobileNumber);
		request.withMessageAttributes(smsAttributes);
		
		PublishResult response = snsClient.publish(request);

		LOGGER.debug(""+response);
		//create a new SNS topic
		/*CreateTopicRequest createTopicRequest = new CreateTopicRequest("MyNewTopic");
		CreateTopicResult createTopicResult = snsClient.pucreateTopic(createTopicRequest);
		//print TopicArn
		LOGGER.debug(""+createTopicResult);
		//get request id for CreateTopicRequest from SNS metadata	
		ResponseMetadata responseMetaData = snsClient.getCachedResponseMetadata(createTopicRequest);
		LOGGER.debug("CreateTopicRequest - " + responseMetaData);*/
		
		return response.toString();
	}
}
