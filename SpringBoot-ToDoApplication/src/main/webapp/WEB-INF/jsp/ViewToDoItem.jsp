<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View ToDo Items</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<style>
a {
	color: white;
}

a:hover {
	color: white;
	text-decoration: none;
}
</style>

</head>
<body>

	<div class="container">
		<h1 class="p-3">ToDo Item List</h1>

		<form:form>

			<table class="table table-bordered">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Date</th>
					<th>Status</th>
					<th>Mark Completed</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach var="todo" items="${list}">

					<tr>
						<td>${todo.toDoEntityId}</td>
						<td>${todo.toDoEntityTitle}</td>
						<td>${todo.todoEntityDate}</td>
						<td>${todo.todoEntityStatus}</td>
						<td><button type="button" class="btn btn-success">
								<a href="/updateToDoStatus/${todo.toDoEntityId}">Mark Complete</a>
							</button></td>
						<td><button type="button" class="btn btn-primary">
								<a href="/editToDoItem/${todo.toDoEntityId}">Edit</a>
							</button></td>
						<td><button type="button" class="btn btn-danger">
								<a href="/deleteToDoItem/${todo.toDoEntityId}">Delete</a>
							</button></td>
					</tr>

				</c:forEach>

			</table>

		</form:form>

		<button type="button" class="btn btn-primary btn-block">
			<a href="/addToDoItem"> Add New ToDo Item</a>
			
		</button>
	</div>

	<script th:inline="javascript">
		window.onload = function() {

			var msg = "${message}";

			if (msg == "save is successful") {
				Command: toastr["success"]("Item added successfully!!")
			} else if (msg == "delete is successful") {
				Command: toastr["success"]("Item deleted successfully!!")
			} else if (msg == "delete is failure") {
				Command: toastr["error"]
						("Some error occurred, couldn't delete item")
			} else if (msg == "successfully saved the edit") {
				Command: toastr["success"]("Item updated successfully!!")
			}else if (msg == "update successful"){
				Command: toastr["success"]("Item status is Marked as Completed !!")
			}else if (msg == "update failure"){
				Command: toastr["error"]
			("Some error occurred, couldn't update the status of item")
			}
			 

			toastr.options = {
				"closeButton" : true,
				"debug" : false,
				"newestOnTop" : false,
				"progressBar" : true,
				"positionClass" : "toast-top-right",
				"preventDuplicates" : false,
				"showDuration" : "300",
				"hideDuration" : "1000",
				"timeOut" : "5000",
				"extendedTimeOut" : "1000",
				"showEasing" : "swing",
				"hideEasing" : "linear",
				"showMethod" : "fadeIn",
				"hideMethod" : "fadeOut"
			}
		}
	</script>


</body>
</html>