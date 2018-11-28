package com.ibeetl.cms.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.ibeetl.cms.entity.*;

/**
 * CoreOrder Dao
 */
@SqlResource("cms.coreOrder")
public interface CoreOrderDao extends BaseMapper<CoreOrder>{
    public PageQuery<CoreOrder> queryByCondition(PageQuery query);
    public void batchDelCoreOrderByIds( List<Long> ids);
}