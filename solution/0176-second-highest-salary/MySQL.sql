# Write your MySQL query statement below
select ifnull((SELECT distinct Salary
FROM Employee
order by Salary desc
LIMIT 1 offset 1), NULL) SecondHighestSalary
