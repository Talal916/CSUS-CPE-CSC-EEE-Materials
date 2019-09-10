window.gaTracker = (function(){

	/**
	 * If location is set returns the same value,
	 * if not set returns current window location
	 * @param location - demo or undefined
	 * @return string
	 */
	var getLocation = function( location ){
		return ( location && location.length > 0 ) ? location : getCurrentURL();
	}

	/**
	 * Returns current window location
	 */
	var getCurrentURL = function(){
		return ( window.top.location.href && window.top.location.href != window.location.href ) ? window.top.location.href : window.location.href;
	}

	/**
	 * Returns interger value for purticular plan
	 * demo - 1
	 * free - 2
	 * personal - 3
	 * team - 4
	 * @param plan - user plan name
	 * @return interger
	 */
	var getPlanInt = function( plan ){
		if( plan == 'demo' ){
			return 1;
		} else if( plan == 'fre' ){
			return 2;
		} else if( plan == 'per' ){
			return 3;
		} else if( plan == 'tea' ){
			return 4;
		} else{
			return 0;
		}
	}

	/**
	 * Returns passing parameter value of the current url
	 * @param - url parameter
	 */
	var getURLParam = function( param ){
		var url = getCurrentURL();
		param = param.replace(/[\[\]]/g, "\\$&");
		var regex = new RegExp("[?&]" + param + "(=([^&#]*)|&|#|$)");
		var results = regex.exec(url);
		if (!results) return null;
		if (!results[2]) return '';
		return decodeURIComponent(results[2].replace(/\+/g, " "));
	}

	/**
	 * Returns diagram id if it's in current url, otherwise returns null
	 */
	var getDiagramId = function(){
		return getURLParam('diagid') || getURLParam('diagID');
	}

	/**
	 * Returns template id if it's in current url, otherwise returns null
	 */
	var getTemplateId = function(){
		return getURLParam('tempID');
	}

	/**
	 * Send Login & Signup events to Google Analytics
	 * @param catergory - eventCatergory
	 * @param location - user current location
	 * @param type - user login type
	 * @param plan - user plan
	 * @param teamSize - user team size
	 * @param callback - hitcallback function
	 */
	var trackLoginSignup = function( category, location, type, plan, teamSize, callback  ){
		if( typeof ga === 'function' && typeof _gaUserPrefs !== 'object' ){

			var location = getLocation( location );
			var plan = getPlanInt( plan );
			var diagramId = getDiagramId();
			var templateId = getTemplateId();

			ga('send', 'event', {
				eventCategory: category,
				eventAction: location,
				eventLabel: type,
				eventValue: plan,
				dimension1: diagramId,
				dimension2: templateId,
				dimension3: teamSize,
				hitCallback : callback
			});
		} else {
			callback && callback();
		}
	}

	return {

		/**
		 * Track login event
		 * @param type - user login type
		 * @param plan - user plan
		 * @param teamSize - number of users of the team
		 * @param location - this action occured location
		 * @param callback - callback function
		 */
		trackLogin : function( type, plan, teamSize, location, callback ){
			trackLoginSignup( 'Login', location, type, plan, teamSize, callback );
		},

		/**
		 * Track signup event
		 * @param type - user login type
		 * @param location - this action occured location
		 * @param callback - callback function
		 */
		trackSignup : function( type, location, callback ){
			trackLoginSignup( 'Register', location, type, undefined, undefined, callback );
		},

		/**
		 * Track purchase event
		 * Send purchase event to Google Analytics
		 * @param status - purchase status, complete or failed
		 * @param product - purchase product code
		 * @param teamSize - number of users of the team
		 * @param location - this action occured location
		 * @param callback - callback function
		 */
		trackPurchase : function( status, product, teamSize, location, callback ){
			if( typeof ga === 'function' && typeof _gaUserPrefs !== 'object' ){

				var location = getLocation( location );

				ga('send', 'event', {
					eventCategory: 'Purchase',
					eventAction: status,
					eventLabel: product,
					eventValue: teamSize,
					dimension1: location,
					hitCallback : callback
				});
			} else {
				callback && callback();
			}
		},
	};
})();