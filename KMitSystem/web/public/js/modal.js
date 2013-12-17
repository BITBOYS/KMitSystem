//$("#modal-dialog-tournament").on("show", function() {    // wire up the OK button to dismiss the modal when shown
//    $("#modal-dialog-tournament a.btn").on("click", function() {
//        $("#modal-dialog-tournament").modal('hide');     // dismiss the dialog
//    });
//});
//
//$("#modal-dialog-tournament").on("hide", function() {    // remove the event listeners when the dialog is dismissed
//    $("#modal-dialog-tournament a.btn").off("click");
//});
//
//$("#modal-dialog-tournament").on("hidden", function() {  // remove the actual elements from the DOM when fully hidden
//    $("#modal-dialog-tournament").remove();
//});
//
//$("#modal-dialog-tournament").modal({// wire up the actual modal functionality and show the dialog
//    "backdrop": "static",
//    "keyboard": true,
//    "show": true                     // ensure the modal is shown immediately
//});


$('#btnYes').click(function() {

    $('form').submit();

});