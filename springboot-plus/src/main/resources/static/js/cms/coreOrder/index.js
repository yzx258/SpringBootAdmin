layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var coreOrderTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),coreOrderTable)
            }
        },
        initTable:function(){
            coreOrderTable = table.render({
                elem : '#coreOrderTable',
                height : Lib.getTableHeight(1),
                method : 'post',
                url : Common.ctxPath + '/cms/coreOrder/list.json' // 数据接口
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
                field : 'name', 
                title : 'name',
                width : 100
                }, 
                {
                field : 'age', 
                title : 'age',
                width : 100
                }, 
                {
                field : 'address', 
                title : 'address',
                width : 100
                } 
        
                ] ]
        
            });
            
            table.on('checkbox(coreOrderTable)', function(obj){
                var coreOrder = obj.data;
                if(obj.checked){
                   //按钮逻辑Lib.buttonEnable()
                }else{
                    
                }
             })
        },
        	
        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),coreOrderTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/coreOrder/add.do";
                    Common.openDlg(url,"CoreOrder管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"coreOrderTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/coreOrder/edit.do?id="+data.id;
                    Common.openDlg(url,"CoreOrder管理>"+data.id+">编辑");
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