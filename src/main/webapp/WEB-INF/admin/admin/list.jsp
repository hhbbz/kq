<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>
        管理员管理
    </title>
    <meta charset="utf-8">
    <%@ include file="../se7en_css.jsp" %>

    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
</head>
<body>
<div class="modal-shiftfix">
    <!-- Navigation -->
    <%@ include file="../navigation.jsp" %>
    <div class="alert alert-success " hidden="hidden" id="msg" role="alert">
       <p> 提示:</p>
    </div>
    <!-- End Navigation -->
    <div class="container-fluid main-content">
        <!-- DataTables Example -->
        <div class="row">
            <div class="col-lg-12">
                <div class="widget-container fluid-height clearfix">
                    <div class="heading">
                        <i class="icon-table"></i>管理员管理<a class="btn btn-sm btn-primary-outline pull-right" href="${pageContext.request.contextPath}/admin/user/addUI" ><i class="icon-plus"></i>添加</a>
                    </div>
                    <div class="widget-content padded clearfix">
                        <table class="table table-bordered table-striped" id="datatable-editable">
                            <thead>
                            <th width="200px"> 账号名</th>
                            <th width="150px">操作</th>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- end DataTables Example -->
    </div>
</div>
<%@ include file="../se7en_js.jsp" %>
<script type="text/javascript">
    $(document).ready(function() {
        $("#user_page").addClass("current");
        var oTable= $("#datatable-editable").dataTable({
            "bProcessing": true, // 是否显示取数据时的那个等待提示
            "bServerSide": true,//这个用来指明是通过服务端来取数据
            "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
            "iDisplayLength": 10,//每页显示10条数据
            "sAjaxSource": "${pageContext.request.contextPath}/rest/admin/user/dataTable",//这个是请求的地址
            "fnServerData": retrieveData ,
            "oLanguage" : { // 汉化
                "sProcessing" : "正在加载数据...",
                "sLengthMenu" : "显示_MENU_条 ",
                "sZeroRecords" : "没有您要搜索的内容",
                "sInfo" : "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                "sInfoEmpty" : "记录数为0",
                "sInfoFiltered" : "(全部记录数 _MAX_  条)",
                "sInfoPostFix" : "",
                "sSearch" : "搜索",
                "sUrl" : "",
                "oPaginate" : {
                    "sFirst" : "第一页",
                    "sPrevious" : " 上一页 ",
                    "sNext" : " 下一页 ",
                    "sLast" : " 最后一页 "
                    }
            },
            "aoColumns":
                    [
                        { "mData": "username", 'sClass':'center'},
                        {
                            "mDataProp": "id",
                            "bSearchable": false,
                            "bSortable": false,
                            "fnRender": function(obj) {
                                var id=obj.aData.id;
                                var render=  '<a target="_blank"  href="${pageContext.request.contextPath}/admin/user/show/'+id+'"><i class="icon-search"></i>查看</a>';
                                render += '&nbsp;/&nbsp;';
                                render +=  '<a class="delete-row" href="#" name='+id+'><i class="icon-remove"></i>删除</a>';
                                return render;
                             }
                        }

                    ]
        });

// 3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
        function retrieveData( sSource111,aoData111, fnCallback111) {
                var arrayObj=new Array(
                        { "mData": "username", 'sClass':'center'},
                        { "mData": "id", 'sClass':'center'});
                var searchtext="";
                var sort="";
                var order="";
                var pageOffset=0;
                var size=10;
                var sEcho=0;
                for(var i=0;i<aoData111.length;i++){
                    var value=aoData111[i].value;
                    if(aoData111[i].name=="iSortCol_0"){
                        sort=arrayObj[value].mData;
                    }
                    if(aoData111[i].name=="sSortDir_0"){
                        order=value;
                    }
                    if(aoData111[i].name=="sSearch"){
                        searchtext=value;
                    }
                    if(aoData111[i].name=="iDisplayStart"){
                        pageOffset=value
                    }
                    if(aoData111[i].name=="iDisplayLength"){
                        size=value
                    }
                    if(aoData111[i].name=="sEcho"){
                        sEcho=value;
                    }

                }
            var page=Math.floor(pageOffset/size)+1;
            $.ajax({
                url : sSource111,//这个就是请求地址对应sAjaxSource
                data :{"sort":sort,"order":order,"offset":pageOffset,"pageSize":size,"searchText":searchtext,"pageNo":page,"sEcho":sEcho},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                type : 'post',
                dataType : 'json',
                async : false,
                success : function(result) {
                    console.info(result)
                    fnCallback111(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                },
                error : function(msg) {
                }
            });
        }
        var nEditing = null;

        $('#datatable-editable').on('click', 'a.delete-row', function (e) {
            var id=$(this).attr("name");
            var nRow = $(this).parents('tr')[0];
            $.post("${pageContext.request.contextPath}/admin/user/delete/"+id, function(result){
                if(result.success){
                    oTable.fnDeleteRow( nRow );
                    $("#msg >p").text("提示:"+result.msg);
                    $("#msg").removeAttrs("hidden");
                }else{
                    $("#msg >p").text("提示:"+result.msg);
                    $("#msg").removeAttrs("hidden");
                }
                setTimeout(function(){    //设时延迟0.5s执行
                    $("#msg").attr("hidden","hidden");
                },5000)
            },"json");
        } );

    });
</script>
<c:if test="${msg!=null}">
    <script type="application/javascript">
        $().ready(function(){
            var result=${msg};
            if(result){
                $("#msg >p").text("提示:"+result.msg);
                $("#msg").removeAttrs("hidden");
            }
            setTimeout(function(){    //设时延迟0.5s执行
                $("#msg").attr("hidden","hidden");
            },5000)
        })
    </script>
</c:if>
</body>
</html>