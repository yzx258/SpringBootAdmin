/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateCoreOrder:function(form,callback){
                Lib.submitForm("/cms/coreOrder/update.json",form,{},callback)
            },
            addCoreOrder:function(form,callback){
                Lib.submitForm("/cms/coreOrder/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/coreOrder/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
		
    };
    exports('coreOrderApi',api);
});