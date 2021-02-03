--@Autor(es): GARCIA MENESES JEREMY, MENDOZA DE LA VEGA DULCE ELIZABETH
--@Fecha creación: dd/01/2021
--@Descripción: CREACION TABLAS DEL CASO DE ESTUDIO 


--La Empresa Global Home hann tenido problemas en el registro de las viviendas vendidas 
--y el registro de los pagos de las mismas, por lo cual se le sugirio a la empresa 
--hacer uso de tablas externas, donde podra mantener su registro en caso de alguna 
--perdida, robo o alteracion de los datos 


-------------------------------------------------------------------------------------------------------------
----------------------------------CREANDO TABLA EXTERNA VIVIENDA_VENTA---------------------------------------
-------------------------------------------------------------------------------------------------------------

show user
prompt creando tabla externa VIVIENDA_VENTA_EXT
create table VIVIENDA_VENTA_EXT (
 vivienda_id number(10,0),
 num_catastral number(10,0),
 clabe number(18,0),
 folio varchar2(18),
 precio_inicial number(10,2),
 avaluo blob,
 comision number(3,0),
 usuario_id number(10,0)
)
organization external (
 type oracle_loader
 default directory tmp_dir
 access parameters (
  records delimited by newline
  badfile tmp_dir:'vivienda_venta_ext_bad.log'
  logfile tmp_dir:'vivienda_venta_ext.log'
  fields terminated by ','
  lrtrim
  missing field values are null
  (
    vivienda_id, num_catastral,clabe,folio, precio_inicial,
    avaluo,comision,usuario_id
  )
 )
 location ('vivienda_venta_ext.csv')
)
reject limit unlimited; 




/*
-------------------------------------------------------------------------------------------------------------
---------------------------------------CREANDO TABLA EXTERNA PAGO--------------------------------------------
-------------------------------------------------------------------------------------------------------------


show user
prompt creando tabla externa pago_vivienda_ext
create table pago_vivienda_ext  (
 num_pago number(3,0),
 vivienda_id number(10,0),
 fecha date,
 importe number(7,2)
 
)
organization external (
 type oracle_loader
 default directory tmp_dir
 access parameters (
  records delimited by newline
  badfile tmp_dir:'pago_vivienda_ext_bad.log'
  logfile tmp_dir:'pago_vivienda_ext.log'
  fields terminated by ','
  lrtrim
  missing field values are null
  (
  num_pago,vivienda_id,
  fecha date mask "dd/mm/yyyy",
  importe

  )
 )
 location ('pago_vivienda_ext.csv')
)
*/
reject limit unlimited; 
linesize window
col  folio format A20
/*
prompt mostrando los datos de pago_vivienda_ext  

select * from pago_vivienda_ext;
*/

prompt mostrando los datos de VIVIENDA_VENTA_EXT 
select * from VIVIENDA_VENTA_EXT;