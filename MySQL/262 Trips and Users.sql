# Problem: https://leetcode.com/problems/trips-and-users/

WITH unbanned AS (
    SELECT users_id
    FROM Users
    WHERE banned = 'No'
)

SELECT
    request_at 'Day',
    ROUND( AVG(status <> 'completed'), 2 ) 'Cancellation Rate'
FROM Trips
WHERE request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND client_id IN (SELECT * FROM unbanned)
    AND driver_id IN (SELECT * FROM unbanned)
GROUP BY request_at
