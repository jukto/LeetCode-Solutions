# Problem: https://leetcode.com/problems/find-followers-count/

SELECT
    user_id,
    COUNT(*) followers_count
FROM Followers
GROUP BY user_id
ORDER BY user_id
