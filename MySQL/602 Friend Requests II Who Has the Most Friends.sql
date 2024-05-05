# Problem: https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/

SELECT id, (
        SELECT COUNT(*)
        FROM RequestAccepted
        WHERE requester_id = r.id
            OR accepter_id = r.id
) as num
FROM (
    SELECT requester_id as id FROM RequestAccepted
    UNION
    SELECT accepter_id as id FROM RequestAccepted
) r
ORDER BY num DESC
LIMIT 1
