package org.rigelos.discuss.web.controllers;

import java.util.List;

import org.json.JSONObject;
import org.rigelos.discuss.model.Topic;
import org.rigelos.discuss.model.TopicFilter;
import org.rigelos.discuss.util.JSONUtils;
import org.rigelos.discuss.util.PageInfo;
import org.rigelos.discuss.util.PageInfoBuilder;
import org.rigelos.discuss.util.ResponseBuilder;
import org.rigelos.discuss.util.ResponseResult;
import org.springframework.web.bind.ServletRequestUtils;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

@Path("/")
public class IndexController extends AbstractCommonController {

	private static int PAGE_SIZE = 20;

	@Get("")
	public String root(Invocation inv){
		return index(inv);
	}

	@Get("index.html")
	public String index(Invocation inv){
		int page = ServletRequestUtils.getIntParameter(inv.getRequest(), "page", 1);
		TopicFilter filter = new TopicFilter();
		List<Topic> topicList = topicImpl.select(filter, page, PAGE_SIZE);
		inv.addModel("topicList", topicList);
		
		int total = topicImpl.getCount(filter);
        PageInfo pageInfo = PageInfoBuilder.build("index.html", total, page, PAGE_SIZE);
        inv.addModel("pageInfo", pageInfo);
		return "index";
	}

	@Get("topic-{topicId:[0-9]+}.html")
	public String topic(@Param("topicId") long topicId, Invocation inv){
		Topic topic = topicImpl.getTopicById(topicId);
		inv.addModel("topic", topic);
		return "topic";
	}

	@Post("addTopic.do")
	public JSONObject addTopic(Topic topic, Invocation inv){
		JSONObject data = new JSONObject();
		
		try{
		    long ret = topicImpl.add(topic);
		    JSONUtils.put(data, "topicId", ret);
		}catch(Exception e){
			logger.error("",  e);
			return ResponseBuilder.build(ResponseResult.ERROR, null);
		}
		return ResponseBuilder.build(ResponseResult.OK, data);
	}
}