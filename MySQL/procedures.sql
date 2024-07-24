DELIMITER //

CREATE PROCEDURE ImprimirTabla(IN nombreTabla VARCHAR(128))
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE columna VARCHAR(128);
    DECLARE columnas TEXT DEFAULT '';
    DECLARE cur CURSOR FOR 
        SELECT COLUMN_NAME 
        FROM INFORMATION_SCHEMA.COLUMNS 
        WHERE TABLE_NAME = nombreTabla 
        ORDER BY ORDINAL_POSITION;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO columna;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SET columnas = CONCAT(columnas, IF(columnas = '', '', ','), '`', columna, '`');
    END LOOP;

    CLOSE cur;

    SET @sql = CONCAT('SELECT ', columnas, ' FROM `', nombreTabla, '`');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END //

DELIMITER ;