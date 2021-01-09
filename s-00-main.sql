--@Autor(es): GARCIA MENESES JEREMY, MENDOZA DE LA VEGA DULCE ELIZABETH
--@Fecha creación: 07/01/2021
--@Descripción: SCRIPT-PRINCIPAL.


connect sys/system as sysdba;


-------------------------------------------------------------------------------------------------------------
----------------------------------------------ELIMINACIÓN DE USUARIOS------------------------------------------------
-------------------------------------------------------------------------------------------------------------

--Ejemplo parecido en previo práctica 7
--SQL*PLUS muestra la salida generada por los procedimientos PL/SQL
set serveroutput on
--declaramos el cursor
--el cursor almacena información procedente de una sentencia select
declare
  v_count number(1,0);
begin 
  select count(*) into v_count
  from dba_users
  where username = 'MG_PROY_INVITADO' OR username = 'GM_PROY_ADMIN';
  if v_count > 0 then
    execute immediate 'drop user MG_PROY_INVITADO cascade';
    execute immediate 'drop user GM_PROY_ADMIN cascade';
    dbms_output.put_line('Usuarios eliminados'); --Para utilizar dbms_output.put_li ne se requiere encender serveroutput
  else
    dbms_output.put_line('Los usuarios no requieren ser eliminados');
  end if;

-------------------------------------------------------------------------------------------------------------
----------------------------------------------ELIMINACIÓN DE ROLES------------------------------------------------
-------------------------------------------------------------------------------------------------------------

  select count(*) into v_count
  from dba_roles
  where role = 'ROL_INVITADO' OR role = 'ROL_ADMIN';
  if v_count > 0 then
    execute immediate 'drop role ROL_INVITADO';
    execute immediate 'drop role ROL_ADMIN';
    dbms_output.put_line('Roles eliminados'); --Para utilizar dbms_output.put_li ne se requiere encender serveroutput
  else
    dbms_output.put_line('Los roles no requieren ser eliminados');
  end if;
end;
/
set serveroutput off
--Fin bloque PL/SQL
-------------------------------------------------------------------------------------------------------------
----------------------------------------------INVOCACIÓN DE SCRIPTS------------------------------------------------
-------------------------------------------------------------------------------------------------------------

@@s-01-usuarios.sql
@@s-02-entidades.sql

