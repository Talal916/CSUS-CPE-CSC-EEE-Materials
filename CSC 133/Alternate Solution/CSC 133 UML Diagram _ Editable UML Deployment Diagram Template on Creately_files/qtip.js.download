// $Id: qtip.js,v 1.1 2010/09/05 20:07:21 bocaj Exp $

Drupal.behaviors.qtip = function(context) {
  /* --------------------------
       CONFIGURATION SETTINGS
     -------------------------- */
  /* Since the hiding won't function properly if 'Hide Event Type'
    is set to 'unfocus' and 'Only allow one qtip to show at a time' checkbox
    is false, we need to set Hide Event Type to 'click' so that the user has
    to click on the link text to close the qtip.
  */
  if (Drupal.settings.qtip.hide_event_type == 'unfocus' && !Drupal.settings.qtip.show_solo) {
    Drupal.settings.qtip.hide_event_type = 'click';
  }
  
  // Set delay on click to immediate
  // TODO: This might be admin-configurable in later releases
  if (Drupal.settings.qtip.show_event_type == 'click') {
    show_delay = 1;
  }
  else {
    show_delay = 140; // This is the default qTip value, set for hover links
  }
  
  if (Drupal.settings.qtip.show_speech_bubble_tip) {
    // Set the proper qtip speech-bubble tip position
    if (Drupal.settings.qtip.show_speech_bubble_tip_side) {
      switch (Drupal.settings.qtip.tooltip_position) {
        case 'topLeft':
          Drupal.settings.qtip.tooltip_position = 'leftTop';
          break;
        case 'topRight':
          Drupal.settings.qtip.tooltip_position = 'topRight';
          break;
        case 'bottomRight':
          Drupal.settings.qtip.tooltip_position = 'rightBottom';
          break;
        case 'bottomLeft':
          Drupal.settings.qtip.tooltip_position = 'leftBottom';
      }
    }
    show_tip = true;
  }
  else {
    show_tip = false;
  }
  
  /* ---  END CONFIGURATION SETTINGS  --- */

  $('.qtip-link').each(function() {
    // if there is a title associated with this qtip...
    if ($(this).children('.qtip-header').length) {
      tooltip_title = $(this).children('.qtip-header').html();
    }
    // if there isn't we don't want a blank title area to show on the qtip...
    else {
      tooltip_title = false;
    }
    
    // jQuery qTip library API
    $(this).qtip({
      content: {
        title: {
          text: tooltip_title
        },
        // Shows contents of element of class qtip-tooltip as tooltip,
        // if this doesn't exist...'false' is set, therefore using the
        // title attribute of the qtip-link element.
        // - see http://craigsworks.com/projects/qtip/docs/#replace
        // For some reason we do not have to explictly set false here,
        // but for the title above we do...dunno!
        text: $(this).children('.qtip-tooltip')
      },
      position: {
        corner: {
          target: Drupal.settings.qtip.target_position,
          tooltip: Drupal.settings.qtip.tooltip_position
        }
      },
      style: { 
        tip: show_tip,
        border: {
          width: parseInt(Drupal.settings.qtip.border_width),
          radius: parseInt(Drupal.settings.qtip.border_radius)
        },
        name: Drupal.settings.qtip.color
      },
      show: {
        when: {
          event: Drupal.settings.qtip.show_event_type
        },
        solo: 'false',
        delay: show_delay
      },
      hide: {
        when: {
          event: Drupal.settings.qtip.hide_event_type
        }
      }
    })
  })
};