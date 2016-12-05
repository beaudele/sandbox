'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'async', 'UserService', function($scope, async, UserService) {
    var self = this;
    self.users=async;

    self.remove = remove;
    
    fetchAllUsers();

    function fetchAllUsers(){
        console.log('fetch all users');
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;                 
                for(var i =0 ; i < d.length ; i++) {
                	var d_tmp = d[i];
                	console.log(d_tmp.address);
                }

            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
    
    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function remove(id){ 
        console.log('id to be deleted', id);
        deleteUser(id);
    }

}]);
