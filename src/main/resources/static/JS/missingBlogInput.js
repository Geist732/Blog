(function(){

var submitForm = $('#submitForm');

var errorBox = $('#errorBox');

var titleHeader = $('#titleIdentifier');
var titleDiv = $('#titleDiv');
var titleContent = $('#title');

var descriptionHeader = $('#descriptionIdentifier');
var descriptionDiv = $('#descriptionDiv');
var descriptionContent = $('#textArea');


submitForm.click(function(event){
    if(titleContent.val().length == 0){
        titleHeader.css('color','orange');
        titleDiv.addClass('has-warning');
        errorBox.removeClass('hidden');
        event.preventDefault();
    }
});

submitForm.click(function(event){
    if(descriptionContent.val().length == 0){
        descriptionHeader.css('color','orange');
        descriptionDiv.addClass('has-warning');
        errorBox.removeClass('hidden');
        event.preventDefault();
    }
});

titleContent.on('keyup',function(e){
    titleDiv.removeClass('has-warning');
    titleHeader.css('color','black');
    titleEmpty = false;
    errorBox.addClass('hidden')
});

descriptionContent.on('keyup',function(e){
    descriptionDiv.removeClass('has-warning');
    descriptionHeader.css('color','black');
    descriptionEmpty = false;
    errorBox.addClass('hidden')
});

}());
