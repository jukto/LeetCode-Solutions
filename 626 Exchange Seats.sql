# Problem: https://leetcode.com/problems/exchange-seats/

SELECT (
    CASE
        WHEN s.id % 2 = 1 THEN s.id + EXISTS(SELECT * FROM Seat WHERE id = s.id + 1)
        ELSE s.id - 1
    END
) as id, student
FROM Seat s
ORDER BY id ASC
