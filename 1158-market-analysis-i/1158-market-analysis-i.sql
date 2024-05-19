# Write your MySQL query statement below
select user_id buyer_id, join_date, count(order_id) orders_in_2019
from Users u
left join Orders o on u.user_id = o.buyer_id and year(o.order_date) = '2019'
group by user_id;