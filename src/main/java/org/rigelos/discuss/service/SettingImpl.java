package org.rigelos.discuss.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rigelos.discuss.dao.SettingDAO;
import org.rigelos.discuss.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingImpl {
    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private SettingDAO SettingDAO;

    public int remove(long SettingId) {
        return SettingDAO.remove(SettingId);
    }
    public List<Setting> select(Setting Setting, int page, int size){
        if(page<=0)
            page = 1;
        int offset = (page-1)*size;
        return SettingDAO.select(Setting, offset, size);
    }
    
    public int getCount(Setting Setting){
        return SettingDAO.getCount(Setting);
    }

    public int add(Setting Setting) {
        if(Setting==null)
            return 0;
        return SettingDAO.add(Setting);
    }

    public int update(Setting Setting) {
        if(Setting==null)
            return 0;

        return SettingDAO.update(Setting);
    }

    public Setting getSettingById(long SettingId) {
        Setting Setting = SettingDAO.get(SettingId);
        if(Setting == null){
            Setting = new Setting();
        }
        return Setting;
    }
}