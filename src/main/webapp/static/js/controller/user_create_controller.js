'use strict';

angular.module('myApp').controller(
        'UserCreateController',
        ['$scope', '$state', 'UserService',
            function($scope, $state, UserService) {
              var self = this;
              self.user = {
                id: null,
                username: '',
                address: '',
                email: ''
              };

              self.submit = submit;
              self.reset = reset;

              function createUser(user) {
                UserService.createUser(user).then(function() {
                  $state.go('user_list');
                }, function(errResponse) {
                  console.error('Error while creating User');
                });
              }

              function submit() {
                console.log('Saving New User', self.user);
                createUser(self.user);
                reset();
              }

              function reset() {
                self.user = {
                  id: null,
                  username: '',
                  address: '',
                  email: ''
                };
                $scope.myForm.$setPristine(); // reset Form
              }

            }]);
