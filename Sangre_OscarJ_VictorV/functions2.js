$(document).ready(function() {
    $('.sociallink').hover(
     function() {
      social_id = $(this).find('.social').attr('id');
      switch(social_id)
      {
        case 'twitter':
          new_textcolor = '#55d4ff';
          new_text = 'Nuestro twitter';
          break;
        case 'facebook':
          new_textcolor = '#354970';
          new_text = 'Nuestro facebook';
          break;
      }

      $(this).find('.button').stop().animate({
        'left': '119px'
      }, 700);
       $(this).find('span').stop().animate({
         'margin-left': '5px',
         'color': new_textcolor
       }, 500);
       $(this).find('.social').stop().animate({
         backgroundColor: '#fcfcfc'
       }, 500);

       $(this).find('span').text(new_text);
    },
    function(){
      social_id = $(this).find('.social').attr('id');
      switch(social_id)
      {
        case 'twitter':
          new_bgcolor = '#55d4ff';
          new_text = 'Visita Twitter';
          break;
        case 'facebook':
          new_bgcolor = '#354970';
          new_text = 'Visita Facebook';
          break;
      } 

       $(this).find('.button').stop().animate({
        'left': '0'
        }, 700);
      $(this).find('span').stop().animate({
         'margin-left': '30px',
        'color': '#ffffff'
       }, 600);
      $(this).find('.social').stop().animate({
         backgroundColor: new_bgcolor
       }, 500);

      $(this).find('span').text(new_text);
    });
});