angular.module('myApp').config(
        function($stateProvider, $urlRouterProvider) {
          $urlRouterProvider.otherwise("/user_list")
          $stateProvider.state('user_list', {
            url: '/user_list',
            cache: false,
            templateUrl: 'user_list',
            controller: "UserController",
            controllerAs: "ctrl",
            resolve: {
              async: ['UserService', function(UserService) {
                return UserService.fetchAllUsers();
              }]
            }
          }).state('user_registration_form', {
            url: '/user_registration_form',
            templateUrl: 'user_registration_form',
            controller: "UserCreateController",
            controllerAs: "ctrl"
          }).state(
                  'user_edit',
                  {
                    url: '/user_edit/:id',
                    templateUrl: function(params) {
                      return 'user_edit/' + params.id;
                    },
                    controller: "UserEditController",
                    controllerAs: "ctrl",
                    resolve: {
                      async: ['UserService', '$stateParams',
                          function(UserService, $stateParams) {
                            return UserService.findById($stateParams.id);
                          }]
                    }
                  });
        });