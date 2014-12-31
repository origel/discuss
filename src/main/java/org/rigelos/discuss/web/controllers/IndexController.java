package org.rigelos.discuss.web.controllers;

import java.util.List;

import org.json.JSONObject;
import org.rigelos.discuss.model.Topic;
import org.rigelos.discuss.model.TopicFilter;
import org.rigelos.discuss.util.JSONUtils;
import org.rigelos.discuss.util.PageInfo;
import org.rigelos.discuss.util.PageInfoBuilder;
import org.springframework.web.bind.ServletRequestUtils;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("/")
public class IndexController extends AbstractCommonController {

	private static int PAGE_SIZE = 20;
	@Get("")
	public String index(Invocation inv){
		int page = ServletRequestUtils.getIntParameter(inv.getRequest(), "page", 1);
		TopicFilter filter = new TopicFilter();
		List<Topic> topicList = topicImpl.select(filter, 1, PAGE_SIZE);
		inv.addModel("topicList", topicList);
		
		int total = topicImpl.getCount(filter);
        PageInfo pageInfo = PageInfoBuilder.build("admin/product/list.html", total, page, PAGE_SIZE);
        inv.addModel("pageInfo", pageInfo);
		return "index";
	}
	
	@Get("topics")
	public JSONObject topics(TopicFilter filter, Invocation inv){
		JSONObject result = new JSONObject();
		List<Topic> topicList = topicImpl.select(filter, 1, PAGE_SIZE);
		int total = topicImpl.getCount(filter);
		JSONUtils.put(result, "total", total);
		JSONUtils.put(result, "topicList", topicList);
		return result;
	}

	@Get("topic-{topicId:[0-9]+}.html")
	public String topic(@Param("topicId") long topicId, Invocation inv){
		inv.addModel("topicId", topicId);
		return "topic";
	}

	public JSONObject addTopic(Topic topic, Invocation inv){
		JSONObject result = new JSONObject();
		
		topicImpl.add(topic);
		long ret = topicImpl.add(topic);
		return result;
	}
}