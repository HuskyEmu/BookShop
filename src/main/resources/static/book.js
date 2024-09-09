var app = angular.module("UserManagement", []);

//Controller Part
app.controller("UserManagementController", function ($scope, $http, $location) {


  //Initialize page with default data which is blank in this example
  $scope.booksData = []; //將data清空
  $scope.form = {
    bookId: -1,
    bookName: "",
    author: "",
    isbn: "",
    category: "",
    publisherId: "",
    image: "",
    price: "",
    description: "",
    salesQuantity: "",
    totalRating: "",
    addedTime: "",
    // servicePath: ($location.protocol() + '://' +  $location.host() + ':' +  $location.port())
  };

  //Now load the data from server
  _refreshPageData(); //刷新


  //HTTP POST/PUT methods for add/edit employee
  $scope.submitEmployee = function () {

    var method = "";
    var url = "";
    if ($scope.form.id == -1) {
      //Id is absent so add employee - POST operation
      method = "POST";
      url = 'http://localhost:8080/emps';
    } else {
      //If Id is present, it's edit operation - PUT operation
      method = "PUT";
      url = 'http://localhost:8080/emps/' + $scope.form.id;
    }

    $http({
      method: method,
      url: url,
      data: angular.toJson($scope.form),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(_success, _error);
  };

  //HTTP DELETE- delete employee by Id
  $scope.removeEmployee = function (employee) {
    $http({
      method: 'DELETE',
      url: 'http://localhost:8080/emps/' + employee.id
    }).then(_success, _error);
  };

  //In case of edit employee, populate form with employee data
  $scope.editEmployee = function (employee) {
    $scope.form.firstName = employee.firstName;
    $scope.form.lastName = employee.lastName;
    $scope.form.email = employee.email;
    $scope.form.id = employee.id;
  };

  /* Private Methods */
  //HTTP GET- get all books collection
  function _refreshPageData() { //get請求後端數據
    $http({
      method: 'GET',
      url: 'http://localhost:8080/book/showall'
    }).then(function successCallback(response) {
      $scope.booksData = response.data;

    }, function errorCallback(response) {
      console.log(response.statusText);
    });
  }

  function _success(response) {
    _refreshPageData();
    _clearForm()
  }

  function _error(response) {
    console.log(response.statusText);
  }

  //Clear the form
  function _clearForm() {
    $scope.form.firstName = "";
    $scope.form.lastName = "";
    $scope.form.email = "";
    $scope.form.id = -1;
  };


});


// 函数：获取点击元素的 ID 并显示
function displayElementId(event) {
  const clickedElementId = event.target.id;
  console.log(clickedElementId);
}


// 为所有具有 'clickable' 类的元素添加点击事件监听器
var clickableElements = document.querySelectorAll('.clickable');
clickableElements.forEach(function (element) {
  element.addEventListener('click', displayElementId);
});


