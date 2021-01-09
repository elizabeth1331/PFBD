--@Autor(es): GARCIA MENESES JEREMY, MENDOZA DE LA VEGA DULCE ELIZABETH
--@Fecha creación: dd/01/2021
--@Descripción: CREACION DE USUARIOS Y PERMISOS NECESARIOS PARA EL CASO DE ESTUDIOS 

-------------------------------------------------------------------------------------------------------------
----------------------------------------------CREANDO USUARIO------------------------------------------------
-------------------------------------------------------------------------------------------------------------

Prompt crear usuario invitado
--drop user mg_proy_invitado cascade;
create user mg_proy_invitado identified by mg quota unlimited on users;

Prompt crear usuario invitado
--drop user gm_proy_admin cascade;
create user gm_proy_admin identified by mg quota unlimited on users;

-------------------------------------------------------------------------------------------------------------
-----------------------------------------------CREANDO ROLES-------------------------------------------------
-------------------------------------------------------------------------------------------------------------

Prompt creando rol_admin 

--drop role rol_admin;
create role rol_admin;
grant create session,create table, create synonym to rol_admin;
 
Prompt creando rol_invitado 

--drop role rol_invitado;
create role rol_invitado;
grant create session to rol_invitado;
-------------------------------------------------------------------------------------------------------------
----------------------------------------------ASIGNANDO ROLES------------------------------------------------
-------------------------------------------------------------------------------------------------------------

grant rol_invitado to mg_proy_invitado;
 
grant rol_admin to gm_proy_admin;