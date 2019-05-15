$( function() {
  let table = $('#tablaAnticipos').DataTable();
  let searchField = $('#tablaAnticipos_filter');

  searchField.children()[0].remove();
  searchField.append( "<strong>Buscar por:</strong> <select id='opcionBuscar'>"+
                          "<option value='1'>Folio</option>"+
                          "<option value='2'>Fecha</option>"+
                      "</select> "+
                      "<label id='porFolio'>"+
                      " <input id='folio' type='text' />"+
                      "</label>"+
                      "<label id='porFecha' hidden>"+
                      " de: <input id='fechaIni' type='text' />"+
                      " a: <input id='fechaFin' type='text' />"+
                      "</label>");

  $("#fechaIni").datepicker();
  $("#fechaFin").datepicker();

  $.fn.dataTable.ext.search.push(
      function( settings, data, dataIndex ) {
        if($("#porFolio").prop('hidden')){
            var min = new Date($("#fechaIni").val()).getTime();
            var max = new Date($("#fechaFin").val()).getTime();
            var fecha = $.datepicker.formatDate('dd/mm/yy', new Date(data[2])); // use data for the age column

            fecha = new Date(fecha).getTime();

            if ( ( fecha==min || fecha==max ) ||
                 ( min >= fecha  && fecha <= max ) )
            {
                return true;
            }
            return false;
        }else{
          var folio = data[1];
          folio = folio.toLowerCase();

          if(folio.indexOf($("#folio")[0].value.toLowerCase())!=-1){
              return true;
          }

          return false;
        }
      }
  );

  $("#fechaIni").change(function(event) {
      table.draw();
  });

  $("#fechaFin").change(function(event) {
      table.draw();
  });

  $("#folio").keyup(function(event) {
      table.draw();
  });

  $("#opcionBuscar").change(function(event) {
    $("#porFolio").prop('hidden')?$("#porFolio").removeAttr('hidden'):$("#porFolio").attr('hidden', 'hidden');
    $("#porFecha").prop('hidden')?$("#porFecha").removeAttr('hidden'):$("#porFecha").attr('hidden', 'hidden');
  });
} );
