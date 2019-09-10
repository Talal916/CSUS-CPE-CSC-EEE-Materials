$( document ).ready(function() {
    
    $( '#btn-purchase-license' ).click(function() {
        
        $( '#error_message' ).hide();
		$( '.messages.error' ).hide();
		$( '.request-processing-text' ).show();
		$( '#btn-purchase-license' ).hide();
		$( '#createlyplugin-plugin-login-form input' ).removeClass("error");

        if( $( "input[name=is_registration]" ).val() == '1' ) {
			// If user not logged in, register the user
			pluginPurchaseUserRegistration();
		} else {
			// If user already logged in, continue the puchasing
			document.getElementById('createlyplugin-plugin-login-form').submit();
		}
    });

    /**
	 * Validate user register data
	 * If data valid do the registration with Gravity API
	 * If registration success continue the puchasing page
	 */
	function pluginPurchaseUserRegistration() {

		// Get input textfield value by name
		var firstname = $.trim( $("input[name=firstname]").val() );
		var lastname = $.trim( $("input[name=lastname]").val() );
		var email = $.trim( $("input[name=mail]").val() );
		var password = $.trim( $("input[name=pass]").val() );
		var confirm_password = $.trim( $("input[name=conf_pass]").val() );
		var name = $.trim( firstname + ' ' + lastname );
		var newsletter_preference = '';
		var err_message = new Object();

		// Get newsletter preference
		if( $( '#edit-subscript:checked' ).val() ) {
			newsletter_preference = 'on' ;
		}
		
		var isValidName = false;
		var isValidEmail = false;
		var isValidPassword = false;

		// Validate name using gravity validator
		isValidName = gravity.validator.isValidName( name );

		if( isValidName != true ) {

			err_message['firstname'] = isValidName;
			err_message['lastname'] = '';
		}

		// Validate email using gravity validator
		isValidEmail = gravity.validator.isValidEmail( email );

		if( isValidEmail != true ) {

			err_message['mail'] = isValidEmail;
		}

		if( password == confirm_password ) {

			// Validate password using gravity validator
			isValidPassword = gravity.validator.isValidPassword( password );

			if( isValidPassword != true ) {

				err_message['pass'] = isValidPassword;
				err_message['conf_pass'] = '';
			}
			
		} else {

			err_message['pass'] = 'Password Confirmation field does not match the Password.';
			err_message['conf_pass'] = '';
		}

		// If all fields valid
		if( isValidName === true && isValidEmail === true && isValidPassword === true ) {

			// Call Gravity register API
			var resultPromise = gravity.api.register( email, name, password, newsletter_preference );

			resultPromise.then( function( response ) {
				
				// If registration success
				if ( response.status <= 99 ) {
					
					gravityAuth.recordRegisterSuccess();
					
					// Set purchase form is_registration hidden value to 0
					$("input[name=is_registration]").val( "0" );
					document.getElementById('createlyplugin-plugin-login-form').submit();
				} else {

					err_message['error'] = response.message;
					pluginShowValidationErrors( err_message );
				}
			}).catch( function( error ) {

				err_message['error'] = 'Uncaught Error. ' + error;
				pluginShowValidationErrors( err );
			});
		} else {
			pluginShowValidationErrors( err_message );
		}
	}

    /**
     * Format error messages and display to user
     */
	function pluginShowValidationErrors( errorObj ) {

		var html = '<ul>';
			$.each(errorObj, function(key, value){
                if( value != '' ) {
				    html += '<li>' + value + '</li>';
                }
			});
			html += '</ul>';
		$('#error_message').html(html);

		$.each(errorObj, function(key, value){
			$( "[name='"+ key +"']" ).addClass("error");
		});

		$( '#error_message' ).show();
		$( '.request-processing-text' ).hide();
		$( '#btn-purchase-license' ).show();
		$( 'html, body' ).animate({ scrollTop: 0 }, 800);
	}
});