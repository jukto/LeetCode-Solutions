# Problem: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/

SELECT
    teacher_id,
    COUNT(DISTINCT subject_id) cnt
FROM Teacher
GROUP BY teacher_id
