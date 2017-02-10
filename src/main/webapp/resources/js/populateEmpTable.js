function getData(data) {
	$.ajax({
		url : 'getEmp',
		type : 'GET',
		dataType : 'json',
		data : data,
		success : function(result, status, xhr) {
			var users = JSON.parse(xhr.responseText);
			document.getElementById("empTableBody").innerHTML = "";
			for ( var u in users) {
				var row = document.createElement("tr");

				// Create cells
				var uname = document.createElement("td");
				var fname = document.createElement("td");
				var lname = document.createElement("td");
				var email = document.createElement("td");

				// Append the cell to the rows
				row.appendChild(uname);
				row.appendChild(fname);
				row.appendChild(lname);
				row.appendChild(email);

				// Add Text to cells
				uname.innerHTML = users[u].uname;
				fname.innerHTML = users[u].fname;
				lname.innerHTML = users[u].lname;
				email.innerHTML = users[u].email;

				// append the table
				document.getElementById("empTableBody").appendChild(row);

			}
			$('#empTable').DataTable();
		},
		error : function(request, textStatus, errorThrown) {
			alert(errorThrown);
		}
	});
}

$(document).ready(function() {
	getData();
})