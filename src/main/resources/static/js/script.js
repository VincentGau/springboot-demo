$(document).ready(function(){
    // var serviceUrl = 'http://localhost:9000/api/values/GetProducts/';
    // var serviceUrl = '/forward/getproducts';
    // var serviceUrl = 'http://localhost:9000/api/values/';
    var serviceUrl = 'http://localhost:9000/api/products/';

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
                total:"RecordCount"
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

    // sendRequest = function() {
    //     var method = $('#method').val();
    //
    //     // $.ajax({
    //     //     type: method,
    //     //     url: serviceUrl,
    //     //     dataType:"json"
    //     // }).done(function (data) {
    //     //     alert("1");
    //     //     alert(data);
    //     //     $('#value1').text(data);
    //     // }).error(function (jqXHR, textStatus, errorThrown) {
    //     //     alert("2");
    //     //     $('#value1').text(jqXHR.responseText || textStatus);
    //     // });
    //
    //     // url1 = 'http://ewealth.abchina.com/insurance/0000000001.htm';
    //     url1 = 'http://ewealth.abchina.com/insurance/1110000001.htm';
    //
    //     $.ajax({
    //         url: url1,
    //         type: 'GET',
    //         dataType:'jsonp',
    //
    //         complete: function(response) {
    //             alert(response.status);
    //             if(response.status == 200) {
    //                 window.open(url1);
    //             } else {
    //                 alert('Invalid');
    //
    //             }
    //         },
    //         error:function (xhr, ajaxOptions, thrownError){
    //             if(xhr.status==404) {
    //                 alert(thrownError);
    //             }
    //         }
    //     });
    //



        // $.ajax({
        //     type:'GET',
        //     url:'http://www.baidu.com',
        //     // dataType:"jsonp",
        //     complete:function(data){
        //       alert(data.status);
        //     },
        //     success:function(res,heads,code){
        //         alert(code.status);
        //     },
        //     error:function(){
        //         alert("WWWW");
        //     }
        // })

});