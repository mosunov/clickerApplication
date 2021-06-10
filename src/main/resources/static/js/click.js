const btn = document.querySelector('.button');

function handleBtnClick(event) {
    $.ajax({
        url: "/index",
        type: "post",
        dataType:"text",
        success: function(response){
            btn.textContent = response
        },
        error: function (){
        }
    });
}