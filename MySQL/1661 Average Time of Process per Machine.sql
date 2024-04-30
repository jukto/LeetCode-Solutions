# Problem: https://leetcode.com/problems/average-time-of-process-per-machine/

SELECT s.machine_id,
    ROUND( AVG(e.timestamp - s.timestamp), 3 ) processing_time
FROM Activity s
JOIN Activity e
ON (s.machine_id, s.process_id) = (e.machine_id, e.process_id)
    AND s.activity_type = 'start'
    AND e.activity_type = 'end'
GROUP BY s.machine_id
