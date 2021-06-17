
$( document ).ready(function() {
$('#register').click(function () {
    alert("confirm your email");
});
$("#register").prop('disabled',true);

    $("#setUsername").keyup(function (){
        console.log($("#setUsername").val());
        if($("#setUsername").val()!=null){
            $("#register").prop('disabled',false);
        }
    })
});