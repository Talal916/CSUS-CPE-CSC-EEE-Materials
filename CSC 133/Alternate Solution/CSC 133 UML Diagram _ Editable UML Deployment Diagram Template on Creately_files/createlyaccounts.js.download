/**
 * Validate email addresses using regular expression
 * 
 * @param emailAddress
 * @return TRUE|FALSE
 */
function isValidEmailAddress(emailAddress) {
	return gravity.validator.isValidEmail(emailAddress) === true ? true : false;
}

//Removes leading whitespaces
function LTrim( value ) {
	
	var re = /\s*((\S+\s*)*)/;
	return value.replace(re, "$1");
	
}

// Removes ending whitespaces
function RTrim( value ) {
	var re = /((\s*\S+)*)\s*/;
	return value.replace(re, "$1");
}
 
/**
 * Removes leading and ending whitespaces
 * 
 * @param str
 * @return trimmed-str
 */
function trim( value ) {
	return LTrim(RTrim(value));
}


/**
 * Validate email addresses
 * 
 * @param emailAddressesString
 * @return index-of-error-occurrence | 0
 */
function isValidEmailAddressInCommaSeparated(emailAddressesString){
	var index = 0;
	// Get email addresses array
	var emailAddressesArray = emailAddressesString.split(",");

	for(i = 0; i < emailAddressesArray.length; i++){
		// Non-empty and invalid ?
		if(trim(emailAddressesArray[i]) != ''){
			
			if(!isValidEmailAddress(trim(emailAddressesArray[i]))){
				index = i+1;
				break;
			}
		}
	}
	
	return index;
}

/**
 * Validate email domain is in the given domain.
 * 
 * @param email
 * @param domain
 * @return TRUE|FALSE
 */
function isEmailInDomain(email, domain){
	var mail_parts = email.split("@");
	return (mail_parts[1] == domain);
}

/**
 * 
 * 
 * @param emailsString
 * @param domain
 * @return TRUE|FALSE
 */
function checkEmailDomains(emailsString, domain){
	 var hasEmail = false;
	// Get email addresses array
	var emailAddressesArray = emailsString.split(",");
	
	for(i = 0; i < emailAddressesArray.length; i++){
		
		if(trim(emailAddressesArray[i]) != ''){
			if(!isEmailInDomain(trim(emailAddressesArray[i]), domain)){
				return confirm("One or more email domains do not match with plan-domain. Please click OK to add this user.");
			}
		}
	}
	return true;
}

/**
 * Build the full url using given relative url, part and other information.
 * 
 * @param relative_url
 * @param part
 * @param is_secure
 * @param is_new_tab
 * @returns {Boolean}
 */
function goto_url( relative_url, part, is_secure, is_new_tab ) {
	
	if ( relative_url && relative_url.substring(0, 1) != '/' ) {
		relative_url = '/' + relative_url;
	}
	
	if ( part ){
		if ( part.substring(0, 1) != '#' ) {
			part = '#' + part;
		}
	} else {
		part = '';
	}
	
	var url_build = window.location.hostname + relative_url + part ;
	if ( is_secure ) {
		url_build = 'https://' + url_build;
	} else {
		url_build = 'http://' + url_build;
	}
	
	if ( is_new_tab ) {
		window.open(url_build, '_blank');
		window.focus();
	} else {
		window.location.href = url_build;
	}
	
	return false;
}
