function getData(data) {

	$
			.ajax({
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
						rid.setAttribute("class", "reimId");
						var aut = document.createElement("td");
						var amo = document.createElement("td");
						var des = document.createElement("td");
						var rec = document.createElement("td");
						var sub = document.createElement("td");
						var resolved = document.createElement("td");
						var resolver = document.createElement("td");
						var stat = document.createElement("td");
						var type = document.createElement("td");

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

						// Add Text to cells
						rid.append(reimbursements[reim].id);
						aut.append(reimbursements[reim].author.uname)
						amo.innerHTML = "$";
						amo.append(reimbursements[reim].amount);
						des.innerHTML = reimbursements[reim].desc;
						if (reimbursements[reim].status == "Pending") {
							if (reimbursements[reim].receipt != null) {
								rec.innerHTML = "<button class=\"btnUpload btn btn-link\">View/Modify</button>";
							} else {
								rec.innerHTML = "<button class=\"btnUpload btn btn-link\">Upload</button>";
							}
						} else {
							if (reimbursements[reim].receipt != null) {
								rec.innerHTML = "<button class=\"btnView btn btn-link\">View</button>";
							} else {
								rec.innerHTML = "";
							}
							
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

						// append the table
						document.getElementById("reimTableBody").appendChild(
								row);

					}
					table = $('#reimTable').DataTable();
				},
				error : function(request, textStatus, errorThrown) {
					alert(errorThrown);
				}
			});
}

function submitSuccess() {
	
	$("#success").attr("style", "display:block");
	$("fail").attr("style", "display:none");
}

function submitFail() {
	
	$("#success").attr("style", "display:none");
	$("fail").attr("style", "display:block");
}

$("#filterButt").click(function() {
	getData({
		username : $("#username").val(),
		reso : $("#reso").val(),
		stat : $("#stat").val()
	});
	return false;
});

$("#filterEmpButt").click(function() {
	getData({
		username : $("#username").val(),
		stat : $("#stat").val()
	});
	return false;
});

$("#submitButt").click(function() {

	var url = "makeReq"

	$.ajax({
		type : "get",
		url : url,
		data : $("#reimForm").serialize(),
		success : function() {
			getData({
				username : $("#username").val()
			});
			$("#reimForm")[0].reset()
			submitSuccess();
		},
		fail: function(request, status, errorThrown){
			submitFail();
		}
	});

	return false;
});

$("table").on("click", "button.btnUpload", function() {
	$("#upId").val($(this).closest("tr").find(".reimId").text());
	$("#upForm").submit();
});

$("table").on("click", "button.btnView", function() {
	$("#recId").val($(this).closest("tr").find(".reimId").text());
	$("#viewForm").submit();
});

$(document).ready(function() {
	table = $('#reimTable').DataTable();
	getData({
		username : $("#username").val()
	})
});