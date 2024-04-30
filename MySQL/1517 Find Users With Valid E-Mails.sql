# Problem: https://leetcode.com/problems/find-users-with-valid-e-mails/

SELECT *
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$'
