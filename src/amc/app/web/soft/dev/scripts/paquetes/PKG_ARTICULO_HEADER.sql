create or replace PACKAGE PKG_ARTICULO AS 

     PROCEDURE SP_LISTAR
    (
        A_CURSOR OUT SYS_REFCURSOR,
        A_CODIGO IN  ARTICULO.CODIGO%TYPE
    );
    

    PROCEDURE SP_BUSCAR_X_ID
    (
        A_CURSOR      OUT SYS_REFCURSOR,
        A_ID          IN  ARTICULO.ID%TYPE,
        A_CODIGO      IN  ARTICULO.CODIGO%TYPE,
        A_SERIE       IN  ARTICULO.SERIE%TYPE
    );
    

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
    );
    
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
    );
        PROCEDURE SP_ELIMINAR
    (
          A_ID           IN  ARTICULO.ID%TYPE,
        
        -- Auditoria
        A_AUD_IDUSUARIO IN  ARTICULO.AUD_IDUSUARIO%TYPE,
        A_AUD_SESION    IN  ARTICULO.AUD_SESION%TYPE,
        A_AUD_IP        IN  ARTICULO.AUD_IP%TYPE
    );

END PKG_ARTICULO;