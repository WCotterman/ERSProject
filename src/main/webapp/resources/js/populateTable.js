function getData() {

	$.ajax({
		url : 'getReqs',
		type : 'POST',
		success : function(result, status, xhr) {
//			for ( var reim in result) {
//				var row = document.createElement("tr");
//
//				// Create cells
//				var amo = document.createElement("td");
//				var des = document.createElement("td");
//				var rec = document.createElement("td");
//				var sub = document.createElement("td");
//				var resolved = document.createElement("td");
//				var resolver = document.createElement("td");
//				var stat = document.createElement("td");
//				var type = document.createElement("td");
//
//				// Append the cell to the rows
//				row.appendChild(amo);
//				row.appendChild(des);
//				row.appendChild(rec);
//				row.appendChild(sub);
//				row.appendChild(resolved);
//				row.appendChild(resolver);
//				row.appendChild(stat);
//				row.appendChild(type);
//
//				// Add Text to cells
//				amo.innerHTML = reim.getAmount();
//				des.innerHTML = reim.getDesc();
////				rec.innerHTML = "";
////				sub.innerHTML = reim.getSubmit();
////				if(reim.getResolve()!= null)
////				resolved.innerHTML = reim.getResolve();
////				resolver.innerHTML = reim.getResolver().getName();
////				stat.innerHTML = reim.getStatus();
////				type.innerHTML = reim.getType();

				// append the table
				//document.getElementById("reimTableBody").innerHTML = "test";

			
		},
		error : function(request, textStatus, errorThrown) {
			alert(errorThrown);
		}
	});
}


$(getData());