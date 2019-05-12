var app = angular.module('clipboardApplication', []);
app.controller('clipboardController', function($scope, $http, $location) {
	$scope.success = false;
	$scope.error = false;
	var url = $location.absUrl();
	
	$scope.sendText = function(text){
		var obj = {};
		obj.text = text;
		$http.post(url+"copyText",obj)
		  .then(function(response) {
				$scope.success = true;
				$scope.error = false;
			  console.log(response)
		  },function(err){
				$scope.success = false;
				$scope.error = true;
			  console.log(err);
		  });
	}
	
	$scope.getText = function(){
		$http.get(url+"getText")
		  .then(function(response) {
				$scope.text = response.data.text;
			
		  },function(err){
				$scope.success = false;
				$scope.error = true;
			  console.log(err);
		  });
	}
});

