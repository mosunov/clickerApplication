window.onload = function () {
    const btnText = document.querySelector('.button');
    $.ajax({
        url: "/index",
        type: "get",
        success: function (response) {
            btnText.textContent = response;
        },
        error: function (xhr) {
        }
    });
}