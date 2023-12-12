
--   26. Stokta bulunmayan ürünlerin ürün listesiyle birlikte tedarikçilerin ismi ve iletişim numarasını 
--   (`ProductID`, `ProductName`,`CompanyName`, `Phone`) almak için bir sorgu yazın.


SELECT p.product_id, p.product_name, s.company_name, s.phone
FROM products AS p
INNER JOIN suppliers AS s ON p.supplier_id = s.supplier_id
where units_in_stock = 0;


--   27. 1998 yılı mart ayındaki siparişlerimin adresi, siparişi alan çalışanın adı, çalışanın soyadı


SELECT o.ship_address, CONCAT (e.first_name,' ', e.last_name) AS employee_names
FROM orders AS o
INNER JOIN employees e ON e.employee_id = o.employee_id
--WHERE EXTRACT (YEAR FROM o.order_date) = 1998  AND EXTRACT (MONTH FROM o.order_date) = 3
WHERE date_part('year', o.order_date) = 1998 AND date_part('month', o.order_date) = 3


--   28. 1997 yılı şubat ayında kaç siparişim var?


SELECT COUNT(*) 
FROM orders 
WHERE date_part('year', order_date) = 1997 
AND date_part('month', order_date) = 2;


--   29. London şehrinden 1998 yılında kaç siparişim var?


SELECT COUNT(*)
FROM orders
WHERE date_part('year', order_date) = 1998
AND ship_city = 'London';



--   30. 1997 yılında sipariş veren müşterilerimin contactname ve telefon numarası


SELECT c.contact_name, c.phone
FROM customers AS c
INNER JOIN ORDERS AS o ON o.customer_id 
= c.customer_id
WHERE date_part ('year', order_date) = 1997;


--   31. Taşıma ücreti 40 üzeri olan siparişlerim


SELECT * FROM orders 
WHERE freight > 40;


--   32. Taşıma ücreti 40 ve üzeri olan siparişlerimin şehri, müşterisinin adı


SELECT ship_city, company_name
FROM orders AS o
INNER JOIN customers AS c ON c.customer_id = o.customer_id
WHERE freight >= 40;


--   33. 1997 yılında verilen siparişlerin tarihi, şehri, çalışan adı -soyadı ( ad soyad birleşik olacak ve büyük harf)


SELECT order_date, ship_city, 
UPPER(CONCAT(first_name, last_name))
FROM orders AS o
INNER JOIN employees AS e ON e.employee_id = o.employee_id
WHERE date_part ('year', order_date) = 1997;


--   34. 1997 yılında sipariş veren müşterilerin contactname i, ve telefon numaraları ( telefon formatı 2223322 gibi olmalı )


SELECT c.contact_name, 
regexp_replace(c.Phone, '[^\d]', '', 'g')
--REPLACE(REPLACE(REPLACE(REPLACE(c.phone,')', ''), '(', ''), '-',''),' ','') 
FROM customers AS c
INNER JOIN orders AS o ON c.customer_id = o.customer_id
WHERE DATE_PART('year', order_date) = 1997;


--   35. Sipariş tarihi, müşteri contact name, çalışan ad, çalışan soyad


SELECT o.order_date, c.contact_name, CONCAT (e.first_name, ' ' ,e.last_name)
FROM orders AS o
INNER JOIN customers AS c ON c.customer_id = o.customer_id
INNER JOIN employees AS e ON e.employee_id = o.employee_id


--   36. Geciken siparişlerim?


SELECT * FROM orders 
WHERE shipped_date > required_date;


--   37. Geciken siparişlerimin tarihi, müşterisinin adı


SELECT shipped_date, company_name
FROM orders AS o 
INNER JOIN customers AS c ON c.customer_id = o.customer_id
WHERE shipped_date > required_date;


--   38. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi


SELECT p.product_name, c.category_name, od.quantity, od.order_id
FROM order_details AS od
INNER JOIN products AS p ON p.product_id = od.product_id
INNER JOIN categories AS c ON c.category_id = p.category_id
WHERE od.order_id = '10248';

--   39. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı


SELECT p.product_name, s.company_name, od.order_id
FROM products AS p
INNER JOIN suppliers AS s ON p.supplier_id = s.supplier_id
INNER JOIN order_details AS od ON od.product_id = p.product_id 
WHERE od.order_id = '10248';


--   40. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti


SELECT e.first_name, e.last_name, product_name, od.quantity
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
WHERE e.employee_id = 3
AND EXTRACT(YEAR FROM o.order_date) = 1997;


--   41. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad


SELECT e.employee_id, CONCAT (e.first_name, ' ' ,e.last_name) AS employee_name, MAX(od.quantity)
    FROM employees AS e
    INNER JOIN orders AS o ON e.employee_id = o.employee_id
    INNER JOIN order_details od ON od.order_id = o.order_id
    WHERE date_part ('year', o.order_date) = 1997
    GROUP BY e.employee_id
    ORDER BY MAX(od.quantity) DESC LIMIT 1


--   42. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad 


SELECT e.employee_id, e.first_name, e.last_name
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
WHERE EXTRACT (YEAR FROM o.order_date) = 1997
GROUP BY e.employee_id
ORDER BY SUM(od.quantity * od.unit_price) DESC
LIMIT 1;


--   43. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?


SELECT p.product_name, p.unit_price, c.category_name
FROM products p
JOIN categories c ON p.category_id = c.category_id
ORDER BY p.unit_price DESC
LIMIT 1;


--   44. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre


SELECT e.first_name, e.last_name, o.order_date, o.order_id
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
ORDER BY o.order_date;


--   45. SON 5 siparişimin ortalama fiyatı ve orderid nedir?


SELECT AVG(od.unit_price * od.quantity) AS average_price, o.order_id
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
GROUP BY o.order_id
ORDER BY o.order_date DESC
LIMIT 5;


--   46. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?


SELECT p.product_name, c.category_name, SUM(od.quantity) AS "total"
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE EXTRACT(MONTH FROM o.order_date) = 1
GROUP BY p.product_name, c.category_name;


--   47. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?


SELECT od.order_id, od.quantity
FROM order_details od
WHERE od.quantity > (SELECT AVG(quantity) from order_details);


--   48. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı


SELECT p.product_name, c.category_name, s.company_name 
FROM products p
JOIN categories c ON p.category_id = c.category_id
JOIN suppliers s ON p.supplier_id = s.supplier_id
JOIN order_details od ON p.product_id = od.product_id
GROUP BY p.product_name, c.category_name, s.company_name
ORDER BY SUM(od.quantity) DESC
LIMIT 1;


--   49. Kaç ülkeden müşterim var


SELECT COUNT(DISTINCT country) 
FROM customers;


--   50. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?


SELECT e.employee_id, e.first_name, e.last_name,
SUM(od.unit_price * od.quantity * (1 - od.discount)) AS "total_order"
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
WHERE e.employee_id = 3
AND o.order_date >= '1998-01-01'
GROUP BY e.employee_id, e.first_name, e.last_name;


--   51. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi


SELECT p.product_name, c.category_name,od.quantity
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE o.order_id = 10248;


--   52. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı


SELECT p.product_name, c.category_name,od.quantity
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE o.order_id = 10248;


--   53. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti


SELECT p.product_name, od.quantity
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
WHERE e.employee_id = 3
AND EXTRACT(YEAR FROM o.order_date) = 1997;


--   54. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad


SELECT e.employee_id, e.first_name, e.last_name,
SUM(od.unit_price * od.quantity * (1 - od.discount)) AS "total_order"
FROM employees e
JOIN orders o oN e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY "Toplam Satış" DESC
LIMIT 1;


--   55. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad 


SELECT e.employee_id, e.first_name, e.last_name,
SUM(od.unit_price * od.quantity * (1 - od.discount)) AS "total_order"
FROM employees e
JOIN orders o oN e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY "Toplam Satış" DESC
LIMIT 1;


--   56. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?


SELECT p.product_name, p.unit_price, c.category_name
FROM products p
JOIN categories c ON p.category_id = c.category_id
ORDER BY p.unit_price DESC
LIMIT 1;


--   57. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre


SELECT e.first_name, e.last_name, o.order_date, o.order_id
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
ORDER BY o.order_date;


--   58. SON 5 siparişimin ortalama fiyatı ve orderid nedir?


SELECT AVG(od.unit_price * od.quantity * (1 - discount)) AS "avg_price", o.order_id
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
GROUP BY o.order_id
ORDER BY MAX(o.order_date) DESC
LIMIT 5;


--   59. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?


SELECT p.product_name, c.category_name, SUM(od.quantity) AS "total_order"
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE EXTRACT(MONTH FROM o.order_date) = 1
GROUP BY p.product_name, c.category_name;


--   60. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?


SELECT o.order_id, o.order_date, od.product_id, p.product_name, od.quantity
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
WHERE od.quantity > (SELECT AVG(quantity) FROM order_details);


--   61. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı


SELECT p.product_name, c.category_name, s.company_name AS "supplier_name"
FROM products p
JOIN categories c ON p.category_id = c.category_id
JOIN suppliers s ON p.supplier_id = s.supplier_id
ORDER BY 
(SELECT SUM(quantity) FROM order_details od WHERE od.product_id = p.product_id) DESC
LIMIT 1;


--   62. Kaç ülkeden müşterim var


SELECT COUNT(DISTINCT country) as "Ülke Sayısı"
FROM customers;


--   63. Hangi ülkeden kaç müşterimiz var


SELECT country, COUNT(*) AS "customers"
FROM customers
GROUP BY country
ORDER BY "customers" DESC;


--   64. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?


SELECT e.employee_id, e.first_name, e.last_name,
SUM(od.unit_price * od.quantity * (1 - od.discount)) AS "total"
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
WHERE e.employee_id = 3
AND o.order_date >= '2023-01-01'
GROUP BY e.employee_id, e.first_name, e.last_name;


--   65. 10 numaralı ID ye sahip ürünümden son 3 ayda ne kadarlık ciro sağladım?


SELECT p.product_id, p.product_name, 
SUM(od.unit_price * od.quantity * (1-discount)) AS "revenue"
FROM products p
JOIN order_details od ON p.product_id = od.product_id
JOIN orders o ON od.order_id = o.order_id
WHERE p.product_id = 10
AND o.order_date >= (
    SELECT MAX(order_date) - INTERVAL '3 months'
    FROM orders)
GROUP BY p.product_id, p.product_name;


--   66. Hangi çalışan şimdiye kadar toplam kaç sipariş almış..?


SELECT e.employee_id, e.first_name, e.last_name, 
COUNT(o.order_id) AS "Toplam Sipariş"
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
GROUP BY e.employee_id, e.first_name, e.last_name;


--   67. 91 müşterim var. Sadece 89’u sipariş vermiş. Sipariş vermeyen 2 kişiyi bulun


SELECT c.customer_id, c.company_name
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL
LIMIT 2;


--   68. Brazil’de bulunan müşterilerin Şirket Adı, TemsilciAdi, Adres, Şehir, Ülke bilgileri


SELECT company_name, contact_name, address, city, country
FROM customers
WHERE country = 'Brazil';


--   69. Brezilya’da olmayan müşteriler


SELECT company_name, contact_name, address, city, country
FROM customers
WHERE country <> 'Brazil' OR country IS NULL;


--   70. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler


SELECT company_name, contact_name, address, city, country
FROM customers
WHERE country IN ('Spain', 'France', 'Germany');


--   71. Faks numarasını bilmediğim müşteriler


SELECT * FROM customers
WHERE fax is NULL;


--   72. Londra’da ya da Paris’de bulunan müşterilerim


SELECT * FROM customers
WHERE city IN ('London', 'Paris');


--   73. Hem Mexico D.F’da ikamet eden HEM DE ContactTitle bilgisi ‘owner’ olan müşteriler

SELECT * FROM customers
WHERE city = 'México D.F.' AND contact_title = 'Owner';

--   74. C ile başlayan ürünlerimin isimleri ve fiyatları


SELECT product_name, unit_price 
FROM products
WHERE product_name LIKE 'C%';


--   75. Adı (FirstName) ‘A’ harfiyle başlayan çalışanların (Employees); Ad, Soyad ve Doğum Tarihleri


SELECT first_name, last_name, birth_date
FROM employees
WHERE first_name LIKE 'A%';


--   76. İsminde ‘RESTAURANT’ geçen müşterilerimin şirket adları


SELECT company_name
FROM customers
WHERE company_name LIKE '%Restaurant%';


--   77. 50$ ile 100$ arasında bulunan tüm ürünlerin adları ve fiyatları


SELECT product_name, unit_price
FROM products
WHERE unit_price BETWEEN 50 AND 100;


--   78. 1 temmuz 1996 ile 31 Aralık 1996 tarihleri arasındaki siparişlerin (Orders), SiparişID 
--   (OrderID) ve SiparişTarihi (OrderDate) bilgileri


SELECT order_id, order_date
FROM orders
WHERE order_date BETWEEN '1996-07-01' AND '1996-12-31';


--   79. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler


SELECT * FROM customers
WHERE country IN ('Spain', 'France', 'Germany');


--   80. Faks numarasını bilmediğim müşteriler


SELECT * FROM customers
WHERE fax IS NULL; 


--   81. Müşterilerimi ülkeye göre sıralıyorum:


SELECT * FROM customers 
ORDER BY country;


--   82. Ürünlerimi en pahalıdan en ucuza doğru sıralama, sonuç olarak ürün adı ve fiyatını istiyoruz


SELECT product_name, unit_price
FROM products
ORDER BY unit_price DESC;


--   83. Ürünlerimi en pahalıdan en ucuza doğru sıralasın, ama stoklarını küçükten-büyüğe doğru göstersin 
--   sonuç olarak ürün adı ve fiyatını istiyoruz


SELECT product_name, unit_price
FROM products
ORDER BY unit_price DESC, units_in_stock ASC;


--   84. 1 Numaralı kategoride kaç ürün vardır..?


SELECT COUNT(*)
FROM products
WHERE category_id = 1;


--   85. Kaç farklı ülkeye ihracat yapıyorum..?


SELECT COUNT(DISTINCT ship_country)
FROM orders;
