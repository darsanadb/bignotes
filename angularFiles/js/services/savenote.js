app.factory('savenote',['$http',function($http){	
	return {
    saveit: function(values) {
    var request =  $http({
        method: 'POST',
        url:  'http://localhost:8080/bignotes/rest/note/savenote',
        dataType: 'json',
        data: values,
        headers: { 'Content-Type': 'application/json; charset=UTF-8' }
    });
	
		request.success(function(eData) {
				  return eData;
		});
    
		request.error(function(err) {
				console.log(err);
				return err;
		}); 
	return request;			

	}}}]);

