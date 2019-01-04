$(document).ready(function(){

    function formatDate(date){
        return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
    }

    $("#chart").kendoChart({
        theme:"material",
        title: {
            text: "Kendo Chart Example"
        },
        dataSource : {
            transport:{
                read:{
                    url: "http://localhost:9000/api/pv"
                }
            },
            schema:{
                data: function(response) {
                    return response.ResultList; // twitter's response is { "statuses": [ /* results */ ] }
                },
                model:{
                    fields:{
                        Date:{from:"Date", type:"Date"},
                        PvCount:{from:"PvCount", type:"number"}
                    }
                }
            }
        },

        series:[{
           name:"次数",
           field:"PvCount"
        }],
        categoryAxis: {
            field:"Date",
            labels: {
                rotation: -70
            },
        },
        tooltip:{
            visible:true,
            format:"次数:{0}"
        }
    });


    // var yeardata = [
    //     { text: "黑", value: "1" },
    //     { text: "白", value: "2" },
    //     { text: "灰", value: "3" }
    // ];
    //
    // $("#yearlist").kendoDropDownList({
    //     filter: "startswith",
    //     dataTextField: "text",
    //     dataValueField: "value",
    //     dataSource: yeardata,
    //     index: 0,
    //     change: onChange
    // });
    //
    // function onChange() {
    //     var value = $("#yearlist").val();
    //     alert(value);
    // }
});