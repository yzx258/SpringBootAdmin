layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var coreUserTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),coreUserTable)
            }
        },
        initTable:function(){
            coreUserTable = table.render({
                elem : '#coreUserTable',
                height : Lib.getTableHeight(1),
                method : 'post',
                url : Common.ctxPath + '/cms/coreUser/list.json' // 数据接口
                ,page : Lib.tablePage // 开启分页
                ,limit : 10,
                cols : [ [ // 表头
                {
                type : 'checkbox',
                fixed:'left',
                }, 
                {
                field : 'id', 
                title : 'id',
                fixed:'left',
                width : 100
                }, 
                {
                field : 'code', 
                title : 'code',
                width : 100
                }, 
                {
                field : 'name', 
                title : 'name',
                width : 100
                }, 
                {
                field : 'password', 
                title : 'password',
                width : 100
                }, 
                {
                field : 'createTime', 
                title : 'createTime',
                width : 100
                }, 
                {
                field : 'orgId', 
                title : 'orgId',
                width : 100
                }, 
                {
                field : 'state', 
                title : 'state',
                width : 100
                }, 
                {
                field : 'jobType1', 
                title : 'jobType1',
                width : 100
                }, 
                {
                field : 'delFlag', 
                title : 'delFlag',
                width : 100
                }, 
                {
                field : 'updateTime', 
                title : 'updateTime',
                width : 100
                }, 
                {
                field : 'jobType0', 
                title : 'jobType0',
                width : 100
                }, 
                {
                field : 'attachmentId', 
                title : 'attachmentId',
                width : 100
                } 
        
                ] ]
        
            });
            
            table.on('checkbox(coreUserTable)', function(obj){
                var coreUser = obj.data;
                if(obj.checked){
                   //按钮逻辑Lib.buttonEnable()
                }else{
                    
                }
             })
        },
        	
        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),coreUserTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/coreUser/add.do";
                    Common.openDlg(url,"CoreUser管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"coreUserTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/coreUser/edit.do?id="+data.id;
                    Common.openDlg(url,"CoreUser管理>"+data.id+">编辑");
                },
                del : function() { 
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
            };
            $('.ext-toolbar').on('click', function() {
                var type = $(this).data('type');
                toolbar[type] ? toolbar[type].call(this) : '';
            });
        }
	}
    exports('index',view);
	
});