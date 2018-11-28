package com.ibeetl.cms.web.query;

import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *CoreUser查询
 */
public class CoreUserQuery extends PageParam {
    @Query(name = "id", display = true)        
    private Integer id;
    public Integer getId(){
        return  id;
    }
    public void setId(Integer id ){
        this.id = id;
    }
 
}
