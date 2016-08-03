app.controller('AddNewNoteController', 
['$scope','savenote', function($scope,savenote) {  

    $scope.msg = ""; 	
		// create a blank object to hold our form information
      // $scope will allow this to pass between controller and view	 
	$scope.formInfo = {};
		
	/*$scope.validateData = function() {
		  $scope.inputTitleReq = '';
		  $scope.inputContentsReq = '';

		  if (!$scope.formInfo.title) {
			$scope.inputTitleReq = 'Title Required';
		  }

		  if (!$scope.formInfo.contents) {
			$scope.inputContentsReq = 'Contents Required';
		  }     
    };*/
	
	$scope.saveTheNote = function() { 
		//	$scope.validateData();
			var values = $scope.formInfo;
			savenote.saveit(values).success(function(eData){
				$scope.msg = eData;
				});
	}; 
		
}

]);

