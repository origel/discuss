package org.rigelos.discuss.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import org.rigelos.discuss.model.User;

@DAO
public interface UserDAO {
    public static final String TABLE = "<>";
    public static final String FIELDS = "<>";
    public static final String FIELDS_REPLACE = " (" + FIELDS + ") ";

    @SQL("update " + TABLE + " set status=0 where userId=:userId and status=1")
    public int remove(@SQLParam("userId") long userId);

    @SQL("select " + FIELDS + " from " + TABLE + " where status=1 " +
         "#if(:size>0){ limit :offset,:size}")
    public List<User> select(@SQLParam("user") User user, @SQLParam("offset") int offset, @SQLParam("size") int size);

    @SQL("select count(*) from " + TABLE + " where status=1 ")
    public int getCount(@SQLParam("user") User user);

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE + FIELDS_REPLACE + " values()")
    public int add(@SQLParam("user") User user);

    @SQL("update " + TABLE + " ")
    public int update(@SQLParam("user") User user);

    @SQL("select " + FIELDS +" from " + TABLE + " where status=1 and userId=:userId")
    public User get(@SQLParam("userId") long userId);
}
