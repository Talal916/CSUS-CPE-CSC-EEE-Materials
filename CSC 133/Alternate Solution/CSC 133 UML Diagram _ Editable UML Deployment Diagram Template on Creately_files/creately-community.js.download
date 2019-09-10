// Previous search term
var pre_search_term;
var search_location;

$(document).ready(function() {

	$('#id-search-input').keyup(function(event) {
		
		  if (event.keyCode == '13') {
			event.preventDefault();
			search_examples();
		}
	});
	
	$('#id-search-image-button').click(function() {
		search_examples();
	});
	
	$('.un-qualify-diagram').each ( function() {
		var curElem = $(this);
		curElem.click(function(event) {
			event.preventDefault();
			var link = curElem.attr('href');
			set_qualify(curElem,link,2);
		});
		
	});
	
	$('.qualify-diagram').each ( function() {
		var curElem = $(this);
		curElem.click(function(event) {
			event.preventDefault();
			var link = curElem.attr('href');
			set_qualify(curElem,link,1);
		});
		
	});
	
/*	$("#id-category-section-collapse").click(function() {
		
		if ($(this).hasClass("section-plus")){
			$(this).removeClass("section-plus");
			$(this).addClass("section-minus");
			$(".category-more-section").removeClass("section-hide");
		} else {
			$(this).removeClass("section-minus");
			$(this).addClass("section-plus");
			$(".category-more-section").addClass ("section-hide");
		}
	});*/
});

function search_examples () {
	
	var cur_search_term = trim($("#id-search-input").val());

	if (cur_search_term != '') {

		if (!pre_search_term || pre_search_term != cur_search_term) {
			// Load matched items
			loadPageWithSearch(cur_search_term);
		}
	} else {

		if (pre_search_term && pre_search_term != '') {
			// Load default searched items
			loadPageWithSearch();
		}
	}
}

function loadPageWithSearch ( search_term ) {
	
	var search_param = "";
	var host = window.location.host;
	var protocol = window.location.protocol;
	
	if (search_term && search_term != "") {
		search_param = "?term=" + escape(encodeURIComponent(search_term));
	}
	
	window.location = window.location.protocol + "//" + window.location.host + search_location + search_param;
}

function set_qualify ( item, diag,qualify ) {
	
	if (qualify && diag) {
		$.get("/diagram/ajax/qualify/" + diag + "/" + qualify , function(data) {
				//alert (data);

			var parse_value = eval( '(' + data + ')' );
			
			if (parse_value){
				if ( parse_value.status && parse_value.status == "success") {
					item.attr('disabled', 'disabled');
					item.hide ();
				} else {
					alert("Error : " + parse_value.data);
				}
				
			} else {
				alert("Error : Could not recieve data");
			}
		});
	}
}