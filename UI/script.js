
/*function load(){
	var tex = document.getElementById("table");
	tex.innerHTML = tex.innerHTML + "YOYOYOY";
}*/

/*
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("table").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "http://localhost:8080/Parser/log/2", true);
  xhttp.send();
}
*/

//gets JSON object => data
/*$(document).ready(function(){
    $("button").click(function(){
        $.getJSON("http://localhost:8080/Parser/log/2", function(data, status){
            $("td:even").text(data.className);
            $("td:odd").text(data.type);
        });
    });
});
*/

function populate(link) {

	$(document).ready(function(){
		$('#table_id').dataTable( {

			"responsive": {
	            "details": {
	                renderer: function ( api, rowIdx, columns ) {
	                    var data = $.map( columns, function ( col, i ) {
	                        return col.hidden ?
	                            '<tr data-dt-row="'+col.rowIndex+'" data-dt-column="'+col.columnIndex+'">'+
	                                '<td>'+col.title+':'+'</td> '+
	                                '<td>'+col.data+'</td>'+
	                            '</tr>' :
	                            '';
	                    } ).join('');
	 
	                    return data ?
	                        $('<table/>').append( data ) :
	                        false;
	                }
	            }
	        },

			"ajax": { 
		  	"url": link ,
		    "dataSrc": ""
			},

		    "columns": [
		        { "data": 'id' },
		        { "data": 'time' },
		        { "data": 'serviceName' },
		        { "data": 'className' },
		        { "data": 'threadName'},
		        { "data": 'type'},
		        { "data": 'message'}
		    ] 
		});
	});

}

/*
$(document).ready( function () {
    $('#table_id').DataTable({
    	data: tester
    	,
    	columns: [
        { data: 'id' },
        { data: 'time' },
        { data: 'serviceName' },
        { data: 'className' },
        { data: 'threadName'},
        { data: 'type'}
    ]
    });
} );

var tester = [{"className":"c.c.m.c.f.CasCustomAuthenticationFilter","id":1,"message":" username for logged in user : admin ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-610","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"c.c.m.c.f.CasCustomAuthenticationFilter","id":2,"message":" username for logged in user : admin ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-607","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"c.c.m.c.f.CasCustomAuthenticationFilter","id":3,"message":" username for logged in user : admin ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-609","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"c.c.m.c.f.CasCustomAuthenticationFilter","id":4,"message":" username for logged in user : admin ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-608","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"USER-ACCOUNTING","id":5,"message":" USERNAME-admin, API-/data/customer-facing-service/summary/policy/copy, TYPE-GET  Successful Authentication ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-610","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"USER-ACCOUNTING","id":6,"message":" USERNAME-admin, API-/data/customer-facing-service/count/virtualnetworkcontext, TYPE-GET  Successful Authentication ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-607","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"USER-ACCOUNTING","id":7,"message":" USERNAME-admin, API-/data/customer-facing-service/count/scalablegroup/, TYPE-GET  Successful Authentication ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-609","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"USER-ACCOUNTING","id":8,"message":" USERNAME-admin, API-/data/customer-facing-service/count/policy/access, TYPE-GET  Successful Authentication ","ms":504,"serviceName":"spf-service-manager","threadName":"qtp399534175-608","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"c.c.a.c.s.p.p.c.CopyPolicyCfsSummaryProcessor","id":9,"message":" no policies in this snapshot: summary is CopyPolicySummary[deployingPoliciesCount=0,failedPoliciesCount=0,successfulPoliciesCount=0,type=Copy,version=,instanceId=0,instanceTenantId=5b3240308d5e6a0088c63dea,_orderedListOEIndex=<Integer>,_creationOrderIndex=<Integer>,_isBeingChanged=<Boolean>,deployPending=<DeployPendingEnum>,instanceVersion=0] ","ms":815,"serviceName":"spf-service-manager","threadName":"qtp399534175-610","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"c.c.a.c.s.f.ServiceProvisionEngineRequestsFilter","id":10,"message":" Time taken for 'GET' request '/data/customer-facing-service/summary/policy/copy' with query 'null' is: 391ms ","ms":896,"serviceName":"spf-service-manager","threadName":"qtp399534175-610","time":"2018-07-09T10:06:20","type":"INFO"},{"className":"c.c.m.c.f.CasCustomAuthenticationFilter","id":11,"message":" username for logged in user : admin ","ms":75,"serviceName":"spf-service-manager","threadName":"qtp399534175-610","time":"2018-07-09T10:06:21","type":"INFO"},{"className":"USER-ACCOUNTING","id":12,"message":" USERNAME-admin, API-/data/customer-facing-service/scalablegroup/, TYPE-GET  Successful Authentication ","ms":75,"serviceName":"spf-service-manager","threadName":"qtp399534175-610","time":"2018-07-09T10:06:21","type":"INFO"},{"className":"c.c.a.c.s.f.ServiceProvisionEngineRequestsFilter","id":13,"message":" Time taken for 'GET' request '/data/customer-facing-service/count/policy/access' with query 'null' is: 698ms ","ms":203,"serviceName":"spf-service-manager","threadName":"qtp399534175-608","time":"2018-07-09T10:06:21","type":"INFO"}];
*/

function clear_table() {
	var table = $('#table_id').DataTable();
 
	table
    	.clear()
    	.draw();

    $("#table_id").dataTable().fnDestroy()
}

function refil() {
	clear_table();
	populate('http://localhost:8080/Parser/log/all');
}

function type_search() {
	$(document).ready(function(){
		var val = $("#type_field").val();
		//alert(val); //make sure reading happens correctly

		clear_table(); //to empty pervious contents

		var link = "http://localhost:8080/Parser/log/type?type=";
		link = link + val;
		populate(link);

	});
}

function service_search() {
	$(document).ready(function(){
		var val = $("#service_field").val();
		//alert(val); //make sure reading happens correctly

		clear_table(); //to empty pervious contents

		var link = "http://localhost:8080/Parser/log/service?service=";
		link = link + val;
		populate(link);

	});
}

function thread_search() {
	$(document).ready(function(){
		var val = $("#thread_field").val();
		//alert(val); //make sure reading happens correctly

		clear_table(); //to empty pervious contents

		var link = "http://localhost:8080/Parser/log/thread?thread=";
		link = link + val;
		populate(link);

	});
}

function class_search() {
	$(document).ready(function(){
		var val = $("#class_field").val();
		//alert(val); //make sure reading happens correctly

		clear_table(); //to empty pervious contents

		var link = "http://localhost:8080/Parser/log/class?class=";
		link = link + val;
		populate(link);

	});
}

function date_search() {
	$(document).ready(function(){
		var from = $("#date_from").val();
		var to = $("#date_to").val();

		clear_table(); //to empty pervious contents

		var link = "http://localhost:8080/Parser/log/date?from=";
		link += from + "&to=" + to;
		populate(link);

	});
}

