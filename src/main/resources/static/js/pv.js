$(document).ready(function(){
    // var ranges = [{
    //     from: 0,
    //     to: 30,
    //     color: "#F97172"
    // }, {
    //     from: 30,
    //     to: 60,
    //     color: "#FADE71"
    // }, {
    //     from: 60,
    //     to: 100,
    //     color: "#67DF65"
    // }];
    //
    //
    //
    // $(".js-gauge").kendoRadialGauge({
    //     theme: 'metro',
    //     pointer: {
    //         value: 50,
    //         cap: {
    //             size: 0.1,
    //             color: "black"
    //         }
    //     },
    //     scale: {
    //         minorUnit: 20,
    //         majorTicks: {
    //             size: 3
    //         },
    //         startAngle: -10,
    //         endAngle: 190,
    //         max: 100,
    //         labels: {
    //             visible: true,
    //             position: "inside",
    //         },
    //         rangeSize: 10,
    //         ranges: ranges
    //     }
    // });
    //
    // $("#chart").kendoChart({
    //     theme: 'metro',
    //     legend: {
    //         position: "top"
    //     },
    //     seriesDefaults: {
    //         type: "column"
    //     },
    //     series: [{
    //         name: "Accomplishment",
    //         color: "#67DF65",
    //         axis: "number",
    //         data: [3.907, 7.943, 7.848, 9.284, 9.263, 9.801, 3.890, 8.238, 9.552, 6.855],
    //         tooltip: {
    //             visible: true,
    //             format: "{0:p1}",
    //             template: "#= series.name #: #= kendo.toString(value,'n2') #"
    //         }
    //     }, {
    //         type: "line",
    //         color: "#B565DF",
    //         axis: "percent",
    //         name: "Validated Pipeline Coverage Ratio",
    //         data: [0.988, 0.733, 0.994, 0.464, 0.52, 0.939, 0.333, 0.245, 0.339, 0.727],
    //         tooltip: {
    //             visible: true,
    //             format: "{0:p1}",
    //             template: "#= series.name #: #= kendo.toString(value,'p2') #"
    //         }
    //     }],
    //     valueAxis: [{
    //         name: 'number',
    //         labels: {
    //             format: "{0:n1}"
    //         },
    //         line: {
    //             visible: false
    //         }
    //     }, {
    //         name: 'percent',
    //         labels: {
    //             format: "{0:p1}"
    //         },
    //         line: {
    //             visible: false
    //         }
    //     }],
    //     categoryAxis: {
    //         categories: ['Papua New Guinea Rep Office', 'Papua New Guinea Rep Office', 'Papua New Guinea Rep Office', 'Papua New Guinea Rep Office', 'Validated Pipeline Coverage Ratio', 'Validated Pipeline Coverage Ratio', 'Validated Pipeline Coverage Ratio', 'Validated Pipeline Coverage Ratio', 'Validated Pipeline Coverage Ratio', 'Validated Pipeline Coverage Ratio'],
    //         line: {
    //             visible: true
    //         },
    //         labels: {
    //             rotation: -75
    //         },
    //         axisCrossingValues: [0, 10]
    //     },
    //     tooltip: {
    //     }
    // });

    // var ds = new kendo.data.DataSource({
    //     transport:{
    //         read:{
    //             url: "http://localhost:9000/api/pv",
    //         }
    //     },
    //     schema:{
    //         date:"ResultList",
    //         // model:{
    //         //     fields:{
    //         //         date:{from:"date", type:"Date"},
    //         //         count:{from:"pvcount", type:"number"}
    //         //     }
    //         // }
    //     }
    // });
    //
    // $("#chart").kendoChart({
    //     theme:"material",
    //     title: {
    //         text: "Kendo Chart Example"
    //     },
    //     dataSource : ds,
    //     categoryAxis: {
    //         labels: {
    //             rotation: 70
    //         },
    //     }
    // });

    var yeardata = [
        { text: "黑", value: "1" },
        { text: "白", value: "2" },
        { text: "灰", value: "3" }
    ];

    $("#yearlist").kendoDropDownList({
        filter: "startswith",
        dataTextField: "text",
        dataValueField: "value",
        dataSource: yeardata,
        index: 0,
        change: onChange
    });

    function onChange() {
        var value = $("#yearlist").val();
        alert(value);
    }
});