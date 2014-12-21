package org.rigelos.discuss.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rigelos.discuss.dao.TopicDAO;
import org.rigelos.discuss.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicImpl {
    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private TopicDAO topicDAO;

    public int remove(long topicId) {
        return topicDAO.remove(topicId);
    }
    public List<Topic> select(Topic topic, int page, int size){
        if(page<=0)
            page = 1;
        int offset = (page-1)*size;
        return topicDAO.select(topic, offset, size);
    }
    
    public int getCount(Topic topic){
        return topicDAO.getCount(topic);
    }

    public int add(Topic topic) {
        if(topic==null)
            return 0;
        return topicDAO.add(topic);
    }

    public int update(Topic topic) {
        if(topic==null)
            return 0;

        return topicDAO.update(topic);
    }

    public Topic getTopicById(long topicId) {
        Topic topic = topicDAO.get(topicId);
        if(topic == null){
            topic = new Topic();
        }
        return topic;
    }
}
