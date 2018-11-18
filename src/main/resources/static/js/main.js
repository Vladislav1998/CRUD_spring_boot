// $(document).ready(function () {
//   $('.table .eBtn').on('click',function (event){
//       $('.myForm #exampleModal').modal();
//   });
// });
//open popup
$('.open_popup').click(function () {

    $('.bg-wrapper').show();

    var dataValue = $(this).attr("data-value");
    var className = ".popup_" + dataValue;

    var windowWidth = $(window).width();
    var popupWidth = $(className).width();
    var leftPosition = (windowWidth - popupWidth) / 2;

    $(className).css('left', leftPosition);
    $(className).show();
    //console.log( $(this).attr('organization-ID'));

    if ($(this).attr('artist-ID') !== null) {
        var feat = $(this).attr('artist-ID');
        var elemF = $(className).find('.hiden-Artist');
        elemF.val(feat);
        console.log(elemF.val());

    }
    if ($(this).attr('organization-ID') !== null) {
        var featOrg = $(this).attr('organization-ID');
        var elemOrg = $(className).find('.hiden-Org');
        elemOrg.val(featOrg);
        console.log(elemOrg.val());
    }
    if ($(this).attr('cd-ID') !== null) {
        var featCD = $(this).attr('cd-ID');
        var elemCD = $(className).find('.hiden-CD');
        elemCD.val(featCD);
        console.log(elemCD.val());
    }

});
//close button
$('.close-popup, .bg-wrapper').click(function () {
    $('.bg-wrapper, .popup-block').hide();
});

$('#area').keyup(validateTextarea);
$('#area-2').keyup(validateTextarea);

function validateTextarea() {
    var errorMsg = "Введите данные в указанном формате.";
    var textarea = this;
    var pattern = new RegExp('^' + $(textarea).attr('pattern') + '$');
    // check each line of text
    $.each($(this).val().split("\n"), function () {
        // check if the line matches the pattern
        var hasError = !this.match(pattern);
        if (typeof textarea.setCustomValidity === 'function') {
            textarea.setCustomValidity(hasError ? errorMsg : '');
        } else {
            // Not supported by the browser, fallback to manual error display...
            $(textarea).toggleClass('error', !!hasError);
            $(textarea).toggleClass('ok', !hasError);
            if (hasError) {
                $(textarea).attr('title', errorMsg);
            } else {
                $(textarea).removeAttr('title');
            }
        }
        return !hasError;
    });
}

