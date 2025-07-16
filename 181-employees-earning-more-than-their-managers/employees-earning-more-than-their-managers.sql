# Write your MySQL query statement belows
select a.name as Employee from Employee a where a.salary>(select e.salary from Employee e where a.managerId= e.id);