// Empty JS for your own code to be herev

var app=angular.module("admCon",[]);

var urlSrv="http://localhost:8080/AdminUsrREST/rest/";

app.controller("crearUsr",function($scope,$http){
	$scope.usuario={};
	$scope.crearUsuario=function() {
		$scope.mierror=undefined;
		if($scope.usuario.clave!=$scope.confirmacionClave) {
			$scope.mierror={};
			$scope.mierror.mensaje="Clave de confirmación no coincide";			
		}else {
			$http.post(urlSrv+"SrvUsuarios/crearUsuario",$scope.usuario).then(
				function(res){
					//exito
					alert(res.data);
				},
				function(res){
					//error
					 $scope.mierror={};
					 $scope.mierror.tipoRespuesta=res.headers("content-type");
					 $scope.mierror.metodo=res.config.method;
					 $scope.mierror.url=res.config.url;
					 $scope.mierror.codigo=res.status;
					 $scope.mierror.textoError=res.statusText;
					
				});
			
		}
		
	};
	
});
