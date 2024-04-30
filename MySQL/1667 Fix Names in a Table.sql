# Problem: https://leetcode.com/problems/fix-names-in-a-table/

SELECT user_id,
    CONCAT( UCASE(LEFT(name, 1)), LCASE(MID(name, 2, 999)) ) name
FROM Users
ORDER BY user_id
