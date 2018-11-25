var app = angular.module('myApp', []);

app.controller('BookingController', function($scope, $http) {

    $scope.getAll = function(){
        $http.get("/bookings/all").then(function(response){
            $scope.bookings = response.data;
        });
    };


    $scope.getAffordable = function(){
        $http.get("/bookings/affordable/1101").then(function(response){
            $scope.bookings = response.data;
        });
    };

    $scope.deleteBooking = function(id){
        $http.post("/bookings/delete/" + id).then(function(response){
            $scope.bookings = response.data;
        });
    };


    $scope.getAll();

});