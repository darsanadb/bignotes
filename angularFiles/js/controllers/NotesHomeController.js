app.controller('NotesHomeController', ['$scope','notes', function($scope,notes) {
  
  notes.success(function(notesData){
                $scope.notes = notesData;    
});
}]);