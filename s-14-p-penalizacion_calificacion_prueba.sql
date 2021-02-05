--@Autores: GARCIA MENESES JEREMY, MENDOZA DE LA VEGA DULCE ELIZABETH
--@Fecha: 03/02/2021
--@Descripción: Procedimiento para penalizar la calificación de una vivienda para alquiler que no responde mensajes.
connect gm_proy_admin/mg

set serveroutput on
declare
v_salida number(1,0);
begin
  dbms_output.put_line('Empezando proceso de penalización en la calificación de viviendas para alquilar');
  penalizacion_calificacion(v_salida);
  if v_salida = 0 then
    dbms_output.put_line('El Procedimiento finalizo correctamente');
  end if;
end;
/