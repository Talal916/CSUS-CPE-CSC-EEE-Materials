// Polyfill the Event() constructor
// functionality for IE browsers
if( typeof window.Event !== 'function' ) {
    function Event ( event, params ) {
        params = params || { bubbles:false, cancelable: false }
        var evt = document.createEvent( 'Event' );
        evt.initEvent( event, params.bubbles, params.cancelable );
        return evt;
    }
    Event.prototype = window.Event.prototype;
    window.Event = Event;
}