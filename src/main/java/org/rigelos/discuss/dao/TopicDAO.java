package org.rigelos.discuss.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import org.rigelos.discuss.model.Topic;
import org.rigelos.discuss.model.TopicFilter;

@DAO
public interface TopicDAO {
    public static final String TABLE = " topic ";
    public static final String FIELDS = " topicId,title,content,categoryId,userId,posts,views,likes,createTime,updateTime,status ";
    public static final String FIELDS_REPLACE = " (" + FIELDS + ") ";

    @SQL("update " + TABLE + " set status=0 where topicId=:topicId and status=1")
    public int remove(@SQLParam("topicId") long topicId);

    @SQL("select " + FIELDS + " from " + TABLE + " where status=1 order by updateTime desc " +
         "#if(:size>0){ limit :offset,:size}")
    public List<Topic> select(@SQLParam("filter") TopicFilter filter, @SQLParam("offset") int offset, @SQLParam("size") int size);

    @SQL("select count(*) from " + TABLE + " where status=1 ")
    public int getCount(@SQLParam("filter") TopicFilter filter);

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE + FIELDS_REPLACE + " values(:topic.topicId,:topic.title,:topic.content,:topic.categoryId,:topic.userId,:topic.posts,:topic.views,:topic.likes,now(),now(),1)")
    public int add(@SQLParam("topic") Topic topic);

    @SQL("update " + TABLE + " set title=:topic.title,content=:topic.content,categoryId=:topic.categoryId,userId=:topic.userId,posts=:topic.posts,views=:topic.views,likes=:topic.likes,createTime=:topic.createTime,updateTime=:topic.updateTime,status=:topic.status where topicId=:topic.topicId")
    public int update(@SQLParam("topic") Topic topic);

    @SQL("select " + FIELDS +" from " + TABLE + " where status=1 and topicId=:topicId")
    public Topic get(@SQLParam("topicId") long topicId);
}
