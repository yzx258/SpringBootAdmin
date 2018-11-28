package com.ibeetl.cms.service;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.core.util.PlatformException;

import com.ibeetl.cms.dao.CoreUserDao;
import com.ibeetl.cms.entity.CoreUser;
import com.ibeetl.admin.core.service.BaseService;

/**
 * CoreUser Service
 */

@Service
@Transactional
public class CoreUserService extends BaseService<CoreUser>{

    @Autowired private CoreUserDao coreUserDao;

    public PageQuery<CoreUser>queryByCondition(PageQuery query){
        PageQuery ret =  coreUserDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelCoreUser(List<Long> ids){
        try {
            coreUserDao.batchDelCoreUserByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除CoreUser失败", e);
        }
    }
}