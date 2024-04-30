# Problem: https://leetcode.com/problems/server-utilization-time/

SELECT FLOOR( SUM(TIMESTAMPDIFF(SECOND, status_time, next_status_time)) / (86400) ) total_uptime_days
FROM (
    SELECT
        session_status,
        status_time,
        LEAD(status_time, 1) OVER(PARTITION BY server_id ORDER BY status_time, session_status) next_status_time
    FROM Servers
) sub
WHERE session_status = 'start'
