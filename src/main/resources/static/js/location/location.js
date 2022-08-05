$(function () {
    $("#location").click(function () {
        $(".locationbox-v2").show();
        $(".locationbox__overlay").show();
        $(".bg-ellipse").show();
    });

    $(".cls-location").click(function () {
        $(".locationbox-v2").hide();
        $(".locationbox__overlay").hide();
        $(".bg-ellipse").hide();
    });
});