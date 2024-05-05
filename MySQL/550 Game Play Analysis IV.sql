# Problem: https://leetcode.com/problems/game-play-analysis-iv/

SELECT ROUND((
    SELECT COUNT(DISTINCT a1.player_id)
    FROM Activity a2
    JOIN (
        SELECT player_id, MIN(event_date) AS first_login
        FROM Activity
        GROUP BY player_id
    ) a1
    ON a1.player_id = a2.player_id
    WHERE DATEDIFF(a2.event_date, a1.first_login) = 1
) / (
    SELECT COUNT(DISTINCT player_id)
    FROM Activity
), 2) as fraction
