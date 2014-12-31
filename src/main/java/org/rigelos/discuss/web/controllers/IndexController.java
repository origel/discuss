package org.rigelos.discuss.web.controllers;

import org.json.JSONObject;
import org.rigelos.discuss.model.Topic;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("/")
public class IndexController extends AbstractCommonController {

	@Get("")
	public String index(Invocation inv){
		return "index";
	}
	
	@Get("topic-{topicId:[0-9]+}.html")
	public String topic(@Param("topicId") int topicId, Invocation inv){
		return "topic";
	}
	
	public JSONObject addTopic(Topic topic, Invocation inv){
		JSONObject result = new JSONObject();
		
		long ret = topicImpl.add(topic);
		return result;
	}
}