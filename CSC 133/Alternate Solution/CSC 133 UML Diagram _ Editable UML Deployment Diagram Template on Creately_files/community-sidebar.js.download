/**
 * 
 */

var org;
var sorted;

$(document).ready( function() {
	
	var li_length = $("#id_category_list li").length;
	
	if (li_length > 1 ) {
		org = [];
		sorted = [];
		var eliment;
		
		$("#id_category_list li:not(:first-child)").each(function(index) {
			eliment = {};
			eliment.text = $(this).text();
			eliment.value = $(this).html();
			
			//org[index]= eliment;
			org.push(eliment);
			sorted.push(eliment);
		});
	}
	
	if ( sorted && sorted.length>0) {
		sorted = sorted.sort (function(a, b){
			var nameA=a.text.toLowerCase(), nameB=b.text.toLowerCase();
			 if (nameA < nameB) //sort string ascending
			  return -1;
			 if (nameA > nameB)
			  return 1;
			 return 0;//default return value (no sorting)
		});

	}
	
	// Show hide section on the community page and example pages
	$("#id-category-section-collapse").click(function() {
		var li_text;
		
		if ($(this).hasClass("section-plus")){
			
			if (sorted.length > 0 ) {
				$("#id_category_list li:not(:first-child)").each(function(index) {
					li_text = sorted[index];
					$(this).text(li_text.text);
					$(this).html(li_text.value);
				});
			}
			
			$(this).removeClass("section-plus");
			$(this).text("Less..");
			$(this).addClass("section-minus");
			$(".category-more-section").removeClass("section-hide");
		} else {
			
			if ( org.length > 0  ) {
				
				$("#id_category_list li:not(:first-child)").each(function(index) {
					li_text = org[index];
					$(this).text(li_text.text);
					$(this).html(li_text.value);
				});
			}
			
			$(this).removeClass("section-minus");
			$(this).addClass("section-plus");
			$(this).text("More..");
			$(".category-more-section").addClass ("section-hide");
		}
	});

});

/**
 * This function toggle the template list and categories list on diagram/commumnity sidebar
 * @param diagram_categories_str - diagram categories JSON string
 * @param diagram_type - popular / all / examples / my
 * @param diagram_category - category type of the diagram
 */
function toggle_sidebar_diagram_categories( diagram_categories_str, diagram_type, diagram_category ) {

	if( !$('#diagram-types-more' ).hasClass( 'active' ) ) {

		if( $( '#categories-list' ).is(':empty') ) {

			var categories_list_html = generate_sidebar_diagram_categories( diagram_categories_str, diagram_type, diagram_category );
			$( '#categories-list' ).hide();
			$( '#categories-list' ).html( categories_list_html );
			$( '#categories-list' ).slideDown();
		} else {
			$( '#categories-list' ).slideDown();
		}
		$( '#templates-list' ).slideUp();
		$( '#diagram-types-more' ).addClass( 'active' ).html( 'View Less' );
	} else {
		$( '#categories-list' ).slideUp();
		$( '#templates-list' ).slideDown();
		$( '#diagram-types-more' ).removeClass( 'active' ).html( 'View More' );
		$( 'html, body' ).animate( {
			scrollTop: $( '#scroll-top' ).offset().top
		}, 300 );
	}
}

/**
 * This function returns generated diagram categories list in html format
 * @param diagram_categories_str - diagram categories JSON string
 * @param diagram_type - popular / all / examples / my
 * @param diagram_category - category type of the diagram
 */
function generate_sidebar_diagram_categories( diagram_categories_str, diagram_type, diagram_category ) {
	
	var categories_list_html = '';

	if( !diagram_type ) {
		diagram_type = 'popular';
	}

	for( var key in diagram_categories_str ) {
		if( diagram_categories_str.hasOwnProperty( key ) ) {

			var selected_class = '';
			if( diagram_category && diagram_category == key ) {
				selected_class = 'class ="selected"';
			}
			categories_list_html += '<li><a '+ selected_class +' href="/diagram-community/' + diagram_type + '/t/' + key +'">'+ diagram_categories_str[key] +'</a></li>';
		}
	}

	return categories_list_html;
}