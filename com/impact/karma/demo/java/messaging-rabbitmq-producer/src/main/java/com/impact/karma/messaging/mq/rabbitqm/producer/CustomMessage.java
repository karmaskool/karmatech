package com.impact.karma.messaging.mq.rabbitqm.producer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {

	private String id;
	private String content;
	private Date dateTime;
}
