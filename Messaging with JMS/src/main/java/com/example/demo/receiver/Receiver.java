/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.receiver;

import com.example.demo.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <code>Receiver</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/11 10:51
 */
@Component
public class Receiver {

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		System.out.println("Received <" + email + ">");
	}

}
