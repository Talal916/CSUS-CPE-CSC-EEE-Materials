var MixpanelTracker = (function( ) {
	
	var config = {};
	config.initialized = true;
	config.mpLibLoaded = false;
	config['url_params'] = {};
	config['track_function_called'] = false;
	// Track functions that are called during the initialization of the MP library are to be queued and are executed after the initialization.
	var queuedTrackFunctions = [];
	/** Init the mixpanel library */
	if( window.mixpanel && Object.prototype.toString.call( window.mixpanel ) != '[object Array]' ) {
	} else if ( window.top.mixpanel && Object.prototype.toString.call( window.top.mixpanel ) != '[object Array]' ){
		window.mixpanel = window.top.mixpanel;
		config.mpLibLoaded = true;
	} else if ( window.top.top.mixpanel && Object.prototype.toString.call( window.top.top.mixpanel ) != '[object Array]' ) {
		window.mixpanel = window.top.top.mixpanel;
		config.mpLibLoaded = true;
	} else {
		(function(f,b){if(!b.__SV){var a,e,i,g;window.mixpanel=b;b._i=[];b.init=function(a,e,d){function f(b,h){var a=h.split(".");2==a.length&&(b=b[a[0]],h=a[1]);b[h]=function(){b.push([h].concat(Array.prototype.slice.call(arguments,0)))}}var c=b;"undefined"!==typeof d?c=b[d]=[]:d="mixpanel";c.people=c.people||[];c.toString=function(b){var a="mixpanel";"mixpanel"!==d&&(a+="."+d);b||(a+=" (stub)");return a};c.people.toString=function(){return c.toString(1)+".people (stub)"};i="disable track track_pageview track_links track_forms register register_once alias unregister identify name_tag set_config get_distinct_id people.set people.set_once people.increment people.append people.track_charge people.clear_charges people.delete_user".split(" ");
		for(g=0;g<i.length;g++)f(c,i[g]);b._i.push([a,e,d])};b.__SV=1.2;a=f.createElement("script");a.type="text/javascript";a.async=!0;a.src="//cdn.mxpnl.com/libs/mixpanel-2.2.min.js";e=f.getElementsByTagName("script")[0];e.parentNode.insertBefore(a,e)}})(document,window.mixpanel||[]);
		
		config.initialized = false;
	}
	/** End of the mixpanel library */
	
	
	
	var getURLParam = function(key) {
		return config['url_params'][key];
	};
	
	var validateEmail = function(email) { 
	    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    return re.test(email);
	} ;
	
	var setUserAlias = function( user_id, first_name, last_name, registered_date ) {

		if( user_id != 'demo@creately.com' ) {
			
			var oldId = undefined;
			if( mixpanel.get_distinct_id ) {
				oldId = mixpanel.get_distinct_id();
			}
			
			if ( oldId && !validateEmail( oldId ) ) {
				mixpanel.alias(user_id, oldId);
			} else {
				mixpanel.identify(user_id);
			}
		}
	};
	
	var setUserIdentity = function( user_id ) {

		if( user_id != 'demo@creately.com' ) {
			
			var oldId = undefined;
			if( mixpanel.get_distinct_id ) {
				oldId = mixpanel.get_distinct_id();
			}
			
			if ( oldId && validateEmail( user_id ) ) {
				mixpanel.identify(user_id);
			}
		}
	};

	var setPeople = function( user_id, first_name, last_name, registered_date ) {

		mixpanel.identify(user_id);
		mixpanel.people.set({
			"$first_name"		:	first_name,
			"$last_name"		:	last_name,
			"$email"			:	user_id,
			"$registered_date"	:	registered_date
		});
	};
//	var inIframe = function() {
//	    try {
//	        return window.self !== window.top;
//	    } catch (e) {
//	        return true;
//	    }
//	}
	
//	var mixpanelAPI = function() {
//		if ( inIframe() ) {
//			return window.top.MixpanelTracker.getMixpanelAPI()
//		}
//		return window.mixpanel;
//	}();
	
	return {
//		getMixpanelAPI : function() {
//			return mixpanelAPI;
//		},
		track : function( event_name, data, callback ) {
			
			if ( config.mpLibLoaded ) {
				mixpanel.track( event_name, data, callback );
				config['track_function_called'] = true;
			} else {
				queuedTrackFunctions.push( {type:'track', data:[event_name, data, callback]} );
			}
		},
		
		initialize : function( project_token, user_id ) {

			if( !config.initialized ) {
				
				mixpanel.init(project_token, {'loaded':function() {
						
						if ( user_id ) {
							mixpanel.identify(user_id);
						}
						
						// Queue processing function that will execute the item and delay for about 500ms for next item.
						var processTheQueue = function(){
							
							if ( queuedTrackFunctions.length > 0 ) {
								
								var queuedEvent = queuedTrackFunctions.shift();
	
								if ( queuedEvent ) {
									
									switch (queuedEvent.type) {
									case 'track':
										mixpanel.track.apply( mixpanel, queuedEvent.data );
										break;
		
									case 'setUser':
										setUserIdentity.apply( null, queuedEvent.data );
										break;
		
									case 'userAlias':
										setUserAlias.apply( null, queuedEvent.data );
										break;
		
									default:
										console.log('The type property in the queued function is not recognized. type:'+queuedEvent.type);
										break;
									}
									
								}
							}
							// If the queue has more events/items then set timeout to be executed the next item in 500 milliseconds, otherwise set the flag to indicate MP library is loaded.
							if ( queuedTrackFunctions.length > 0 ) {
								setTimeout( processTheQueue, 500);
							} else {
								config.mpLibLoaded = true;
							}
						};
						// Invoke the queue processing function without a delay
						processTheQueue();
					}
				});

				/*if ( user_id ) {
					mixpanel.identify(user_id);
				}*/
			}
			config.initialized = true;
			
			var parentURL = (location == window.top.location ) ? location : window.top.location;
			
			if ( parentURL ) {
				parentURL.search.substr(1)
				.split("&")
				.forEach(function (item) {
					tmp = item.split("=");
					config['url_params'][decodeURIComponent(tmp[0])] = decodeURIComponent(tmp[1]);
				});
			}
			
			if ( parentURL ) {
				urlParts = parentURL.pathname.substr(1).split( '/' );
				if( urlParts.length > 2 &&  urlParts[0] == 'diagram' ){
					if( urlParts[1] == 'example' ) {
						config['url_params']['diagid'] = urlParts[2];
					} else {
						config['url_params']['diagid'] = urlParts[1];
					}
				}
			}
		},
		
		setUser : function( user_id ) {
			
			if ( config.mpLibLoaded ) {
				setUserIdentity( user_id );
			} else {
				queuedTrackFunctions.push({type:'setUser', data:[user_id]});
			}
		},
		
		userAlias : function( user_id, first_name, last_name, registered_date ) {
			
			if ( config.mpLibLoaded ) {
				setUserAlias( user_id, first_name, last_name, registered_date );
			} else {
				queuedTrackFunctions.push({type:'userAlias', data:[user_id, first_name, last_name, registered_date]});
			}
		},
		
		
		
		trackLogin : function( email, type, success, plan, team_size, location, callback ) {
			
			if( success == "success" ) {
				this.setUser(email);
			}
			if( !email ) {
				email = 'unknown-user';
			}
			var data = {};
			data['c.email'] = email;
			data['c.type'] = type;
			data[ 'c.success' ] = success;
			data['c.location'] = ( location && location.length > 0 ) ? location : ( window.top.location.href && window.top.location.href != window.location.href ) ? window.top.location.href : window.location.href ;
			if( plan ) {
				data['c.plan'] = plan;
			}
			
			if( team_size ){
				data['p.teamSize'] = team_size;
			}

			if (getURLParam('diagid') || getURLParam('diagID') ) {
				data['p.diagramId'] = getURLParam('diagid') || getURLParam('diagID');
			}
			
			if (getURLParam('tempID')) {
				data['p.templateId'] = getURLParam('tempID');
			}
			this.track('Login', data, callback);
		},
		
		trackSignup : function( email, type, success, location, first_name, last_name, registered_date, callback ) {
			if( success == "success" ) {
				this.userAlias(email, first_name, last_name, registered_date);
			}
			if( !email ) {
				email = 'unknown-user';
			}
			var data = {};
			data['c.email'] = email;
			data['c.type'] = type;
			data[ 'c.success' ] = success;
			data['c.location'] = ( location && location.length > 0 ) ? location : ( window.top.location.href && window.top.location.href != window.location.href ) ? window.top.location.href : window.location.href ;

			if (getURLParam('diagid')) {
				data['p.diagramId'] = getURLParam('diagid');
			}
			
			if (getURLParam('tempID')) {
				data['p.templateId'] = getURLParam('tempID');
			}
			
			// This property is always true, GDPR requirement
			data['c.consent'] = true;
			
			this.track('Register', data, callback);
		},
		
		trackPlans : function( action, click, team_size, location ) {

			var data = {};
			data['c.action'] = action;
			data['c.location'] = location;
			data['c.click'] = click;
			data['p.teamSize'] = team_size;
			
			this.track('Plans', data);
		},
		
		trackPurchase : function( action, product, team_size, fail_reason, discount, change, submit_type, method, fail_type, callback ) {
			var data = {};
			data['c.action'] = 'purchase.' + action;
			data['c.product'] = product;
			data['c.location'] = window.location.href;
			if( team_size ) {
				if( team_size == -1 ) {
					team_size = 'unlimited';
				}
				data['p.teamSize'] = team_size;
			}
			
			if ( fail_reason ) {
				data['p.failReason'] = fail_reason;
			}

			if( discount && discount > 0 ) {
				data['c.discount'] = discount;
			}

			if( change ) {
				data['c.change'] = 'purchase.' + change;
			}

			if( submit_type ) {
				data['c.submitType'] = 'purchase.' + submit_type;
			}

			if( method ) {
				data['c.method'] = method;
			}

			if( fail_type ) {
				data['p.failType'] = fail_type;
			}
			
			this.track('Purchase', data, callback );
		},
		
		trackLanding : function( action, page, templateGroup ) {
			var data = {};
			data['c.action'] = 'landing.' + action;
			data['c.page'] = page;
			data['c.location'] = window.location.href;
			if( templateGroup ) {
				data['c.templateGroup'] = 'industry.'+ templateGroup;
			}
			
			this.track('Landing', data);
		},
		
		trackLoadPlans : function( location, page, teamSize ) {
			var data = {};
			data['c.action'] = "load";
			data['c.planTest'] = page;
			data['c.location'] = location;
			if( teamSize ) {
				data['c.teamSize'] = teamSize;
			}
			
			this.track('Plans', data);
		},

		trackCommunity : function( action, page, type, diagramType ) {
			var data = {};
			data['c.action'] = 'community.' + action;
			data['c.page'] = page;
			data['c.type'] = type;
			if( diagramType ){
				data['c.diagramType'] = diagramType;
			}
			
			this.track('Community', data);
		},

		trackPrompt : function( dialog, action ) {
			var data = {};
			data['c.dialog'] = dialog;
			data['c.dialogAction'] = 'dialog.' + action;

			var templateId = getURLParam('tempID');
			if ( templateId ) {
				data['p.templateId'] = templateId;
			}
			
			this.track('Prompt', data);
		},

		trackAuthWindow : function( action, authWindow ) {
			var data = {};
			data['c.action'] = action;
			data['c.window'] = authWindow;
			data['c.location'] = window.location.href;

			this.track('AuthWindow', data);
		},

		trackNewsletter : function( email, location, action, type ) {

			if( validateEmail( email ) ) {
				var data = {};
				data['c.email'] = email;
				data['c.location'] = location;
				data['c.action'] = action;
				if( type ) {
					data['c.type'] = type;
				}

				this.track('Newsletter', data);
			}
		},

		trackBetaEntry : function( entryPoint ) {
			var data = {};
			data['c.entryPoint'] = entryPoint;
			this.track('BetaEntry', data);
		}
	};
})();