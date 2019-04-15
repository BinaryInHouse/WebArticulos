create or replace PACKAGE BODY PKG_ARTICULO AS

  PROCEDURE SP_LISTAR
    (
        A_CURSOR OUT SYS_REFCURSOR,
        A_CODIGO IN  ARTICULO.CODIGO%TYPE
    ) AS
  BEGIN
     OPEN
        A_CURSOR
        FOR
            SELECT  
                    ID,
                    CODIGO,
                    SERIE,
                    DESCRIPCION,
                    MARCA,
                    MODELO
            FROM 
                    ARTICULO
            WHERE 
                    UPPER(CODIGO) LIKE '%'||UPPER(A_CODIGO)||'%'
                    AND ESTADO='1';

  END SP_LISTAR;



  PROCEDURE SP_BUSCAR_X_ID
    (
        A_CURSOR        OUT SYS_REFCURSOR,
        A_ID            IN  ARTICULO.ID%TYPE,
        A_CODIGO        IN  ARTICULO.CODIGO%TYPE,
        A_SERIE         IN  ARTICULO.SERIE%TYPE
    ) AS
  BEGIN
     OPEN 
            A_CURSOR
        FOR
            SELECT  
                    ID,
                    CODIGO,
                    SERIE,
                    DESCRIPCION,
                    MARCA,
                    MODELO
                    
            FROM 
                    ARTICULO
            WHERE 
                    ID     =  A_ID OR
                    CODIGO =  A_CODIGO OR
                    SERIE  = A_SERIE;
  END SP_BUSCAR_X_ID;

  PROCEDURE SP_INSERTAR
    (
        A_ID             OUT ARTICULO.ID%TYPE,
        A_CODIGO         IN  ARTICULO.CODIGO%TYPE,
        A_SERIE          IN  ARTICULO.SERIE%TYPE,
        A_DESCRIPCION    IN  ARTICULO.DESCRIPCION%TYPE,
        A_MARCA          IN  ARTICULO.MARCA%TYPE,
        A_MODELO         IN  ARTICULO.MODELO%TYPE,
        -- Auditoria
        A_AUD_IDUSUARIO IN  ARTICULO.AUD_IDUSUARIO%TYPE,
        A_AUD_SESION    IN  ARTICULO.AUD_SESION%TYPE,
        A_AUD_IP        IN  ARTICULO.AUD_IP%TYPE
    ) AS
  BEGIN
    SELECT
        SEQ_ARTICULO.NEXTVAL
    INTO
        A_ID
    FROM
        DUAL;
        
    INSERT INTO ARTICULO(
        ID,
        CODIGO,
        SERIE,
        DESCRIPCION,
        MARCA,
        MODELO,
        ESTADO,
        -- Auditoria
        AUD_TIPO,
        AUD_IDUSUARIO,
        AUD_SESION,
        AUD_IP,
        AUD_FECHA
    )
    VALUES
    (
        A_ID,
        A_CODIGO,
        A_SERIE,
        A_DESCRIPCION,
        A_MARCA,
        A_MODELO,
        '1',
        -- Auditoria
        'I',
        A_AUD_IDUSUARIO,
        A_AUD_SESION,
        A_AUD_IP,
        sysdate
 
    );
   
  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR
    (
        A_ID             IN  ARTICULO.ID%TYPE,
        A_DESCRIPCION    IN  ARTICULO.DESCRIPCION%TYPE,
        A_MARCA          IN  ARTICULO.MARCA%TYPE,
        A_MODELO         IN  ARTICULO.MODELO%TYPE,
        
        -- Auditoria
        A_AUD_IDUSUARIO IN  ARTICULO.AUD_IDUSUARIO%TYPE,
        A_AUD_SESION    IN  ARTICULO.AUD_SESION%TYPE,
        A_AUD_IP        IN  ARTICULO.AUD_IP%TYPE
    ) AS
  BEGIN
      UPDATE 
        ARTICULO
    SET
        DESCRIPCION     =   A_DESCRIPCION,
        MARCA           =   A_MARCA,
        MODELO          =   A_MODELO,
        
        -- Auditoria
        AUD_TIPO        =   'A',
        AUD_IDUSUARIO   =   A_AUD_IDUSUARIO,
        AUD_SESION      =   A_AUD_SESION,
        AUD_IP          =   A_AUD_IP,
        AUD_FECHA       =   sysdate
    WHERE
        ID              =   A_ID;

  END SP_ACTUALIZAR;

  PROCEDURE SP_ELIMINAR
    (
          A_ID           IN  ARTICULO.ID%TYPE,
        
        -- Auditoria
        A_AUD_IDUSUARIO IN  ARTICULO.AUD_IDUSUARIO%TYPE,
        A_AUD_SESION    IN  ARTICULO.AUD_SESION%TYPE,
        A_AUD_IP        IN  ARTICULO.AUD_IP%TYPE
    ) AS
  BEGIN
      UPDATE 
        ARTICULO
    SET
         ESTADO          =   '0',
        
        -- Auditoria
        AUD_TIPO        =   'E',
        AUD_IDUSUARIO   =   A_AUD_IDUSUARIO,
        AUD_SESION      =   A_AUD_SESION,
        AUD_IP          =   A_AUD_IP,
        AUD_FECHA       =   sysdate
    WHERE
        ID              =   A_ID;
  END SP_ELIMINAR;

END PKG_ARTICULO;