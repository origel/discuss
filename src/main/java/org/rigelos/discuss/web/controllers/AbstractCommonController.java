package org.rigelos.discuss.web.controllers;

import org.rigelos.discuss.service.CategoryImpl;
import org.rigelos.discuss.service.TopicImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCommonController {

	@Autowired
	protected TopicImpl topicImpl;
	
	@Autowired
	protected CategoryImpl categoryImpl;
}
