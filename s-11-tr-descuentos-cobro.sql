--@Autores: GARCIA MENESES JEREMY, MENDOZA DE LA VEGA DULCE ELIZABETH
--@Fecha: 03/02/2021
--@Descripción: CREACION DE TRIGGER TIPO ROW LEVEL


--FECHA DE PROMOCIONES, PARA LOS CLIENTES QUE HAN COMPRADO UNA CASA SE LES DARA
-- UN DESCUESTO AL REALIZAR SU PAGO NUMERO 8 DEL 10% O UN PAGO DE 15% PARA SU PAGO NUMERO 13
--TAMBIÉN SE SOLICITA CREAR UNA NUEVA TABLA DONDE SE LLEVARA EL REGISTRO DE LOS DESCUENTOS, 
--DICHA TABLA DEBERA LLAMARSE 'REGISTRO_PROMOCION' Y USANDO UNA SECUENCIA LLAMADA registro_promocion_seq

----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------TRIGGER DESCUENTO DE VENTA---------------------------------------------
----------------------------------------------------------------------------------------------------------------------

set serveroutput on
create or replace trigger tr_descuentos_venta 
before insert 
on pago_vivienda
for each row

declare
--declaración de variables
v_usuario_id usuario.usuario_id%type;
v_vivienda_id vivienda.vivienda_id%type;
v_monto_pagado pago_vivienda.importe%type;
v_precio_inicial vivienda_venta.precio_inicial%type;
v_ult_num_pag number;
v_importe number;
begin

select  u.usuario_id,q.vivienda_id,vv.precio_inicial, q.monto_pagado, q.num_ult_pago 
into v_usuario_id,v_vivienda_id,v_precio_inicial, v_monto_pagado,v_ult_num_pag
from  usuario u
join (
  select vv.usuario_id,v.vivienda_id, sum(pv.importe) as monto_pagado, max(num_pago) as num_ult_pago
  from vivienda v
  join vivienda_venta vv
  on v.vivienda_id=vv.vivienda_id
  join pago_vivienda pv
  on pv.vivienda_id=vv.vivienda_id
  group by vv.usuario_id,v.vivienda_id
) q on q.usuario_id=u.usuario_id
join vivienda_venta vv
on u.usuario_id=vv.usuario_id
where vv.vivienda_id=:new.vivienda_id;

v_importe:=:new.importe;

if v_ult_num_pag=8 then 
  dbms_output.put_line('El usuario cuenta con lo siguientes datos ');
  dbms_output.put_line( 'Id_cliente  Id_auto   Precio Inicial   #Importe total de los pagos registrados  #Total de pagos registrados ');
  dbms_output.put_line(v_usuario_id||' , '||v_vivienda_id||' , '||v_precio_inicial||' , '|| v_monto_pagado||' , '||v_ult_num_pag);
  dbms_output.put_line('A este usuario de le dara un descuento del 10% sobre su pago ');
  dbms_output.put_line('Salgo actual '||(v_importe*0.10)+v_monto_pagado||' Saldo restante '||v_precio_inicial-((v_importe*0.10)+v_monto_pagado)||'  Se le desconto  '||(v_importe*0.10)||' Número de pago '|| v_ult_num_pag+1);
  
  insert into REGISTRO_PROMOCION(registro_promocion_id, vivienda_id,usuario_id,precio_inicial,monto_pagado,numero_pago, tipo_descuento) 
  values (registro_promocion_seq.nextval,v_vivienda_id,v_usuario_id,v_precio_inicial,v_monto_pagado,v_ult_num_pag+1, 'V1' );
elsif v_ult_num_pag=13 then
  dbms_output.put_line('El usuario cuenta con lo siguientes datos ');
   dbms_output.put_line( 'Id_cliente  Id_auto   Precio Inicial   #Importe total de los pagos registrados  #Total de pagos registrados ');
  dbms_output.put_line(v_usuario_id||' , '||v_vivienda_id||' , '||v_precio_inicial||' , '|| v_monto_pagado||' , '||v_ult_num_pag);
  dbms_output.put_line('A este usuario de le dara un descuento del 10% sobre su pago ');
  dbms_output.put_line('Salgo actual '||(v_importe*0.15)+v_monto_pagado||' Saldo restante '||v_precio_inicial-((v_importe*0.15)+v_monto_pagado)||'  Se le desconto  '||(v_importe*0.15)||' Número de pago '|| v_ult_num_pag+1);
  
  insert into REGISTRO_PROMOCION(registro_promocion_id, vivienda_id,usuario_id,precio_inicial,monto_pagado,numero_pago,tipo_descuento) 
  values (registro_promocion_seq.nextval,v_vivienda_id,v_usuario_id,v_precio_inicial ,v_monto_pagado,v_ult_num_pag+1,'V2');

else 
  dbms_output.put_line('Pago realizado con exito ');
  dbms_output.put_line('Salgo actual '||v_monto_pagado+ v_importe||' Saldo restante '||v_precio_inicial-((v_importe)+v_monto_pagado)||' Número de pago '|| v_ult_num_pag+1);
  
end if;

end;
/
show errors;

