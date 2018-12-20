$(document).ready(function(){
    // $("#grid").kendoGrid({
    //     sortable:true,
    //     columns: [{
    //         field: "FirstName",
    //         title: "First Name"
    //     },
    //         {
    //             field: "LastName",
    //             title: "Last Name"
    //         }],
    //     dataSource: {
    //         data: [{
    //             FirstName: "Joe",
    //             LastName: "Smith"
    //         },
    //             {
    //                 FirstName: "Jane",
    //                 LastName: "Smith"
    //             }]
    //     }
    // });

    // var dataSource = new kendo.data.DataSource({
    //     transport: {
    //         read:  {
    //             url: "http://localhost:9000/api/values/GetProducts/",
    //             dataType: "json" // "jsonp" is required for cross-domain requests; use "json" for same-domain requests
    //         }
    //     }
    // });
    // dataSource.fetch(function(){
    //     var data = dataSource.data();
    //     console.log(data.length);  // displays "77"
    //     console.log(data[0].ProductName); // displays "Chai"
    // });

    var serviceUrl = 'http://localhost:9000/api/values/GetProducts/';

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