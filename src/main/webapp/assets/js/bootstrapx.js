function to(url){
	location.href=url;
}

function values(selector){
	var sids = "";
	jQuery(selector).each(function(){
		if(jQuery(this).prop('checked')){
			if(sids===''){
				sids = jQuery(this).val();
			}else{
				sids = sids + "," + jQuery(this).val();
			}
		}
	});
	return sids;
}

function ajaxSubmitForm(id, onSuccess, onError){
	$('#progress').modal({backdrop:'static'});
	var data = jQuery(id).serializeArray(); 
	$.post(jQuery(id).attr("action"),data, function (response) {
		$('#progress').modal('hide');
		if(response.result==="OK"){
			onSuccess&&onSuccess(response);
		}else{
			onError&&onError(response);
		}
		jQuery('#confirm').modal({backdrop:'static'});
	}, "json");
}

function ajaxSubmitJSON(url, data, onSuccess, onError){
	$('#progress').modal({backdrop:'static'});
	$.post(url,data, function (response) {
		$('#progress').modal('hide');
		if(response.result==="OK"){
			onSuccess&&onSuccess(response);
		}else{
			onError&&onError(response);
		}
		jQuery('#confirm').modal({backdrop:'static'});
	});
}