package org.rigelos.discuss.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import org.rigelos.discuss.model.Setting;

@DAO
public interface SettingDAO {
    public static final String TABLE = "<>";
    public static final String FIELDS = " name,dataType,value,createTime,updateTime,status ";
    public static final String FIELDS_REPLACE = " (" + FIELDS + ") ";

    @SQL("update " + TABLE + " set status=0 where SettingId=:SettingId and status=1")
    public int remove(@SQLParam("SettingId") long SettingId);

    @SQL("select " + FIELDS + " from " + TABLE + " where status=1 " +
         "#if(:size>0){ limit :offset,:size}")
    public List<Setting> select(@SQLParam("Setting") Setting Setting, @SQLParam("offset") int offset, @SQLParam("size") int size);

    @SQL("select count(*) from " + TABLE + " where status=1 ")
    public int getCount(@SQLParam("Setting") Setting Setting);

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE + FIELDS_REPLACE + " values(:setting.name,:setting.dataType,:setting.value,:setting.createTime,:setting.updateTime,:setting.status)")
    public int add(@SQLParam("Setting") Setting Setting);

    @SQL("update " + TABLE + " set dataType=:setting.dataType,value=:setting.value,createTime=:setting.createTime,updateTime=:setting.updateTime,status=:setting.status where name=:setting.name")
    public int update(@SQLParam("Setting") Setting Setting);

    @SQL("select " + FIELDS +" from " + TABLE + " where status=1 and SettingId=:SettingId")
    public Setting get(@SQLParam("SettingId") long SettingId);
}