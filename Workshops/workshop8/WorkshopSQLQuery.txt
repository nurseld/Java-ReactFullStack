
--   86. a.Bu ülkeler hangileri..?


SELECT DISTINCT ship_country
FROM orders;


--   87. En Pahalı 5 ürün


SELECT product_name,unit_price
FROM products
ORDER BY unit_price DESC
LIMIT 5;


--   88. ALFKI CustomerID’sine sahip müşterimin sipariş sayısı..?


SELECT COUNT(*) 
FROM orders
WHERE customer_id = 'ALFKI';



--   89. Ürünlerimin toplam maliyeti


SELECT SUM(p.unit_price * od.quantity) AS total_cost
FROM products AS p
INNER JOIN order_details AS od ON p.product_id = od.product_id;


--   90. Şirketim, şimdiye kadar ne kadar ciro yapmış..?


SELECT SUM(unit_price * quantity * (1 - discount)) AS Ciro
FROM order_details;


--   91. Ortalama Ürün Fiyatım


SELECT AVG(unit_price) AS Average Price
FROM products;


--  92. En Pahalı Ürünün Adı


SELECT product_name, unit_price
FROM products
WHERE unit_price = (SELECT MAX(unit_price) 
					FROM products);


--   93. En az kazandıran sipariş

SELECT *
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
ORDER BY (od.quantity * od.unit_price * (1 - od.discount)) + o.freight
LIMIT 1;


--   94. Müşterilerimin içinde en uzun isimli müşteri


SELECT *
FROM customers
ORDER BY LENGTH(company_name) DESC
LIMIT 1;


--   95. Çalışanlarımın Ad, Soyad ve Yaşları


SELECT first_name,last_name,DATE_PART('year', AGE(birth_date)) AS age
FROM employees;


--   96. Hangi üründen toplam kaç adet alınmış..?


SELECT od.product_id, p.product_name, SUM(od.quantity)
FROM order_details od
INNER JOIN products p ON od.product_id = p.product_id
GROUP BY od.product_id, p.product_id;


--   97. Hangi siparişte toplam ne kadar kazanmışım..?


SELECT o.order_id,SUM(od.quantity * od.unit_price * (1 - od.discount)) AS total
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
GROUP BY o.order_id;


--   98. Hangi kategoride toplam kaç adet ürün bulunuyor..?


SELECT category_name, COUNT(*) AS total_product
FROM products AS p
INNER JOIN categories c ON c.category_id = p.category_id
GROUP BY category_name;


--   99. 1000 Adetten fazla satılan ürünler?


SELECT p.product_name,SUM(od.quantity) AS total_amount
FROM products p
INNER JOIN order_details od ON od.product_id = p.product_id
GROUP BY p.product_name
HAVING SUM(od.quantity) > 1000;


--   100. Hangi Müşterilerim hiç sipariş vermemiş..?


SELECT c.customer_id,company_name 
FROM orders o
RIGHT JOIN customers c ON o.customer_id = c.customer_id
WHERE o.order_id IS NULL;


--   101. Hangi tedarikçi hangi ürünü sağlıyor ?


SELECT s.company_name,p.product_name
FROM products p
INNER JOIN suppliers s ON s.supplier_id = p.supplier_id
ORDER BY company_name;


--   102. Hangi sipariş hangi kargo şirketi ile ne zaman gönderilmiş..?


SELECT o.order_id, s.company_name,o.order_date
FROM orders o
INNER JOIN shippers s ON o.ship_via = s.shipper_id;


--   103. Hangi siparişi hangi müşteri verir..?


SELECT o.order_id,c.company_name
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id;


--   104. Hangi çalışan, toplam kaç sipariş almış..?


SELECT e.employee_id,e.first_name || ' ' || e.last_name AS employee_name,
	   COUNT(o.order_id) AS "total_order"
FROM employees e
LEFT JOIN orders o ON e.employee_id = o.employee_id
GROUP BY e.employee_id;


--   105. En fazla siparişi kim almış..?


SELECT e.employee_id,e.first_name || ' ' || e.last_name AS employee_name,
	   COUNT(o.order_id) AS "total_order"
FROM employees e
LEFT JOIN orders o ON e.employee_id = o.employee_id
GROUP BY e.employee_id
ORDER BY total_order DESC
LIMIT 1;


--   106. Hangi siparişi, hangi çalışan, hangi müşteri vermiştir..?


SELECT order_id,
	   e.first_name || ' ' || e.last_name AS employee_name,c.company_name
FROM orders o
INNER JOIN customers c ON c.customer_id = o.customer_id
INNER JOIN employees e ON e.employee_id = o.employee_id;


--   107. Hangi ürün, hangi kategoride bulunmaktadır..? Bu ürünü kim tedarik etmektedir..?


SELECT p.product_id, p.product_name, c.category_name, s.supplier_id, s.company_name
FROM products p
JOIN categories c ON p.category_id = c.category_id
JOIN suppliers s ON p.supplier_id = s.supplier_id;


--   108. Hangi siparişi hangi müşteri vermiş, hangi çalışan almış, hangi tarihte, 
--   hangi kargo şirketi tarafından gönderilmiş, hangi üründen kaç adet alınmış, 
--   hangi fiyattan alınmış, ürün hangi kategorideymiş bu ürünü hangi tedarikçi sağlamış



SELECT 
    o.order_id,
    c.customer_id,
    c.company_name,
    e.employee_id,
    e.first_name || ' ' || e.last_name,
    o.order_date,
    s.company_name AS shipper_name,
    od.product_id,
    p.product_name,
    p.unit_price,
    od.quantity,
    ca.category_name,
    suppliers.company_name AS supplier_name
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN employees e ON o.employee_id = e.employee_id
INNER JOIN shippers s ON o.ship_via = s.shipper_id
INNER JOIN order_details od ON o.order_id = od.order_id
INNER JOIN products p ON od.product_id = p.product_id
INNER JOIN categories ca ON p.category_id = ca.category_id
INNER JOIN suppliers ON p.supplier_id = suppliers.supplier_id;


--   109. Altında ürün bulunmayan kategoriler


SELECT c.category_id, c.category_name, COUNT(p.product_id)
FROM categories c
LEFT JOIN products p ON c.category_id = p.category_id
GROUP BY c.category_id, c.category_name
HAVING COUNT(p.product_id) = 0;


--   110. Manager ünvanına sahip tüm müşterileri listeleyiniz.


SELECT *
FROM customers
WHERE contact_title ILIKE '%manager%';


--   111. FR ile başlayan 5 karekter olan tüm müşterileri listeleyiniz.


SELECT *
FROM customers
WHERE customer_id LIKE 'FR___';


--   112. (171) alan kodlu telefon numarasına sahip müşterileri listeleyiniz.


SELECT *
FROM customers
WHERE phone LIKE '%171%';


--   113. BirimdekiMiktar alanında boxes geçen tüm ürünleri listeleyiniz.


SELECT *
FROM products
WHERE quantity_per_unit LIKE '%boxes%';


--   114. Fransa ve Almanyadaki (France,Germany) Müdürlerin (Manager) 
--   Adını ve Telefonunu listeleyiniz.(MusteriAdi,Telefon)


SELECT contact_name,phone,country
FROM customers
WHERE contact_title LIKE '%Manager%' AND country IN('France','Germany');


--   115. En yüksek birim fiyata sahip 10 ürünü listeleyiniz.


SELECT product_name,unit_price
FROM products
ORDER BY unit_price DESC
LIMIT 10;


--   116. Müşterileri ülke ve şehir bilgisine göre sıralayıp listeleyiniz.


SELECT *
FROM customers
ORDER BY country,city;


--   117. Personellerin ad,soyad ve yaş bilgilerini listeleyiniz.


SELECT first_name,last_name,DATE_PART('year', AGE(birth_date)) AS age
FROM employees;


--   118. 35 gün içinde sevk edilmeyen satışları listeleyiniz.


SELECT *
FROM orders
WHERE (shipped_date - order_date) > 35 OR shipped_date IS NULL;


--   119. Birim fiyatı en yüksek olan ürünün kategori adını listeleyiniz. (Alt Sorgu)


SELECT category_name
FROM categories
WHERE category_id = (SELECT category_id
                     FROM products
			         ORDER BY unit_price DESC
			         LIMIT 1);
			  
			  
--   120. Kategori adında 'on' geçen kategorilerin ürünlerini listeleyiniz. (Alt Sorgu)


SELECT product_id, product_name, category_id
FROM products
WHERE category_id IN(
SELECT category_id 
FROM categories
WHERE (category_name) LIKE '%on%');


--SELECT *
--FROM products
--WHERE EXISTS (SELECT category_id
             -- FROM categories
              --WHERE category_name LIKE '%on%');
			 
			 
--   121. Konbu adlı üründen kaç adet satılmıştır.


SELECT p.product_name, 
SUM(od.quantity) AS total
FROM products p
JOIN order_details od ON p.product_id = od.product_id
WHERE p.product_name = 'Konbu'
GROUP BY p.product_name;


--   122. Japonyadan kaç farklı ürün tedarik edilmektedir.


SELECT COUNT(DISTINCT p.product_id)
FROM products p
JOIN suppliers s ON p.supplier_id = s.supplier_id
WHERE s.country = 'Japan';


--   123. 1997 yılında yapılmış satışların en yüksek, en düşük ve ortalama nakliye ücretlisi ne kadardır?


SELECT MAX(freight) AS max_freight,
	   MIN(freight) AS min_freight,
	   AVG(freight) AS avg_freight
FROM orders
WHERE DATE_PART('year',order_date) = '1997';


--   124. Faks numarası olan tüm müşterileri listeleyiniz.


SELECT * 
FROM customers 
WHERE fax IS NOT NULL;


--   125. 1996-07-16 ile 1996-07-30 arasında sevk edilen satışları listeleyiniz. 


SELECT * 
FROM orders 
WHERE shipped_date BETWEEN '1996-07-16' AND '1996-07-30';

