app.factory('notes',['$http',function($http){

return $http.get('http://localhost:8080/bignotes/rest/note/getNotes')
            .success(function(eData) {
              return eData;
            })
            .error(function(err) {
              return err;
            });
}]);


