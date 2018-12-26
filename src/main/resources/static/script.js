$(document).ready(function(){
    // var serviceUrl = 'http://localhost:9000/api/values/GetProducts/';
    // var serviceUrl = '/forward/getproducts';
    var serviceUrl = 'http://localhost:9000/api/values/';

    // $("#grid").kendoGrid({
    //
    //     dataSource: {
    //         transport: {
    //             read: {
    //                 url: serviceUrl,
    //
    //             },
    //             parameterMap:function(options, operation){
    //                 return "page=" + options.page + "&pagesize=" + options.pageSize;
    //             }
    //         },
    //         serverPaging:true,
    //         schema: {
    //             data: "ResultList",
    //             total:"total"
    //         }
    //     },
    //     pageable: {
    //         pageSize: 10,
    //         numeric: true,
    //         buttonCount:5,
    //         refresh:true
    //     },
    //
    //     columns: [
    //         {field: "Id", title: "Product Id"},
    //         {field: "Name", title: "Product Name"},
    //         {field: "Remark", title: "Remark"},
    //     ],
    //     scrollable: true,
    //     selectable: "multiple",
    //     toolbar: ["create", "save", "cancel"],
    // });

    sendRequest = function() {
        var method = $('#method').val();

        $.ajax({
            type: method,
            url: serviceUrl,
            dataType:"json"
        }).done(function (data) {
            alert("1");
            alert(data);
            $('#value1').text(data);
        }).error(function (jqXHR, textStatus, errorThrown) {
            alert("2");
            $('#value1').text(jqXHR.responseText || textStatus);
        });
    }
});