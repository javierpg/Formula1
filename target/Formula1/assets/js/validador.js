<script type=”text/javascript”>
$(document).ready(function() {
$('#altaPiloto').bootstrapValidator({
     message: 'Este valor no es valido',
     feedbackIcons: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
     },
     fields: {
         nombre: {
             validators: {
                 notEmpty: {
                     message: 'El nombre del piloto es requerido'
                 }
             }
         }
     }
});
});
</script>