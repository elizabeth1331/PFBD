--@Autor: Jeremy García Meneses
--@Fecha creación: 03/02/2021
--@Descripción: PRUEBA DE FUNCIONES

connect sys/system as sysdba
create or replace directory csv as '/home/jeremy/Desktop/p_f_v3';
grant read, write on directory csv to GM_PROY_ADMIN;
!rm respaldo_usuario.csv
connect gm_proy_admin/mg
set serveroutput on;
declare
    v_number number(1,0);
  cursor cur_usuario is
    select   u.usuario_id,nombre_usuario,email,
      password,tarjeta_id,num_seguridad,
     num_tarjeta,anio_exp,mes_exp
    from usuario u,tarjeta_credito tc
    where u.usuario_id = tc.usuario_id;
begin
  for r in cur_usuario loop
    dbms_output.put_line(r.usuario_id);
    select genera_csv(
      'CSV',
      'respaldo_usuario.csv',
      r.usuario_id,
	  r.nombre_usuario,
	  r.email,
	  r.password,
	  r.tarjeta_id,
	  r.num_seguridad,
	  r.num_tarjeta,
	  r.anio_exp,
	  r.mes_exp
	) into v_number from dual;
  end loop;
end;
/