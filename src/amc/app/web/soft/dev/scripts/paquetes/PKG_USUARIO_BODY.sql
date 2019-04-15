CREATE OR REPLACE
PACKAGE BODY PKG_USUARIO AS

  PROCEDURE SP_VALIDAR_ACCESO(
        P_CURSOR    OUT SYS_REFCURSOR,
        P_USUARIO   IN  USUARIO.USUARIO%TYPE,
        P_CLAVE     IN  USUARIO.CLAVE%TYPE
  ) AS
  BEGIN
         OPEN 
            P_CURSOR
        FOR
            SELECT  
                    ID_USUARIO,
                    USUARIO,
                    NOMBRE
            FROM 
                    USUARIO
            WHERE
                        USUARIO   =  P_USUARIO
                    AND CLAVE     =  P_CLAVE;
                    
  END SP_VALIDAR_ACCESO;

END PKG_USUARIO;