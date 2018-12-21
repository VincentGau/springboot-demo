$(document).ready(function(){
    var serviceUrl = 'http://localhost:9000/api/values/GetProducts/';
    // var serviceUrl = '/forward/getproducts';

    $("#grid").kendoGrid({

        dataSource: {
            transport: {
                read: {
                    url: serviceUrl,

                },
                parameterMap:function(options, operation){
                    return "page=" + options.page + "&pagesize=" + options.pageSize;
                }
            },
            serverPaging:true,
            schema: {
                data: "ResultList",
                total:"total"
            }
        },
        pageable: {
            pageSize: 10,
            numeric: true,
            buttonCount:5,
            refresh:true
        },

        columns: [
            {field: "Id", title: "Product Id"},
            {field: "Name", title: "Product Name"},
            {field: "Remark", title: "Remark"},
        ],
        scrollable: true,
        selectable: "multiple",
        toolbar: ["create", "save", "cancel"],
    });
});