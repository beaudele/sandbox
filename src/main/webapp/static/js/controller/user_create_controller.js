'use strict';

angular.module('myApp').controller('UserCreateController', ['$scope', '$state', 'UserService', function($scope, $state, UserService) {
    var self = this;
    self.user={id:null,username:'',address:'',email:''};

    self.submit = submit;
    self.reset = reset;

    function createUser(user){
        UserService.createUser(user)
            .then(
            function(){},
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
    
    function submit() {
        console.log('Saving New User', self.user);
        createUser(self.user);
        reset();
        $state.go('user_list', {async: null, cache: false});
    }

    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
