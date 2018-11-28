package com.ibeetl.cms.web.query;

import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *CoreOrder查询
 */
public class CoreOrderQuery extends PageParam {
    @Query(name = "id", display = true)        
    private Integer id;
    public Integer getId(){
        return  id;
    }
    public void setId(Integer id ){
        this.id = id;
    }
 
}
