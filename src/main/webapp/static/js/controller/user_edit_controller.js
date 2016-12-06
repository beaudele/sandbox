'use strict';

angular.module('myApp').controller('UserEditController', ['$scope', '$state', 'async', 'UserService', function($scope, $state, async, UserService) {
    var self = this;
    
    self.user=async;

    self.submit = submit;
    self.reset = reset;

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            function(){$state.go('user_list');},
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function submit() {
        updateUser(self.user, self.user.id);
        console.log('User updated with id ', self.user.id);
        reset();
    }

    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
