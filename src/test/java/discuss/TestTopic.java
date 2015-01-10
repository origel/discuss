package discuss;

import java.util.List;

import org.rigelos.discuss.dao.TopicDAO;
import org.rigelos.discuss.model.Topic;
import org.rigelos.discuss.model.TopicFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTopic {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		TopicDAO topicDao = context.getBean(TopicDAO.class);
		
		for(int i=0;i<200;i++){
			Topic tpc = new Topic();
			tpc.setTitle("这是一个标题" + i);
			tpc.setContent("这是帖子内容");
			//topicDao.add(tpc);
		}
		
		List<Topic> topicList = topicDao.select(new TopicFilter(), 1, 200);
		for(Topic tpc:topicList){
			System.out.println(tpc.getTitle());
		}
	}
}
