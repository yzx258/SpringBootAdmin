layui.define(['table', 'coreOrderApi'], function(exports) {
    var coreOrderApi = layui.coreOrderApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"coreOrderTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些CoreOrder?",function(){
            var ids =Common.concatBatchId(data,"id");
            coreOrderApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});