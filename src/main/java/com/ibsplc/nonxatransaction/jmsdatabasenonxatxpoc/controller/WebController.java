package com.ibsplc.nonxatransaction.jmsdatabasenonxatxpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibsplc.nonxatransaction.jmsdatabasenonxatxpoc.model.Edifact;
import com.ibsplc.nonxatransaction.jmsdatabasenonxatxpoc.repository.EdifactRepository;

@RestController
public class WebController {

	@Autowired
	EdifactRepository edifactRepository;

	@Autowired
	JmsTemplate jmsTemplate;

	@RequestMapping(value = "/send")
	public Object send(@RequestParam(required = true) String pnr, @RequestParam(required = true) String edifactMsg,
			@RequestParam(required = true) long pollStatus) {

		Edifact edifact = new Edifact();
		edifact.setPnr(pnr);
		edifact.setEdifactRaw(edifactMsg);
		edifact.setPollStatus(pollStatus);

		try {
			ObjectMapper mapper = new ObjectMapper();
			String edifactJson = mapper.writeValueAsString(edifact);
			edifact.setEifactJson(edifactJson);

			edifactRepository.save(edifact);
			jmsTemplate.convertAndSend("notification.queue", edifactJson );
		} catch (Exception ex) {
			System.err.println();
			return "not ok ->" + ex.getMessage();
		}

		return "ok";
	}

}
