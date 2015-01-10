package org.rigelos.discuss.web.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rigelos.discuss.service.CategoryImpl;
import org.rigelos.discuss.service.TopicImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCommonController {
	protected Log  logger = LogFactory.getLog(getClass());
	
	@Autowired
	protected TopicImpl topicImpl;
	
	@Autowired
	protected CategoryImpl categoryImpl;
}
