layui.define([ 'form', 'laydate', 'table','coreOrderApi'], function(exports) {
    var form = layui.form;
    var coreOrderApi = layui.coreOrderApi;
    var index = layui.index;
    var view = {
        init:function(){
	        Lib.initGenrealForm($("#updateForm"),form);
	        this.initSubmit();
        },
        initSubmit:function(){
            $("#updateButton").click(function(){
                form.on('submit(form)', function(){
                    coreOrderApi.updateCoreOrder($('#updateForm'),function(
                       parent.window.dataReload();
                       Common.info("更新成功");
                       Lib.closeFrame();
                    });
                });
            });
            $("#updateButton-cancel").click(function(){
                Lib.closeFrame();
            });
            
    }
    exports('edit',view);
	
});