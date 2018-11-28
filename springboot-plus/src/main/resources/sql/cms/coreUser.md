queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from core_user t
    where 1=1  
    @//数据权限，该sql语句功能点  
    and #function("coreUser.query")#
    
    
    

batchDelCoreUserByIds
===

* 批量逻辑删除

    update core_user set del_flag = 1 where ID  in( #join(ids)#)
    
