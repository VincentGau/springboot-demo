$(document).ready(function(){
    $("#grid").kendoGrid({
        sortable:true,
        columns: [{
            field: "FirstName",
            title: "First Name"
        },
            {
                field: "LastName",
                title: "Last Name"
            }],
        dataSource: {
            data: [{
                FirstName: "Joe",
                LastName: "Smith"
            },
                {
                    FirstName: "Jane",
                    LastName: "Smith"
                }]
        }
    });
});