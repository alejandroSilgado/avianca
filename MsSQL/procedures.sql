CREATE PROCEDURE ImprimirTabla
    @nombreTabla NVARCHAR(128)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @sql NVARCHAR(MAX);
    DECLARE @columnas NVARCHAR(MAX) = '';

    -- Obtener las columnas de la tabla
    SELECT @columnas = @columnas + QUOTENAME(COLUMN_NAME) + ',' 
    FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_NAME = @nombreTabla 
    ORDER BY ORDINAL_POSITION;

    -- Quitar la última coma
    SET @columnas = LEFT(@columnas, LEN(@columnas) - 1);

    -- Construir la consulta dinámica
    SET @sql = N'SELECT ' + @columnas + ' FROM ' + QUOTENAME(@nombreTabla);

    -- Ejecutar la consulta
    EXEC sp_executesql @sql;
END
