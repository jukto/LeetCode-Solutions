# Problem: https://leetcode.com/problems/human-traffic-of-stadium/

SELECT *
FROM Stadium s
WHERE people >= 100 
    AND ((
        EXISTS( SELECT * FROM Stadium WHERE id = s.id + 1 AND people >= 100 )
        AND (
            EXISTS( SELECT * FROM Stadium WHERE id = s.id + 2 AND people >= 100 )
            OR EXISTS( SELECT * FROM Stadium WHERE id = s.id - 1 AND people >= 100 )
        )
    ) OR (
        EXISTS( SELECT * FROM Stadium WHERE id = s.id - 1 AND people >= 100 )
        AND EXISTS( SELECT * FROM Stadium WHERE id = s.id - 2 AND people >= 100 )
    ))
ORDER BY visit_date
