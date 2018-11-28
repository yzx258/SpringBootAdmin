queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from core_order t
    where 1=1  
    @//数据权限，该sql语句功能点  
    and #function("coreOrder.query")#
    
    
    

batchDelCoreOrderByIds
===

* 批量逻辑删除

    update core_order set del_flag = 1 where id  in( #join(ids)#)
    
