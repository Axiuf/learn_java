-- 秒杀执行的存储过程
DELIMITER $$ -- console语句中分割符的转换
-- 定义参数的存储过程
-- 参数： in 输入参数；out输出参数
-- row_count()：返回上一条修改类型sql（delete，update，insert）的影响语句
-- row_count()：0：未修改数据；> 0：表示修改的行数；< 0：sql错误/未执行修改sql
CREATE PROCEDURE `seckill`.`execute_secKill`
    (IN v_secKill_id BIGINT, IN v_phone bigint, IN v_kill_time TIMESTAMP, OUT r_result INT)
    BEGIN
        DECLARE insert_count INT DEFAULT 0;
        START TRANSACTION;
        INSERT IGNORE INTO success_killed(secKill_id, user_phone, state, create_time)
        VALUES (v_secKill_id, v_phone, 0, v_kill_time);
        SELECT ROW_COUNT() INTO insert_count;
        IF (insert_count = 0) THEN
            ROLLBACK;
            SET r_result = -1;
        ELSEIF (insert_count < 0) THEN
            ROLLBACK;
            SET r_result = -2;
        ELSE
            UPDATE seckill
            SET number = number - 1
            WHERE secKill_id = v_secKill_id
                AND end_time > v_kill_time
                AND start_time < v_kill_time
                AND number > 0;
            SELECT ROW_COUNT() INTO insert_count;
        IF (insert_count = 0) THEN
            ROLLBACK;
            SET r_result = 0;
        ELSEIF (insert_count < 0) THEN
            ROLLBACK;
            SET r_result = -2;
        ELSE
            COMMIT;
            SET r_result = 1;
        END IF;
        END IF;
    END;
$$
-- 存储过程定义结束


-- console端调用存储过程
DELIMITER ;
SET @r_result = -3;
CALL execute_secKill(1003, 15921252131, now(), @r_result);
SELECT @r_result;