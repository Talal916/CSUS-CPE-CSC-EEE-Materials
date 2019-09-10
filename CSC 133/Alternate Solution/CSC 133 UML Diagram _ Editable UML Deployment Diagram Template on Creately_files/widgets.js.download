/**
 * Public function for performing a AJAX style GET request to
 * any end point. This hits the given URL as GET and send the 
 * response back to the callback method.
 * @param url is the full URL of the endpoint that needs to be hit.
 * @param callback is the method that will be called when the request completes.
 *      The first parameter of the callback is the HTTP status code.
 *      The second parameter of the callback is the response body.
 */
window.httpGetRequest = function( url, callback ){
    var xhr = new XMLHttpRequest();
        
    xhr.onreadystatechange = function () {
        if ( xhr.readyState === 4 ) {
            callback( xhr.status, xhr.response );
        }
    };
    xhr.open( 'GET', url );
    xhr.send();
}

/**
 * A class specifically designed to load widgets from the creately
 * /client/widgets location. This loads the given widget and possibly 
 * the css. The methods allow loading each of them induvidually.
 * 
 * The fileName param is the name of the file the html and css files 
 * should be named based on. 
 */
var WidgetLoader = function( fileName ){

    /**
     * Returns the origin base URL including the
     * protocol and hostname
     * Ex: https://app.creately.com
     */
    var getOrigin = function(){
        if( window.location.origin ){
            return window.location.origin;
        } else {
            var loc = window.location;
            return loc.protocol + '//' + loc.hostname;
        }
    }

    this.fileName = fileName;
    this.htmlFileUrl = getOrigin() + '/client/widgets/' + fileName + '.html';
    this.cssFileUrl = getOrigin() + '/client/widgets/css/' + fileName + '.css';
    this.jsFileUrl = getOrigin() + '/client/widgets/js/' + fileName + '.js';

     /**
     * Loads given css to the document head with the given id,
     * when css files is not already loaded. This will simply 
     * add a link to the head part of the document.
     * @param id is the id to be set to the link on the head
     * @param full path of the css file. 
     */
    this.loadCss = function( id, cssPath ) {

        var element = document.getElementById( id + '-css' );
        if( !element ) {
            var cssElement = document.createElement( 'link' );
            cssElement.setAttribute( 'rel', 'stylesheet' );
            cssElement.setAttribute( 'type', 'text/css' );
            cssElement.setAttribute( 'id', id + '-css' );
            cssElement.setAttribute( 'href', cssPath );
            document.getElementsByTagName( 'head' )[0].appendChild( cssElement );
        }
    }

    /**
     * Loads given js to the document head with the given id,
     * when js file is not already loaded.
     * @param id is the id to be set to the script on the head
     * @param jsPath is the full path of the js file
     */
    this.loadJs = function( id, jsPath ){
        var element = document.getElementById( id + '-js' );
        if( !element ) {
            var jsElement = document.createElement( 'script' );
            jsElement.setAttribute( 'type', 'text/javascript' );
            jsElement.setAttribute( 'id', id + '-js' );
            jsElement.setAttribute( 'src', jsPath );
            document.getElementsByTagName( 'head' )[0].appendChild( jsElement );
        }
    }
};

/**
 * Method loads the css file by the given name on the widgets css
 * location. See the class document fore more details.
 */
WidgetLoader.prototype.css = function(){
    this.loadCss( this.fileName, this.cssFileUrl );
}

/**
 * Loads the js file by the given name on the widgets js location.
 */
WidgetLoader.prototype.js = function(){
    this.loadJs( this.fileName, this.jsFileUrl );
}

/**
 * Method loads the html file by the given name on the widgets 
 * location. See the class document for more details.
 */
WidgetLoader.prototype.html = function(){
    httpGetRequest( this.htmlFileUrl, function( status, response ){
        if( status == 200 ){
            document.body.insertAdjacentHTML( 'beforeend', response );
        } else {
            console.error( 'Failed to load html from ' + this.htmlFileUrl + ', with status code ' + status );
        }
    });
}



var WIDGET_PLACEHOLDER = 'widget-placeholder';
var TOP_CONTAINER = 'top-container';
var MIDDLE_CONTAINER = 'middle-container';
var BOTTOM_CONTAINER = 'bottom-container';
var CREATELY_OVERLAY = 'creately-overlay';
/**
 * Module for handling all Creately widgets that
 * show on top of an overlay. These are used throughout
 * the site and the app.
 */
window.createlyWidgets = (function(){

    /**
     * This will represent the currently opened widget id
     */
    var currentWidget = null;

    /**
     * Load the common css file when this js file
     * is linked.
     */
    var loader = new WidgetLoader( 'widgets' );
    loader.css();

    /**
     * Append overlay and middle-container divs
     * to widget placeholder div.
     */
    var addOverlay = function() {
        createDiv( CREATELY_OVERLAY );
        createDiv( MIDDLE_CONTAINER );
    }

    /**
     * Remove overlay and middle-container divs
     * from widget placeholder div.
     */
    var removeOverlay = function() {
        var widgetPlaceholder = document.getElementById( WIDGET_PLACEHOLDER );
        removeElement( widgetPlaceholder, CREATELY_OVERLAY );
        removeElement( widgetPlaceholder, MIDDLE_CONTAINER );
        removeElement( widgetPlaceholder, TOP_CONTAINER );
        removeElement( widgetPlaceholder, BOTTOM_CONTAINER );
    }

    /**
     * Create a div by given id.
     * @param id is creating div id and class attribute.
     */
    var createDiv = function( id ) {
        if( !getElement(id) ){ 
            var widgetPlaceholder = document.getElementById( WIDGET_PLACEHOLDER );
            var containerDiv = document.createElement( 'div' );
            containerDiv.setAttribute( 'id', id );
            containerDiv.setAttribute( 'class', id );
            widgetPlaceholder.appendChild( containerDiv );
        }
    }

    /**
     * Remove element from given placeholder.
     * @param placeholder is removeing element parant id
     * @param id is removeing element id.
     */
    var removeElement = function( placeholder, id ){
        var element = getElement( id );
        if( element ) {
            placeholder.removeChild( element );
        }
    }

    /**
     * Return the element of given id, if element exists
     * return element, otherwise return false.
     * @param id is a element id which need to be returned.
     */
    var getElement = function( id ) {
        var element = document.getElementById( id );
        return element || false ;
    }

    /**
     * Set html element content to given container div
     * @param containerId widget content sets to this div.
     * @param widgetId is a div id of showing widget.
     */
    var showWidget = function( containerId , widgetId ) {
        var widgetElement = getElement( widgetId );
        if( widgetElement ) {
            var containerPlaceholder = document.getElementById( containerId );
            containerPlaceholder.innerHTML = widgetElement.innerHTML;
        }
    }

    /**
     * Remove html content of the given element.
     * @param id is a id attribute of removing content.
     */
    var removeContent = function( id ) {
        var element = getElement( id );
        if( element ) {
            element.innerHTML = '';
        }
    }

    /**
     * Positioning widget to the center
     * @param id is id of the div which is need to be centered
     */
    var centerWidget = function( id ) {
        
        var element = getElement( id );

        if( element ) {
            var offsetleft = ( screenWidth() / 2 ) - ( element.offsetWidth / 2 );

            if( id == MIDDLE_CONTAINER ) {
                var elmTopContainer = getElement( TOP_CONTAINER );
                var elmBottomContainer = getElement( BOTTOM_CONTAINER );

                var topContainerHeight = elmTopContainer ? elmTopContainer.offsetHeight : 0;
                var bottomContainerHeight = elmBottomContainer ? elmBottomContainer.offsetHeight : 0;

                var offsetTop = ( screenHeight() / 2 ) - ( element.offsetHeight / 2 ) - ( bottomContainerHeight / 2 ) - ( topContainerHeight / 2 );
            } else if ( id == TOP_CONTAINER ) {
                var offsetTop = 0;
            } else {
                var offsetTop = screenHeight() - element.offsetHeight;
            }

            setPosition( id, offsetleft, offsetTop );
        }
    }

    /**
     * Return viewport width
     */
    var screenWidth = function() {
        var viewPortWidth;
        viewPortWidth = window.innerWidth;

        if( viewPortWidth === undefined ) {
            viewPortWidth = document.documentElement.clientWidth;
            if( viewPortWidth === undefined || viewPortWidth == 0 ) {
                viewPortWidth = document.body.clientWidth;
            }
        }

        return viewPortWidth;
    }

    /**
     * Returns viewport height
     */
    var screenHeight = function() {
        var viewPortHeight;
        viewPortHeight = window.innerHeight;

        if( viewPortHeight === undefined ) {
            viewPortHeight = document.documentElement.clientHeight;
            if( viewPortHeight === undefined || viewPortHeight == 0 ) {
                viewPortHeight = document.body.clientHeight;
            }
        }

        return viewPortHeight;
    }
    
    /**
     * Set the widget left & top positions
     * @param id is the div which is need to be centered.
     * @param left is a container offset value from left.
     * @param top is a container offset value from top.
     */
    var setPosition = function( id, left, top ) {
        document.getElementById( id ).style.left = left + 'px';
        document.getElementById( id ).style.top = top + 'px';
    }

    /**
     * Centering widget on window resizing
     */
    var handleWindowResize = function(){
        centerWidget( MIDDLE_CONTAINER );
        centerWidget( TOP_CONTAINER );
        centerWidget( BOTTOM_CONTAINER );
    }

    /**
     * Add click event listener to given id element
     * @param id is the div which is need add event listener
     */
    var addClickCloseListener = function( id ){
        var element = getElement( id );
        if( element ){
            element.addEventListener( 'click', createlyWidgets.close );
        }
    }

    /**
     * Remove click event listener from given id element
     * @param id is the div which is need to remove event listener
     */
    var removeClickCloseListener = function( id ){
        var element = getElement( id );
        if( element ){
            element.removeEventListener( 'click', createlyWidgets.close );
        }
    }

    return {

        /**
         * Show the widget on center screen
         * @param widgetId is a div id of showing widget.
         * @param clickClose is boolean value which is use to make overlay closable
         */
        show: function( widgetId, clickClose ) {

            addOverlay();
            showWidget( MIDDLE_CONTAINER , widgetId );
            centerWidget( MIDDLE_CONTAINER );
            window.addEventListener( 'resize', handleWindowResize );

            if( clickClose ){
                addClickCloseListener( CREATELY_OVERLAY );
            }

            currentWidget = widgetId;
        },

        /**
         * Show the widget on top part of the screen
         * @param widgetId is a div id of showing widget.
         */
        showTop: function( widgetId ) {

            createDiv( TOP_CONTAINER );
            showWidget( TOP_CONTAINER , widgetId );
            centerWidget( TOP_CONTAINER );
        },

        /**
         * Show the widget on bottom part of the screen
         * @param widgetId is a div id of showing widget.
         */
        showBottom: function( widgetId ) {

            createDiv( BOTTOM_CONTAINER );
            showWidget( BOTTOM_CONTAINER , widgetId );
            centerWidget( BOTTOM_CONTAINER );
        },

        /**
         * Remove the widgets components from
         * widget placeholder div.
         */
        close: function() {

            removeClickCloseListener( CREATELY_OVERLAY );
            removeOverlay();
            window.removeEventListener( 'resize', handleWindowResize );

            var closeEvent = new Event( 'createlyWidgetClose' );
            closeEvent.widgetId = currentWidget;
            window.dispatchEvent( closeEvent );

            currentWidget = null;
        },

        /**
         * Close the widgets components and
         * reload the page.
         */
        closeAndReload: function() {
            this.close();
            window.location.reload();
        },

        /**
         * Switch between middle widgets, remove showing widget 
         * content and load new widget content.
         * @param widgetId is a div id of showing widget.
         */
        switch: function( widgetId ) {

            removeContent( MIDDLE_CONTAINER );
            removeContent( TOP_CONTAINER );
            showWidget( MIDDLE_CONTAINER , widgetId );
            centerWidget( MIDDLE_CONTAINER );

            currentWidget = widgetId;
        },

        /**
         * Loads a given widget. The widget should be available 
         * in the domain/client/widgets location. Attaches the loaded
         * widget at the bottom of the body.
         * @param widgetFile is file name without extension of the widget
         *      that must be loaded.
         * @param css is a boolean indicating if the widget must be loaded
         *      this is true by default. Can forcefully set to false to avoid.
         * @param js is a boolean indication of the js file to be loaded.
         */
        load: function( widgetFile, css, js ) {
            if( typeof css === 'undefined' )  css = true;

            var loader = new WidgetLoader( widgetFile );
            loader.html();
            if ( css ){
                loader.css();
            }
            if( js ){
                loader.js();
            }
        },
       
    }    

}());