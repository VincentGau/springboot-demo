$(document).ready(function(){
    var serviceUrl = 'http://localhost:9000/api/values/GetProducts/';

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
            buttonCount:1,
            refresh:true
        },

        columns: [
            {field: "Id", title: "Product Id"},
            {field: "Name", title: "Product Name"},
            {field: "Remark", title: "Remark"},
        ],
        // height: 500,
        scrollable: true,
        selectable: "multiple",
        toolbar: ["create", "save", "cancel"],
    });



    // var serviceUrl = 'http://localhost:9000/api/values/GetProducts/';
    //
    sendRequest = function() {
        var method = $('#method').val();

        $.ajax({
            type: method,
            url: serviceUrl
        }).done(function (data) {
            $('#value1').text(data);
        }).error(function (jqXHR, textStatus, errorThrown) {
            $('#value1').text(jqXHR.responseText || textStatus);
        });
    }

});