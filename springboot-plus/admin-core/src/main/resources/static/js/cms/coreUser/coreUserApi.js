/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateCoreUser:function(form,callback){
                Lib.submitForm("/cms/coreUser/update.json",form,{},callback)
            },
            addCoreUser:function(form,callback){
                Lib.submitForm("/cms/coreUser/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/coreUser/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
		
    };
    exports('coreUserApi',api);
});