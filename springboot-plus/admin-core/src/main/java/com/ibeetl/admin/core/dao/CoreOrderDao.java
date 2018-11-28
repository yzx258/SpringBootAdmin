package com.ibeetl.admin.core.dao;

import java.util.List;

import com.ibeetl.admin.core.entity.CoreOrder;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;


/**
 * CoreOrder Dao
 */
@SqlResource("cms.coreOrder")
public interface CoreOrderDao extends BaseMapper<CoreOrder>{
    public PageQuery<CoreOrder> queryByCondition(PageQuery query);
    public void batchDelCoreOrderByIds(List<Long> ids);
}