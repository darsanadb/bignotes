app.controller('DetailedNotesController', ['$scope', 'notes', '$routeParams',
function($scope, notes, $routeParams) {
  notes.success(function(data) {
    $scope.n1 = data[$routeParams.id];
  });
}]);
