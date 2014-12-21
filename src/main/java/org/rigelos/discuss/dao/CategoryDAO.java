package org.rigelos.discuss.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import org.rigelos.discuss.model.Category;

@DAO
public interface CategoryDAO {
    public static final String TABLE = " category ";
    public static final String FIELDS = " categoryId,name,color,description,textColor,position,createdTime,updatedTime,status ";
    public static final String FIELDS_REPLACE = " (" + FIELDS + ") ";

    @SQL("update " + TABLE + " set status=0 where categoryId=:categoryId and status=1")
    public int remove(@SQLParam("categoryId") long categoryId);

    @SQL("select " + FIELDS + " from " + TABLE + " where status=1 " +
         "#if(:size>0){ limit :offset,:size}")
    public List<Category> select(@SQLParam("category") Category category, @SQLParam("offset") int offset, @SQLParam("size") int size);

    @SQL("select count(*) from " + TABLE + " where status=1 ")
    public int getCount(@SQLParam("category") Category category);

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE + FIELDS_REPLACE + " values()")
    public int add(@SQLParam("category") Category category);

    @SQL("update " + TABLE + " ")
    public int update(@SQLParam("category") Category category);

    @SQL("select " + FIELDS +" from " + TABLE + " where status=1 and categoryId=:categoryId")
    public Category get(@SQLParam("categoryId") long categoryId);
}
