package com.ibeetl.admin.core.service;

import java.util.List;

import com.ibeetl.admin.core.dao.CoreOrderDao;
import com.ibeetl.admin.core.entity.CoreOrder;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.core.util.PlatformException;


/**
 * CoreOrder Service
 */

@Service
@Transactional
public class CoreOrderService extends BaseService<CoreOrder>{

    @Autowired private CoreOrderDao coreOrderDao;

    public PageQuery<CoreOrder>queryByCondition(PageQuery query){
        PageQuery ret =  coreOrderDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelCoreOrder(List<Long> ids){
        try {
            coreOrderDao.batchDelCoreOrderByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除CoreOrder失败", e);
        }
    }
}