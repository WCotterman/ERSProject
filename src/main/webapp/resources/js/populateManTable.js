function getData(data) {

	$.ajax({
		url : 'getReqs',
		type : 'POST',
		dataType : 'json',
		data : data,
		success : function(result, status, xhr) {
			var reimbursements = JSON.parse(xhr.responseText);
			table.destroy();
			document.getElementById("reimTableBody").innerHTML = "";
			for ( var reim in reimbursements) {
				var row = document.createElement("tr");
				// Create cells
				var rid = document.createElement("td");
				rid.setAttribute("class", "reimId hidden");
				var aut = document.createElement("td");
				var amo = document.createElement("td");
				var des = document.createElement("td");
				var rec = document.createElement("td");
				var sub = document.createElement("td");
				var resolved = document.createElement("td");
				var resolver = document.createElement("td");
				var stat = document.createElement("td");
				var type = document.createElement("td");
				var resolve = document.createElement("td");

				// Append the cell to the rows
				row.appendChild(rid);
				row.appendChild(aut);
				row.appendChild(amo);
				row.appendChild(des);
				row.appendChild(rec);
				row.appendChild(sub);
				row.appendChild(resolved);
				row.appendChild(resolver);
				row.appendChild(stat);
				row.appendChild(type);
				row.appendChild(resolve);


				// Add Text to cells
				rid.append(reimbursements[reim].id);
				aut.append(reimbursements[reim].author.uname);
				amo.innerHTML = "$";
				amo.append(reimbursements[reim].amount);
				des.innerHTML = reimbursements[reim].desc;
				if (reimbursements[reim].receipt != null) {
					rec.innerHTML = "<button class=\"btnView btn btn-link\">View</button>";
				} else {
					rec.innerHTML = "";
				}
				sub.innerHTML = reimbursements[reim].submit;
				if (reimbursements[reim].resolve != null) {
					resolved.innerHTML = reimbursements[reim].resolve;
				} else {
					resolved.innerHTML = "N/A"
				}

				if (reimbursements[reim].resolver != null) {
					resolver.innerHTML = reimbursements[reim].resolver.uname;
				} else {
					resolver.innerHTML = "N/A"
				}
				stat.innerHTML = reimbursements[reim].status;
				type.innerHTML = reimbursements[reim].type;
				if (reimbursements[reim].status == "Pending"){
					resolve.innerHTML = "<div class=\"btn-group\"><button class=\"btnApp btn btn-success\">Approve</button><button class=\"btnDen btn btn-danger\">Deny</button></div>";
				}

				// append the table
				document.getElementById("reimTableBody").appendChild(row);

			}
			table = $('#reimTable').DataTable();
		},
		error : function(request, textStatus, errorThrown) {
			alert(errorThrown);
		}
	});
}

function resolve(id){
	$.ajax({
		type: "get",
		url: "resolve",
		data: id,
		success: function(){getData({username: $("#username").val()})}
	})
}


$("#filterButt").click(function() {
	getData({username: $("#username").val(), reso: $("#reso").val(), stat: $("#stat").val()});
	$("#reimViewForm")[0].reset()
	return false;
});

$("table").on("click", "button.btnApp", function(){
	resolve({id: $(this).closest("tr").find(".reimId").text(), type: "Approved", reso: $("#currentUser").text()});
	return false;
});

$("table").on("click", "button.btnDen", function(){
	resolve({id: $(this).closest("tr").find(".reimId").text(), type: "Denied", reso: $("#currentUser").text()});
	return false;
});

$("table").on("click", "button.btnView", function(){
	$("#recId").val($(this).closest("tr").find(".reimId").text());
	$("#viewForm").submit();
});


$(document).ready( function(){ 
	table = $('#reimTable').DataTable();
	getData({username: $("#username").val()});
	
});
 

