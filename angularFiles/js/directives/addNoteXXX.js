app.directive('addNote',function(){

  return {     restrict: 'E',
                   scope: {info:'=' },
                   templateUrl: 'js/directives/addNote.html' 
    };
});
